package com.missedclass.system.model;

public class Student extends User {

    public Student() {
    }

    public Student(String name) {

        super(name);
    }

    @Override
    public String getRole() {

        return "Student";
    }
}