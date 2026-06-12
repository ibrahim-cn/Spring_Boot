package com.ibrahimcan.sevices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ibrahimcan.config.AppConfig;

public class LoginService {
	public void login() {
		//userList lazım.
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = context.getBean(UserService.class);
		
		
	}

}
