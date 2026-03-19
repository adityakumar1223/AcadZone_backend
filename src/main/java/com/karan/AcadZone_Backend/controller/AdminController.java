package com.karan.AcadZone_Backend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.karan.AcadZone_Backend.model.Student;
import com.karan.AcadZone_Backend.model.Teacher;
import com.karan.AcadZone_Backend.service.AdminService;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired private AdminService adminService;

    // Student APIs
    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){ 
        return adminService.addStudent(student);
    }

    @GetMapping("/getstudents")
    public List<Student> getAllStudents(){ 
        return adminService.getAllStudents();
    }

    @DeleteMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        adminService.deleteStudent(id);
        return "Student deleted successfully!";
    }

    // Teacher APIs
    @PostMapping("/addteacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){ 
        return adminService.addTeacher(teacher);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers(){ 
        return adminService.getAllTeachers();
    }

    @DeleteMapping("/deleteteacher/{id}")
    public String deleteTeacher(@PathVariable Long id){
        adminService.deleteTeacher(id);
        return "Teacher deleted successfully!";
    }
}
