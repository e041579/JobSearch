/**
 * 
 */
package com.careers.microservices.job.search.service;

import static com.careers.microservices.job.search.constants.Constants.CONTAINS;
import static com.careers.microservices.job.search.constants.Constants.EQUAL;
import static com.careers.microservices.job.search.constants.Constants.GREATER_THAN;
import static com.careers.microservices.job.search.constants.Constants.LIKE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.careers.microservices.job.search.JobSearchApplication.MessageProducer;
import com.careers.microservices.job.search.entities.Careers;
import com.careers.microservices.job.search.exception.ApplicationException;
import com.careers.microservices.job.search.kafka.FileReader;
import com.careers.microservices.job.search.kafka.MessageListener;
import com.careers.microservices.job.search.models.CareersVO;
import com.careers.microservices.job.search.models.JobRequest;
import com.careers.microservices.job.search.repositories.CareersRepository;
import com.careers.microservices.job.search.repositories.FilterCriteria;
import com.careers.microservices.job.search.repositories.JobSpecification;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vivek
 *
 */
@Service
public class JobSearchServiceImpl implements JobSearchService {

	private CareersRepository careersRepository;
	private ObjectMapper mapper;
	private MessageProducer producer;
	private static final Logger logger = LoggerFactory.getLogger(JobSearchServiceImpl.class);

	/**
	 * Constuctor
	 * 
	 * @param careersRepository
	 */
	@Autowired
	JobSearchServiceImpl(CareersRepository careersRepository, ObjectMapper mapper, MessageProducer producer) {
		this.careersRepository = careersRepository;
		this.mapper = mapper;
		this.producer = producer;
	}

	/**
	 * Method to source new Jobs
	 * 
	 * @param
	 */
	public ResponseEntity<?> createNewJob(JobRequest jobRequest) {
		logger.info("Creating new job");
		Careers entity = mapper.convertValue(jobRequest, Careers.class);
		entity = careersRepository.save(entity);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Method to process bulk file upload
	 * 
	 * @param File
	 * @throws InterruptedException
	 * @throws ApplicationException
	 */

	public ResponseEntity<?> uploadBulkJobs(MultipartFile file)
			throws IOException, InterruptedException, ApplicationException {
		logger.info("Started uploadBulkJobs");
		File csvFile = this.convertMultiPartToFile(file);
		List<JobRequest> bulkJobList = FileReader.readCsvFile(csvFile.getName());

		logger.info("Posted " + bulkJobList.size());
		// Push jobs to kafka
		for (int i = 0; i < bulkJobList.size(); i++) {
			producer.sendJobMessage(bulkJobList.get(i));
			MessageListener.latch.await(5, TimeUnit.SECONDS);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Method to convert uploaded file into Pojo
	 * 
	 * @param File
	 */

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	/**
	 * Method to search all Jobs
	 * 
	 * @param ResponseEntity
	 */
	public ResponseEntity<?> searchJobs(String skill, String availability, String jobType, String country,
			String experinece, String postedDate, String designation, String ratePerHour, String replyRate) {
		logger.info("searchJobs invoked in service layer");
		List<Careers> listOfJobs = null;

		Specification<Careers> specList = constructFilterParam(skill, availability, jobType, country, experinece,
				postedDate, designation, ratePerHour, replyRate);

		if (specList != null)
			listOfJobs = careersRepository.findAll(specList);
		else
			listOfJobs = (List<Careers>) careersRepository.findAll();

		return new ResponseEntity<>(mapper.convertValue(listOfJobs, CareersVO[].class), HttpStatus.OK);
	}

	/**
	 * Method to build criteria
	 * 
	 * @param ResponseEntity
	 */

	@SuppressWarnings("deprecation")
	private Specification<Careers> constructFilterParam(String skill, String employerName, String jobType,
			String location, String experinece, String postedDate, String designation, String ratePerHour,
			String replyRate) {

		List<Specification<Careers>> list = new ArrayList<>();
		FilterCriteria criteria = null;

		if (Objects.nonNull(skill)) {
			criteria = buildCriteria(skill, CONTAINS, "skillSet", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(employerName)) {
			criteria = buildCriteria(employerName, EQUAL, "employerName", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(jobType)) {
			criteria = buildCriteria(jobType, LIKE, "availability", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(location)) {
			criteria = buildCriteria(location, LIKE, "location", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(experinece)) {
			criteria = buildCriteria(experinece, CONTAINS, "experience", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(postedDate)) {
			criteria = buildCriteria(postedDate, GREATER_THAN, "postedDate", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(designation)) {
			criteria = buildCriteria(designation, EQUAL, "designation", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(ratePerHour)) {
			criteria = buildCriteria(ratePerHour, GREATER_THAN, "ratePerHour", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (Objects.nonNull(replyRate)) {
			criteria = buildCriteria(replyRate, GREATER_THAN, "replyRate", criteria);
			list.add(new JobSpecification(criteria));
		}

		if (list.size() > 0) {
			Specification<Careers> specs = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				specs = Specifications.where(specs).and(list.get(i));
			}
			return specs;
		} else
			return null;
	}

	/**
	 * Method to build criteria
	 * 
	 * @param ResponseEntity
	 */
	private FilterCriteria buildCriteria(String filterValue, String filterOperation, String filterKey,
			FilterCriteria criteria) {
		criteria = new FilterCriteria();
		criteria.setFilterKey(filterKey);
		criteria.setFilterOperation(filterOperation);
		criteria.setFilterValue(filterValue);
		return criteria;
	}

}
