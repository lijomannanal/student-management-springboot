package com.lijo.studentmanagement.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijo.studentmanagement.entity.Course;
import com.lijo.studentmanagement.entity.CourseMaterial;
import com.lijo.studentmanagement.error.CourseNotFoundException;
import com.lijo.studentmanagement.model.CourseModel;
import com.lijo.studentmanagement.repository.CourseMaterialRepository;
import com.lijo.studentmanagement.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    
	@Autowired
	private CourseRepository repository;
	

	@Override
	public Course addCourse(@Valid CourseModel courseModel) {
		Course course = Course.builder().title(courseModel.getTitle()).credit(courseModel.getCredit()).build();
		CourseMaterial material = CourseMaterial.builder().url(courseModel.getMaterialUrl()).course(course).build();
		course.setCourseMaterial(material);
		repository.save(course);
		return course;
	}

	@Override
	public List<Course> getCourses() {
		return repository.findAll();
	}

	@Override
	public Course getCourse(Long courseId) throws CourseNotFoundException {
	Optional<Course> course = repository.findById(courseId);
	if(course.isPresent()) {
		return course.get();
	} else {
		throw new CourseNotFoundException("Course does not exist");
	}
		
	}

	@Override
	public Course updateCourseById(Long courseId, @Valid CourseModel courseModel) throws CourseNotFoundException {
		Course savedCourse = this.getCourse(courseId);
		savedCourse.setTitle(courseModel.getTitle());
		savedCourse.setCredit(courseModel.getCredit());
		CourseMaterial material = savedCourse.getCourseMaterial();
		material.setUrl(courseModel.getMaterialUrl());
		savedCourse.setCourseMaterial(material);
		repository.save(savedCourse);
		return savedCourse;
	}

	@Override
	public void deleteCourseById(Long courseId) throws CourseNotFoundException {
		Course savedCourse = this.getCourse(courseId);
		repository.delete(savedCourse);
	}

}
