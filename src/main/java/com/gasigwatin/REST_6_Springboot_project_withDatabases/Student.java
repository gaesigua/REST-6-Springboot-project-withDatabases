package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "TABLE_STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "f_name", length = 25)
    private String firstname;

    @Column(name = "l_name", length = 25)
    private String lastname;

    @Column(unique = true ,length = 50)
    private String email;

    private int age;

    @Column(updatable = false)
    private String creationDate;

    //Let's now create a relationship between this entity(Student) to the StudentProfile Entity

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    //Let's now create a relationship between this entity(Student) to the School

    @ManyToOne
    @JoinColumn(name = "school-id")
    @JsonBackReference
    private School school;

//    Let's create an empty constructor (REQUIRED)

    public Student(){}

//    Let's now create a Constructor for the class

    public Student(String firstname, String lastname, String email, int age, String creationDate, StudentProfile studentProfile, School school) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.creationDate = creationDate;
        this.studentProfile = studentProfile;
        this.school = school;
    }

//    Getter and Setter for Id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    Getter and Setter for Firstname

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

//    Getter and Setter for Lastname

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

//    Getter and Setter for Email

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    Getter and Setter for Age

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    Getter and Setter for CreationDate

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

//    Getter and Setter for StudentProfile

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

//    Getter and Setter for School

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
