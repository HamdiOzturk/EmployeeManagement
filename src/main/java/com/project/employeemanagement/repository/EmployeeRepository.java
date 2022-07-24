package com.project.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.employeemanagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, 
											JpaSpecificationExecutor<Employee>, 
											PagingAndSortingRepository<Employee, Long>{

}
