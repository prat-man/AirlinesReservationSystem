package com.cg.ars.airport.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ars.airport.dto.Airport;
import com.cg.ars.airport.exception.AirportException;
import com.cg.ars.airport.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController
{
	@Autowired
	private AirportService aser;
	
	@PostMapping(path="/add")
	public Airport addAirport(@RequestBody @Valid Airport airport) throws AirportException {
		if(aser.findByAbbreviation(airport.getAbbreviation()) != null) {
			throw new AirportException("Airport with abbreviation:"+ airport.getAbbreviation() + " already exists","/airport/addAirport");
		}
		Airport newAirport = aser.insert(airport);
		if(newAirport == null) {
			throw new AirportException("Airport :" + airport.getAbbreviation() + "Could not be added","/airport/addAirport");
		}
		else {
			return newAirport;
		}
	}
	
	@DeleteMapping(path="/delete/{abreviation}")
	public String deleteAirport(@PathVariable("abbreviation") @Valid String abbreviation) throws AirportException {
		String deleteAirport = aser.deleteByAbbreviation(abbreviation);
		if(deleteAirport.equals("0")){
			throw new AirportException("Could not delete airport: " + abbreviation + "." + "The Airport may not exist in the DB","airport/deleteAirport/" + abbreviation);
		}else {
			return "Deleted Airport with abbreviation:" + abbreviation;
		}	
	}
	
	@GetMapping(path="/viewAllAirport",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Airport> viewAllAirport() throws AirportException{
		List<Airport> airportList = aser.findAll();
		if(airportList.isEmpty()) {
			throw new AirportException("No Airports Found","airport/viewAllAirport");
		}else
			return airportList;
	}
}
