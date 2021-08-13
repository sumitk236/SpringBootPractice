package com.example.sprinboot.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sprinboot.dto.EmployeeDTO;
import com.example.sprinboot.model.Employee;
import com.example.sprinboot.repository.EmployeeDatabase;
import com.example.sprinboot.repository.EmployeeRepo;
import com.example.sprinboot.service.EmployeeService;

@RestController
public class HelloController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeDatabase database;
	
	@Autowired
	EmployeeRepo emprepo;
	
	@Autowired
	MessageChannel output;

	@Value("${server.port}")
	String port_Address;
	
	
	@RequestMapping("/Employee")
	public ResponseEntity showEmployeeDetails() {
		List<Employee> details=EmployeeDatabase.getallEmployess();
		return ResponseEntity.ok(details);
	}
	
	@RequestMapping("/SortedEmployee")
	public List<Employee> showEmployessDetailsInSortedOrder(){
		return employeeService.getAllEmployessDetialsInSorted();
	}
	
	@GetMapping("/Employee/{id}")
	public List<Employee> showEmployeeDetailById(@PathVariable int id){
		return employeeService.getAllEmployeesDetailsById(id);
	}
	
	@PostMapping("/newEmployee")
	public ResponseEntity createNewEmployeeDetails(@RequestBody EmployeeDTO employeedto) {
		employeeService.putEmployeeDetail(employeedto);
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/Employee/{id}")
	public void removeEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/Employee/{id}")
	public void updateEmpoyeeDetails(@RequestBody Employee employee,@PathVariable int id) {
		employeeService.updateEmployeeDetails(employee, id);
	}
	
	@PostMapping("/newEmployee/data")
	public ResponseEntity addEmployee(@RequestBody Employee employee) {
		if(employee.getAddress().isEmpty()) 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		database.addEmployeeInDB(employee);
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping("/publish")
	public ResponseEntity publishEvent(@RequestBody Employee employee) {
		output.send(MessageBuilder.withPayload(employee).build());
		return ResponseEntity.ok().build();
	}

}
