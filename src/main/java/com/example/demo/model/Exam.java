package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "exams_table")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "exams_id")
    private Long exams_id;

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
    @Column(name= "date")
    private String date;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Long getExams_id() {
        return exams_id;
    }

    public void setExams_id(Long exams_id) {
        this.exams_id = exams_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
