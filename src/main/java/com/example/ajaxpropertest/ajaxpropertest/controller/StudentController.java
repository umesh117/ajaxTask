package com.example.ajaxpropertest.ajaxpropertest.controller;

import com.example.ajaxpropertest.ajaxpropertest.entity.Student;
import com.example.ajaxpropertest.ajaxpropertest.services.StudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stud_api")
public class StudentController {

    @Autowired
    @Qualifier("JPARepositoryStudServicesImp")
    private StudServices studServices;

    @RequestMapping("/ajax")
    public String getFirstPage(Model model){
        Student student=new Student();
        model.addAttribute("student1",student);
        return "/student/AjaxTest1";
    }

}
