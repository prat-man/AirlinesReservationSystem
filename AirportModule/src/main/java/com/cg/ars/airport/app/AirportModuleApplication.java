package com.cg.ars.airport.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages="com.cg.ars.airport")
@EnableMongoRepositories(basePackages="com.cg.ars.airport")

@SpringBootApplication
@EnableEurekaClient
public class AirportModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportModuleApplication.class, args);
	}
}
