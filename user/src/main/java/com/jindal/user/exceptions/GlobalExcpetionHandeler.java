package com.jindal.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jindal.user.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExcpetionHandeler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
		var apiresponse = ApiResponse.builder().message(exception.getMessage()).success(false).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(apiresponse, HttpStatus.NOT_FOUND);
		
	}
}
