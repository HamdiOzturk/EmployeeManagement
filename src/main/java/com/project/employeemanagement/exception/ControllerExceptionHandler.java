package com.project.employeemanagement.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception Handler class
 * 
 * @author hamdi
 *
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleDataNotFoundException(EmployeeNotFoundException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
	
	@ExceptionHandler(RequiredInputException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleRequiredInputException(RequiredInputException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return errorMap;
    }
}
