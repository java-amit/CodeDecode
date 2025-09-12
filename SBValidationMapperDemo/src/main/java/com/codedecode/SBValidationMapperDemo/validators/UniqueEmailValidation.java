package com.codedecode.SBValidationMapperDemo.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.codedecode.SBValidationMapperDemo.Repository.EmployeeRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmailValidator, String> {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(employeeRepository.findByEmailAddress(value).size()==0)
			return true;
		return false;
	}

}
