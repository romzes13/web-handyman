package com.web.handyman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.handyman.entity.User;
import com.web.handyman.entity.WorkOrder;
import com.web.handyman.service.UserService;
import com.web.handyman.service.WorkorderService;

@Controller
@RequestMapping("/workorder")
public class WorkorderController {
	
			// need to inject the customer service
			@Autowired
			private WorkorderService workorderService;
			@Autowired
			private UserService handymanService;  

			@GetMapping("/list")
			public String listWorkOrder(Model theModel){
			
				// get list of work orders from service
				
				List<WorkOrder> listOfWorkOrders =  workorderService.getWorkOrders();
				
				// add workOrders to DAO model
				
				theModel.addAttribute("workorders", listOfWorkOrders);
				
				
				
				return "list-workorders";
			}
			
			// Simple button redirect 
			@GetMapping("/toAddForm")
			public String toAddForm(){
				
				return "workorder-form";
				
			}
			
			
			//Save workorder to database
			
			@GetMapping("/showFormForAdd")
			public String showFormForAdd(Model theModel){
				
				// Create a new model attribute to bind form data
				
				WorkOrder workOrder = new WorkOrder();
				theModel.addAttribute("workorder",workOrder);
				
				return "workorder-form";
				
			}
			
			// Saving workorder
			
			@PostMapping("/saveWorkOrder")
			public String saveWorkOrder(@ModelAttribute("workorder") WorkOrder theWorkOrder, BindingResult result){
				
				if (result.hasErrors()){
					
					return "workorder-form";
					
				}
				
				
				workorderService.saveWorkOrder(theWorkOrder);
				
				
				return "redirect:/workorder/list";
			}
			
			// Update Workorder information
			
			@GetMapping("/showFormForUpdate")
			public String showFormForUpdate(@RequestParam("workorderId") int theId, Model theModel ){
						
				// Get the workorder from the service
				
				WorkOrder workOrder = workorderService.getWorkOrder(theId);
				
				// get list of users to select and assign to a work order
				List<User> listOfUsers =  handymanService.getUsers();
				System.out.println("\nPrinting Users from Workorder Controller: \n" + listOfUsers);
				// set workorder as a model to prepopulate the form
				theModel.addAttribute("workorder", workOrder);
				theModel.addAttribute("users", listOfUsers);
				
				// send over to our form
				
				return "workorder-form";
				
			}
			
			@GetMapping("/delete")
			public String delete(@RequestParam("workorderId") int theId){
				
				// delete the workorder with id
				
				workorderService.deleteWorkorder(theId);
				
				return "redirect:/workorder/list";
			}
			
			@GetMapping("/mylist")
			public String myWorkorders(Model theModel){
				
				// get list of work orders from service
				
				List<WorkOrder> listOfMyWorkOrders =  workorderService.getMyWorkOrders();
				
				// add workOrders to DAO model
				
				theModel.addAttribute("workorders", listOfMyWorkOrders);
				
				return "mylist-workorders-test";
			}
			
			
			
}
