package com.GritAcademyAPI.repositories;

import com.GritAcademyAPI.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByNameContaining(String word);
    List<Course> findByDescriptionContaining(String word);
}
