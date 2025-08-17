package com.codedecode.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.repo.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee saveEmployee = crudRepo.save(employee);
		return saveEmployee;
	}
	
	
	
}
