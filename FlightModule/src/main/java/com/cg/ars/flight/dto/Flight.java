package com.cg.ars.flight.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Flight")
public class Flight
{
	@Id
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
	
	private LocalDate depDate;
	
	private LocalDate arrDate;
	
	private LocalTime depTime;
	
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
	
	@NotNull(message="Departure Airport cannot be Empty")
	@Pattern(regexp = "[A-Z]{3,4}",message="Departure Airport should be of the format:[WXYZ]")
	private String depAirport;
	
	@NotNull(message="Arrival Airport cannot be Empty")
	@Pattern(regexp = "[A-Z]{3,4}",message="Departure Airport should be of the format:[WXYZ]")
	private String arrAirport;
	
	@Transient
	public static final String FIRST = "First";
	
	@Transient
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

	public void setDepDate(LocalDate depDate) {
		this.depDate = depDate;
	}

	public LocalDate getArrDate() {
		return arrDate;
	}

	public void setArrDate(LocalDate arrDate) {
		this.arrDate = arrDate;
	}

	public LocalTime getDepTime() {
		return depTime;
	}

	public void setDepTime(LocalTime depTime) {
		this.depTime = depTime;
	}

	public LocalTime getArrTime() {
		return arrTime;
	}

	public void setArrTime(LocalTime arrTime) {
		this.arrTime = arrTime;
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

	public String getDepAirport() {
		return depAirport;
	}

	public void setDepAirport(String depAirport) {
		this.depAirport = depAirport;
	}

	public String getArrAirport() {
		return arrAirport;
	}

	public void setArrAirport(String arrAirport) {
		this.arrAirport = arrAirport;
	}

	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", airline=" + airline + ", depCity=" + depCity + ", arrCity=" + arrCity
				+ ", depDate=" + depDate + ", arrDate=" + arrDate + ", depTime=" + depTime + ", arrTime=" + arrTime
				+ ", firstSeats=" + firstSeats + ", firstSeatsFare=" + firstSeatsFare + ", bussSeats=" + bussSeats
				+ ", bussSeatsFare=" + bussSeatsFare + ", depAirport=" + depAirport + ", arrAirport=" + arrAirport
				+ "]";
	}
}
