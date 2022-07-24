package com.project.employeemanagement.util;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.employeemanagement.dto.EmployeeDTO;
import com.project.employeemanagement.entity.Employee;

/**
 * Test Util class for object generations
 * 
 * @author hamdi
 *
 */
public class TestDefaultClassUtil {

	// DTO
	
	public static List<EmployeeDTO> defaultEmployeeDTOList(){
		
		return Arrays.asList(defaultEmployeeDTO1(), defaultEmployeeDTO2());
	}
	
	public static EmployeeDTO defaultEmployeeDTO1(){
		EmployeeDTO employeeDTO = EmployeeDTO.builder()
				.id(1L)
				.name("John")
				.jobRole("Software Engineer")
				.build();
		
		return employeeDTO;
	}
	
	public static EmployeeDTO defaultEmployeeDTO2(){
		EmployeeDTO employeeDTO = EmployeeDTO.builder()
				.id(2L)
				.name("Jane")
				.jobRole("Test Engineer")
				.build();

		return employeeDTO;
	}
	
	public static Page<EmployeeDTO> defaultEmployeeDTOPage(){
		
		return new PageImpl<EmployeeDTO>(defaultEmployeeDTOList());
	}
	
	
	// Entity
	
	public static List<Employee> defaultEmployeeList(){
		
		return Arrays.asList(defaultEmployee1(), defaultEmployee2());
	}
	
	public static Employee defaultEmployee1() {
		Employee employee = Employee.builder()
				.id(1L)
				.name("John")
				.jobRole("Software Engineer")
				.build();
		
		return employee;
	}
	
	public static Employee defaultEmployee2() {
		Employee employee = Employee.builder()
				.id(1L)
				.name("Jane")
				.jobRole("Test Engineer")
				.build();
		
		return employee;
	}
	
	public static Optional<Employee> defaultEmployeeOptional1() {
		return Optional.of(defaultEmployee1());
	}
	
	public static Page<Employee> defaultEmployeePage(){
		
		return new PageImpl<Employee>(defaultEmployeeList());
	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
}
