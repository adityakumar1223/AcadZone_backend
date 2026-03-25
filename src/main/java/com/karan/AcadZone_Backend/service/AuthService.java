package com.karan.AcadZone_Backend.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.dto.ERole;
import com.karan.AcadZone_Backend.model.Role;
import com.karan.AcadZone_Backend.model.User;
import com.karan.AcadZone_Backend.model.Teacher; // Import Teacher model
import com.karan.AcadZone_Backend.repository.RoleRepository;
import com.karan.AcadZone_Backend.repository.UserRepository;
import com.karan.AcadZone_Backend.repository.TeacherRepository; // Import Teacher Repo

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private TeacherRepository teacherRepo; // Inject TeacherRepository

    // Register user with enum role
    public User registerUser(String username, String email, String password, ERole roleEnum) {
        // ... existing validation checks

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); //

        Role role = roleRepo.findByName(roleEnum);
        if (role == null) {
            role = roleRepo.save(new Role(roleEnum)); //
        }

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        // 1. Save the user first to get a User ID
        User savedUser = userRepo.save(user);

        // 2. If the user is a teacher, create the Teacher profile
        if (roleEnum == ERole.TEACHER) {
            Teacher teacher = new Teacher();
            teacher.setUser(savedUser); // Link to the user
            teacher.setName(username);  // Set a default name
            
            // This save generates the 'teacher_id' in the teachers table
            teacherRepo.save(teacher); 
        }

        return savedUser;
    }

    // Login user
    public User loginUser(String username, String password) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password))
            throw new RuntimeException("Invalid password");

        return user;
    }
}