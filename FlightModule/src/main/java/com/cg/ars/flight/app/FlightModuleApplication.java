package com.cg.ars.flight.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages="com.cg.ars.flight")
@EnableMongoRepositories(basePackages="com.cg.ars.flight")

@SpringBootApplication
public class FlightModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightModuleApplication.class, args);
	}
}
