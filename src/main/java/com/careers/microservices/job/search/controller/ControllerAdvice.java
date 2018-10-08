/**
 * 
 */
package com.careers.microservices.job.search.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.careers.microservices.job.search.exception.ApplicationException;
import com.careers.microservices.job.search.exception.ErrorCodesEnum;

/**
 * @author Vivek
 *
 */
@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ApplicationException.class)
	protected ResponseEntity<Error> handleApplicationException(ApplicationException exception) {
		Error error = new Error(exception.getErrorVO().getStatus(),
				exception.getErrorVO().getDescription(), exception.getErrorVO().getCode());
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	protected ResponseEntity<Error> handleException() {
		Error error = new Error(ErrorCodesEnum.TECHNICAL_ERROR.getStatus(),
				ErrorCodesEnum.TECHNICAL_ERROR.getDescription(), ErrorCodesEnum.TECHNICAL_ERROR.getCode());
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { IOException.class, InterruptedException.class })
	protected ResponseEntity<Error> handleJaksonException() {
		Error error = new Error(ErrorCodesEnum.INTERNAL_ERROR.getStatus(),
				ErrorCodesEnum.INTERNAL_ERROR.getDescription(), ErrorCodesEnum.INTERNAL_ERROR.getCode());
		return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
	}

	public class Error {

		public String status;
		public String description;
		public String code;

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}

		/**
		 * @return the code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * @param code the code to set
		 */
		public void setCode(String code) {
			this.code = code;
		}

		/**
		 * @param status
		 * @param description
		 * @param code
		 */
		public Error(String status, String description, String code) {
			super();
			this.status = status;
			this.description = description;
			this.code = code;
		}

	}
}
