package com.codedecode.SBValidationMapperDemo.DTO;

import java.util.Date;

import com.codedecode.SBValidationMapperDemo.UpdateValidationGroup;
import com.codedecode.SBValidationMapperDemo.validators.UniqueEmailValidator;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

	private int id;
	
	@NotBlank(message = "Name cannot be blank")
	private String name;
	
	@Min(value = 20, message = "MInimum age should be 20")
	@Max(value = 100, message = "Max age should be 100")
	private int age;
	
	@Email
	@NotBlank(message = "Email should not be blank")
	@UniqueEmailValidator(message = "Email must be Unique", groups = {UpdateValidationGroup.class})
	private String emailAddress;
	
	private int projectId;
	
}
