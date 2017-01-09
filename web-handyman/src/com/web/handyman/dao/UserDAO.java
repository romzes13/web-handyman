package com.web.handyman.dao;

import java.util.List;

import com.web.handyman.entity.Handyman;
import com.web.handyman.entity.User;

public interface UserDAO {

	public List<Handyman> getHandymen();

	public List<User> getUsers();

}
