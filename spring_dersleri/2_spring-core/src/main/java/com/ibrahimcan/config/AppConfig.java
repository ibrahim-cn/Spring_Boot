package com.ibrahimcan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibrahimcan.__spring_core.Person;
import com.ibrahimcan.sevices.UserService;

@Configuration
public class AppConfig {
	
	@Bean
	public UserService userService() {
		UserService userService1 = new UserService();
		
		List<Person> userList = new ArrayList<>();
		userList.add(new Person("22","ibrahim"));
		userList.add(new Person("23","ibrahim1"));
		userList.add(new Person("24","ibrahim2"));
		
		userService1.setUserList(userList);
		
		return userService1;
	}

}
