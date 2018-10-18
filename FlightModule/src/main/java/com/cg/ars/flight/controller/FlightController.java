package com.cg.ars.flight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @PostMapping(path="/add")
    public Flight addFlight(@RequestBody Flight flight) throws FlightException
    {
        if(service.findByflightNo(flight.getFlightNo()) != null) {
            throw new FlightException("Flight with Flight No. :"+ flight.getFlightNo() + " already exists","/flight/add");
        }
        
        Flight newFlight = service.insert(flight);
        
        if(newFlight == null) {
            throw new FlightException("Flight:" + flight.getFlightNo() + "Could not be added","/flight/add");
        }
        else {
            return newFlight;
        }
    }
    
    @GetMapping(path="/view")
    public List<Flight> viewAllFlights()
    {
        return service.findAll();
    }
    
    @GetMapping(path="/search/{depCity}/{arrCity}/{depDate}")
    public List<Flight> searchFlight(@PathVariable("depCity") String depCity, @PathVariable("arrCity") String arrCity, @PathVariable("depDate") String depDate)
    {
        return service.findByDepCityAndArrCityAndDepDate(depCity, arrCity, LocalDate.parse(depDate));
    }
    
    @RequestMapping(path="/getCityList/{query}")
    public List<String> autocomplete(@PathVariable("query") String depCity){
		return service.findByDepCityLike(depCity);	
    }
    
    @RequestMapping(path="/searchbyFlightNo/{flightNo}")
    public Flight searchByFlightNo(@PathVariable String flightNo) {
    	return service.findByflightNo(flightNo);
    }
}
