package com.coursemanagement.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coursemanagement.demo.entity.StudentCouseEntiry;

@Repository
public interface CourseStudentRepository extends JpaRepository<StudentCouseEntiry, Integer> {
	@Query(value = "select *  from student_course_entity where student_id =:id", nativeQuery = true)
	List<StudentCouseEntiry> getCouseRegisteredByStudent(@Param("id") Integer Id);

	@Query(value = "select * from student_course_entity where course_id =:id", nativeQuery = true)
	List<StudentCouseEntiry> getStudentRegisteredForCourse(@Param("id") Integer Id);

	@Query(value = "select * from student_course_entity where course_id =:courseId and student_id =:studentId", nativeQuery = true)
	StudentCouseEntiry deRegisterStudent(@Param("courseId") Integer courseId, @Param("studentId") Integer studentId);

}
