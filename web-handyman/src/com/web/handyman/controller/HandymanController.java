package com.web.handyman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
			
			// add customers to DAO model
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
	
}
