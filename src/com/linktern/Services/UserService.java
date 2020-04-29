package com.linktern.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktern.Models.User;
import com.linktern.Repositories.IUserRepository;

@Service
class UserService implements IUserService{

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public User GetLoggedInUserInfo(String email, String password) {
		
		return userRepository.GetUserInfo(email, password);
	}
	
	@Override
	public ArrayList<User> GetRoleUsers(int role) {
		return userRepository.GetRoleUsers(role);
	}
	
	
}
