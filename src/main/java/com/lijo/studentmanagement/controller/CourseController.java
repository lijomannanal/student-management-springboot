package com.lijo.studentmanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lijo.studentmanagement.entity.Course;
import com.lijo.studentmanagement.error.CourseNotFoundException;
import com.lijo.studentmanagement.model.CourseModel;
import com.lijo.studentmanagement.service.CourseService;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CourseController.class);
	
	@PostMapping("/")
	public Course addCourse(@Valid @RequestBody CourseModel courseModel) {
		LOGGER.info("addCourse api got called in CourseController");
		return courseService.addCourse(courseModel);
		
	}
	
	@GetMapping("/")
	public List<Course> getAllCourses() {
		LOGGER.info("addCourse api got called in CourseController");
		return courseService.getCourses();
		
	}
	
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable("id") Long courseId) throws CourseNotFoundException {
		LOGGER.info("getCourseById api got called in CourseController");
		return courseService.getCourse(courseId);
		
	}
	
	@PutMapping("/{id}")
	public Course updateCourseById(@PathVariable("id") Long courseId,@Valid @RequestBody CourseModel courseModel) throws CourseNotFoundException {
		LOGGER.info("updateCourseById api got called in CourseController");
		return courseService.updateCourseById(courseId, courseModel);
		
	}
	
	@DeleteMapping("/{id}")
	public String deleteCourseById(@PathVariable("id") Long courseId) throws CourseNotFoundException {
		LOGGER.info("deleteCourseById api got called in CourseController");
		courseService.deleteCourseById(courseId);
		return "Course deleted successfully";
		
	}



}
