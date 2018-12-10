package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootConsulCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsulCApplication.class, args);
	}
}
