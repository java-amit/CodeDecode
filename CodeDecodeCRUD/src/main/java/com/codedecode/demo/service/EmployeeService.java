package com.codedecode.demo.service;

import java.util.List;

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

	@Override
	public List<Employee> getAllEmployees() {
		return crudRepo.findAll();
		
	}

	@Override
	public Employee getEmpById(Long empidL) {
		//return crudRepo.findById(empidL).get();   //findById(id) returns Optional Object so call get() or orElseThrow() method with it.
		return crudRepo.findById(empidL).orElseThrow(() -> new RuntimeException("Employee not found with id: " + empidL));

	}

	@Override
	public void deleteEmpById(Long empidL) {
		crudRepo.deleteById(empidL);
	}
	
	
	
}
