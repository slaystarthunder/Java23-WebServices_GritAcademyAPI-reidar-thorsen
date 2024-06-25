package com.GritAcademyAPI.services;

import com.GritAcademyAPI.entities.Student;
import com.GritAcademyAPI.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByFirstName(String fName) {
        return studentRepository.findByfName(fName);
    }

    public List<Student> getStudentsByLastName(String lName) {
        return studentRepository.findBylName(lName);
    }

    public List<Student> getStudentsByTown(String town) {
        return studentRepository.findBytown(town);
    }
}
