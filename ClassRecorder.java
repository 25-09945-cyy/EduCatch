package com.missedclass.system.model;

public class ClassRecorder extends User {

    public ClassRecorder() {
    }

    public ClassRecorder(String name) {

        super(name);
    }

    @Override
    public String getRole() {

        return "Class Recorder";
    }
}