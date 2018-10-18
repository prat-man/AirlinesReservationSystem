package com.cg.ars.airport.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.ars.airport.dto.Airport;

public interface AirportService extends MongoRepository<Airport, String> {

	public String deleteByAbbreviation(String airportAbbreviation);

	public Airport findByAbbreviation(String abbreviation);

}
