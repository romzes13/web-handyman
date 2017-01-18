/* This class defines WorkOrder model
 * 
 * 
 * Updated SQL collumns: id, work_order_name, work_description, estimate, location, 
 * user_id, date_received, date_scheduled, date_compleated, compleated
 * 
 */


package com.web.handyman.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="work_order")
public class WorkOrder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="work_order_name")
	private String workOrderName;
	
	@Column(name="work_description")
	private String workDescription;
	
	@Column(name="estimate")
	private double estimate;
	
	@Column(name="location")
	private String location;
	
	@Column(name="date_received")
	//@Temporal(TemporalType.DATE)
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date dateReceived;
	
	@Column(name="date_scheduled")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date dateScheduled;
	
	@Column(name="date_compleated")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private Date dateCompleated;
	
	@Column(name="compleated")
	private Boolean isCompleated=false;
	
	
	
	// fetch = FetchType.EAGER replaced with LAZY
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id", nullable = true)
	private User user;
	
	
	// Default constructor
	
	public WorkOrder(){
		
	}

	
	

	public WorkOrder(String workOrderName, String workDescription, double d, String location, User user) {
		super();
		this.workOrderName = workOrderName;
		this.workDescription = workDescription;
		this.estimate = d;
		this.location = location;
		this.user = user;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getWorkOrderName() {
		return workOrderName;
	}


	public void setWorkOrderName(String workOrderName) {
		this.workOrderName = workOrderName;
	}


	public String getWorkDescription() {
		return workDescription;
	}


	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}


	public double getEstimate() {
		return estimate;
	}


	public void setEstimate(double estimate) {
		this.estimate = estimate;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	

	public Date getDateReceived() {
		return dateReceived;
	}




	public void setDateReceived(Date dateReceived) {
		this.dateReceived = dateReceived;
	}




	public Date getDateScheduled() {
		return dateScheduled;
	}




	public void setDateScheduled(Date dateScheduled) {
		this.dateScheduled = dateScheduled;
	}




	public Date getDateCompleated() {
		return dateCompleated;
	}




	public void setDateCompleated(Date dateCompleated) {
		this.dateCompleated = dateCompleated;
	}

	




	public Boolean getIsCompleated() {
		return isCompleated;
	}




	public void setIsCompleated(Boolean isCompleated) {
		this.isCompleated = isCompleated;
	}




	@Override
	public String toString() {
		return "WorkOrder [id=" + id + ", workOrderName=" + workOrderName + ", workDescription=" + workDescription
				+ ", estimate=" + estimate + ", location=" + location + ", dateReceived=" + dateReceived
				+ ", dateScheduled=" + dateScheduled + ", dateCompleated=" + dateCompleated + ", isCompleated="
				+ isCompleated + ", user=" + user + "] \n";
	}




	
	

}
