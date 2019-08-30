package com.leagueOfCoders.bank.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Banker {
	
	public Banker() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String adminName;
	private String password;
	public long getId() {
		return id;
	}
	public String getAdminName() {
		return adminName;
	}
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "Banker [id=" + id + ", adminName=" + adminName + ", password=" + password + "]";
	}
	
	public Banker(String adminName,String password) {
		super();
		this.adminName=adminName;
		this.password = password;
	}

}