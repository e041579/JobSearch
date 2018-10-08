/**
 * 
 */
package com.careers.microservices.job.search.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.careers.microservices.job.search.models.JobRequest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vivek
 *
 */
public class JobRequestDeserializer implements Deserializer {

	@Override
	public void configure(Map configs, boolean isKey) {

	}

	@Override
	public JobRequest deserialize(String topic, byte[] data) {
		JobRequest job = null;
		try {
			ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			String str = new String(data, "UTF-8");
			System.out.println(mapper.readValue(data, String.class));
			//job = mapper.readValue(data, JobRequest.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return job;
	}

	@Override
	public void close() {

	}

}
