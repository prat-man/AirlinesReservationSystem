package com.cg.ars.user.exception;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler
{
	private static final Logger logger = LogManager.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody ApiError handleException(UserException exc)
	{
		logger.error(exc.getMessage() + " [url=" + exc.getUri() + "]");
		return new ApiError(exc.getMessage(), exc.getUri());
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiError handleException(Exception exc)
	{
		logger.error(exc.getMessage());
		return new ApiError(exc.getMessage(), null);
	}
}
