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
    private FlightService fser;
    
    @PostMapping(path="/add")
    public Flight addFlight(@RequestBody Flight flight) throws FlightException
    {
        if(fser.findByflightNo(flight.getFlightNo()) != null) {
            throw new FlightException("Flight with Flight No. :"+ flight.getFlightNo() + " already exists","/flight/add");
        }
        
        Flight newFlight = fser.insert(flight);
        
        if(newFlight == null) {
            throw new FlightException("Flight:" + flight.getFlightNo() + "Could not be added","/flight/add");
        }else {
            return newFlight;
        }
    }
    
    @GetMapping(path="/view")
    public List<Flight> viewAllFlights()
    {
        return fser.findAll();  
    }
    
    @GetMapping(path="/search/{depCity}/{arrCity}/{depDate}")
    public List<Flight> searchFlight(@PathVariable("depCity") String depCity, @PathVariable("arrCity") String arrCity, @PathVariable("depDate") String depDate)
    {
    	return fser.findByDepCityAndArrCityAndDepDate(depCity, arrCity, LocalDate.parse(depDate));
    }
}
