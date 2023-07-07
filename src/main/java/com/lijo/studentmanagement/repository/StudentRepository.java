package com.lijo.studentmanagement.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lijo.studentmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByFirstNameContaining(String firstName);
	public List<Student> findByLastNameIsNotNull();
	public List<Student> findByFirstNameAndLastName(String firstName, String LastName);
	public List<Student> findByGuardianName(String guardianName);
	
	//JPQL using entity class properties instead of db table, refer the usage of emailId instead of emailAddress
	
	@Query("select s from Student s where s.emailId = ?1")
	public Student getStudentByEmailAddress(String emailAddress);
	
	@Query("select concat(s.firstName, '', s.lastName) from Student s where s.emailId = ?1")
	public String getStudentNameByEmailAddress(String emailAddress);
	
	@Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
	public Student getStudentByEmailAddressNative(String emailAddress);

	@Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
	public Student getStudentByEmailAddressNativeNamedParam(@Param(value = "emailId") String  emailAddress);
	
	@Modifying
	@Transactional
	@Query(value = "update tbl_student set first_name = ?2 where email_address=?1", nativeQuery = true)
	public int updateFirstNameByEmailAddress(String  emailAddress, String firstName);
	public Optional<Student> findByEmailId(String email);
}
