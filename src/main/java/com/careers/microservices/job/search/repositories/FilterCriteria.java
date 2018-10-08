/**
 * 
 */
package com.careers.microservices.job.search.repositories;

/**
 * @author Vivek
 *
 */
public class FilterCriteria {

	private String filterKey;
	private String filterOperation;
	private String filterValue;

	/**
	 * @return the filterKey
	 */
	public String getFilterKey() {
		return filterKey;
	}

	/**
	 * @param filterKey the filterKey to set
	 */
	public void setFilterKey(String filterKey) {
		this.filterKey = filterKey;
	}

	/**
	 * @return the filterOperation
	 */
	public String getFilterOperation() {
		return filterOperation;
	}

	/**
	 * @param filterOperation the filterOperation to set
	 */
	public void setFilterOperation(String filterOperation) {
		this.filterOperation = filterOperation;
	}

	/**
	 * @return the filterValue
	 */
	public String getFilterValue() {
		return filterValue;
	}

	/**
	 * @param filterValue the filterValue to set
	 */
	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

}
