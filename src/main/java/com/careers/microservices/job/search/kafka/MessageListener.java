/**
 * 
 */
package com.careers.microservices.job.search.kafka;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.careers.microservices.job.search.models.JobRequest;
import com.careers.microservices.job.search.service.JobSearchService;

/**
 * @author Vivek
 *
 */
@Component
public class MessageListener {

	private static final Logger logger = LoggerFactory
			.getLogger(MessageListener.class);
	@Lazy
	@Autowired
	private JobSearchService service;
	
	public static CountDownLatch latch = new CountDownLatch(10);
	
	@KafkaListener(topics = "${message.topic.name}", containerFactory = "jobKafkaListenerContainerFactory")
    public void jobListener(JobRequest jobRequest) {
		logger.info("Recieved message: " + jobRequest);
		insertJobIntoDB(jobRequest);
        latch.countDown();
    }

	private void insertJobIntoDB(JobRequest jobRequest) {
		service.createNewJob(jobRequest);
	}


}
