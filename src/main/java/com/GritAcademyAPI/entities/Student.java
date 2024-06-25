package com.GritAcademyAPI.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fName", nullable = false)
    private String fName;

    @Column(name = "lName", nullable = false)
    private String lName;

    @Column(name = "town", nullable = true)
    private String town;
}
