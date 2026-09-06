package com.example.EmployeeManagementSystem.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.EmployeeManagementSystem.exception.payload.ApiErrorResponse;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleemployeeNotFoundException(EmployeeNotFoundException ex,
			HttpServletRequest request) {
		ApiErrorResponse response = new ApiErrorResponse(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURL().toString());
		return ResponseEntity.ok(response);
	}
	
	

}
