package com.jindal.user.services;

import java.util.List;

import com.jindal.user.entities.User;

public interface UserServices {

//	User operations
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);

//	TODO update/delete user
}
