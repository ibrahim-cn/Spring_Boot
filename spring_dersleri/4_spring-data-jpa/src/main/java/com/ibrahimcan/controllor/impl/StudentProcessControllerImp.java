package com.ibrahimcan.controllor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibrahimcan.controllor.IStudentProcessController;
import com.ibrahimcan.dto.StudentDto;
import com.ibrahimcan.entities.Student;
import com.ibrahimcan.service.impl.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/student")
public class StudentProcessControllerImp implements IStudentProcessController{
	@Autowired
	private StudentServiceImpl service;

	@PostMapping("/save")
	@Override
	public StudentDto saveStudent(@RequestBody @Valid Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/getAllStudent")
	@Override
	public List<StudentDto> getAllStudents() {
		return service.getAllStudents();
	}

	@GetMapping("/getStudent/{id}")
	@Override
	public StudentDto getStudentById(@PathVariable(name = "id") Integer id) {
		return service.getStudentById(id);
	}

	@PostMapping("/saveAll")
	@Override
	public List<StudentDto> saveAllStudents(@RequestBody List<Student> students) {
		return service.saveAllStudents(students);
	}

	
	@DeleteMapping("/delete/{id}")
	@Override
	public Integer deleteStudentById(@PathVariable(name = "id") Integer id) {
		return service.deleteStudentById(id);
	}

	@PutMapping("/updateName")
	@Override
	public StudentDto updateStudentName(@RequestParam(name = "name") String name,
			@RequestParam(name = "id") Integer id) {
		return service.updateStudentName(name, id);
	}

	
	
	
	
	

	
	
	

}
