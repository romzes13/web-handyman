/* User class stores user name, password and email.
 * 
 *  SQL mappings 
 *  id, user_name, user_password, user_email, handyman_id
 */

package com.web.handyman.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@Column(name="user_email")
	private String email;
	
	// add workorder OneToMAny relationship 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="user", orphanRemoval=true, cascade=CascadeType.ALL)
	private Set<WorkOrder> workOrder;
	
	
	
	public User(){
		
	}
	
	

	public User(String userName, String userPassword, String email, Set<WorkOrder> workOrder) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.workOrder = workOrder;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public Set<WorkOrder> getWorkOrder() {
		return workOrder;
	}

	public void setWorkOrder(Set<WorkOrder> workOrder) {
		this.workOrder = workOrder;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", email=" + email
				+ "]";
	}
	
	
	
}
