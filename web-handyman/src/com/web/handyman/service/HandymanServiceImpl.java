package com.web.handyman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.handyman.dao.HandymanDAO;
import com.web.handyman.entity.Handyman;

@Service
public class HandymanServiceImpl implements HandymanService {

	@Autowired
	private HandymanDAO handymanDAO;
	
	@Override
	@Transactional
	public List<Handyman> getHandymen() {
		
		
		return handymanDAO.getHandymen();
	}

	@Override
	@Transactional
	public void saveHandyman(Handyman theHandyman) {
		
		handymanDAO.saveHandyman(theHandyman);
		
	}

	@Override
	@Transactional
	public Handyman getHandyman(Integer theId) {
		
		
		return handymanDAO.getHandyman(theId);
	}

	@Override
	@Transactional
	public Handyman getHandyman() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			//model.addObject("username", userDetail.getUsername());
			System.out.println("Logged in user is: " + userDetail.getUsername());
			
			String userName = userDetail.getUsername();
			
		return handymanDAO.getHandyman(userName);
		  }
		  return null;
	}

}
