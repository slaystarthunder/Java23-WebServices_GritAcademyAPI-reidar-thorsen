package com.GritAcademyAPI.services;

import com.GritAcademyAPI.entities.Course;
import com.GritAcademyAPI.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course getCourseByIdWithStudents(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public List<Course> getCoursesByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> getCoursesByWordInName(String word) {
        return courseRepository.findByNameContaining(word);
    }

    public List<Course> getCoursesByWordInDescription(String word) {
        return courseRepository.findByDescriptionContaining(word);
    }
}
