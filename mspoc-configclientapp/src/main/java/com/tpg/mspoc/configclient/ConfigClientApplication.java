package com.tpg.mspoc.configclient;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ConfigClientApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigClientApplication.class.getSimpleName());
	
	public static void main(String[] args) {
		log.info("Current Thread : {}", Thread.currentThread().getName());
		SpringApplication.run(ConfigClientApplication.class, args);
	}
	
	@Value("${spring.profiles.active}")
    private String profile=null;
	
	@Value("${app.props.file.name}")
    private String fileName=null;
	
	@Value("${app.prop1}")
    private String prop1=null;
	
	@Value("${app.prop2}")
    private String prop2=null;

	@Value("${app.common.prop1}")
	private String commonAppProp=null;
	
	@PostConstruct
	public void getConfigs() {
		log.info("CONFIG SERVER APPLICATION PROFILE: {}",profile);
		log.info("CONFIG SERVER APPLICATION fileName: {}",fileName);
		log.info("CONFIG SERVER APPLICATION prop1: {}",prop1);
		log.info("CONFIG SERVER APPLICATION prop2: {}",prop2);
		log.info("CONFIG SERVER APPLICATION commonAppProp: {}",commonAppProp);
	}
}
