package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import jakarta.persistence.*;

@Entity
@Table(name = "table_student")
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


    public Student(){}

    public Student(String firstname, String lastname, String email, int age, String creationDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
