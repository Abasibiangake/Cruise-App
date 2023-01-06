package com.microservice.one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AbasibiangakeIlmaComp303Assignment4Application {

	public static void main(String[] args) {
		SpringApplication.run(AbasibiangakeIlmaComp303Assignment4Application.class, args);
		System.setProperty("spring.config.name", "customer-cruise-web");
	    System.out.println("Spring Boot JPA Customer Crusie web app started");
	}

}
