package com.gasigwatin.REST_6_Springboot_project_withDatabases;

//1. Here we are going to create a record class for the fields available in Student,
//2. Since the Student Entity has a relationship with the School Entity, we also need to create a record of the School by CREATING A "SchoolId" record
// with the Integer type instead of writing School school
public record StudentDto(String firstname,
                         String lastname,
                         String email,
                         Integer schoolId) {

}
