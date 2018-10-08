/**
 * 
 */
package com.careers.microservices.job.search.kafka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.careers.microservices.job.search.exception.ApplicationException;
import com.careers.microservices.job.search.exception.ErrorCodesEnum;
import com.careers.microservices.job.search.exception.ErrorVO;
import com.careers.microservices.job.search.models.JobRequest;

/**
 * @author Vivek
 *
 */
@Component
public class FileReader {

	private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

	private static final String[] FILE_HEADER_MAPPING = { "employerName", "designation", "availability", "location",
			"postedDate", "experience", "jobDescription", "skillSet", "replyRate", "ratePerHour", "languages" };

	private static final String EMPLOYER_NAME = "employerName";
	private static final String DESIGNATION = "designation";
	private static final String AVAILABILITY = "availability";
	private static final String LOCATION = "location";
	private static final String POSTED_DATE = "postedDate";
	private static final String EXPERIENCE = "experience";
	private static final String JOB_DESCRIPTION = "jobDescription";
	private static final String SKILL_SET = "skillSet";
	private static final String REPLY_RATE = "replyRate";
	private static final String RATE_PER_HOUR = "ratePerHour";
	private static final String LANGUAGES = "languages";

	public static List<JobRequest> readCsvFile(String fileName) throws ApplicationException {

		java.io.FileReader fileReader = null;
		List<JobRequest> jobs = null;
		CSVParser csvFileParser = null;
		CSVFormat csvFileFormat = CSVFormat.newFormat('	').withHeader(FILE_HEADER_MAPPING);

		try {
			jobs = new ArrayList<>();
			fileReader = new java.io.FileReader(fileName);
			csvFileParser = new CSVParser(fileReader, csvFileFormat);
			List csvRecords = csvFileParser.getRecords();

			for (int i = 1; i < csvRecords.size(); i++) {
				CSVRecord record = (CSVRecord) csvRecords.get(i);
				JobRequest jobRequest = new JobRequest(record.get(EMPLOYER_NAME),
						record.get(DESIGNATION), record.get(AVAILABILITY),
						record.get(LOCATION), record.get(POSTED_DATE),
						record.get(EXPERIENCE), record.get(JOB_DESCRIPTION),
						record.get(SKILL_SET), record.get(REPLY_RATE),
						record.get(RATE_PER_HOUR), record.get(LANGUAGES));
				jobs.add(jobRequest);
			}

			return jobs;
		} catch (Exception e) {
			logger.error("Error in CsvFileReader !!!", e.getMessage());
			throw new ApplicationException(new ErrorVO(ErrorCodesEnum.INVALID_FILE.getStatus(),
					ErrorCodesEnum.INVALID_FILE.getDescription(), ErrorCodesEnum.INVALID_FILE.getCode()));
		} finally {
			try {
				fileReader.close();
				csvFileParser.close();
			} catch (IOException e) {
				logger.error("Error while closing csvFileParser !!!" + e.getMessage());
			}
		}
	}
}
