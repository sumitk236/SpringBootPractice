package com.example.sprinboot.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sprinboot.dto.EmployeeDTO;
import com.example.sprinboot.model.Address;
import com.example.sprinboot.model.Employee;
import com.example.sprinboot.service.ConverterService;

@Repository
public class EmployeeDatabase {

	@Autowired
	EmployeeRepo employeeRepo;
	
static ConverterService converterService;	
	
	protected static final List<Employee> list =new ArrayList<>(Arrays.asList(
			new Employee(1, "Sumit", "Manager", Arrays.asList(new Address("bollarum","INDIA"))),
			new Employee(2, "Sujit", "Consultant", Arrays.asList(new Address("bollarum","INDIA")))
			));
	
	public static List<Employee> getallEmployess(){	
		return list;
	}
	
	public static void addEmployee(EmployeeDTO employeedto) {
		list.add(converterService.convertToEntity(employeedto));
	}

	public static void removeEmployeeRecord(int id) {
		list.removeIf(x->x.getEmpid()==id);
	}

	public static void updateEmployeeRecord(Employee employee, int id) {
		for(int i=0; i<list.size(); i++) {
			Employee emp=list.get(i);
			if(emp.getEmpid()==id) {
				list.set(i, employee);
			return;
			}
		}
	}

	public void addEmployeeInDB(Employee employee) {	
		employeeRepo.save(employee);
	}
}
