package com.codedecode.SBValidationMapperDemo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.SBValidationMapperDemo.DTO.EmployeeDTO;
import com.codedecode.SBValidationMapperDemo.Entity.Employee;
import com.codedecode.SBValidationMapperDemo.Mapper.EmployeePopulator;
import com.codedecode.SBValidationMapperDemo.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveEmployee(EmployeeDTO employeeDTO) {
		//code to convert dto to entity
		Employee employee = EmployeePopulator.INSTANCE.populateEmployee(employeeDTO);
		employee.setCreationDate(new Date());
		return employeeRepository.save(employee);
	}
}
