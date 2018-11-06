package com.tpg.mspoc.sqlcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tpg.mspoc.sqlcrud.model.Customer;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<Customer> handleEntityNotFound(CustomerNotFoundException ex) {
		
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}

}
