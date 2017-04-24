package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.repositories.EmpRepository;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {
	
	@Autowired
	EmpRepository empRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
