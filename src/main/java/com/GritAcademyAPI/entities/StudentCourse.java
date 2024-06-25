package com.GritAcademyAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students_courses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "students_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "courses_id", nullable = false)
    private Course course;
}
