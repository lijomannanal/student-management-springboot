package com.lijo.studentmanagement.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.lijo.studentmanagement.entity.Teacher;
import com.lijo.studentmanagement.error.TeacherNotFoundException;
import com.lijo.studentmanagement.model.TeacherModel;

@Service
public interface TeacherService {

	Teacher addTeacher(@Valid TeacherModel teacher);

	List<Teacher> getAllTeachers();

	Teacher getTeacherById(Long teacherId) throws TeacherNotFoundException;

	void deleteTeacherById(Long teacherId) throws TeacherNotFoundException;

	Teacher updateTeacherById(Long teacherId, @Valid TeacherModel teacherModel) throws TeacherNotFoundException;

}
