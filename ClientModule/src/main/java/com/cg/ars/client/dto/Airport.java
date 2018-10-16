package com.cg.ars.client.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Airport
{
	@NotNull(message="Airport abbreviation is required")
    @Pattern(regexp = "[A-Z]{3,4}",message="Abbreviation should be of the format:[XYZ123]")
	private String abbreviation;
	
	@NotNull(message="Airport name is required")
	@Pattern(regexp = "([A-Z][a-z]+ )*[A-Z][a-z]+",message="Airport Name cannot be blank and should start with UPPERCASE letter")
	private String airportName;
	
	@NotNull(message="Location is required")
	@Pattern(regexp = "([A-Z][a-z]+ )*[A-Z][a-z]+",message="Location cannot be empty and should start with UPPERCASE letter")
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
