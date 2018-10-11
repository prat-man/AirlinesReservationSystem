package com.cg.ars.airport.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Airport")
public class Airport
{
	@Id
	private String abbreviation;
	
	private String airportName;
	
	private String location;

	public Airport() {
		super();
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Airport [abbreviation=" + abbreviation + ", airportName=" + airportName + ", location=" + location
				+ "]";
	}
}
