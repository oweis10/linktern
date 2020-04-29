package com.linktern.Services;

import java.util.ArrayList;

import com.linktern.Models.User;

public interface IUserService {
	
	public User GetLoggedInUserInfo(String email, String password);
	public ArrayList<User>GetRoleUsers(int role);

}
