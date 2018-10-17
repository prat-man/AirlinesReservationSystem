package com.cg.ars.flight.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.ars.flight.dto.Flight;

public interface FlightService extends MongoRepository<Flight, String> 
{

	public Flight findByflightNo(String flightNo);
	
	public List<Flight> findByDepCityAndArrCityAndDepDate(String depCity, String arrCity, LocalDate depDate);
	
}
