package com.tpg.mspoc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@Value("${server.port}")
	private String port;

	@GetMapping(path = "portNumber/")
	public ResponseEntity<String>  getPortNumber(){
		
		return new ResponseEntity<String>("Port Number is : "+port, HttpStatus.OK);
	}
}
