package com.lijo.studentmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")
@Table(name = "course_material",
uniqueConstraints = @UniqueConstraint(
	name = "url_unique",
	columnNames = "url"))

public class CourseMaterial {
	
	@Id
	@SequenceGenerator(
	name = "material_sequence",
	sequenceName = "material_sequence",
	allocationSize = 1
	)
	@GeneratedValue(
	strategy = GenerationType.SEQUENCE, generator = "material_sequence"
	)
	
  private Long courseMaterialId; 
	
  @Column(unique = true, 
		  nullable = false)
  private String url;
  
  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id",
  referencedColumnName = "courseId"
		  )
 @JsonIgnore
 private Course course;
  
}
