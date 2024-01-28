package com.webapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp2.entity.Registration;


public interface RegistrationRepository extends JpaRepository <Registration, Long> {

}
