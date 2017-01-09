/* This class defines WorkOrder model
 * SQL: id, work_order_name, work_description, estimate, location, user_id
 * 
 * 
 */


package com.web.handyman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
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


	@Override
	public String toString() {
		return "WorkOrder [id=" + id + ", workOrderName=" + workOrderName + ", workDescription=" + workDescription
				+ ", estimate=" + estimate + ", location=" + location + ", user=" + user + "]";
	}
	
	
	

}
