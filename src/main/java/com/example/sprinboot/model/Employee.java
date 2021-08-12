package com.example.sprinboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee implements Comparable<Employee> {

	@Id
	int empid;
	String ename;
	String job;
	
	@ElementCollection
	List<Address> address=new ArrayList<>();
	
	public Employee() {
		
	}
	
	public Employee(int empid, String ename, String job, List<Address> address) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.job = job;
		this.address = address;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + empid;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
					return false;
		if (empid != other.empid)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
					return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
					return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", job=" + job + ", address=" + address + "]";
	}

	@Override
	public int compareTo(Employee o) {
		 if(empid==o.empid)    
			 return 0;    
		 else if(empid<o.empid)    
			 		return 1;    
		 else    
			 	return -1;    
			 } 
	
	
}
