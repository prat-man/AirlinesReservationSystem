package com.cg.ars.flight.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cg.ars.flight.controller.FlightController;

@Configuration
public class JavaConfig {
	@Bean
	public Logger getLogger(){
		return LogManager.getLogger(FlightController.class);
	}
}
