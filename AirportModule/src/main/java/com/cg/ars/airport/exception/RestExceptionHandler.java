package com.cg.ars.airport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler
{
	@ExceptionHandler(AirportException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ApiError handleException(AirportException exc)
	{
		return new ApiError(exc.getMessage(), exc.getUri());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiError handleException(MethodArgumentNotValidException exc)
	{
	
		return new ApiError(exc.getMessage(), null);
	}
}
