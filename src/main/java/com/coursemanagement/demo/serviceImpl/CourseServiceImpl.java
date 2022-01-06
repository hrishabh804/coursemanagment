package com.coursemanagement.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursemanagement.demo.dto.CourseDto;
import com.coursemanagement.demo.entity.CourseEntity;
import com.coursemanagement.demo.repository.CourseRepository;
import com.coursemanagement.demo.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseEntity getCourse(Integer Id) {
		Optional<CourseEntity> course = courseRepository.findById(Id);
		if (!course.isEmpty()) {
			return course.get();
		}
		return null;
	}

	@Override
	public CourseEntity createCourse(CourseDto courseDto) {
		CourseEntity course = new CourseEntity();
		course.setCourseName(courseDto.getCourseName());
		course.setCredit(courseDto.getCredit());
		course.setInstructorName(courseDto.getInstructorName());
		return courseRepository.save(course);
	}

	@Override
	public CourseEntity updatedCourse(CourseDto courseDto) {
		CourseEntity course = new CourseEntity();
		course.setCourseId(courseDto.getCourseId());
		course.setCourseName(courseDto.getCourseName());
		course.setCredit(courseDto.getCredit());
		course.setInstructorName(courseDto.getInstructorName());
		return courseRepository.save(course);
	}

	@Override
	public String deleteCourse(Integer id) {
		courseRepository.deleteById(id);
		return "Deleted for by:" + id;

	}

}
