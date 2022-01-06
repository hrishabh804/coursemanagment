package com.coursemanagement.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.coursemanagement.demo.service","com.coursemanagement.demo.entity","com.coursemanagement.demo.controller","com.coursemanagement.demo.util","com.coursemanagement.demo.serviceImpl","com.coursemanagement.demo.repository","com.coursemanagement.demo.dto"})

public class CourseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseManagementApplication.class, args);
	}

}
