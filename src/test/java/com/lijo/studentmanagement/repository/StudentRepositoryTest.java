package com.lijo.studentmanagement.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.lijo.studentmanagement.entity.Guardian;
import com.lijo.studentmanagement.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
//	
//	@Autowired
//	private StudentRepository studentRepository;
//
//	@BeforeEach
//	void setUp() throws Exception {
//	}
//
//	@Test
//	@DisplayName("insert student")
//	void test() {
//		Guardian guardian = Guardian.builder().name("Tommy").email("tommy@123.com").mobile("34364364").build();
//		Student student = Student.builder().
//				emailId("lijo@123.com").
//				firstName("Lijo").
//				lastName("Thomas").
//				guardian(guardian).
//				build();
//             
//		studentRepository.save(student);
//	}
//	
//	@Test
//	@DisplayName("get all students")
//	void test1() {
//             
//		List<Student> studentsList = studentRepository.findAll();
//		System.out.println("---------------------------------" + studentsList);
//	}
//	
//	@Test
//	@DisplayName("get all students by firstname")
//	void test2() {
//             
//		List<Student> studentsList = studentRepository.findByFirstName("justy");
//		System.out.println("---------------------------------" + studentsList);
//	}
//	
//	@Test
//	@DisplayName("get all students by firstname like %str%")
//	void test3() {
//             
//		List<Student> studentsList = studentRepository.findByFirstNameContaining("ty");
//		System.out.println("---------------------------------" + studentsList);
//	}
//	
//	@Test
//	@DisplayName("get all students by laststname not null")
//	void test4() {
//             
//		List<Student> studentsList = studentRepository.findByLastNameIsNotNull();
//		System.out.println("---------------------------------" + studentsList);
//	}
//	
//	@Test
//	@DisplayName("get all students by guardian name")
//	void test5() {
//             
//		List<Student> studentsList = studentRepository.findByGuardianName("Tommy");
//		System.out.println("---------------------------------" + studentsList);
//	}
//	
//	@Test
//	@DisplayName("get student by email")
//	void test6() {
//             
//		Student student = studentRepository.getStudentByEmailAddress("l@123.com");
//		System.out.println("---------------------------------" + student);
//	}
//	
//	@Test
//	@DisplayName("get student name by email")
//	void test7() {
//             
//		String name = studentRepository.getStudentNameByEmailAddress("justy@123.com");
//		System.out.println("---------------------------------" + name);
//	}
//	@Test
//	@DisplayName("get student by email using native query")
//	void test8() {
//             
//		Student student = studentRepository.getStudentByEmailAddressNative("l@123.com");
//		System.out.println("---------------------------------" + student);
//	}
//	
//	@Test
//	@DisplayName("get student by email using native query named param")
//	void test9() {
//             
//		Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("l@123.com");
//		System.out.println("---------------------------------" + student);
//	}
//	
//	@Test
//	@DisplayName("update student first name by email using native query")
//	void test10() {
//             
//		int result = studentRepository.updateFirstNameByEmailAddress("l@123.com", "LIJO");
//		System.out.println("---------------------------------" + result);
//	}
	

}
