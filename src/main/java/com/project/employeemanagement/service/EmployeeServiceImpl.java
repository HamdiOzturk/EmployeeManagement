package com.project.employeemanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.employeemanagement.dto.EmployeeDTO;
import com.project.employeemanagement.entity.Employee;
import com.project.employeemanagement.exception.EmployeeNotFoundException;
import com.project.employeemanagement.exception.ExceptionUtil;
import com.project.employeemanagement.exception.RequiredInputException;
import com.project.employeemanagement.mapper.EmployeeMapper;
import com.project.employeemanagement.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employeeList = repository.findAll();
		return EmployeeMapper.mapToDTO(employeeList);
	}
	
	@Override
	public Page<EmployeeDTO> getAllEmployeesWithPaging(Pageable pageable) {
		Page<EmployeeDTO> employeeList = repository.findAll(pageable).map(entity -> {
			EmployeeDTO dto = EmployeeMapper.mapToDTO(entity);
	        return dto;
	    });
		return employeeList;
	}

	@Override
	public EmployeeDTO findEmployeeById(Long id) throws EmployeeNotFoundException, RequiredInputException {
		if (id == null) {
			ExceptionUtil.throwIdRequiredException();
		}
			
		Optional<Employee> employeeOptional = repository.findById(id);
		if (employeeOptional.isPresent()) {
			return EmployeeMapper.mapToDTO(employeeOptional.get());
		} else {
			ExceptionUtil.throwEmployeeNotFoundException(id);
		}
		return null;
	}

	@Override
	public EmployeeDTO addNewEmployee(EmployeeDTO employeeDTO) throws RequiredInputException{
		if (employeeDTO == null) {
			ExceptionUtil.throwEmployeeDTORequiredException();
		}
			
		Employee employee = EmployeeMapper.mapToEntity(employeeDTO);
		return EmployeeMapper.mapToDTO(repository.save(employee));
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) throws EmployeeNotFoundException, RequiredInputException {
		if (employeeDTO == null) {
			ExceptionUtil.throwEmployeeDTORequiredException();
		}
		if (employeeDTO.getId() == null) {
			ExceptionUtil.throwIdRequiredException();
		}
			
		Optional<Employee> employeeOptional = repository.findById(employeeDTO.getId());
		if (employeeOptional.isPresent()) {
			Employee employee = employeeOptional.get();
			employee = EmployeeMapper.mapToEntity(employee, employeeDTO);
			return EmployeeMapper.mapToDTO(repository.save(employee));
		} else {
			ExceptionUtil.throwEmployeeNotFoundException(employeeDTO.getId());
		}
		return null;
	}

}
