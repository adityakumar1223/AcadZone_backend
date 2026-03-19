package com.karan.AcadZone_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.karan.AcadZone_Backend.model.Student;

import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNo(String rollNo); // Get student by roll number
    Optional<Student> findByUserId(Long userId);  // Get student linked to user account
}
