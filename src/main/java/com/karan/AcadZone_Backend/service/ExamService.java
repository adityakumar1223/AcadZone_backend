package com.karan.AcadZone_Backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.model.Exam;
import com.karan.AcadZone_Backend.repository.ExamRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExamService {

    @Autowired private ExamRepository examRepo;

    public Exam addExam(Exam exam){ return examRepo.save(exam); }
    public List<Exam> getAllExams(){ return examRepo.findAll(); }
    public List<Exam> getExamsByTeacher(Long teacherId){ return examRepo.findByTeacherId(teacherId); }
    public List<Exam> getExamsByDate(LocalDate date){ return examRepo.findByExamDate(date); }
    public void deleteExam(Long id){ examRepo.deleteById(id); }
}
