package com.web.handyman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.handyman.dao.UserDAO;
import com.web.handyman.entity.Handyman;
import com.web.handyman.entity.User;

@Service
public class HandymanServiceImpl implements HandymanService {

		// need to inject user DAO
		@Autowired
		private UserDAO userDAO;
	
	
		@Override
		@Transactional
		public List<User> getUsers() {
			
			
	
			return userDAO.getUsers();
		}
		
		// Saving user 
		@Override
		@Transactional
		public void saveUser(User user){
			
			userDAO.saveUser(user);
			
			
		}

		@Override
		@Transactional
		public User getUser(int theId) {
			
			return userDAO.getUser(theId);
		}

}
