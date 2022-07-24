package com.project.employeemanagement.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.project.employeemanagement.dto.EmployeeDTO;
import com.project.employeemanagement.service.EmployeeService;
import com.project.employeemanagement.util.TestDefaultClassUtil;

/**
 * EmployeeRestControllerService Integration Test class
 * 
 * @author hamdi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
public class EmployeeRestControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeService employeeService;
	
	@Test
	public void whenGetAllEmployees_thenReturnJsonArray() throws Exception {
		Mockito.when(employeeService.getAllEmployees()).thenReturn(TestDefaultClassUtil.defaultEmployeeDTOList());

	    mockMvc.perform(MockMvcRequestBuilders.get("/employee")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(2)))
	      .andExpect(jsonPath("$[0].id", is(1)))
	      .andExpect(jsonPath("$[0].name", is("John")))
	      .andExpect(jsonPath("$[0].jobRole", is("Software Engineer")))
	      .andExpect(jsonPath("$[1].id", is(2)))
	      .andExpect(jsonPath("$[1].name", is("Jane")))
	      .andExpect(jsonPath("$[1].jobRole", is("Test Engineer")));
	}
	
	@Test
	public void whenGetAllEmployeesWithPaging_thenReturnJsonArray() throws Exception {
		Mockito.when(employeeService.getAllEmployeesWithPaging(Mockito.any(Pageable.class))).thenReturn(TestDefaultClassUtil.defaultEmployeeDTOPage());

	    mockMvc.perform(MockMvcRequestBuilders.get("/employee/paging")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.size", is(2)))
	      .andExpect(jsonPath("$.pageable", is("INSTANCE")))
	      .andExpect(jsonPath("$.content", hasSize(2)))
	      .andExpect(jsonPath("$.content.[0].id", is(1)))
	      .andExpect(jsonPath("$.content.[0].name", is("John")));
	}
	
	@Test
	public void givenId_whenFindEmployeeById_thenReturnJsonArray() throws Exception {
		Mockito.when(employeeService.findEmployeeById(Mockito.anyLong())).thenReturn(TestDefaultClassUtil.defaultEmployeeDTO1());

	    mockMvc.perform(MockMvcRequestBuilders.get("/employee/{id}", Mockito.anyLong())
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.id", is(1)))
	      .andExpect(jsonPath("$.name", is("John")))
	      .andExpect(jsonPath("$.jobRole", is("Software Engineer")));
	}
	
	@Test
	public void givenEmployeeDTO_whenAddNewEmployee_thenReturnJsonArray() throws Exception {
		Mockito.when(employeeService.addNewEmployee(Mockito.any(EmployeeDTO.class))).thenReturn(TestDefaultClassUtil.defaultEmployeeDTO1());

	    mockMvc.perform(MockMvcRequestBuilders.post("/employee/add")
	      .content(TestDefaultClassUtil.asJsonString(TestDefaultClassUtil.defaultEmployeeDTO1()))
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.id", is(1)))
	      .andExpect(jsonPath("$.name", is("John")))
	      .andExpect(jsonPath("$.jobRole", is("Software Engineer")));
	}
	
	@Test
	public void givenEmployeeDTO_whenUpdateEmployee_thenReturnJsonArray() throws Exception {
		Mockito.when(employeeService.updateEmployee(Mockito.any(EmployeeDTO.class))).thenReturn(TestDefaultClassUtil.defaultEmployeeDTO1());

	    mockMvc.perform(MockMvcRequestBuilders.post("/employee/update")
	      .content(TestDefaultClassUtil.asJsonString(TestDefaultClassUtil.defaultEmployeeDTO1()))
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$.id", is(1)))
	      .andExpect(jsonPath("$.name", is("John")))
	      .andExpect(jsonPath("$.jobRole", is("Software Engineer")));
	}
}
