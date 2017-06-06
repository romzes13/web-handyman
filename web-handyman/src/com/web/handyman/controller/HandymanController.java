package com.web.handyman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.handyman.entity.Handyman;
import com.web.handyman.entity.User;
import com.web.handyman.service.HandymanService;
import com.web.handyman.service.UserService;

@Controller
@RequestMapping("/handyman")
public class HandymanController {

	@Autowired
	private HandymanService handymanService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listHandymen(Model theModel){
		
		// @DELETE this can be deleted 
		System.out.println("Login as " +SecurityContextHolder.getContext().getAuthentication().getName());
		
		// get list of handymen from service
		
		List<Handyman> listOfHandymen = handymanService.getHandymen();
		
		// add handymen to dao model
		
		theModel.addAttribute("handymen", listOfHandymen);
		
		
		
		return "list-handymen";
	}
	
			// Save handyman to database
			@GetMapping("/showFormForAdd")
			public String showFormForAdd(Model theModel){
				
				// Create a new model attribute to bind form data
				
				Handyman theHandyman = new Handyman();
				
				// Get list of users for handyman page
				List<User> listOfUsers =  userService.getUsers();
				
				theModel.addAttribute("handyman", theHandyman);
				
				// Adds list of users to pick from
				theModel.addAttribute("users", listOfUsers);
				
				return "handyman-form";
				
			}
	
		
			// Saving User
			
			@PostMapping("/saveHandyman")
			public String saveHandyman(@ModelAttribute("handyman") Handyman theHandyman){
				
				// Save the user using service
				handymanService.saveHandyman(theHandyman);
				
				
				return "redirect:/handyman/list";
				
			}
			
			// Update Handyman information
			
			@GetMapping("/showFormForUpdate")
			public String showFormForUpdate(@RequestParam("handymanId") int theId, Model theModel ){
					
				
				// Get the handyman from the service
				
				Handyman handyman = handymanService.getHandyman(theId);
				
				// get list of users to select and assign to a handyman
				List<User> listOfUsers =  userService.getUsers();
				System.out.println("\nPrinting Users from Handyman Controller: \n" + listOfUsers);
				// set handyman as a model to pre populate the form
				theModel.addAttribute("handyman", handyman);
				theModel.addAttribute("users", listOfUsers);
				
				// send over to our form
				
				return "handyman-form";
				
			}
	
}
