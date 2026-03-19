package com.karan.AcadZone_Backend.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String employeeId;

    // Link to User entity (One-to-One)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Additional fields
    @ElementCollection
    @CollectionTable(name = "teacher_subjects", joinColumns = @JoinColumn(name = "teacher_id"))
    @Column(name = "subject")
    private List<String> subjects; // subjects the teacher teaches

    private String classInfo; // info about classes assigned (e.g., "Class 10A")

    // Constructors
    public Teacher() {}

    public Teacher(String name, String employeeId, User user, List<String> subjects, String classInfo) {
        this.name = name;
        this.employeeId = employeeId;
        this.user = user;
        this.subjects = subjects;
        this.classInfo = classInfo;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<String> getSubjects() { return subjects; }
    public void setSubjects(List<String> subjects) { this.subjects = subjects; }

    public String getClassInfo() { return classInfo; }
    public void setClassInfo(String classInfo) { this.classInfo = classInfo; }
}

