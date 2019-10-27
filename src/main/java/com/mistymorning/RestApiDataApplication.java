package com.mistymorning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RestApiDataApplication {
	
	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/rest");
		SpringApplication.run(RestApiDataApplication.class, args);
		
	}


}
