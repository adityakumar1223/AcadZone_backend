package com.karan.AcadZone_Backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String rollNo;

    // Link to User entity (One-to-One)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Additional fields
    private boolean eLibraryAccess; // true if student can access eLibrary
    private String onlineClassInfo; // info about online classes

    // Constructors
    public Student() {}

    public Student(String name, String rollNo, User user, boolean eLibraryAccess, String onlineClassInfo) {
        this.name = name;
        this.rollNo = rollNo;
        this.user = user;
        this.eLibraryAccess = eLibraryAccess;
        this.onlineClassInfo = onlineClassInfo;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRollNo() { return rollNo; }
    public void setRollNo(String rollNo) { this.rollNo = rollNo; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public boolean isELibraryAccess() { return eLibraryAccess; }
    public void setELibraryAccess(boolean eLibraryAccess) { this.eLibraryAccess = eLibraryAccess; }

    public String getOnlineClassInfo() { return onlineClassInfo; }
    public void setOnlineClassInfo(String onlineClassInfo) { this.onlineClassInfo = onlineClassInfo; }
}

