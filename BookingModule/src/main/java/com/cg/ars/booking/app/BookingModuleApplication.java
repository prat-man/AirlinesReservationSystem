package com.cg.ars.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages="com.cg.ars.booking")
@EnableMongoRepositories(basePackages="com.cg.ars.booking")

@SpringBootApplication
@EnableEurekaClient
public class BookingModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingModuleApplication.class, args);
	}
}
