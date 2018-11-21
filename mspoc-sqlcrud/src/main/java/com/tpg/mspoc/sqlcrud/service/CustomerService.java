package com.tpg.mspoc.sqlcrud.service;

import org.springframework.stereotype.Service;

import com.tpg.mspoc.sqlcrud.model.Customer;

@Service
public interface CustomerService {

	public Customer getCustomer(String mobileNumber);
	public void saveCustomer(Customer customer);
}
