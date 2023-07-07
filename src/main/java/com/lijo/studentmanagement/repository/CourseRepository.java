package com.lijo.studentmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lijo.studentmanagement.entity.Course;

@Repository 
public interface CourseRepository extends JpaRepository<Course, Long> {
public Page<Course> findByTitleContaining(String title, PageRequest request);
 
public List<Course> findByCourseIdIn(List<Long> courseIds);
}
