package com.example.sprinboot.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sprinboot.dto.EmployeeDTO;
import com.example.sprinboot.model.Employee;

@Component
public class ConverterService {

	@Autowired
	ModelMapper modelMapper;
	
	public EmployeeDTO convertToDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDTO.class);
	}
	
	public Employee convertToEntity(EmployeeDTO employeeDTO) {
		return modelMapper.map(employeeDTO, Employee.class);
	}
	
}
