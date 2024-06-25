package com.GritAcademyAPI.repositories;

import com.GritAcademyAPI.entities.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    Optional<StudentCourse> findByid(Long id);
    List<StudentCourse> findByStudentIdIn(List<Long> studentIds);
}
