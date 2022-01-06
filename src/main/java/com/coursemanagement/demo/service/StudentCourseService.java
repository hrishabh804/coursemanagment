package com.coursemanagement.demo.service;

import java.util.List;

import com.coursemanagement.demo.dto.StudentCourseDto;
import com.coursemanagement.demo.entity.StudentCouseEntiry;

public interface StudentCourseService {
	StudentCouseEntiry registerStudent(StudentCourseDto dto);
	StudentCouseEntiry DeregisterStudent(StudentCourseDto dto);
	List<String> getAllStudentForCourse(Integer courseId);
	List<String> getAllCouseRegisteredByStudent(Integer studentId);
	

}
