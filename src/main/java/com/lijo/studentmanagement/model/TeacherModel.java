package com.lijo.studentmanagement.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherModel {
	@NotBlank(message = "This is required")
	private String firstName;
	@NotBlank(message = "This is required")
	private String lastName;
	
	@NotEmpty(message = "This is required and cannot be empty list")
	private List<Long> courseIds;

}
