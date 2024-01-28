package com.webapp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp2.dto.RegistrationDto;
import com.webapp2.entity.Registration;
import com.webapp2.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/registrations")
public class RestRegistrationController {
    
	@Autowired
	private RegistrationRepository registraionRepository;
	
	@GetMapping
	public List<Registration> getAllReg(){
		List<Registration> registrations = registraionRepository.findAll();
        return registrations;
	}
	 
	@DeleteMapping ("/{id}")
	public void deleteRegistration(@PathVariable long id) {
		registraionRepository.deleteById(id);
		
	}
	
	
	//http://localhost:8080/api/registrations
	///save Registration
	
	@PostMapping
	public void saveRegistration (@RequestBody Registration reg) {
		registraionRepository.save(reg);
		
	}
	
	//http://localhost:8080/api/registrations?id14
	@PutMapping
	public void updateRegistration(@RequestParam long id,@RequestBody RegistrationDto registrationDto) {
		
		Registration registration = registraionRepository.findById(id).get();
		registration.setFirstName(registrationDto.getFirstName());
		registration.setLastName(registrationDto.getLastName());
		registration.setEmail(registrationDto.getEmail());
		registration.setMobile(registrationDto.getMobile());
		
		registraionRepository.save(registration);
	}
}
	

