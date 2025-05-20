package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    1. LET'S ADD STUDENTS (The old method without a Data Transfer Object(DTO))

//    @PostMapping("/students")
//    public Student postTable(
//            @RequestBody Student student){
//
//        return studentRepository.save(student);
//    }

//    1. REPRESENTATION: LET'S ADD STUDENTS USING DTO

//    @PostMapping("/students")
//    public Student postStudents(
//            @RequestBody StudentDto dto){  //the moment we change Student to StudentDto record, the return gives an error, so in order to be able
//                                               to use the StudentDto, we must find a way to TRANSFORM IT into a STUDENT Object, like it was supposed to be
//                                               And we will achieve that by first creating a method below of the Student here, that will receive the object "StudentDto student
//
//        var student = toStudent(dto);
//        return studentRepository.save(student);
//    }

//    1. REPRESENTATION: LET'S ADD STUDENTS BUT RETURN/SHOW ONLY SOME INFORMATION (only firstname, lastname, email)

    @PostMapping("/students")
    public StudentResponseDto postStudents(
            @RequestBody StudentDto dto){

        var student = toStudent(dto);
        var savedStudent = studentRepository.save(student);
        return toStudentResponseDto(savedStudent);
    }

    private Student toStudent(StudentDto studentDto){

        //a. Now let's create an instance of the Student Entity, so that we can retrieve the setters from there.
        var student = new Student();

        student.setFirstname(studentDto.firstname());
        student.setLastname(studentDto.lastname());
        student.setEmail(studentDto.email());

        //b. Now let's create an instance of the School Entity, so that we can retrieve the setter for the Id from there

        var school = new School();

        school.setId(studentDto.schoolId());

        //c. Now let's assign the school instance to the student instance

        student.setSchool(school);

        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student){
        return new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail());
    }



//    2. LET'S RETRIEVE ALL THE STUDENTS ENTERED

    @GetMapping("/students")
    public List<Student> retrieveAllStudents(){

        return studentRepository.findAll();
    }

//    3. LET'S RETRIEVE ONE STUDENT BY USING THEIR ID

    @GetMapping("/students/{student-id}")
    public Student retrieveStudentById(
            @PathVariable("student-id") Integer id){

        return studentRepository.findById(id).orElse(new Student());
    }

//    4. LET'S NOW CREATE A CUSTOM QUERY TO RETRIEVE STUDENTS BY THEIR FIRST NAME

    //Be careful: we don't have a built-in method to search for a specific group of people, so we MUST first CREATE A CUSTOM METHOD in the StudentRepository that
    //we will then use here

    @GetMapping("/students/search/{first-name}")
    public List<Student> retrieveStudentsByFirstName(
            @PathVariable("first-name") String firstName){
        return studentRepository.findAllByFirstnameContaining(firstName);
    }

//    5. LET'S NOW DELETE A STUDENT BY USING THEIR ID


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteAStudentById(
           @PathVariable("student-id") Integer id){
        studentRepository.deleteById(id);
    }
}
