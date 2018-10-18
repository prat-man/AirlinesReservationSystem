package com.cg.ars.airport.exception;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler
{
	@Autowired
	private Logger logger;
	
	@ExceptionHandler(AirportException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ApiError handleException(AirportException exc)
	{
		logger.error(exc.getMessage() + " [url=" + exc.getUri() + "]");
		return new ApiError(exc.getMessage(), exc.getUri());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiError handleException(MethodArgumentNotValidException exc)
	{
		logger.error(exc.getMessage());
		return new ApiError(exc.getMessage(), null);
	}
}
