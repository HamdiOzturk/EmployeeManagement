package com.project.employeemanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.employeemanagement.dto.EmployeeDTO;

/**
 * EmployeeService interface
 * 
 * @author hamdi
 *
 */
public interface EmployeeService {

	/**
	 * gets all employees
	 */
	public List<EmployeeDTO> getAllEmployees();
	
	/**
	 * gets all employees in page
	 */
	public Page<EmployeeDTO> getAllEmployeesWithPaging(Pageable pageable);

	/**
	 * finds an employee by id
	 */
	public EmployeeDTO findEmployeeById(Long id) ;
	
	/**
	 * adds a new employee and generates a new id
	 */
	public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO) ;

	/**
	 * updates and existing employee by its id given in the EmployeeDTO
	 */
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) ;
}
