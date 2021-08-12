package com.example.sprinboot.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.sprinboot.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDTO {

	public EmployeeDTO() {
		
	}
	public EmployeeDTO(int empid, String ename, String job, List<Address> address) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.job = job;
		this.address = address;
	}
	@JsonProperty(value="empid")
	int empid;
	@JsonProperty(value="ename")
	String ename;
	@JsonProperty(value="job")
	String job;
	@JsonProperty(value="address")
	List<Address> address=new ArrayList<>();
	
}
