/**
 * 
 */
package com.careers.microservices.job.search.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author VIVEK
 * 
 */
@Entity
@Table(name = "JOBS")
public class Careers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "EMPLOYER_NAME")
	private String employerName;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(name = "EMPLOYMENT_TYPE")
	private String availability;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "POSTED_DATE")
	private String postedDate;

	@Column(name = "EXPERIENCE")
	private String experience;

	@Column(name = "DESCRIPTION")
	private String jobDescription;

	@Column(name = "SKILLS")
	private String skillSet;

	@Column(name = "REPLY_RATE")
	private String replyRate;

	@Column(name = "RATE_PER_HOUR")
	private String ratePerHour;

	@Column(name = "LANGUAGES")
	private String languages;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
}
