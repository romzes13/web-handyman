package com.web.handyman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.handyman.entity.Company;
import com.web.handyman.service.CompanyService;

/**
 * 
 * @author roman
 *
 */

	

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	
	@GetMapping("/list")
	public String listCompanies(){
		
		List<Company> companies = companyService.getCompanies();
		
		
		
		return "list-companies";
		
		
	}

}
