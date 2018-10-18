package com.cg.ars.client.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.cg.ars.client")

@SpringBootApplication
@EnableEurekaClient
public class ClientModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientModuleApplication.class, args);
	}
}
