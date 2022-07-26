package com.project.employeemanagement.exception;

public class RequiredInputException extends RuntimeException {
	public RequiredInputException(String message){
        super(message);
    }

}
