package com.example.ajaxpropertest.ajaxpropertest.services;


import com.example.ajaxpropertest.ajaxpropertest.entity.Student;

import java.util.List;

public interface StudServices {

    public List<Student> getStudentList();

    public Student getStudentbyID(int id);

    public void insertOrUpdateStudent(Student student);

    public void deleteStudent(int studentID);
}
