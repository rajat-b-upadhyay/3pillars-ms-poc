package com.tpg.mspoc.sqlcrud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "scheduler-service", fallback = FeignServiceImpl.class)
public interface FeignService {

	@GetMapping(path = "portNumber/")
	public ResponseEntity<String>  getPortNumber();
}

@Component
class FeignServiceImpl implements FeignService{

	@Override
	public ResponseEntity<String> getPortNumber() {
		return new ResponseEntity<String>("Default port : 8080", HttpStatus.OK);
	}
	
}


