package com.ibrahimcan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibrahimcan.dto.StudentDto;
import com.ibrahimcan.entities.Student;
import com.ibrahimcan.repository.IStudentRepository;
import com.ibrahimcan.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	IStudentRepository repository;
	
	@Override
	public StudentDto saveStudent(Student student) {
		StudentDto dto = new StudentDto();
		Student dStudent= repository.save(student);
		BeanUtils.copyProperties(dStudent, dto);
		return dto;
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> dStudent = repository.findAllStudents();
	    
	    return dStudent.stream().map(student -> {
	        StudentDto dto = new StudentDto();
	        BeanUtils.copyProperties(student, dto); // Tekil nesneler arasında kopyalama
	        return dto;
	    }).toList(); // Java 16+ için. Eski sürümler için: .collect(Collectors.toList())
	}
	

	@Override
	public StudentDto getStudentById(Integer id) {
		StudentDto dto = new StudentDto();
		BeanUtils.copyProperties(repository.findStudentById(id), dto);
		return dto;
	}

	@Override
	public List<StudentDto> saveAllStudents(List<Student> students) {
		List<StudentDto> dtos = new ArrayList<>();
		BeanUtils.copyProperties(repository.saveAll(students), dtos);
		return dtos;
	}

	@Override
	public Integer deleteStudentById(Integer id) {
		repository.deleteById(id);
		return 1;
	}

	@Override
	public StudentDto updateStudentName(String name, Integer id) {
		Student student = repository.getById(id);
		student.setFName(name);
		StudentDto dto = new StudentDto();
		BeanUtils.copyProperties(repository.save(student), dto);
		return dto;
	}
	
}
