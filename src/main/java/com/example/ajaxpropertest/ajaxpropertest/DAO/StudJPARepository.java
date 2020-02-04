package com.example.ajaxpropertest.ajaxpropertest.DAO;

import com.example.ajaxpropertest.ajaxpropertest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudJPARepository extends JpaRepository<Student, Integer> {
}
