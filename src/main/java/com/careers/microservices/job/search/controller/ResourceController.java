package com.careers.microservices.job.search.controller;

import static com.careers.microservices.job.search.constants.Constants.BULK_UPLOAD;
import static com.careers.microservices.job.search.constants.Constants.HEALTH;
import static com.careers.microservices.job.search.constants.Constants.SEARCH;
import static com.careers.microservices.job.search.constants.Constants.SUCCESS;
import static com.careers.microservices.job.search.constants.Constants.URI;
import static com.careers.microservices.job.search.constants.Constants.VERSION;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.careers.microservices.job.search.exception.ApplicationException;
import com.careers.microservices.job.search.models.JobRequest;
import com.careers.microservices.job.search.service.JobSearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller class
 * 
 * @author Vivek
 * 
 */
@RestController
@RequestMapping(VERSION + URI)
@Api(value="JobSearch", description="API's listed for JobSearch online")
public class ResourceController {

	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

	@Autowired
	private JobSearchService jobSearchService;

	/**
	 * Health check API
	 * 
	 * @return
	 */

	@GetMapping(HEALTH)
	@ApiOperation(value = "Health check API",response = String.class)
	public String healthCheck() {
		logger.info("Health check invoked");
		return SUCCESS;
	}

	/**
	 * Controller method to save Jobs into portal
	 * 
	 * @param jobRequest
	 * @return
	 */

	@PostMapping
	@ApiOperation(value = "Post single job",response = ResponseEntity.class)
	public ResponseEntity<?> createNewJob(@RequestBody JobRequest jobRequest) {
		logger.info("createNewJob invoked from controller");
		return jobSearchService.createNewJob(jobRequest);
	}

	/**
	 * Controller method to upload bulk jobs
	 * 
	 * @param MultipartFile
	 * @return ResponseEntity
	 * @throws ApplicationException 
	 */
	
	@PostMapping(BULK_UPLOAD)
	@ApiOperation(value = "Post bulk job's",response = ResponseEntity.class)
	public ResponseEntity<?> uploadBulkJobs(@RequestParam("jobFile") MultipartFile file)
			throws IOException, InterruptedException, ApplicationException {
		
		if (file.isEmpty()) {
			logger.info("File is empty");
			throw new ApplicationException("Uploaded file is empty");

		}
		jobSearchService.uploadBulkJobs(file);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}

	/**
	 * Controller method to search Jobs based on search params
	 * 
	 * @param request
	 * @return
	 */

	@GetMapping(SEARCH)
	@ApiOperation(value = "Search jobs based on query params",response = ResponseEntity.class)
	public ResponseEntity<?> searchJobs(@RequestParam(value = "skillSet", required = false) String skillSet,
			@RequestParam(value = "employerName", required = false) String employerName,
			@RequestParam(value = "availability", required = false) String availability,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "experience", required = false) String experience,
			@RequestParam(value = "postedDate", required = false) String postedDate,
			@RequestParam(value = "designation", required = false) String designation,
			@RequestParam(value = "ratePerHour", required = false) String ratePerHour,
			@RequestParam(value = "replyRate", required = false) String replyRate) {
		logger.debug("searchJobs invoked from controller");
		return jobSearchService.searchJobs(skillSet, employerName, availability, location, experience, postedDate,
				designation, ratePerHour, replyRate);
	}

}