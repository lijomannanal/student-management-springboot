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

import com.lijo.studentmanagement.entity.Teacher;
import com.lijo.studentmanagement.error.TeacherNotFoundException;
import com.lijo.studentmanagement.model.TeacherModel;
import com.lijo.studentmanagement.service.TeacherService;

import lombok.Delegate;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping
	public Teacher addTeacher(@Valid @RequestBody TeacherModel teacher) {
		LOGGER.info("addTeacher api got called in TeacherController");
		return teacherService.addTeacher(teacher);
		
	}
	
	@GetMapping
	public List<Teacher> getAllTeachers() {
		LOGGER.info("getAllTeachers api got called in TeacherController");
		return teacherService.getAllTeachers();
		
	}
	
	@GetMapping("/{teacherId}")
	public Teacher getTeacherById(@PathVariable Long teacherId) throws TeacherNotFoundException {
		LOGGER.info("getTeacherById api got called in TeacherController");
		return teacherService.getTeacherById(teacherId);
		
	}
	
	@PutMapping("/{teacherId}")
	public Teacher updateTeacherById(@PathVariable Long teacherId, @Valid @RequestBody TeacherModel teacherModel) throws TeacherNotFoundException {
		LOGGER.info("updateTeacherById api got called in TeacherController");
		return teacherService.updateTeacherById(teacherId, teacherModel);
		
	}
	
	@DeleteMapping("/{teacherId}")
	public String deleteTeacherById(@PathVariable Long teacherId) throws TeacherNotFoundException {
		LOGGER.info("deleteTeacherById api got called in TeacherController");
		teacherService.deleteTeacherById(teacherId);
		return "Deleted successfully";
		
	}
	
	
	

}
