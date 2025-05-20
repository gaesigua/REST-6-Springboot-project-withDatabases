package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;

    private String bio;

    //Let's create a relationship back to the Student entity

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;


    public StudentProfile(){}

    public StudentProfile(String bio, Student student){
        this.bio = bio;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
