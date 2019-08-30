package com.leagueOfCoders.bank.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class CustomerDetails {
	
	public CustomerDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cust_id;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNumber;
	@Column(columnDefinition="boolean default true")
	private boolean activated;
	private String panID;
	private String gender;
	private LocalDate dateOfBirth;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Account> accounts = new HashSet<>();
	
	
	
	public CustomerDetails(long cust_id, String password, String firstname, String lastname, String email,
			String phoneNumber, boolean activated, String panID, String gender, LocalDate dateOfBirth) {
		super();
		this.cust_id = cust_id;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.activated = activated;
		this.panID = panID;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public long getCust_id() {
		return cust_id;
	}
	
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPanID() {
		return panID;
	}

	public void setPanID(String panID) {
		this.panID = panID;
	}

	@Override
	public String toString() {
		return "CustomerDetails [cust_id=" + cust_id + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", phoneNum=" + phoneNumber + ", panId=" + panID
				+ "]";
	}

}
