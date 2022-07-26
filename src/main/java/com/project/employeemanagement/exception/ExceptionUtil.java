package com.project.employeemanagement.exception;

/**
 * Exception Util class
 * 
 * @author hamdi
 *
 */
public class ExceptionUtil {

	public static void throwIdRequiredException() {
		throw new RequiredInputException("Id can not be null!");
	}
	
	public static void throwEmployeeDTORequiredException() {
		throw new RequiredInputException("EmployeeDTO can not be null!");
	}
	
	public static void throwEmployeeNotFoundException(Long id) {
		throw new EmployeeNotFoundException("Employee not found with id: " + id);
	}
}
