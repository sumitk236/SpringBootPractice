package com.example.sprinboot.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sprinboot.controllers.HelloController;
import com.example.sprinboot.model.Address;
import com.example.sprinboot.model.Employee;
import com.example.sprinboot.repository.EmployeeDatabase;
import com.example.sprinboot.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

	@Autowired
	HelloController helloController;
	
	@MockBean
	EmployeeDatabase employeeDatabase;
	
	@MockBean
	EmployeeService employeeService;
	
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
	
}
