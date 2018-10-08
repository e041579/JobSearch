/**
 * 
 */
package com.careers.microservices.job.search.exception;

/**
 * @author Vivek
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -435698872184337135L;

	private ErrorVO errorVO;
	
	/**
	 * @return the errorVO
	 */
	public ErrorVO getErrorVO() {
		return errorVO;
	}

	public ApplicationException(String errorMessage)
	{
		super(errorMessage);
	}
	
	public ApplicationException(String errorMessage, Throwable throwable)
	{
		super(errorMessage, throwable);
	}
	
	public ApplicationException(ErrorVO error)
	{
		this.errorVO = error;
	}

}
