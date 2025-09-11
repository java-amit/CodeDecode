package com.codedecode.SBValidationMapperDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.SBValidationMapperDemo.DTO.EmployeeDTO;
import com.codedecode.SBValidationMapperDemo.Entity.Employee;
import com.codedecode.SBValidationMapperDemo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO employeeDTO){
		 return new ResponseEntity<>(employeeServiceImpl.saveEmployee(employeeDTO), HttpStatus.CREATED);
	}

}
