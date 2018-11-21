package com.tpg.mspoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class.getSimpleName());
	
	public static void main(String[] args) {
		log.info("Current Thread : {}", Thread.currentThread().getName());
		SpringApplication.run(Application.class, args);
	}
}
