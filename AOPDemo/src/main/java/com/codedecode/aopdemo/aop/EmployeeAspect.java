package com.codedecode.aopdemo.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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

}
