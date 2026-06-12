package com.ibrahimcan.controllor;

import java.util.List;

import com.ibrahimcan.dto.StudentDto;
import com.ibrahimcan.entities.Student;

public interface IStudentProcessController {
	public StudentDto saveStudent(Student student);
	public List<StudentDto> saveAllStudents(List<Student> students);
	public List<StudentDto> getAllStudents();
	public StudentDto getStudentById(Integer id);
	public Integer deleteStudentById(Integer id);
	public StudentDto updateStudentName(String name,Integer id);

}
