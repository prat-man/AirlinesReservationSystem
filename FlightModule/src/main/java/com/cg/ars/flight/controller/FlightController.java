package com.cg.ars.flight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ars.flight.dto.Flight;
import com.cg.ars.flight.exception.FlightException;
import com.cg.ars.flight.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController
{
	@Autowired
    private FlightService service;
    
    @PostMapping(path="/add",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Flight addFlight(@RequestBody @Valid Flight flight) throws FlightException {
        if(service.findByflightNo(flight.getFlightNo()) != null) {
            throw new FlightException("Flight with Flight No. :"+ flight.getFlightNo() + " already exists","/flight/add");
        }
        Flight newFlight = service.insert(flight);
        if(newFlight == null) {
            throw new FlightException("Flight:" + flight.getFlightNo() + "Could not be added","/flight/add");
        }else {
            return newFlight;
        }
    }
    
    @GetMapping(path="/view",produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Flight> viewAllFlights(){
        return service.findAll();  
    }
    
    @GetMapping(path="/find/{flightNo}",produces=MediaType.APPLICATION_JSON_VALUE)
    public Flight searchFlightbyId(@PathVariable("flightNo") String flightNo) {
    	return service.findByflightNo(flightNo);
    }
}
