package com.codedecode.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.demo.custom.exception.BusinessException;
import com.codedecode.demo.custom.exception.EmptyInputException;
import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.repo.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface{

	@Autowired
	private EmployeeCrudRepo crudRepo;

	@Override
	public Employee addEmployee(Employee employee) {
		
		if(employee.getName().isEmpty() || employee.getName().length() == 0) {
			throw new EmptyInputException("601", "Input Field are empty");
		}
			Employee saveEmployee = crudRepo.save(employee);
			return saveEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			empList = crudRepo.findAll();
		} catch (Exception e) {
			throw new BusinessException("605", "Something went wrong in Service layer while fetching all employee"+e.getMessage());
		}
		if(empList.isEmpty())
			throw new BusinessException("604", "Hey List is completely empty, we have nothing to return");
		return empList;
	}

	@Override
	public Employee getEmpById(Long empidL) {
		return crudRepo.findById(empidL).get();   //findById(id) returns Optional Object so call get() or orElseThrow() method with it.
		//return crudRepo.findById(empidL).orElseThrow(() -> new RuntimeException("Employee not found with id: " + empidL));
	}

	@Override
	public void deleteEmpById(Long empidL) {
		try {
		crudRepo.deleteById(empidL);
		}catch (IllegalArgumentException e) {
			throw new BusinessException("608","given Employee Id is null, please send some id to be searched"+e.getMessage());
		}	
	}
	
	
	
}
