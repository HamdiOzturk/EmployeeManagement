package com.project.employeemanagement.exception;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String message){
        super(message);
    }
}
