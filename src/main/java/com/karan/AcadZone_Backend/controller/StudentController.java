package com.karan.AcadZone_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.karan.AcadZone_Backend.model.Attendance;
import com.karan.AcadZone_Backend.model.Book;
import com.karan.AcadZone_Backend.model.Exam;
import com.karan.AcadZone_Backend.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {

    @Autowired private StudentService studentService;

    // Attendance
    @GetMapping("/attendance/{studentId}")
    public List<Attendance> getAttendance(@PathVariable Long studentId){
        return studentService.getAttendanceByStudent(studentId);
    }

    // eLibrary
    @GetMapping("/books")
    public List<Book> getBooks(){
        return studentService.getAllBooks();
    }

    // Exams
    @GetMapping("/exams")
    public List<Exam> getExams(){
        return studentService.getAllExams();
    }
}
