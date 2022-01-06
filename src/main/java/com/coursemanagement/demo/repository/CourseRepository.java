package com.coursemanagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coursemanagement.demo.entity.CourseEntity;
@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer>{

}
