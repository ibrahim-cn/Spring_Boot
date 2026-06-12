package com.ibrahimcan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibrahimcan.model.Employee;

@Configuration
public class AppConfig {
	@Bean
	public List<Employee> getEmployees (){
		List<Employee> employees  =  new ArrayList<>();
		
		employees.add(new Employee("1","ibrahim","can"));
		employees.add(new Employee("2","ibrahim","cann"));
		employees.add(new Employee("3","ibrahim","cannn"));
		employees.add(new Employee("4","ibrahim","cannnn"));
		
		return employees;
	}

}
