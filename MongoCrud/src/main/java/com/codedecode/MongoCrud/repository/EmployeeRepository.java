package com.codedecode.MongoCrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codedecode.MongoCrud.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
