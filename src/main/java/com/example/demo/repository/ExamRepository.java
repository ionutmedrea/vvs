package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Exam;
import java.util.List;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    List<Exam> findByYearOfStudy(int yearOfStudy);
    List<Exam> findByFaculty(String faculty);
}
