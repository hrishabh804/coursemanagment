package com.coursemanagement.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursemanagement.demo.dto.CourseDto;
import com.coursemanagement.demo.dto.StudentCourseDto;
import com.coursemanagement.demo.dto.StudentDto;
import com.coursemanagement.demo.entity.CourseEntity;
import com.coursemanagement.demo.entity.StudentCouseEntiry;
import com.coursemanagement.demo.entity.StudentEntity;
import com.coursemanagement.demo.repository.CourseStudentRepository;
import com.coursemanagement.demo.service.CourseService;
import com.coursemanagement.demo.service.StudentCourseService;
import com.coursemanagement.demo.service.StudentService;

@RestController
@RequestMapping(value = "/courseManagement")
public class CourseManagementController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentCourseService courseStudentService;

	@PostMapping(value = "/addStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentEntity addStudent(@RequestBody StudentDto studentDto) throws Exception {
		System.out.print(studentDto);
		StudentEntity student = studentService.createEntity(studentDto);
		return student;
	}

	@PostMapping(value = "/updateStudents", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StudentEntity addStudents(@RequestBody StudentDto studentDto) {
		return studentService.updatedStudent(studentDto);
	}

	@GetMapping(value = "/getStudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentEntity getStudent(@PathVariable("id") Integer id) {
		System.out.print(id);
		return studentService.getStudent(id);
	}

	@DeleteMapping(value = "/deleteStudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String DeleteStudent(@PathVariable("id") Integer id) {
		System.out.print(id);
		return studentService.deleteStudent(id);
	}

	@PostMapping(value = "/addCourse", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseEntity addCourse(@RequestBody CourseDto courseDto) throws Exception {
		System.out.print(courseDto);
		CourseEntity course = courseService.createCourse(courseDto);
		return course;
	}

	@PostMapping(value = "/updateCourse", consumes = MediaType.APPLICATION_JSON_VALUE)
	public CourseEntity updateCourse(@RequestBody CourseDto courseDto) {
		return courseService.updatedCourse(courseDto);
	}

	@GetMapping(value = "/getCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseEntity getCourse(@PathVariable("id") Integer id) {
		System.out.print(id);
		return courseService.getCourse(id);
	}

	@DeleteMapping(value = "/deleteCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String DeleteCourse(@PathVariable("id") Integer id) {
		System.out.print(id);
		return courseService.deleteCourse(id);
	}

	@GetMapping(value = "/getStudentForCourse/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getStudentForCourse(@PathVariable("id") Integer courseId) {
		System.out.print(courseId);
		return courseStudentService.getAllStudentForCourse(courseId);
	}

	@GetMapping(value = "/getCourseForStudent/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getCourseForStudent(@PathVariable("id") Integer studentId) {
		System.out.print(studentId);
		return courseStudentService.getAllCouseRegisteredByStudent(studentId);
	}
	@PostMapping(value = "/registerStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentCouseEntiry registerStudent(@RequestBody StudentCourseDto courseDto) {
		System.out.print(courseDto);
		return courseStudentService.registerStudent(courseDto);
	}
	@PostMapping(value = "/deRegisterStudent", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentCouseEntiry deRegisterStudent(@RequestBody StudentCourseDto courseDto) {
		return courseStudentService.DeregisterStudent(courseDto);
	}

}
