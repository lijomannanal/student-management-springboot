package com.lijo.studentmanagement.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseModel {
	@NotEmpty(message = "This is required")
	private String title;
	
	@NotNull(message = "This is required")
	private Integer credit;
	@NotEmpty(message = "This is required")
	@URL
    private String materialUrl;

}
