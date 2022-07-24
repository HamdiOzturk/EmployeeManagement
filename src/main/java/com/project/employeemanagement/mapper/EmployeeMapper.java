package com.project.employeemanagement.mapper;

import java.util.ArrayList;
import java.util.List;

import com.project.employeemanagement.dto.EmployeeDTO;
import com.project.employeemanagement.entity.Employee;

/**
 * EmployeeDTO / Employee mapping util class
 * 
 * @author hamdi
 *
 */
public class EmployeeMapper {

	public static Employee mapToEntity(EmployeeDTO employeeDTO) {
		if (employeeDTO!=null)
			return Employee.builder()
				.name(employeeDTO.getName())
				.jobRole(employeeDTO.getJobRole())
				.build();
		else
			return null;
	}
	
	public static EmployeeDTO mapToDTO(Employee employee) {
		if (employee!=null)
			return EmployeeDTO.builder()
					.id(employee.getId())
					.name(employee.getName())
					.jobRole(employee.getJobRole())
					.build();
		else
			return null;
	}

	public static List<EmployeeDTO> mapToDTO(List<Employee> employeeList) {
		List<EmployeeDTO> dtoList = null;
		if(employeeList != null && !employeeList.isEmpty()) {
			dtoList = new ArrayList<EmployeeDTO>();
			for(Employee employee : employeeList) {
				dtoList.add(mapToDTO(employee));
			}
		}
		return dtoList;
	}
	
	public static Employee mapToEntity(Employee employee, EmployeeDTO employeeDTO) {
		if (employeeDTO!=null)
			if (employee == null) {
				return mapToEntity(employeeDTO);
			} else {
				employee.setName(employeeDTO.getName());
				employee.setJobRole(employeeDTO.getJobRole());
				return employee;
			}
		else
			return null;
	}
}
