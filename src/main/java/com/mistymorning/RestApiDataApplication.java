package com.mistymorning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiDataApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/rest/v1");
		SpringApplication.run(RestApiDataApplication.class, args);
	}

}
