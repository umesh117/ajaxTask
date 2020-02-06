package com.example.ajaxpropertest.ajaxpropertest.controller;

import com.example.ajaxpropertest.ajaxpropertest.entity.Student;
import com.example.ajaxpropertest.ajaxpropertest.services.StudServices;
import com.example.ajaxpropertest.ajaxpropertest.validation.AjaxResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class RestControllerStudent {

    @Autowired
    private StudServices studServices;

    @GetMapping("/studentList")
    public List<Student> findAll(Model model){
        Student student=new Student();
        model.addAttribute("student1",student);
        return studServices.getStudentList();
    }

    @PostMapping("/ajaxinsertStudent") //all insert request are handled by updateStudent() method below.
    public AjaxResponseBody insertStudent(@RequestParam("profile") MultipartFile[] file, @Valid @ModelAttribute Student student, BindingResult bindingResult){

        AjaxResponseBody response=new AjaxResponseBody();
        if(bindingResult.hasErrors()){
            TreeMap<String,String> errors = new TreeMap<>();
            bindingResult.getFieldErrors().stream().forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()) );
/*
            Map<String,String> errors=bindingResult.getFieldErrors().stream().
                    collect(Collectors.
                            toMap(FieldError::getField, FieldError::getDefaultMessage));
*/
                    //throws Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is java.lang.IllegalStateException: Duplicate key must not be blank] with root cause
            response.setValidated(false);
            response.setStudent(null);
            response.setErrorMessages(errors);
            System.out.println(response);

            System.out.println(errors);
        }else{
            response.setValidated(true);
 //for file upload
            String filename=file[0].getOriginalFilename();
            String path=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images";
            System.out.println(Paths.get(path+"\\"+filename));
            int num=0;
            while(Files.exists(Paths.get(path+num+"\\"+filename))){
                ++num;
            }
            filename=num+filename;

            //setting filename
            student.setProfilePic(filename);

            try{
                byte barr[]=file[0].getBytes();
                BufferedOutputStream bout=new BufferedOutputStream(
                        new FileOutputStream(path+"\\"+filename));
                bout.write(barr);
                bout.flush();
                bout.close();

            }catch(Exception e){System.out.println(e);}

//end code for file upload
            studServices.insertOrUpdateStudent(student);
            response.setStudent(student);
        }

        System.out.println(response);
        return response;
    }

    @PostMapping("/ajaxupdateStudent")
    public AjaxResponseBody updateStudent(@RequestParam("profile") MultipartFile[] file, @Valid @ModelAttribute Student student, BindingResult bindingResult){

        AjaxResponseBody response=new AjaxResponseBody();
        if(bindingResult.hasErrors()){
            TreeMap<String,String> errors = new TreeMap<>();
            bindingResult.getFieldErrors().stream().forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()) );
            response.setValidated(false);
            response.setStudent(null);
            response.setErrorMessages(errors);
            System.out.println(response);

            System.out.println(errors);
        }else{
            response.setValidated(true);
            //for file upload
            String filename=file[0].getOriginalFilename();
            String path=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images";
            System.out.println(Paths.get(path+"\\"+filename)+"*****");
            int num=0;
            while(Files.exists(Paths.get(path+"\\"+num+filename))){
                ++num;
            }
            filename=num+filename;

            //setting filename
            student.setProfilePic(filename);

            try{
                byte barr[]=file[0].getBytes();
                BufferedOutputStream bout=new BufferedOutputStream(
                        new FileOutputStream(path+"\\"+filename));
                bout.write(barr);
                bout.flush();
                bout.close();

            }catch(Exception e){System.out.println(e);}

//end code for file upload
            studServices.insertOrUpdateStudent(student);
            response.setStudent(student);
        }

        System.out.println(response);
        return response;
    }

    @DeleteMapping("/ajaxdeleteStudent/{id}")
    public void deleteStudent(@PathVariable("id")int id) throws IOException {
        System.out.println(id);
        Student student1=studServices.getStudentbyID(id);
        String path=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images";
        Files.delete(Paths.get(path+"\\"+student1.getProfilePic()));
        studServices.deleteStudent(id);
    }

}
