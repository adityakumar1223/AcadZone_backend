package com.karan.AcadZone_Backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.karan.AcadZone_Backend.model.Teacher;

import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmployeeId(String employeeId); // Get teacher by employee ID
    Optional<Teacher> findByUserId(Long userId);           // Get teacher linked to user account
}