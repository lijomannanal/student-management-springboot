package com.lijo.studentmanagement.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lijo.studentmanagement.entity.Course;
import com.lijo.studentmanagement.entity.CourseMaterial;
import com.lijo.studentmanagement.entity.Teacher;

@SpringBootTest
class CourseMaterialRepositoryTest {
    
//	@Autowired
//	private CourseMaterialRepository repository;
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@Test
//	@DisplayName("insert course material with course")
//	void test() {
//		Course course = Course.builder().title("ABC").credit(120).build();
//		CourseMaterial material = CourseMaterial.builder().url("testABC.com").course(course).build();
//		repository.save(material);
//		
//	}
//	@Test
//	@DisplayName("fetch all course materials with courses")
//	void test2() {
//             
//		List<CourseMaterial> result = repository.findAll();
//		System.out.println("---------------------------------" + result);
//	}
//	
//	@Test
//	@DisplayName("save course with teacher")
//	void test3() {
//             
//      Teacher teacher = Teacher.builder().firstName("Mary").lastName("kappen").build();
//      Course course = Course.builder().title("Civil Engineering").credit(9)
//    		  .teacher(teacher).build();
//      CourseMaterial material = CourseMaterial.builder().url("testCE.com").course(course).build();
//      repository.save(material);
//	}
}

