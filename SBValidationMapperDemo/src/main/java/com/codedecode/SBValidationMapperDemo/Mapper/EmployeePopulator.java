package com.codedecode.SBValidationMapperDemo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.codedecode.SBValidationMapperDemo.DTO.EmployeeDTO;
import com.codedecode.SBValidationMapperDemo.Entity.Employee;

@Mapper
public interface EmployeePopulator {

	EmployeePopulator INSTANCE = Mappers.getMapper(EmployeePopulator.class);
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "creationDate", ignore = true)
	Employee populateEmployee(EmployeeDTO employeeDTO);
}
