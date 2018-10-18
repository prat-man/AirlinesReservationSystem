package com.cg.ars.booking.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Booking")
public class Booking
{
	@Id
	private String bookingId;
	
	@NotNull(message= "Flight Number cannot be null.")
	@Pattern(regexp="[A-Z]{3,4}[0-9]{4,6}",message="Invalid Flight Number. Must be 3 to 4 UPPERCASE alphabets followed by 4 to 6 digits")
	private String flightNo;
	
	@NotNull(message= "Username cannot be null.")
	@Pattern(regexp="[A-Za-z][A-Za-z0-9\\.\\-\\_]{7,39}",message="Invalid Username. Must be atleast 8 characters long. Must start with an alphabet. Can contain UPPERCASE, lowercase, digits, ., -, and _")
	private String username;
	
	@NotNull(message= "Number of Passengers cannot be null.")
	private Integer noOfPassengers;
	
	@NotNull(message= "Class Type cannot be null.")
	private String classType;
	
	private Double totalFare;
	
	@NotNull(message= "Credit Card Information cannot be null.")
	@Pattern(regexp="[0-9]{16}",message="Invalid Credit Card Information. Must be exactly 16 digits")
	private String creditCardInfo;
	
	@NotNull(message= "Source City cannot be null.")
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
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
		return "Booking [bookingId=" + bookingId + ", flightNo=" + flightNo + ", username=" + username
				+ ", noOfPassengers=" + noOfPassengers + ", classType=" + classType + ", totalFare=" + totalFare
				+ ", seatNumber=" + seatNumber + ", creditCardInfo=" + creditCardInfo + ", srcCity=" + srcCity
				+ ", destCity=" + destCity + "]";
	}
}
