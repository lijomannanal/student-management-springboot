package com.lijo.studentmanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_student",
uniqueConstraints = @UniqueConstraint(
	name = "emailid_unique",
	columnNames = "email_address")
)
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "studentId")
public class Student {
	
	@Id
	@SequenceGenerator(name = "student_sequence",
	sequenceName = "student_sequence",
	allocationSize = 1,
	initialValue = 100
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	private Long studentId;
	private String firstName;
	
	private String lastName;
	
	@Column(name = "email_address",
			unique = true,
			nullable = false)
	private String emailId;
	@Embedded
    private Guardian guardian;
	
	@ManyToMany(mappedBy="students")
    private List<Course> courses;
	
	   public void addCourse(Course course){
	        if (this.courses == null){
	            this.courses = new ArrayList<>();
	        }
	        this.courses.add(course);
	    }   
	   public void removeCourse(Course course){
	        course.setTeacher(null);
	    }
	   
}
