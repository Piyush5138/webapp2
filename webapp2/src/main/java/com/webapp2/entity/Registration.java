package com.webapp2.entity;

import javax.persistence.*;
//import jakarta.persistence.Entity;      ( old version the change jakarta to javax.persistance..import)
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name="registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
    
    @Column(name="first_Name" , length=45)
	 private String firstName;
    
    @Column(name="last_Name" , length=45)
	 private String lastName;
    
    @Column(name="email" , unique=true , length=128)
	 private String email;
    
    @Column(name = "mobile")
	 private long mobile;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	 
	 
}
