package com.GritAcademyAPI.controllers;

import com.GritAcademyAPI.entities.Student;
import com.GritAcademyAPI.entities.StudentCourse;
import com.GritAcademyAPI.services.StudentCourseService;
import com.GritAcademyAPI.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentCourseService studentCourseService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Student> getStudentsByCriteria(@RequestParam(required = false) String fName,
                                               @RequestParam(required = false) String lName,
                                               @RequestParam(required = false) String town) {
        if (fName != null) {
            return studentService.getStudentsByFirstName(fName);
        } else if (lName != null) {
            return studentService.getStudentsByLastName(lName);
        } else if (town != null) {
            return studentService.getStudentsByTown(town);
        } else {
            return studentService.getAllStudents();
        }
    }

    @GetMapping("/byFirstNameWithCourses")
    public ResponseEntity<List<StudentCourse>> getStudentsByFirstNameWithCourses(@RequestParam String fName) {
        List<Student> students = studentService.getStudentsByFirstName(fName);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Long> studentIds = students.stream().map(Student::getId).collect(Collectors.toList());
        List<StudentCourse> studentCourses = studentCourseService.getStudentCoursesByStudentIds(studentIds);
        return ResponseEntity.ok(studentCourses);
    }

    @GetMapping("/byLastNameWithCourses")
    public ResponseEntity<List<StudentCourse>> getStudentsByLastNameWithCourses(@RequestParam String lName) {
        List<Student> students = studentService.getStudentsByLastName(lName);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Long> studentIds = students.stream().map(Student::getId).collect(Collectors.toList());
        List<StudentCourse> studentCourses = studentCourseService.getStudentCoursesByStudentIds(studentIds);
        return ResponseEntity.ok(studentCourses);
    }

    @GetMapping("/byTownWithCourses")
    public ResponseEntity<List<StudentCourse>> getStudentsByTownWithCourses(@RequestParam String town) {
        List<Student> students = studentService.getStudentsByTown(town);
        if (students.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Long> studentIds = students.stream().map(Student::getId).collect(Collectors.toList());
        List<StudentCourse> studentCourses = studentCourseService.getStudentCoursesByStudentIds(studentIds);
        return ResponseEntity.ok(studentCourses);
    }
}
