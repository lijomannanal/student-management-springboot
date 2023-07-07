package com.lijo.studentmanagement.controller;
import java.util.List;
import java.util.Map;

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

import com.lijo.studentmanagement.entity.Student;
import com.lijo.studentmanagement.error.StudentNotFoundException;
import com.lijo.studentmanagement.model.StudentCourseModel;
import com.lijo.studentmanagement.model.StudentModel;
import com.lijo.studentmanagement.service.StudentService;



@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StudentController.class);

	@PostMapping("/")
	public Student saveStudentst(@Valid @RequestBody StudentModel studentModel ) {
		LOGGER.info("saveStudentst api got called in StudentController");
		return studentService.saveStudent(studentModel);
	}
	
	@GetMapping("/")
	public List<Student> getAllStudents() {
		LOGGER.info("getAllStudentst api got called in StudentController");
		return studentService.findAllStudents();
	}
	
	@GetMapping(path = "/{email}")
	public Student getStudentByEmail(@PathVariable("email") String emailId) throws StudentNotFoundException {
		LOGGER.info("getAllStudentst api got called in StudentController");
		return studentService.findStudentByEmail(emailId);
	}
	
	@PutMapping(path = "/{email}")
	public Student updateStudentByEmail(@Valid @RequestBody StudentModel student,@PathVariable("email") String emailId) throws StudentNotFoundException {
		LOGGER.info("updateStudentByEmail api got called in StudentController");
		return studentService.updateStudentByEmail(emailId, student);
	}
	
	@DeleteMapping(path = "/{email}")
	public String deleteStudentByEmail(@PathVariable("email") String emailId) throws StudentNotFoundException {
		LOGGER.info("deleteStudentByEmail api got called in StudentController");
		studentService.deleteStudentByEmail(emailId);
		return "Student deleted successfully";
	}
	
	@PostMapping("/assign-courses")
	public Student assignStudentCourses(@Valid @RequestBody StudentCourseModel studentCourseModel ) throws StudentNotFoundException {
		LOGGER.info("assignStudentCourses api got called in StudentController");
		return studentService.assignCourses(studentCourseModel);
	}
}
