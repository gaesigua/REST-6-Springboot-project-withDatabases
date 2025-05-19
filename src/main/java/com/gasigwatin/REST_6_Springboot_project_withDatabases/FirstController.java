package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FirstController {

    private final StudentRepository studentRepository;


    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/students")
    public Student postTable(
            @RequestBody Student student){

        return studentRepository.save(student);
    }

    @GetMapping("/student/{student-id}")
    public Student retrieveStudentById(
            @PathVariable("student-id") Integer id){

        return studentRepository.findById(id).orElse(null);
    }
}
