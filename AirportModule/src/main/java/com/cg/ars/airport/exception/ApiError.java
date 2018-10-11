package com.cg.ars.airport.exception;

import java.time.LocalDateTime;

public class ApiError
{
	private LocalDateTime timestamp;
	
	private String message;
	
	private String uri;

	public ApiError(String message, String uri)
	{
		this.timestamp = LocalDateTime.now();
		this.message = message;
		this.uri = uri;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getUri() {
		return uri;
	}
}
