package com.web.handyman.service;

import java.util.List;

import com.web.handyman.entity.Handyman;
import com.web.handyman.entity.User;

public interface UserService {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);

	public User getUser();

	
	
}
