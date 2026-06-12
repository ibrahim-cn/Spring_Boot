package com.ibrahimcan.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@EntityScan(basePackages = {"com.ibrahimcan"})
@ComponentScan(basePackages = {"com.ibrahimcan"})
@EnableJpaRepositories(basePackages = {"com.ibrahimcan.repository"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
