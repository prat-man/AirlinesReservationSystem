package com.cg.ars.flight.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.ars.flight.dto.Flight;

public interface FlightService extends MongoRepository<Flight, String> {

}
