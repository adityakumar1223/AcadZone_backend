package com.karan.AcadZone_Backend.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.model.Attendance;
import com.karan.AcadZone_Backend.model.Book;
import com.karan.AcadZone_Backend.model.Exam;
import com.karan.AcadZone_Backend.repository.AttendanceRepository;
import com.karan.AcadZone_Backend.repository.BookRepository;
import com.karan.AcadZone_Backend.repository.ExamRepository;

import java.util.List;

@Service
public class StudentService {

    @Autowired private AttendanceRepository attendanceRepo;
    @Autowired private BookRepository bookRepo;
    @Autowired private ExamRepository examRepo;

    // Attendance
    public List<Attendance> getAttendanceByStudent(Long studentId){ 
        return attendanceRepo.findByStudentId(studentId); 
    }

    // eLibrary
    public List<Book> getAllBooks(){ return bookRepo.findAll(); }

    // Exams
    public List<Exam> getAllExams(){ return examRepo.findAll(); }
}

