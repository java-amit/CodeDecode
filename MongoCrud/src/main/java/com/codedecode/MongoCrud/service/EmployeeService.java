package com.codedecode.MongoCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.codedecode.MongoCrud.model.Employee;
import com.codedecode.MongoCrud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveOrUpdate(Employee emp) {
		return employeeRepository.save(emp);
	}
	
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	@DeleteMapping
	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}
	
	
}
