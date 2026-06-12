package com.ibrahimcan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ibrahimcan.entities.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{
	@Query(value = "from Student", nativeQuery = false)
	List<Student> findAllStudents();
	
	@Query(value = "select * from student.student where id =:id", nativeQuery = true)
	Student findStudentById(int id);
	
	}
