package com.example.sprinboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.sprinboot.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	

}
