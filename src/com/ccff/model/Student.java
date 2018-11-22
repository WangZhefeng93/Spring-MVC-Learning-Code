package com.ccff.model;

public class Student {
    private String studentName;
    private String password;

    public Student(){

    }

    public Student(String studentName, String password) {
        this.studentName = studentName;
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
