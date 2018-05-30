package com.zuster.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class User0_1_Application {

	public static void main(String[] args) {
		SpringApplication.run(User0_1_Application.class, args);
	}
}
