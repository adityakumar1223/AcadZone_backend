package com.karan.AcadZone_Backend.model;


import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Link to Student
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Link to Teacher (who marked the attendance)
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private boolean present;

    // Constructors
    public Attendance() {}

    public Attendance(Student student, Teacher teacher, LocalDate date, boolean present) {
        this.student = student;
        this.teacher = teacher;
        this.date = date;
        this.present = present;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Teacher getTeacher() { return teacher; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isPresent() { return present; }
    public void setPresent(boolean present) { this.present = present; }
}

