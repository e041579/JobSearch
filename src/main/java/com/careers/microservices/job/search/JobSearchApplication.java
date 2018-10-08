package com.careers.microservices.job.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Vivek
 *
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import com.careers.microservices.job.search.kafka.MessageListener;
import com.careers.microservices.job.search.models.JobRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JobSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobSearchApplication.class, args);
	}

	@Bean
	public ObjectMapper mapper() {
		return new ObjectMapper();
	}

	@Bean
	public MessageProducer messageProducer() {
		return new MessageProducer();
	}

	@Bean
	public MessageListener messageListener() {
		return new MessageListener();
	}

	public static class MessageProducer {

		@Autowired
		private KafkaTemplate<String, JobRequest> jobKafkaTemplate;

		@Value(value = "${message.topic.name}")
		private String topicName;

		public void sendJobMessage(JobRequest job) {
			jobKafkaTemplate.send(topicName, job);
		}

	}
	
}
