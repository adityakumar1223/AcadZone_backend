package com.karan.AcadZone_Backend.repository;



import com.karan.AcadZone_Backend.dto.ERole;
import com.karan.AcadZone_Backend.model.Role;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Repository to manage Role entities
@Repository

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(ERole name);
}