package com.karan.AcadZone_Backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karan.AcadZone_Backend.model.Attendance;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudentId(Long studentId);     // Get attendance for a student
    List<Attendance> findByTeacherId(Long teacherId);     // Get attendance marked by teacher
    List<Attendance> findByDate(LocalDate date);          // Get attendance by date
    List<Attendance> findByStudentIdAndDate(Long studentId, LocalDate date); // Single day
}
