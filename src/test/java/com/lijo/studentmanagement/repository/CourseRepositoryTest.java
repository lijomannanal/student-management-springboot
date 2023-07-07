package com.lijo.studentmanagement.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.print.Pageable;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.lijo.studentmanagement.entity.Course;
import com.lijo.studentmanagement.entity.CourseMaterial;
import com.lijo.studentmanagement.entity.Student;
import com.lijo.studentmanagement.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	
//	@Autowired
//	private CourseRepository repository;
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@Test
//	@DisplayName("fetch all courses with course materials")
//	void test1() {
//             
//		List<Course> result = repository.findAll();
//		System.out.println("---------------------------------" + result);
//	}
//	
//	
//	@Test
//	@DisplayName("fetch all records with pagination and sorting")
//	void test3() {
//	  PageRequest firstPageWith2Records =   PageRequest.of(0, 2, Sort.by("title"));
//      List<Course> courses = repository.findAll(firstPageWith2Records).getContent();
//      System.out.println("====================== "+ courses);
//      int totalPages = repository.findAll(firstPageWith2Records).getTotalPages();
//      System.out.println("====================== total pages "+ totalPages);
//      long totalRecords = repository.findAll(firstPageWith2Records).getTotalElements();
//      System.out.println("====================== total records "+ totalRecords);
//	}
//	
//	@Test
//	@DisplayName("fetch all records containing title with pagination and sorting")
//	void test4() {
//	  PageRequest firstPageWith3Records =   PageRequest.of(0, 3, Sort.by("title"));
//      List<Course> courses = repository.findByTitleContaining("So", firstPageWith3Records).getContent();
//      System.out.println("====================== "+ courses);
//      int totalPages = repository.findByTitleContaining("So", firstPageWith3Records).getTotalPages();
//      System.out.println("====================== total pages "+ totalPages);
//      long totalRecords = repository.findByTitleContaining("So", firstPageWith3Records).getTotalElements();
//      System.out.println("====================== total records "+ totalRecords);
//	}
//	
//	@Test
//	@DisplayName("add student with courses")
//	void test5() {
//        Teacher teacher = Teacher.builder().firstName("Babu").lastName("N").build();
//        Student student = Student.builder().firstName("vivek").lastName("k").emailId("viv@123.com").build();
//        Course course = Course.builder().title("Computer Networks").credit(23).teacher(teacher).build();
//        course.addStudents(student);
//        repository.save(course);
//	}
}
