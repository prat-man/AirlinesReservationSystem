package com.cg.ars.client.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Booking
{
	@NotNull(message= "Booking ID cannot be null")
	@Pattern(regexp="[A-Z]{3,4}[0-9]{4,6}",message="Invalid Booking ID. Must be 3 to 4 UPPERCASE alphabets followed by 4 to 6 digits")
	private String bookingId;
	
	@NotNull(message= "Flight Number cannot be null")
	@Pattern(regexp="[A-Z]{3,4}[0-9]{4,6}",message="Invalid Flight Number. Must be 3 to 4 UPPERCASE alphabets followed by 4 to 6 digits")
	private String flightNo;
	
	@NotNull(message= "Name cannot be null")
	@Pattern(regexp="([A-Z][a-z]+ )*[A-Z][a-z]+",message="Invalid Name. Must start with UPPERCASE followed by lowercase alphabets")
	private String name;
	
	@NotNull(message= "Number of Passengers cannot be null")
	private Integer noOfPassengers;
	
	private String classType;
	
	private Double totalFare;
	
	@NotNull(message= "Credit Card Information cannot be null")
	@Pattern(regexp="[0-9]{16}",message="Invalid Credit Card Information. Must be exactly 16 digits")
	private String creditCardInfo;
	
	@NotNull(message= "Source City cannot be null")
	@Pattern(regexp="([A-Z][a-z]+ )*[A-Z][a-z]+",message="Invalid City Name. Must start with UPPERCASE followed by lowercase alphabets")
	private String srcCity;
	
	@NotNull(message= "Destination City cannot be null")
	@Pattern(regexp="([A-Z][a-z]+ )*[A-Z][a-z]+",message="Invalid City Name. Must start with UPPERCASE followed by lowercase alphabets")
	private String destCity;

	public Booking() {
		super();
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}


	public String getCreditCardInfo() {
		return creditCardInfo;
	}

	public void setCreditCardInfo(String creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}

	public String getSrcCity() {
		return srcCity;
	}

	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public void setDestCity(String destCity) {
		this.destCity = destCity;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", flightNo=" + flightNo + ", name=" + name
				+ ", noOfPassengers=" + noOfPassengers + ", classType=" + classType + ", totalFare=" + totalFare
				+ ", creditCardInfo=" + creditCardInfo + ", srcCity=" + srcCity
				+ ", destCity=" + destCity + "]";
	}
}
