package com.web.handyman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.handyman.entity.User;
import com.web.handyman.service.HandymanService;




@Controller
@RequestMapping("/handyman")
public class HandymanController {

	

		// need to inject the customer service
		@Autowired
		private HandymanService handymanService;
		

		
		
		@GetMapping("/list")
		public String listHandymen(Model theModel){
		
			// get list of handymen from service
			
			List<User> listOfUsers =  handymanService.getUsers();
			
			// add users to DAO model
			theModel.addAttribute("users", listOfUsers);
			
			
			
			return "list-users";
		}
	
	
		// Save user to database
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel){
			
			// Create a new model attribute to bind form data
			
			User theUser= new User();
			
			theModel.addAttribute("user", theUser);
			
			return "user-form";
			
		}
		
		// Saving User
		
		@PostMapping("/saveUser")
		public String saveUser(@ModelAttribute("user") User theUser){
			
			// Save the user using service
			handymanService.saveUser(theUser);
			
			
			return "redirect:/handyman/list";
			
		}
		
		// Updating User information
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel){
			
			// get the user from the service
			User theUser= handymanService.getUser(theId);
			
			// set user as a model attribute to pre populate the form 
			theModel.addAttribute("user", theUser);
			
			
			
			// send over to our form
			return "user-form";
			
		}
		
		
		
		
		
		
		
		
		
		
		
	
}
