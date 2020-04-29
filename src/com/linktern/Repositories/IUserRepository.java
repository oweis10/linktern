package com.linktern.Repositories;

import java.util.ArrayList;

import com.linktern.Models.User;

public interface IUserRepository {
	public User GetUserInfo(String email, String password);
	public ArrayList<User>GetRoleUsers(int role);

}
