package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DentalGpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DentalGpBackendApplication.class, args);
	}

}
