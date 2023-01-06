package com.microservice.two;
 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AbassIlmaComp303Assign4Application {

	public static void main(String[] args) {
		SpringApplication.run(AbassIlmaComp303Assign4Application.class, args);
		System.setProperty("spring.config.name", "employee-cruise-web");
	    System.out.println("Spring Boot Employee Crusie web app started");
	}

}
