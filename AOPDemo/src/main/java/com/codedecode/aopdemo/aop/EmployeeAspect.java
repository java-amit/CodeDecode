package com.codedecode.aopdemo.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.codedecode.aopdemo.entity.Employee;

@Aspect
@Component
public class EmployeeAspect {
	
	@Before(value = "execution(* com.codedecode.aopdemo.controller.EmployeeController.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Request to "+ joinPoint.getSignature() + " Stared at " + new Date());
	}
	
	@After(value = "execution(* com.codedecode.aopdemo.controller.EmployeeController.*(..))")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("Request to "+ joinPoint.getSignature() + " Ended at " + new Date());
	}
	
	@Before(value = "execution(* com.codedecode.aopdemo.service.EmployeeService.*(..))")
	public void beforeAdviceForService(JoinPoint joinPoint) {
		System.out.println("Request to service layer "+ joinPoint.getSignature() + " Stared at " + new Date());
	}
	
	@After(value = "execution(* com.codedecode.aopdemo.service.EmployeeService.*(..))")
	public void afterAdviceForService(JoinPoint joinPoint) {
		System.out.println("Request to service layer "+ joinPoint.getSignature() + " Ended at " + new Date());
	}
	
	@AfterReturning(value = "execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))", returning = "employee")
	public void afterReturningAdviceForAddEmpService(JoinPoint joinPoint, Employee employee) {
		System.out.println("Business logic to save an employee run succesfully and employee is saved with id "+ employee.getId());
	}
	
	@AfterThrowing(value = "execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))", throwing = "exception")
	public void afterThrowingAdviceForAddEmpService(JoinPoint joinPoint, Exception exception) {
		System.out.println("Business logic to save an employee threw an exception "+ exception.getMessage());
	}
	
	@Around(value = "execution(* com.codedecode.aopdemo.service.EmployeeService.addEmployee(..))")
	public Employee aroundAdviceForAddEmpService(ProceedingJoinPoint joinPoint) {
		System.out.println("Inside Around Advice in Aspect: Business logic to save an employee started at " + new Date());
		try {
			Employee[] empArr = new Employee[1];
			Employee dummyEmp = new Employee();
			dummyEmp.setName("Dummy");
			empArr[0] = dummyEmp;
			Employee employee = (Employee)joinPoint.proceed();
			return employee;
		} catch (Throwable e) {
			System.out.println("Inside Around Advice in Aspect: Business logic to save an employee failed terribly " + e.getMessage());
		}
		System.out.println("Inside Around Advice in Aspect: Business logic to save an employee ended at " + new Date());
		return null;
	}

	
	
	
	
	
}
