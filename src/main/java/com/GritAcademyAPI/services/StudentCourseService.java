package com.GritAcademyAPI.services;

import com.GritAcademyAPI.entities.StudentCourse;
import com.GritAcademyAPI.repositories.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    @Autowired
    public StudentCourseService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    public Optional<StudentCourse> getStudentCourseById(Long id) {
        return studentCourseRepository.findByid(id);
    }

    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseRepository.findAll();
    }

    public List<StudentCourse> getStudentCoursesByStudentIds(List<Long> studentIds) {
        return studentCourseRepository.findByStudentIdIn(studentIds);
    }
}
