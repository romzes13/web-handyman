package com.web.handyman.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.event.spi.DeleteEvent;

/**
 * @author roman
 * This is a Company class
 * 
 * SQL names id, company_name, phone_number, fax, email, website, info, address_id
 *
 */

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="fax")
	private String fax;
	
	@Column(name="email")
	private String email;
	
	@Column(name="website")
	private String website;
	
	@Column(name="info")
	private String info;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinColumn(name="address_id", nullable = false)
	private Address address;
	 
	 
	/**
	 * TODO 
	 * FIXME Check the association between customer and a company
	 * DELETE Possible fix: change relationship to many to many
	 * 
	 */
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy="company" )
	@JoinColumn(name="customer_id", nullable = true)
	private Set<Customer> customer;
	*/
	
	
	public Company(){
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getFax() {
		return fax;
	}



	public void setFax(String fax) {
		this.fax = fax;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getInfo() {
		return info;
	}



	public void setInfo(String info) {
		this.info = info;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}






	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", phoneNumber=" + phoneNumber + ", fax=" + fax
				+ ", email=" + email + ", website=" + website + ", info=" + info + ", address=" + address
				+ ", customer=]";
	}

	
	
	
}
