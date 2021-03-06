/**
 * 
 */
package com.careers.microservices.job.search.models;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author VIVEK
 *
 */
public class JobRequest {

	@ApiModelProperty(notes = "Employer Name")
	private String employerName;
	@ApiModelProperty(notes = "Designation for the job")
	private String designation;
	@ApiModelProperty(notes = "Fulltime or Parttime")
	private String availability;
	@ApiModelProperty(notes = "Location, If more than one use ~, Ex: Chennai ~ Bangalore")
	private String location;
	@ApiModelProperty(notes = "Date format, YYYY-MM-DD")
	private String postedDate;
	@ApiModelProperty(notes = "Experience in years, Ex: 5 ~ 9")
	private String experience;
	@ApiModelProperty(notes = "Job description in details")
	private String jobDescription;
	@ApiModelProperty(notes = "Skill sets, Ex: Java~Spring~Hibernate")
	private String skillSet;
	@ApiModelProperty(notes = "Reply rate in percentage")
	private String replyRate;
	@ApiModelProperty(notes = "Rate per hour")
	private String ratePerHour;
	@ApiModelProperty(notes = "Known languages")
	private String languages;
	
	JobRequest()
	{
		
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
	/**
	 * @param employerName the employerName to set
	 */
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	/**
	 * @return the employerName
	 */
	public String getEmployerName() {
		return employerName;
	}
	/**
	 * @param employerName
	 * @param designation
	 * @param availability
	 * @param location
	 * @param postedDate
	 * @param experience
	 * @param jobDescription
	 * @param skillSet
	 * @param replyRate
	 * @param ratePerHour
	 * @param languages
	 */
	
	public JobRequest(String employerName, String designation, String availability, String location, String postedDate,
			String experience, String jobDescription, String skillSet, String replyRate, String ratePerHour,
			String languages) {
		super();
		this.employerName = employerName;
		this.designation = designation;
		this.availability = availability;
		this.location = location;
		this.postedDate = postedDate;
		this.experience = experience;
		this.jobDescription = jobDescription;
		this.skillSet = skillSet;
		this.replyRate = replyRate;
		this.ratePerHour = ratePerHour;
		this.languages = languages;
	}
	
	
	@Override
	public String toString() {
		return "Request [employerName=" + employerName + ", designation=" + designation + ", availability="
				+ availability + ", location=" + location + ", postedDate=" + postedDate + ", experience=" + experience
				+ ", jobDescription=" + jobDescription + ", skillSet=" + skillSet + ", replyRate=" + replyRate
				+ ", ratePerHour=" + ratePerHour + ", languages=" + languages + "]";
	}
}
