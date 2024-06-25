package com.GritAcademyAPI.controllers;

import com.GritAcademyAPI.entities.Course;
import com.GritAcademyAPI.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/withStudents")
    public ResponseEntity<Course> getCourseByIdWithStudents(@PathVariable Long id) {
        Course course = courseService.getCourseByIdWithStudents(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byName")
    public List<Course> getCoursesByName(@RequestParam String name) {
        return courseService.getCoursesByName(name);
    }

    @GetMapping("/byWordInName")
    public List<Course> getCoursesByWordInName(@RequestParam String word) {
        return courseService.getCoursesByWordInName(word);
    }

    @GetMapping("/byWordInDescription")
    public List<Course> getCoursesByWordInDescription(@RequestParam String word) {
        return courseService.getCoursesByWordInDescription(word);
    }
}
