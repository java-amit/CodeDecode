package com.codedecode.SBValidationMapperDemo.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueEmailValidation.class})
public @interface UniqueEmailValidator {

	
	//error message
	public String message() default "Invalid email address";  //What message should be shown if validation fails?
	//represents group  of constraints 
	public Class<?>[] groups() default {}; 	//Can I apply this constraint in specific scenarios (like validation for admins vs users)?
	//represents additional information about annotation
	public Class<? extends Payload>[] payload() default{};	//Any extra info or metadata I want to attach?
}
