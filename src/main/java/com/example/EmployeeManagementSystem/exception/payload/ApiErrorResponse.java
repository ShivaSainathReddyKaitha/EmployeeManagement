package com.example.EmployeeManagementSystem.exception.payload;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
	
	private LocalDateTime timestamp;
	private int errorCode;
	private String error;
	private String errormessage;
	private String path;
	

}
