package com.missedclass.system.model;

public class ClassRecord {

    // attributes

    private int id;

    private String subject;

    private String topic;

    private String assignment;

    private String classDate;

    private String deadline;

    private String notes;


    public ClassRecord() {
    }


    public ClassRecord(
            int id,
            String subject,
            String topic,
            String assignment,
            String classDate,
            String deadline,
            String notes) {

        this.id = id;
        this.subject = subject;
        this.topic = topic;
        this.assignment = assignment;
        this.classDate = classDate;
        this.deadline = deadline;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(
            int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(
            String subject) {
        this.subject = subject;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(
            String topic) {
        this.topic = topic;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(
            String assignment) {
        this.assignment = assignment;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(
            String classDate) {
        this.classDate = classDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(
            String deadline) {
        this.deadline = deadline;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(
            String notes) {
        this.notes = notes;
    }
}
