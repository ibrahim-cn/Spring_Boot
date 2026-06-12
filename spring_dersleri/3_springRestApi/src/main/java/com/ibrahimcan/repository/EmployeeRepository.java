package com.ibrahimcan.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibrahimcan.model.Employee;


@Repository
public class EmployeeRepository {
	
	@Autowired
	private List<Employee> employeeList;

	
	public List<Employee> getALlEmployees(){
		List<Employee> employees = new ArrayList<>();
		
		
		employees.addAll(employeeList);
		
		return employees;
	}
	
	public Employee getEmployee(String id) {
		for(Employee employee : employeeList) {
			if (employee.getId().equals(id)) {
				return employee;
			}
		}
		return null;
	}
	
	public List<Employee> getEmployeesWithParams(String fName, String lName) {
		List<Employee> employees = new ArrayList<>();
		
		for(Employee employee : employeeList) {
			if(employee.getFName().equals(fName) && employee.getLName().equals(lName)) {
				employees.add(employee);
			}
		}
		return employees;
	}
	
	public List<Employee> getEmployeesWithOrWithoutParams(String fName, String lName) {
		List<Employee> employees = new ArrayList<>();

		if(fName != null && lName != null) {
			employees = getEmployeesWithParams(fName, lName);
		}
		else if(fName == null && lName == null) {
			employees = getALlEmployees();
		}
		else if(fName != null && lName == null) {
			for(Employee employee : employeeList) {
				if(employee.getFName().equals(fName)) {
					employees.add(employee);
				}
			}
			
		}
		else if(fName == null && lName != null) {
			for(Employee employee : employeeList) {
				if(employee.getLName().equals(lName)) {
					employees.add(employee);
				}
			}
		}
		else {
			return null;
		}
		return employees;
	}
	
	public Employee addNewEmployee(Employee employee) {
		
		if (employeeList.add(employee)) {
			return employee;
		}
		
		return null;
	}
	
	public boolean deleteEmployee(Employee employee) {
		if(!employeeList.remove(employee)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public Employee updateEmployee(Employee fName, String id) {
		for(Employee employee : employeeList) {
			if(employee.getId().equals(id)) {
				employee.setFName(fName.getFName());
				return employee;
			}
		}
		return null;
	}
}
