package com.cg.ars.booking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler
{
	@ExceptionHandler(BookingException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ApiError handleException(BookingException exc)
	{
		return new ApiError(exc.getMessage(), exc.getUri());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiError handleException(Exception exc)
	{
		return new ApiError(exc.getMessage(), null);
	}
}
