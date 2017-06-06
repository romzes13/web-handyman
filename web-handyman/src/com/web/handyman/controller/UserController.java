package com.web.handyman.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.handyman.entity.Handyman;
import com.web.handyman.entity.User;
import com.web.handyman.entity.WorkOrder;
import com.web.handyman.service.HandymanService;
import com.web.handyman.service.UserService;
import com.web.handyman.service.WorkorderService;




@Controller
@RequestMapping("/user")
public class UserController {

	

		// need to inject the customer service
		@Autowired
		private UserService userService;
		
		// injecting handyman service
		@Autowired
		private HandymanService handymanService;
		
		@Autowired
		private WorkorderService workorderService;
		

		
		
		@GetMapping("/list")
		public String listUsers(Model theModel){
		
			// get list of handymen from service
			
			List<User> listOfUsers =  userService.getUsers();
			
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
			userService.saveUser(theUser);
			
			
			return "redirect:/handyman/list";
			
		}
		
		// Updating User information
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel){
			
			// get the user from the service
			User theUser= userService.getUser(theId);
			
			// set user as a model attribute to pre populate the form 
			theModel.addAttribute("user", theUser);
			
			
			
			// send over to our form
			return "user-form";
			
		}
		
		@GetMapping("/delete")
		public String delete(@RequestParam("userId") int theId) {
			
			// delete the user with id
			
			userService.deleteUser(theId);
			
			return "redirect:/user/list";
		}
		
		/** 
		 * @ TODO
		 * If authorization failed redirect to 403 or other page.
		 *   test
		 */
		@GetMapping("/mypage")
		public String userInfo(HttpSession session, Model theModel){
		
			// get user information from service
			// this can be deleted, it does not belong in the controller
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			  if (!(auth instanceof AnonymousAuthenticationToken)) {
				UserDetails userDetail = (UserDetails) auth.getPrincipal();
				//model.addObject("username", userDetail.getUsername());
				System.out.println("Logged in user is: " + userDetail.getUsername());
			
			// get the user object
			User user = userService.getUser();
			// get the corresponding handyman object
			Handyman handyman = handymanService.getHandyman();
			
			// getting the list of pending work orders
			List<WorkOrder> listOfWorkOrders =  workorderService.getMyWorkOrdersPending();
			
			System.out.println("Active workorders: " + listOfWorkOrders);
			
			// add users to DAO model
			theModel.addAttribute("user", user);
			theModel.addAttribute("handyman", handyman);
			theModel.addAttribute("listOfWorkorders", listOfWorkOrders);
			
			session.setAttribute("userLogged", user);
			session.setAttribute("handymanLogged", handyman);
			
			
			return "user-info";
			}
			  
			
			return null;
			  
		}
		
		
		
		
		
		
		
	
}
