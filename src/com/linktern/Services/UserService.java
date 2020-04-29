package com.linktern.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktern.Models.Role;
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

	@Override
	public void SetNewUser(User user) {
		userRepository.SetNewUser(user);
		
	}

	@Override
	public ArrayList<Role> GetRoles() {
		return userRepository.GetRoles();
	}

	@Override
	public User GetUser(int id) {
		return userRepository.GetUser(id);
	}

	@Override
	public void EditUser(User user) {
		
		 userRepository.EditUser(user);
		
	}

	@Override
	public ArrayList<User> GetWorkMentorStudents(int id) {
		// TODO Auto-generated method stub
		return userRepository.GetWorkMentorStudents(id);
	}

	@Override
	public ArrayList<User> GetSchoolMentorStudents(int id) {
		// TODO Auto-generated method stub
		return userRepository.GetSchoolMentorStudents(id);
	}
	
	
}
