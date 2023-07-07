package com.lijo.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijo.studentmanagement.entity.Course;
import com.lijo.studentmanagement.entity.Guardian;
import com.lijo.studentmanagement.entity.Student;
import com.lijo.studentmanagement.error.StudentNotFoundException;
import com.lijo.studentmanagement.model.StudentCourseModel;
import com.lijo.studentmanagement.model.StudentModel;
import com.lijo.studentmanagement.repository.CourseRepository;
import com.lijo.studentmanagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentReposiory; 
	
	@Autowired
	private CourseRepository courseReposiory; 

	@Override
	public Student saveStudent(@Valid StudentModel studentModel) {
		Student student = Student.builder().firstName(studentModel.getFirstName()).
				lastName(studentModel.getLastName()).emailId(studentModel.getEmailId()).
				guardian(studentModel.getGuardian()).build();
		studentReposiory.save(student);
		return studentReposiory.save(student);
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studentReposiory.findAll();
	}

	@Override
	public Student findStudentByEmail(String email) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> student = studentReposiory.findByEmailId(email);
		if(student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException("Student does not exist");
		}
	}

	@Override
	public Student updateStudentByEmail(String email, StudentModel student) throws StudentNotFoundException  {
		// TODO Auto-generated method stub
		Student savedStudent = this.findStudentByEmail(email);
		savedStudent.setFirstName(student.getFirstName());
		savedStudent.setLastName(student.getLastName());
		savedStudent.setGuardian(student.getGuardian());
		studentReposiory.save(savedStudent);
		return savedStudent;
	}

	@Override
	public void deleteStudentByEmail(String email) throws StudentNotFoundException {
		Student savedStudent = this.findStudentByEmail(email);
		studentReposiory.delete(savedStudent);
	}

	@Override
	public Student assignCourses(@Valid StudentCourseModel studentCourseModel) throws StudentNotFoundException {
		Optional<Student> student = studentReposiory.findById(studentCourseModel.getStudentId());
		if(student.isPresent()) {
			Student savedStudent =  student.get();
			List<Course> savedCourses = savedStudent.getCourses();
			savedCourses.forEach(course -> course.removeStudent(savedStudent));
			savedStudent.setCourses(new ArrayList<>());
			List<Course> courses = courseReposiory.findByCourseIdIn(studentCourseModel.getCourseIds());
			savedStudent.setCourses(courses);
			courses.forEach(course -> course.addStudents(savedStudent));
			studentReposiory.save(savedStudent);
			return savedStudent;
		} else {
			throw new StudentNotFoundException("Student does not exist");
		}
	}

}
