package com.GritAcademyAPI.repositories;

import com.GritAcademyAPI.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByfName(String fName);
    List<Student> findBylName(String lName);
    List<Student> findBytown(String town);
}
