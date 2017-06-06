/**
 * @author roman
 * 
 * Address class is for storing addresses.
 * SQL: id, address, address2, city, state, zip_code
 */

package com.web.handyman.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="address2")
	private String addressAlternative;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zip_code")
	private String zipCode;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="address" )
	private Company company;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="address" )
	private Customer customer;

	@OneToOne(fetch = FetchType.LAZY, mappedBy="address" )
	private Handyman handyman;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressAlternative() {
		return addressAlternative;
	}

	public void setAddressAlternative(String addressAlternative) {
		this.addressAlternative = addressAlternative;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + address + ", addressAlternative=" + addressAlternative + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", company=" + company + ", customer=" + customer
				+ "]";
	}

	
	
	
	
	
	
}
