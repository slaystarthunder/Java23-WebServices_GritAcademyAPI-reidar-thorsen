package com.GritAcademyAPI.controllers;

import com.GritAcademyAPI.entities.StudentCourse;
import com.GritAcademyAPI.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students_courses")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourse> getStudentCourseById(@PathVariable Long id) {
        return studentCourseService.getStudentCourseById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseService.getAllStudentCourses();
    }
}
