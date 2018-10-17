package com.cg.ars.flight.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cg.ars.flight.dto.Flight;

public interface FlightService extends MongoRepository<Flight, String> 
{

	Flight findByflightNo(String flightNo);
	@Query("{'depCity': ?0, 'arrCity': ?1, 'depDate': ?2}")
	List<Flight> findByDepCityandArrCityandDepDate(String depCity, String arrCity, String depDate);


}
