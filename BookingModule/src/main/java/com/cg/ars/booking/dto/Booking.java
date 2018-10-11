package com.cg.ars.booking.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Booking")
public class Booking
{
	@Id
	private String bookingId;
	
	private String flightNo;
	
	private String username;
	
	private Integer noOfPassengers;
	
	private String classType;
	
	private Double totalFare;
	
	private String seatNumber;
	
	private String creditCardInfo;
	
	private String srcCity;
	
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
