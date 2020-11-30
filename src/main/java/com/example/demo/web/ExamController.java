package com.example.demo.web;

import com.example.demo.model.Exam;
import com.example.demo.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExamController {
    @Autowired
    ExamRepository examRepository;

    @GetMapping("/addExam")
    public String add(Model model){
        model.addAttribute("examForm", new Exam());
        return "addExam";
    }
    @PostMapping("/addExam")
    public String add(@ModelAttribute("examForm") Exam examForm){
        examRepository.save(examForm);
        return "redirect:/welcome";
    }

    @GetMapping("/showExams")
    public String show(Model model){
        model.addAttribute("examForm", examRepository.findAll());
        return "showExams";
    }
}
