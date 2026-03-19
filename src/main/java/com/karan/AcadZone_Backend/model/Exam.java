package com.karan.AcadZone_Backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;          // Subject name of the exam
    private String title;            // Title of the exam
    private LocalDate examDate;      // Date of the exam
    private int totalMarks;          // Total marks for the exam

    // Link to Student (Many exams can belong to one student)
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Link to Teacher (Many exams can be conducted by one teacher)
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    // Constructors
    public Exam() {
    }

    public Exam(String subject, String title, LocalDate examDate, int totalMarks, Student student, Teacher teacher) {
        this.subject = subject;
        this.title = title;
        this.examDate = examDate;
        this.totalMarks = totalMarks;
        this.student = student;
        this.teacher = teacher;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getExamDate() {
        return examDate;
    }
    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public int getTotalMarks() {
        return totalMarks;
    }
    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
