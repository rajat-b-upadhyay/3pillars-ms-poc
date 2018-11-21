package com.tpg.mspoc.sqlcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpg.mspoc.sqlcrud.model.Customer;
import com.tpg.mspoc.sqlcrud.service.CustomerService;
import com.tpg.mspoc.sqlcrud.service.FeignService;


@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	FeignService feignService;
	
	@Value("${server.port}")
	private String port;

	@GetMapping(path = "customers/{mobileNumber}")
	public ResponseEntity<Customer>  getCustomer(@PathVariable String mobileNumber){
		Customer customer = customerService.getCustomer(mobileNumber);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PostMapping(path = "customers/")
	public ResponseEntity<Customer>  saveCustomer(@RequestBody Customer customer){
		customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(HttpStatus.CREATED);
	}
	
	@GetMapping(path = "schedulerPortNumber/")
	public ResponseEntity<String>  getPortNumber(){
		
		return feignService.getPortNumber();
	}
	
	
	@GetMapping(path = "customerPortNumber/")
	public ResponseEntity<String>  getcustomerPortNumber(){
		
		return new ResponseEntity<String>("Port Number is : "+port, HttpStatus.OK);
	}
}
