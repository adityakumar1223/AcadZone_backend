package com.karan.AcadZone_Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.karan.AcadZone_Backend.model.Attendance;
import com.karan.AcadZone_Backend.model.Book;
import com.karan.AcadZone_Backend.model.Exam;
import com.karan.AcadZone_Backend.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

    @Autowired private TeacherService teacherService;

    // Attendance APIs
    @PostMapping("/attendance")
    public Attendance markAttendance(@RequestBody Attendance attendance){
        return teacherService.markAttendance(attendance);
    }

    @GetMapping("/attendance/{teacherId}")
    public List<Attendance> getAttendanceByTeacher(@PathVariable Long teacherId){
        return teacherService.getAttendanceByTeacher(teacherId);
    }

    // Book APIs
    @PostMapping("/book")
    public Book uploadBook(@RequestBody Book book){
        return teacherService.uploadBook(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return teacherService.getAllBooks();
    }

    // Exam APIs
    @PostMapping("/exam")
    public Exam addExam(@RequestBody Exam exam){
        return teacherService.addExam(exam);
    }

    @GetMapping("/exams/{teacherId}")
    public List<Exam> getExamsByTeacher(@PathVariable Long teacherId){
        return teacherService.getExamsByTeacher(teacherId);
    }
}
