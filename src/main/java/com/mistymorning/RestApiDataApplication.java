package com.mistymorning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiDataApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(RestApiDataApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("***********Test logging message at startup in "+ RestApiDataApplication.class.getSimpleName());
		System.setProperty("server.servlet.context-path", "/rest");
		SpringApplication.run(RestApiDataApplication.class, args);
	}

}
