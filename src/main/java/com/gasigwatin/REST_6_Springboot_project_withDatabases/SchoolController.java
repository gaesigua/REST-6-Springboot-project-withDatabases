package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

//    Let's create a school (creating entries for the school)

//    @PostMapping("/schools")
//    public School createSchool(
//            @RequestBody School schoolDetails){
//        return schoolRepository.save(schoolDetails);
//    }

//    REPRESENTATION: Let's exponse some information to the Rest client/End user

    @PostMapping("/schools")
    public SchoolDto createSchool(
            @RequestBody SchoolDto schoolDto){

        var school = toSchool(schoolDto);

        return
    }
//    Let's retrieve school details

    @GetMapping("/schools")
    public List<School> retrieveSchools(){
        return schoolRepository.findAll();
    }
}
