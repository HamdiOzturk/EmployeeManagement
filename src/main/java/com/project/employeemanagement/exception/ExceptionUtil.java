package com.project.employeemanagement.exception;

/**
 * Exception Util class
 * 
 * @author hamdi
 *
 */
public class ExceptionUtil {

	public static void throwIdRequiredException() throws RequiredInputException {
		throw new RequiredInputException("Id can not be null!");
	}
	
	public static void throwEmployeeDTORequiredException() throws RequiredInputException {
		throw new RequiredInputException("EmployeeDTO can not be null!");
	}
	
	public static void throwEmployeeNotFoundException(Long id) throws EmployeeNotFoundException {
		throw new EmployeeNotFoundException("Employee not found with id: " + id);
	}
}
