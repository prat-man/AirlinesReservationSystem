package com.cg.ars.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages="com.cg.ars.booking")
@EnableMongoRepositories(basePackages="com.cg.ars.booking")

@SpringBootApplication
public class BookingModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingModuleApplication.class, args);
	}
}
