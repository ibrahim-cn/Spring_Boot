package com.ibrahimcan.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ibrahimcan.__spring_core.Person;
import com.ibrahimcan.config.AppConfig;
import com.ibrahimcan.sevices.UserService;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		for (Person tmPerson : userService.getUserList()) {
			System.out.println(tmPerson.getNameString());
			System.out.println(tmPerson.getAge());
			
		}
		
		
	}

}
