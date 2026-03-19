package com.karan.AcadZone_Backend.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.model.Student;
import com.karan.AcadZone_Backend.model.Teacher;
import com.karan.AcadZone_Backend.repository.StudentRepository;
import com.karan.AcadZone_Backend.repository.TeacherRepository;

import java.util.List;

@Service
public class AdminService {

    @Autowired private StudentRepository studentRepo;
    @Autowired private TeacherRepository teacherRepo;

    // Students
    public Student addStudent(Student student){ return studentRepo.save(student); }
    public List<Student> getAllStudents(){ return studentRepo.findAll(); }
    public void deleteStudent(Long id){ studentRepo.deleteById(id); }

    // Teachers
    public Teacher addTeacher(Teacher teacher){ return teacherRepo.save(teacher); }
    public List<Teacher> getAllTeachers(){ return teacherRepo.findAll(); }
    public void deleteTeacher(Long id){ teacherRepo.deleteById(id); }
}

