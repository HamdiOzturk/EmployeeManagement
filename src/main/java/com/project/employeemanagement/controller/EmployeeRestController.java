package com.project.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemanagement.dto.EmployeeDTO;
import com.project.employeemanagement.exception.EmployeeNotFoundException;
import com.project.employeemanagement.exception.RequiredInputException;
import com.project.employeemanagement.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

/**
 * EmployeeRestController controller class
 * 
 * @author hamdi
 *
 */
@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping()
	@ApiOperation(value = "Retrieves a list of all employee records")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}
	
	@GetMapping("/paging")
	@ApiOperation(value = "Retrieves a page of all employee records")
	public ResponseEntity<Page<EmployeeDTO>> getAllEmployeesWithPaging(Pageable pageable){
		return ResponseEntity.ok().body(employeeService.getAllEmployeesWithPaging(pageable));
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Retrieves a single employee record by its id")
	public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException, RequiredInputException {
		return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "Creates a new employee")
	public ResponseEntity<EmployeeDTO> addNewEmployee(@RequestBody EmployeeDTO employeeDTO) throws RequiredInputException {
		return ResponseEntity.ok().body(employeeService.addNewEmployee(employeeDTO));
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "Updates an existing employee record by its id")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) throws EmployeeNotFoundException, RequiredInputException {
		return ResponseEntity.ok().body(employeeService.updateEmployee(employeeDTO));
	}
}
