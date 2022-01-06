package com.coursemanagement.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.demo.dto.StudentCourseDto;
import com.coursemanagement.demo.entity.CourseEntity;
import com.coursemanagement.demo.entity.StudentCouseEntiry;
import com.coursemanagement.demo.entity.StudentEntity;
import com.coursemanagement.demo.repository.CourseRepository;
import com.coursemanagement.demo.repository.CourseStudentRepository;
import com.coursemanagement.demo.repository.StudentRepository;
import com.coursemanagement.demo.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	private CourseStudentRepository courseStudentRepo;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public StudentCouseEntiry registerStudent(StudentCourseDto dto) {
		StudentCouseEntiry studentCourseEntity = new StudentCouseEntiry();
		Optional<StudentEntity> student = studentRepository.findById(dto.getStudentId());
		Optional<CourseEntity> course = courseRepository.findById(dto.getCourseId());
		if (!course.isEmpty()) {
			studentCourseEntity.setCourseEntity(course.get());
		}
		if (!student.isEmpty()) {
			studentCourseEntity.setStudentEntity(student.get());
		}

		return courseStudentRepo.save(studentCourseEntity);
	}

	@Override
	public List<String> getAllStudentForCourse(Integer courseId) {
		List<StudentCouseEntiry> courseStudentList = courseStudentRepo.getStudentRegisteredForCourse(courseId);
		List<String> listOfStudent = courseStudentList.stream()
				.map(s -> s.getStudentEntity().getfName() + " " + s.getStudentEntity().getlName())
				.collect(Collectors.toList());
		// List<CourseEntity> courseEntity = courseRepository.findAllById(listOfCourse);

		return listOfStudent;
	}

	@Override
	public List<String> getAllCouseRegisteredByStudent(Integer studentId) {
		List<StudentCouseEntiry> courseStudentList = courseStudentRepo.getCouseRegisteredByStudent(studentId);
		List<String> listOfCourse = courseStudentList.stream().map(s -> s.getCourseEntity().getCourseName())
				.collect(Collectors.toList());
		// List<CourseEntity> courseEntity =courseRepository.findAllById(listOfCourse);

		return listOfCourse;
	}

	@Override
	public StudentCouseEntiry DeregisterStudent(StudentCourseDto dto) {
		StudentCouseEntiry courseStudentList = courseStudentRepo.deRegisterStudent(dto.getCourseId(),
				dto.getStudentId());
		if (null != courseStudentList)
			courseStudentRepo.delete(courseStudentList);
		return courseStudentList;
	}

}
