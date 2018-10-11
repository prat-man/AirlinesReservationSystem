package com.cg.ars.flight.exception;

public class FlightException extends Exception
{
	private static final long serialVersionUID = -178378712590879194L;
	
	private String uri;
	
	public FlightException(String message, String uri)
	{
		super(message);
		this.uri = uri;
	}

	public String getUri()
	{
		return uri;
	}
}
