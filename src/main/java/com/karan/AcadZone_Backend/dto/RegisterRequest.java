package com.karan.AcadZone_Backend.dto;

//DTOs
public class RegisterRequest {
 private String username;
 private String email;
 private String password;
 private ERole role; // ADMIN, TEACHER, STUDENT
 public String getUsername() {
	return username;
 }
 public void setUsername(String username) {
	this.username = username;
 }
 public String getEmail() {
	return email;
 }
 public void setEmail(String email) {
	this.email = email;
 }
 public String getPassword() {
	return password;
 }
 public void setPassword(String password) {
	this.password = password;
 }
 public ERole getRole() {
	return role;
 }
 public void setRole(ERole role) {
	this.role = role;
 }


}
