/**
 * 
 */
package com.careers.microservices.job.search.service;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.careers.microservices.job.search.exception.ApplicationException;
import com.careers.microservices.job.search.models.JobRequest;

/**
 * @author VIVEK
 *
 */
public interface JobSearchService {

	public ResponseEntity<?> createNewJob(JobRequest jobRequest);
	public ResponseEntity<?> uploadBulkJobs(MultipartFile file) throws IOException, InterruptedException, ApplicationException;
	public ResponseEntity<?> searchJobs(String skill, String availability, String jobType, String country,
			String experinece, String postedDate, String designation, String ratePerHour,
			String replyRate);
}
