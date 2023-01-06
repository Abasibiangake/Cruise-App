package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootJpaDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaDiscoveryServerApplication.class, args);
		System.out.println("Spring Boot Eureka server started");

	}

}
