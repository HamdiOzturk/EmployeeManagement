package com.project.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EmployeeDTO class is the model of the Employee Entity class
 * 
 * @author hamdi
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

	private Long id;
	private String name;
	private String jobRole;
	
}
