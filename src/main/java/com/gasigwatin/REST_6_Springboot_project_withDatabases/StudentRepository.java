package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    //LET'S CREATE A LIST OF STUDENT THAT WILL ALLOW US TO RETRIEVE THEIR FIRST NAMES

    //Warning 1: the parameter here must be exactly the same as in the RestController, what we are trying to pass...meaning we want to find students
                             // by their first name
    //Warning 2: the findAllByFirstnameContaining, the "firstname" field from the Student class/Entity become "Firstname" here as a good practice

    List<Student> findAllByFirstnameContaining (String firstName);

}
