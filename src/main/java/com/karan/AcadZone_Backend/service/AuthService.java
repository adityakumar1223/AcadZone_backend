package com.karan.AcadZone_Backend.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.dto.ERole;
import com.karan.AcadZone_Backend.model.Role;
import com.karan.AcadZone_Backend.model.User;
import com.karan.AcadZone_Backend.repository.RoleRepository;
import com.karan.AcadZone_Backend.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    // Register user with enum role
    public User registerUser(String username, String email, String password, ERole roleEnum) {

        if (userRepo.existsByUsername(username))
            throw new RuntimeException("Username already exists");

        if (userRepo.existsByEmail(email))
            throw new RuntimeException("Email already exists");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); // plain text password

        // Get role directly
        Role role = roleRepo.findByName(roleEnum);
        if (role == null) {
            // If role not exists, create it
            role = roleRepo.save(new Role(roleEnum));
        }

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        return userRepo.save(user);
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
