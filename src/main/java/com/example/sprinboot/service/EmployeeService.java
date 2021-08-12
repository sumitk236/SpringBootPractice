package com.example.sprinboot.service;



import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sprinboot.dto.EmployeeDTO;
import com.example.sprinboot.model.Employee;
import com.example.sprinboot.repository.EmployeeDatabase;

@Service
public class EmployeeService {
	
	public List<Employee> getAllEmployessDetialsInSorted(){
		List<Employee> empDetails = EmployeeDatabase.getallEmployess();
		Collections.sort(empDetails);
		return empDetails;
	}
	
	public List<Employee> getAllEmployeesDetailsById(int id){
		List<Employee> empDetails=EmployeeDatabase.getallEmployess();
		return empDetails.stream().filter(x->x.getEmpid()==id).collect(Collectors.toList());
	}
	
	public void putEmployeeDetail(EmployeeDTO employeedto) {
		EmployeeDatabase.addEmployee(employeedto);
		
	}
	
	public void deleteEmployee(int id) {
		EmployeeDatabase.removeEmployeeRecord(id);
	}
	
	public void updateEmployeeDetails(Employee employee ,int id) {
		EmployeeDatabase.updateEmployeeRecord(employee,id);
	}
}
