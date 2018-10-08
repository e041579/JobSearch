/**
 * 
 */
package com.careers.microservices.job.search.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vivek
 *
 */
public class CareersVO {

	@JsonIgnore
	private Long id;
	private String employerName;
	private String designation;
	private String availability;
	private String location;
	private String postedDate;
	private String experience;
	private String jobDescription;
	private String skillSet;
	private String replyRate;
	private String ratePerHour;
	private String languages;
	
	
	/**
	 * @return the employerName
	 */
	public String getEmployerName() {
		return employerName;
	}
	/**
	 * @param employerName the employerName to set
	 */
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}
	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the postedDate
	 */
	public String getPostedDate() {
		return postedDate;
	}
	/**
	 * @param postedDate the postedDate to set
	 */
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	/**
	 * @return the experience
	 */
	public String getExperience() {
		return experience;
	}
	/**
	 * @param experience the experience to set
	 */
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	/**
	 * @return the skillSet
	 */
	public String getSkillSet() {
		return skillSet;
	}
	/**
	 * @param skillSet the skillSet to set
	 */
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	/**
	 * @return the replyRate
	 */
	public String getReplyRate() {
		return replyRate;
	}
	/**
	 * @param replyRate the replyRate to set
	 */
	public void setReplyRate(String replyRate) {
		this.replyRate = replyRate;
	}
	/**
	 * @return the ratePerHour
	 */
	public String getRatePerHour() {
		return ratePerHour;
	}
	/**
	 * @param ratePerHour the ratePerHour to set
	 */
	public void setRatePerHour(String ratePerHour) {
		this.ratePerHour = ratePerHour;
	}
	/**
	 * @return the languages
	 */
	public String getLanguages() {
		return languages;
	}
	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
