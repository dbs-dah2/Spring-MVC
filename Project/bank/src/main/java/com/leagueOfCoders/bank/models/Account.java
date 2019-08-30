package com.leagueOfCoders.bank.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNum;
	private String accountType;
	private double balance;
	
	@Column(columnDefinition="boolean default true")
	private boolean activated;

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@ManyToOne
	@JoinColumn(name="cust_id", nullable = false)
	//@JsonBackReference
	private CustomerDetails customer;
	
	@ManyToOne
	@JoinColumn(name="branchIFSC",nullable= false)
	private Branch branch;
	
	@OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Transaction> transactions = new HashSet<>();
	
	
	
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public CustomerDetails getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDetails customer) {
		this.customer = customer;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
	
    public Account() {}
    
    public Account(long accountNum, String accountType, CustomerDetails customer) {
		super();
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.customer = customer;
	}
	
	public Account(long accountNum, String accountType, CustomerDetails customer, Branch branch,Boolean activated) {
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.customer = customer;
		this.branch = branch;
		this.activated=activated;
	}
    

}