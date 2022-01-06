package com.coursemanagement.demo.service;

import com.coursemanagement.demo.dto.CourseDto;
import com.coursemanagement.demo.entity.CourseEntity;

public interface CourseService {
	CourseEntity getCourse(Integer Id);

	CourseEntity createCourse(CourseDto courseDto);

	CourseEntity updatedCourse(CourseDto courseDto);

	String deleteCourse(Integer id);
}
