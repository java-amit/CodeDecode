package com.codedecode.aopdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.aopdemo.entity.Employee;
import com.codedecode.aopdemo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	public List<Employee> getAllEmps() {
		return employeeRepo.findAll();
	}

	public Employee addEmployee(Employee e) throws Exception {
		if(e.getName().length()>5)
			throw new Exception("Sorry please reduce size of your names");
		return employeeRepo.save(e);
	}

}
