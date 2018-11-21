package com.tpg.mspoc.sqlcrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	public Customer() {
		
	}

	public Customer(String mobileNumber, String name) {
		this.mobileNumber = mobileNumber;
		this.name = name;
	}

	@Id
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name = "name")
	private String name;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
