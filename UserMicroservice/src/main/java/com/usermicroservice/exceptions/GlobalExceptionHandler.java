package com.usermicroservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.usermicroservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public String handlerResourceNotFoundExceptionEntityf(ResourceNotFoundException ex) {
		String message=ex.getMessage();
		return message;
			
	}
}
