package com.karan.AcadZone_Backend.model;

import com.karan.AcadZone_Backend.dto.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	 @Column(length = 20, unique = true, nullable = false)
	private ERole name;
	
	

    // Constructors
    public Role() {}

    public Role(ERole name) { this.name = name; }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ERole getName() { return name; }
    public void setName(ERole name) { this.name = name; }
    
 // Add this to convert the enum to a readable string
    @Override
    public String toString() {
        return this.name.name();
    }
}
