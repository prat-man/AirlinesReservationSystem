package com.cg.ars.airport.exception;

public class AirportException extends Exception
{
	private static final long serialVersionUID = -178378712590879194L;
	
	private String uri;
	
	public AirportException(String message, String uri)
	{
		super(message);
		this.uri = uri;
	}

	public String getUri()
	{
		return uri;
	}
}
