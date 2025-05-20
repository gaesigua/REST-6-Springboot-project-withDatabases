package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue
    private Integer id;

    private String schoolname;

//    Let's now create a OneToMany Relationship between this School Entity and the Student Entity

    @OneToMany(mappedBy = "school")
    @JsonManagedReference
    private List<Student> students;

//    An Empty Constructor (REQUIRED)

    public School(){}

//    A Constructor of the Class

    public School(String schoolname){
        this.schoolname = schoolname;
    }

//    Getter and Setter for the Id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    Getter and Setter for the schoolname

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

//    Getter and Setter for the Student List

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
