package com.lijo.studentmanagement.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseModel {
	@NotNull(message = "This is required and cannot be empty")
	private Long studentId;
	@NotEmpty(message = "This is required and cannot be empty")
	private List<Long> courseIds;

}
