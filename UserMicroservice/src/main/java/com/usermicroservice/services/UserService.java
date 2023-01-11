package com.usermicroservice.services;

import java.util.List;
import java.util.Optional;

import com.usermicroservice.entity.User;

public interface UserService {

	
	//user operations
	
	//save single user

	User saveUser(User user);
	
	//get all users
	
	List<User> getAllUser();
	
	//get single user by id

	User getUser(String userId);
	
	

}
