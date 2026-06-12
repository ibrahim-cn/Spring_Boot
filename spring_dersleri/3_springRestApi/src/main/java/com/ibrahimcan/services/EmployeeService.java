package com.ibrahimcan.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ibrahimcan.model.Employee;
import com.ibrahimcan.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> getallEmployees() {
		List<Employee> employees =  new ArrayList<>();
		
		employees.addAll(repository.getALlEmployees());
		
		
		return employees;
	}
	
	public Employee getEmployeeById(String id) {
		return repository.getEmployee(id);
	}
	
	public List<Employee> getEmployeesWithParams(String fName, String lName){
		return repository.getEmployeesWithParams(fName, lName);
	}
	
	public List<Employee> getEmployeesWithOrWithoutParams(String fName, String lName){
		return repository.getEmployeesWithOrWithoutParams(fName, lName);
	}
	
	public Employee addNewEmployee(Employee employee) {
		return repository.addNewEmployee(employee);
	}

	public boolean deleteEMployee(Employee employee) {
		return repository.deleteEmployee(employee);
	}
	public Employee updateEmployee(Employee fName, String id) {
		return repository.updateEmployee(fName, id);
	}
}
