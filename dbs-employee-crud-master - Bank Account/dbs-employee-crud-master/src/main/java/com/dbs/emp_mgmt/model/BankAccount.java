package com.dbs.emp_mgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankAccount")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "account_balance")
	private double accountBalance;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "pan_no")
	private String panNo;
	
	
	public BankAccount() {}
	
	public BankAccount(double accountBalance, String accountName, String panNo) {
		super();
		this.accountBalance = accountBalance;
		this.accountName = accountName;
		this.panNo = panNo;
	}

	public long getId() {
		return id;
	}
		
	public void setId(long id) {
		this.id = id;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	
	
}
