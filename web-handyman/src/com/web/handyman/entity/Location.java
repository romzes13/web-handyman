package com.web.handyman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author roman
 *
 * SQL: id, location_name, phone_number, manager_name, customers_id
 * 
 */

@Entity
@Table(name="locations")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="location_name")
	private String locationName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="manager_name")
	private String managerName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customers_id", nullable = true)
	private Customer customer;

	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", locationName=" + locationName + ", phoneNumber=" + phoneNumber
				+ ", managerName=" + managerName + ", customer=" + customer + "]";
	}
	
	
	
	
	
}
