package com.ibrahimcan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibrahimcan.model.Employee;
import com.ibrahimcan.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {
	
	private final List<Employee> getEmployees;
	@Autowired
	private EmployeeService employeeService;


	RestEmployeeController(List<Employee> getEmployees) {
		this.getEmployees = getEmployees;
	}
	
	
	@GetMapping(path = "/list")
	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = new ArrayList<>();
		allEmployees.addAll(employeeService.getallEmployees());
		
		return allEmployees;
		
	}
	
	@GetMapping(path = "/list/{id}")
	public Employee getEmployeeById(@PathVariable(name = "id", required = true)String id){
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping(path = "/with-params")
	public List<Employee> getEmployeeWithParams(@RequestParam(name = "fName", required = false)String fname,
												@RequestParam(name = "lName", required = false) String lName){
		return employeeService.getEmployeesWithOrWithoutParams(fname, lName);
	}
	
	@PostMapping("/save-employee")
	public Employee saveNewEmployee(@RequestBody Employee employee) {
		
		return employeeService.addNewEmployee(employee);
	}

	@PutMapping("/update-employee/{id}")
	public Employee updateEmployee( @PathVariable(name = "id") String id, @RequestBody Employee employee) {
		//According to id, name change.
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/delete-employee")
	public boolean deleteEmployee(Employee employee) {
		return employeeService.deleteEMployee(employee);
	}
	

	
	
	
}
