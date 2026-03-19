package com.karan.AcadZone_Backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.AcadZone_Backend.model.Exam;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karan.AcadZone_Backend.model.Book;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
	
	// Find exams by teacher (using teacher's ID)
    List<Exam> findByTeacherId(Long teacherId);

    // Find exams by student (using student's ID)
    List<Exam> findByStudentId(Long studentId);

    // Find exams by title (case-insensitive search)
    List<Exam> findByTitleContainingIgnoreCase(String title);

    // Find exams on a particular date
    List<Exam> findByExamDate(LocalDate examDate);
}
