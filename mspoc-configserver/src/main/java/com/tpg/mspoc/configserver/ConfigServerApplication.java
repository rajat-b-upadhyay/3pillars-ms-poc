package com.tpg.mspoc.configserver;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigServerApplication.class.getSimpleName());
	
	public static void main(String[] args) {
		log.info("Current Thread : {}", Thread.currentThread().getName());
		SpringApplication.run(ConfigServerApplication.class, args);
	}
	
	@Value("${spring.profiles.active}")
    private String profile=null;

	@PostConstruct
	public void getConfigs() {
		log.info("CONFIG SERVER APPLICATION PROFILE: {}",profile);
	}
}
