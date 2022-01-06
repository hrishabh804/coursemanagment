package com.coursemanagement.demo.service;

import com.coursemanagement.demo.dto.StudentDto;
import com.coursemanagement.demo.entity.StudentEntity;

public interface StudentService {
	StudentEntity getStudent(Integer Id);
	StudentEntity createEntity(StudentDto student);
	StudentEntity updatedStudent(StudentDto student);
	String deleteStudent(Integer id);

}
