package com.karan.AcadZone_Backend.dto;

import java.time.LocalDate;

public class AttendanceRequestDTO {

    private Long studentId;
    private Long teacherId;
    private LocalDate date;
    private boolean present;

    // Constructors
    public AttendanceRequestDTO() {}

    public AttendanceRequestDTO(Long studentId, Long teacherId, LocalDate date, boolean present) {
        this.studentId = studentId;
        this.teacherId = teacherId;
        this.date = date;
        this.present = present;
    }

    // Getters and Setters
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public boolean isPresent() { return present; }
    public void setPresent(boolean present) { this.present = present; }
}