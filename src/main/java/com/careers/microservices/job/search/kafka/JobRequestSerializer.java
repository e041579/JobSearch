/**
 * 
 */
package com.careers.microservices.job.search.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Vivek
 *
 */
public class JobRequestSerializer implements Serializer {

	@Override
	public void close() {
	}

	@Override
	public void configure(Map configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String topic, Object job) {
		byte[] retVal = null;
		try {
			ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			retVal = mapper.writeValueAsString(job).getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

}
