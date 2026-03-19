package com.karan.AcadZone_Backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.AcadZone_Backend.model.Role;
import com.karan.AcadZone_Backend.model.User;
import com.karan.AcadZone_Backend.repository.RoleRepository;
import com.karan.AcadZone_Backend.repository.UserRepository;
import com.karan.AcadZone_Backend.dto.ERole;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired private UserRepository userRepo;
    @Autowired private RoleRepository roleRepo;

    // Register user with enum role
    public User registerUser(String username, String email, String password, ERole roleEnum) {

        if (userRepo.existsByUsername(username))
            throw new RuntimeException("Username already exists");
        if (userRepo.existsByEmail(email))
            throw new RuntimeException("Email already exists");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); // plain password

        // Fetch role by enum
        Role role = roleRepo.findByName(roleEnum);
        if (role == null)
            throw new RuntimeException("Role not found in DB");

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        return userRepo.save(user);
    }

    public List<User> getAllUsers() { return userRepo.findAll(); }

    public Optional<User> getUserById(Long id) { return userRepo.findById(id); }

    public void deleteUser(Long id) { userRepo.deleteById(id); }
}
