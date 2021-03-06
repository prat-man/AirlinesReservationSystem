package com.cg.ars.client.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Flight
{
	@NotNull(message="FlightNo cannot be Empty")
	@Pattern(regexp = "[A-Z]{3,4}[0-9]{4,6}",message="FlightNo should be of the format:[XYZ1234]")
	private String flightNo;
	
	@NotNull(message="Airline cannot be Empty")
	@Pattern(regexp = "([A-Z][a-z]+ )*[A-Z][a-z]+",message="Airline should be of the format:[Xyz Pqr]")
	private String airline;
	
	@NotNull(message="Departure City cannot be Empty")
	@Pattern(regexp = "([A-Z][a-z]+ )*[A-Z][a-z]+",message="Departure City should be of the format:[Xyz Pqr]")
	private String depCity;
	
	@NotNull(message="Arrival City cannot be Empty")
	@Pattern(regexp = "([A-Z][a-z]+ )*[A-Z][a-z]+",message="Arrival City should be of the format:[Xyz Pqr]")
	private String arrCity;
	
	@NotNull(message="Departure Date cannot be Empty")
	private LocalDate depDate;
	
	@NotNull(message="Arrival City cannot be Empty")
	private LocalDate arrDate;
	
	@NotNull(message="Departure Time cannot be Empty")
	private LocalTime depTime;
	
	@NotNull(message="Arrival Time cannot be Empty")
	private LocalTime arrTime;
	
	@NotNull(message="Seats cannot be Empty")
	@Min(value=1)
	private Integer firstSeats;
	
	@NotNull(message="Seats fare cannot be Empty")
	@Min(value=1000)
	private Double firstSeatsFare;
	
	@NotNull(message="Seats cannot be Empty")
	@Min(value=1)
	private Integer bussSeats;
	
	@NotNull(message="Seats fare cannot be Empty")
	@Min(value=1000)
	private Double bussSeatsFare;
	
	public static final String FIRST = "First";
	
	public static final String BUSINESS = "Business";

	public Flight() {
		super();
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDepCity() {
		return depCity;
	}

	public void setDepCity(String depCity) {
		this.depCity = depCity;
	}

	public String getArrCity() {
		return arrCity;
	}

	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}

	public LocalDate getDepDate() {
		return depDate;
	}

	public void setDepDate(String depDate) {
		this.depDate = LocalDate.parse(depDate);
	}

	public LocalDate getArrDate() {
		return arrDate;
	}

	public void setArrDate(String arrDate) {
		this.arrDate = LocalDate.parse(arrDate);
	}

	public LocalTime getDepTime() {
		return depTime;
	}

	public void setDepTime(String depTime) {
		this.depTime = LocalTime.parse(depTime);
	}

	public LocalTime getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = LocalTime.parse(arrTime);
	}

	public Integer getFirstSeats() {
		return firstSeats;
	}

	public void setFirstSeats(Integer firstSeats) {
		this.firstSeats = firstSeats;
	}

	public Double getFirstSeatsFare() {
		return firstSeatsFare;
	}

	public void setFirstSeatsFare(Double firstSeatsFare) {
		this.firstSeatsFare = firstSeatsFare;
	}

	public Integer getBussSeats() {
		return bussSeats;
	}

	public void setBussSeats(Integer bussSeats) {
		this.bussSeats = bussSeats;
	}

	public Double getBussSeatsFare() {
		return bussSeatsFare;
	}

	public void setBussSeatsFare(Double bussSeatsFare) {
		this.bussSeatsFare = bussSeatsFare;
	}

	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", airline=" + airline + ", depCity=" + depCity + ", arrCity=" + arrCity
				+ ", depDate=" + depDate + ", arrDate=" + arrDate + ", depTime=" + depTime + ", arrTime=" + arrTime
				+ ", firstSeats=" + firstSeats + ", firstSeatsFare=" + firstSeatsFare + ", bussSeats=" + bussSeats
				+ ", bussSeatsFare=" + bussSeatsFare + "]";
	}
}
