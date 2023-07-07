package com.lijo.studentmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijo.studentmanagement.entity.Course;
import com.lijo.studentmanagement.entity.Teacher;
import com.lijo.studentmanagement.error.TeacherNotFoundException;
import com.lijo.studentmanagement.model.TeacherModel;
import com.lijo.studentmanagement.repository.CourseRepository;
import com.lijo.studentmanagement.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Teacher addTeacher(@Valid TeacherModel teacherModel) {
		Teacher teacher = Teacher.builder().firstName(teacherModel.getFirstName()).lastName(teacherModel.getLastName()).build();
		List<Course> courses = courseRepo.findByCourseIdIn(teacherModel.getCourseIds());
		courses.forEach(course -> teacher.addCourse(course));
		teacherRepo.save(teacher);
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return teacherRepo.findAll();
	}

	@Override
	public Teacher getTeacherById(Long teacherId) throws TeacherNotFoundException {
	Optional<Teacher> teacher = teacherRepo.findById(teacherId);
	if(teacher.isPresent()) {
		return teacher.get();
	} else {
		throw new TeacherNotFoundException("Teacher does not exist");
	}
	}

	@Override
	public void deleteTeacherById(Long teacherId) throws TeacherNotFoundException {
	 Teacher teacher = this.getTeacherById(teacherId);
	 teacherRepo.delete(teacher);	
	}

	@Override
	public Teacher updateTeacherById(Long teacherId, TeacherModel teacherModel) throws TeacherNotFoundException {
		Teacher teacher = this.getTeacherById(teacherId);
		teacher.setFirstName(teacherModel.getFirstName());
		teacher.setLastName(teacherModel.getLastName());
		List<Course> courses = courseRepo.findByCourseIdIn(teacherModel.getCourseIds());
		List<Course> savedCourses = teacher.getCourses();
		teacher.setCourses(new ArrayList<>());
		savedCourses.forEach(course -> teacher.removeCourse(course));
		courses.forEach(course -> teacher.addCourse(course));
		teacherRepo.save(teacher);
		return teacher;
	}

}
