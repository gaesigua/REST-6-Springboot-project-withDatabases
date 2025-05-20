package com.gasigwatin.REST_6_Springboot_project_withDatabases;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}