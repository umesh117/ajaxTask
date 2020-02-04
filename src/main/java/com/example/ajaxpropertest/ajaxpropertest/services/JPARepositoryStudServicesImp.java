package com.example.ajaxpropertest.ajaxpropertest.services;

import com.example.ajaxpropertest.ajaxpropertest.DAO.StudJPARepository;
import com.example.ajaxpropertest.ajaxpropertest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class JPARepositoryStudServicesImp implements StudServices {

    @Autowired
    private StudJPARepository studJPARepository;

    @Override
    public List<Student> getStudentList() {
        return studJPARepository.findAll();
    }

    @Override
    public Student getStudentbyID(int id) {
        Optional<Student> byId = studJPARepository.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }else{
            throw new RuntimeException("No data found for the id "+id);
        }
    }

    @Override
    public void insertOrUpdateStudent(Student student) {
        String tempPass=student.getPassword();

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytePass=md.digest(tempPass.getBytes());
            student.setPassword(Base64.getEncoder().encodeToString(bytePass));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        studJPARepository.save(student);
    }

    @Override
    public void deleteStudent(int studentID) {
        studJPARepository.deleteById(studentID);
    }

}
