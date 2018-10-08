/**
 * 
 */
package com.careers.microservices.job.search.exception;

/**
 * @author Vivek
 *
 */
public enum ErrorCodesEnum {
	
	TECHNICAL_ERROR("F","Technical error occured","RS001"),
	INTERNAL_ERROR("F","Internal error occured","RS002"),
	INVALID_FILE("F","Incorrect file format","RS003")
	;
	
	public String status;
	public String description;
	public String code;

	ErrorCodesEnum(String status, String description, String code)
	{
		this.status =status;
		this.description = description;
		this.code = code;
	}
	
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

}
