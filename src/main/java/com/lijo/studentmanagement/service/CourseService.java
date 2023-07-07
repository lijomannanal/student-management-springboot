package com.lijo.studentmanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.lijo.studentmanagement.entity.Course;
import com.lijo.studentmanagement.error.CourseNotFoundException;
import com.lijo.studentmanagement.model.CourseModel;

@Service
public interface CourseService {

	Course addCourse(@Valid CourseModel courseModel);

	List<Course> getCourses();

	Course getCourse(Long courseId) throws CourseNotFoundException;

	Course updateCourseById(Long courseId, @Valid CourseModel courseModel) throws CourseNotFoundException;

	void deleteCourseById(Long courseId) throws CourseNotFoundException;

}
