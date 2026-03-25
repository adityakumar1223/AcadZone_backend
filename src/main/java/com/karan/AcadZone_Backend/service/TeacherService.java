package com.karan.AcadZone_Backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.model.Attendance;
import com.karan.AcadZone_Backend.model.Book;
import com.karan.AcadZone_Backend.model.Exam;
import com.karan.AcadZone_Backend.model.Student;
import com.karan.AcadZone_Backend.model.Teacher;
import com.karan.AcadZone_Backend.repository.AttendanceRepository;
import com.karan.AcadZone_Backend.repository.BookRepository;
import com.karan.AcadZone_Backend.repository.ExamRepository;
import com.karan.AcadZone_Backend.repository.StudentRepository;
import com.karan.AcadZone_Backend.repository.TeacherRepository;

import java.util.List;

@Service
public class TeacherService {

    @Autowired private AttendanceRepository attendanceRepo;
    @Autowired private BookRepository bookRepo;
    @Autowired private ExamRepository examRepo;
    @Autowired private StudentRepository studentRepo;
    @Autowired private TeacherRepository teacherRepo;

    // Attendance
    public Attendance markAttendance(Attendance attendance){
        // Fetch the actual Student entity from database
        if (attendance.getStudent() != null && attendance.getStudent().getId() != null) {
            Student student = studentRepo.findById(attendance.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + attendance.getStudent().getId()));
            attendance.setStudent(student);
        }

        // Fetch the actual Teacher entity from database
        if (attendance.getTeacher() != null && attendance.getTeacher().getId() != null) {
            Teacher teacher = teacherRepo.findById(attendance.getTeacher().getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + attendance.getTeacher().getId()));
            attendance.setTeacher(teacher);
        }

        return attendanceRepo.save(attendance);
    }

    public List<Attendance> getAttendanceByTeacher(Long teacherId){ return attendanceRepo.findByTeacherId(teacherId); }

    // Books
    public Book uploadBook(Book book){ return bookRepo.save(book); }
    public List<Book> getAllBooks(){ return bookRepo.findAll(); }

    // Exams
    public Exam addExam(Exam exam){
        // Fetch the actual Student entity from database
        if (exam.getStudent() != null && exam.getStudent().getId() != null) {
            Student student = studentRepo.findById(exam.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + exam.getStudent().getId()));
            exam.setStudent(student);
        }

        // Fetch the actual Teacher entity from database
        if (exam.getTeacher() != null && exam.getTeacher().getId() != null) {
            Teacher teacher = teacherRepo.findById(exam.getTeacher().getId())
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + exam.getTeacher().getId()));
            exam.setTeacher(teacher);
        }

        return examRepo.save(exam);
    }

    public List<Exam> getExamsByTeacher(Long teacherId){ return examRepo.findByTeacherId(teacherId); }
}
