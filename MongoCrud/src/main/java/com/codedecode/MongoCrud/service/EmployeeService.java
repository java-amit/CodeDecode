package com.codedecode.MongoCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.MongoCrud.model.Employee;
import com.codedecode.MongoCrud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveOrUpdate(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	
	
}
