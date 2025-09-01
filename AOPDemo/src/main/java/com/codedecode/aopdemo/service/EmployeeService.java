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

	public Employee addEmployee(Employee e) {
		return employeeRepo.save(e);
	}

}
