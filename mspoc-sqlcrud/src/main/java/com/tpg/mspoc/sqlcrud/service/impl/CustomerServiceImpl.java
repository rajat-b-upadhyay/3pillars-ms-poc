package com.tpg.mspoc.sqlcrud.service.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tpg.mspoc.sqlcrud.exception.CustomerNotFoundException;
import com.tpg.mspoc.sqlcrud.model.Customer;
import com.tpg.mspoc.sqlcrud.repository.CustomerRepository;
import com.tpg.mspoc.sqlcrud.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer getCustomer(String mobileNumber) {
		try {
			return customerRepository.findById(mobileNumber).get();
		}catch(NoSuchElementException ex) {
			throw new CustomerNotFoundException();
		}
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

}
