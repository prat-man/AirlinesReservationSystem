package com.cg.ars.user.exception;

public class UserException extends Exception
{
	private static final long serialVersionUID = -178378712590879194L;
	
	private String uri;
	
	public UserException(String message, String uri)
	{
		super(message);
		this.uri = uri;
	}

	public String getUri()
	{
		return uri;
	}
}
