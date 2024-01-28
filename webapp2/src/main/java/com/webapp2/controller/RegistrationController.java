package com.webapp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webapp2.dto.RegistrationDto;
import com.webapp2.entity.Registration;
import com.webapp2.service.RegistrationService;
import com.webapp2.util.EmailService;


@Controller
public class RegistrationController {
	
	private EmailService emailService;
	
	@Autowired
	 private RegistrationService registrationService;
	 
	//Handler Methode
	 @RequestMapping("/mornning")
	 public String viewsRegistrationPage(){
		return "new_registration";
		 
	 }
//	 @RequestMapping("/saveReg") // this methode save the data in Backened .Not a database SQL.
//	   public String saveRegistration (Registration registration) {
//		 System.out.println(registration.getFirstName());
//		 System.out.println(registration.getLastName());
//		 System.out.println(registration.getEmail());
//		 System.out.println(registration.getMobile());
//		return "new_registration";
//	
//	 }
//	1-methode to save DataBase SQL  @RequestMapping("/saveReg") 1 
//	 public String saveRegistration(Registration registration,Model model) {
//		 registrationService.saveRegistration(registration);
//		 model.addAttribute("msg","Record is saved");
//		return "new_registration";
//		 
//	 }
//	2- methode to save DataBase SQL-  @RequestMapping("/saveReg")  create/update
//	 public String saveRegistration(
//			 @RequestParam("firstName")String fName,
//			 @RequestParam("lastName") String lName,
//			 @RequestParam("email")   String email,
//			 @RequestParam("mobile") long mobile
//			 
//			 ) {
//	  Registration registration = new Registration ();
//		 
//	      registration.setFirstName(fName);
//		  registration.setLastName(lName);
//		  registration.setEmail(email);
//		  registration.setMobile(mobile);
//		 
//		 registrationService.saveRegistration(registration);
//		 return "new_registration";
//		 
//	 }
	 @RequestMapping("/saveReg")
	 public String saveRegistration(
			 
			 RegistrationDto dto,
			 ModelMap model
			 ) {
	     
	  Registration registration = new Registration ();
		 
	     registration.setFirstName(dto.getFirstName());
	     registration.setLastName(dto.getLastName());
	     registration.setEmail(dto.getEmail());
	     registration.setMobile(dto.getMobile());
		 
		 registrationService.saveRegistration(registration);
		 model.addAttribute("msg" , "Record is saved");
		          return "new_registration";
	 }
	  @RequestMapping("/getAllReg")
      public String getAllRegistrations(Model model) {
		  List<Registration> reg = registrationService.getAllRegistrations();
		  model.addAttribute("registrations", reg);
		  return "list_registrations";
	  }
	  
	   @RequestMapping("/delete")
	   public String deleteRegById(@RequestParam("id")long id , Model model) {
		 registrationService.deleteRegById(id);
		 List<Registration> reg = registrationService.getAllRegistrations();
		 model.addAttribute("registrations", reg);
		  return "list_registrations";
	   }
	   @RequestMapping("/getRegistrationById")
	   public String getRegistrationById(@RequestParam("id")long id , Model model) {
		Registration registration = registrationService.getRegistrationById(id);
		 model.addAttribute("reg", registration); 
		 return "update_registration2";
	   }
	  
	   @RequestMapping("/updateReg")
		 public String updateRegistration(
				 
				 RegistrationDto dto,
		        	Model model
			
			
				 ) {
		     
		  Registration registration = new Registration ();
			 registration.setId (dto.getId());
		     registration.setFirstName(dto.getFirstName());
		     registration.setLastName(dto.getLastName());
		     registration.setEmail(dto.getEmail());
		     registration.setMobile(dto.getMobile());
		     
		     registrationService.saveRegistration(registration);
			 emailService.sendEmail(dto.getEmail(), "welcome", "Piyush8@");
		     List<Registration> reg = registrationService.getAllRegistrations();
			 model.addAttribute("registrations", reg);
			  return "list_registrations";
		 }
	  
	  
}
