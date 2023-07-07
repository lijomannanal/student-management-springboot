package com.lijo.studentmanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.lijo.studentmanagement.entity.Student;
import com.lijo.studentmanagement.error.StudentNotFoundException;
import com.lijo.studentmanagement.model.StudentCourseModel;
import com.lijo.studentmanagement.model.StudentModel;

@Service
public interface StudentService {

	Student saveStudent(@Valid StudentModel studentModel);

	List<Student> findAllStudents();

	Student findStudentByEmail(String email) throws StudentNotFoundException;

	Student updateStudentByEmail(String emailId, StudentModel studentModel) throws StudentNotFoundException;

	void deleteStudentByEmail(String emailIdt) throws StudentNotFoundException;

	Student assignCourses(@Valid StudentCourseModel studentCourseModel) throws StudentNotFoundException;


}
