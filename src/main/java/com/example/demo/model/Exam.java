package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue
    @Column(name= "exams_id")
    private Long id;

    @Column(name= "session")
    private String session;
    @Column(name= "yearOfStudy")
    private int yearOfStudy;
    @Column(name= "faculty")
    private String faculty;
    @Column(name= "domain")
    private String domain;
    @Column(name= "course")
    private String course;
    @Column(name= "teacher")
    private String teacher;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
