package com.gasigwatin.REST_6_Springboot_project_withDatabases;

//These 3 fields are what we want to expose to our REST client/end user
public record StudentResponseDto(String firstname,
                                 String lastname,
                                 String email) {
}
