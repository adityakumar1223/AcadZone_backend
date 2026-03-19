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
public class TeacherService {

    @Autowired private AttendanceRepository attendanceRepo;
    @Autowired private BookRepository bookRepo;
    @Autowired private ExamRepository examRepo;

    // Attendance
    public Attendance markAttendance(Attendance attendance){ return attendanceRepo.save(attendance); }
    public List<Attendance> getAttendanceByTeacher(Long teacherId){ return attendanceRepo.findByTeacherId(teacherId); }

    // Books
    public Book uploadBook(Book book){ return bookRepo.save(book); }
    public List<Book> getAllBooks(){ return bookRepo.findAll(); }

    // Exams
    public Exam addExam(Exam exam){ return examRepo.save(exam); }
    public List<Exam> getExamsByTeacher(Long teacherId){ return examRepo.findByTeacherId(teacherId); }
}
