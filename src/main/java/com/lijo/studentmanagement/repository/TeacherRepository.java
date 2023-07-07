package com.lijo.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lijo.studentmanagement.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
