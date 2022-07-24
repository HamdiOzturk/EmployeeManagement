package com.project.employeemanagement.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.employeemanagement.dto.EmployeeDTO;
import com.project.employeemanagement.entity.Employee;
import com.project.employeemanagement.exception.EmployeeNotFoundException;
import com.project.employeemanagement.exception.RequiredInputException;
import com.project.employeemanagement.repository.EmployeeRepository;
import com.project.employeemanagement.util.TestDefaultClassUtil;

/**
 * EmployeeService Test class
 * 
 * @author hamdi
 *
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeServiceImpl employeeService;
	
	@Mock
	EmployeeRepository employeeRepository;

	@Test
	void whenGetAllEmployees_thenReturnEmployeeDTOList() {
		Mockito.when(employeeRepository.findAll()).thenReturn(TestDefaultClassUtil.defaultEmployeeList());

		List<EmployeeDTO> returnObject = employeeService.getAllEmployees();
		
		assertThat(returnObject.size()).isEqualTo(2);
	}
	
	@Test
	void whenGetAllEmployeesWithPaging_thenReturnEmployeeDTOPage() {
		Mockito.when(employeeRepository.findAll(Mockito.any(Pageable.class))).thenReturn(TestDefaultClassUtil.defaultEmployeePage());

		Page<EmployeeDTO> returnObject = employeeService.getAllEmployeesWithPaging(Mockito.mock(Pageable.class));
		
		assertThat(returnObject.getSize()).isEqualTo(2);
	}
	
	@Test
	void givenId_whenFindEmployeeById_thenReturnEmployeeDTO() throws EmployeeNotFoundException, RequiredInputException {
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(TestDefaultClassUtil.defaultEmployeeOptional1());

		EmployeeDTO returnObject = employeeService.findEmployeeById(Mockito.anyLong());
		
		assertThat(returnObject.getId()).isEqualTo(1);
		assertThat(returnObject.getName()).isEqualTo("John");
		assertThat(returnObject.getJobRole()).isEqualTo("Software Engineer");
	}
	
	@Test
	void givenEmployeeDTO_whenAddNewEmployee_thenReturnEmployeeDTO() throws EmployeeNotFoundException, RequiredInputException {
		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(TestDefaultClassUtil.defaultEmployee1());

		EmployeeDTO returnObject = employeeService.addNewEmployee(Mockito.mock(EmployeeDTO.class));
		
		assertThat(returnObject.getId()).isEqualTo(1);
		assertThat(returnObject.getName()).isEqualTo("John");
		assertThat(returnObject.getJobRole()).isEqualTo("Software Engineer");
	}

	@Test
	void givenEmployeeDTO_whenUpdateEmployee_thenReturnEmployeeDTO() throws EmployeeNotFoundException, RequiredInputException {
		Mockito.when(employeeRepository.findById(Mockito.anyLong())).thenReturn(TestDefaultClassUtil.defaultEmployeeOptional1());
		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(TestDefaultClassUtil.defaultEmployee1());

		EmployeeDTO returnObject = employeeService.updateEmployee(Mockito.mock(EmployeeDTO.class));
		
		assertThat(returnObject.getId()).isEqualTo(1);
		assertThat(returnObject.getName()).isEqualTo("John");
		assertThat(returnObject.getJobRole()).isEqualTo("Software Engineer");
	}
}
