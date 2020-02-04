package com.example.ajaxpropertest.ajaxpropertest.validation;

import com.example.ajaxpropertest.ajaxpropertest.entity.Student;

import java.util.TreeMap;

public class AjaxResponseBody {

    private boolean validated;
    private TreeMap<String,String> errorMessages;
    private Student student;

    public AjaxResponseBody() {
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public TreeMap<String, String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(TreeMap<String, String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "AjaxResponseBody{" +
                "validated=" + validated +
                ", errorMessages=" + errorMessages +
                ", student=" + student +
                '}';
    }
}
