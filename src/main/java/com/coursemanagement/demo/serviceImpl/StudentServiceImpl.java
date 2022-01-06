package com.coursemanagement.demo.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coursemanagement.demo.dto.StudentDto;
import com.coursemanagement.demo.entity.StudentEntity;
import com.coursemanagement.demo.repository.StudentRepository;
import com.coursemanagement.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentEntity getStudent(Integer Id) {
		Optional<StudentEntity> student = studentRepository.findById(Id);
		if(!student.isEmpty()) {
			return student.get();
		}
		return null;
	}

	@Override
	public StudentEntity createEntity(StudentDto studentDto) {
		StudentEntity student = new StudentEntity();
		student.setfName(studentDto.getfName());
		student.setlName(studentDto.getlName());
		student.setDob(studentDto.getDob());
		return studentRepository.save(student);
		
	}

	@Override
	public StudentEntity updatedStudent(StudentDto studentDto) {
		StudentEntity student = new StudentEntity();
		student.seteNumber(studentDto.getStudentId());
		student.setfName(studentDto.getfName());
		student.setlName(studentDto.getlName());
		student.setDob(studentDto.getDob());
		return studentRepository.save(student);
	}

	@Override
	public String deleteStudent(Integer id) {
		Optional<StudentEntity> student = studentRepository.findById(id);
		if(!student.isEmpty()) {
			studentRepository.deleteById(id);
			return "Student deleted for id: "+id;
		}
		return null;
	}

}
