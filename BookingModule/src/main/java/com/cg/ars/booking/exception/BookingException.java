package com.cg.ars.booking.exception;

public class BookingException extends Exception
{
	private static final long serialVersionUID = -178378712590879194L;
	
	private String uri;
	
	public BookingException(String message, String uri)
	{
		super(message);
		this.uri = uri;
	}

	public String getUri()
	{
		return uri;
	}
}
