package com.lijo.studentmanagement.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.lijo.studentmanagement.entity.Guardian;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {
	
	@NotBlank(message = "firstname is required")
	private String firstName;
	
	@NotBlank(message = "lastName is required")
	private String lastName;
	
	@NotBlank(message = "emailId is required")
	@Column(name = "email_address",
			unique = true,
			nullable = false)
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String emailId;
	@Embedded
	@Valid
    private Guardian guardian;

}
