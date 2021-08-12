package com.example.sprinboot;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.sprinboot.controllers.HelloController;
import com.example.sprinboot.dto.EmployeeDTO;
import com.example.sprinboot.model.Employee;
import com.example.sprinboot.repository.EmployeeDatabase;
import com.example.sprinboot.repository.EmployeeRepo;
import com.example.sprinboot.service.ConverterService;
import com.example.sprinboot.service.EmployeeService;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	HelloController helloController;
	
	@MockBean
	EmployeeDatabase employeeDatabase;
	
	@MockBean
	EmployeeRepo employerepo;
	@MockBean
	EmployeeService employeeService;
	
	@MockBean
	ConverterService service;
	
	@Test
	public void shouldGetAllEmployeeDetails() {
		when(employeeService.getAllEmployessDetialsInSorted()).thenReturn(Arrays.asList(new Employee(1, "Sumit", "Manager", Collections.emptyList())));
		assertEquals(1, helloController.showEmployessDetailsInSortedOrder().size());
	}
	
	@Test
	public void getAllEmployeeDetailsTest() {
		when(employeeService.getAllEmployeesDetailsById(1)).thenReturn(Arrays.asList(new Employee(1, "Sumit", "Manager", Collections.emptyList())));
		assertEquals(1, helloController.showEmployeeDetailById(1).size());
	}
	
	@Test
	public void convertToDtoTest() {
		Employee employee=new Employee(1, "Sumit", "Manager", Collections.emptyList());
		when(employerepo.save(employee)).thenReturn(employee);
		assertEquals(employee, employee);
	
		
	}

	
}
