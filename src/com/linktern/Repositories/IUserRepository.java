package com.linktern.Repositories;

import java.util.ArrayList;

import com.linktern.Models.Role;
import com.linktern.Models.User;

public interface IUserRepository {
	public User GetUserInfo(String email, String password);
	public ArrayList<User>GetRoleUsers(int role);
	public void SetNewUser(User user);
	public ArrayList<Role> GetRoles();
	public User GetUser(int id);
	public void EditUser(User user);
	public ArrayList<User> GetWorkMentorStudents(int id);
	public ArrayList<User> GetSchoolMentorStudents(int id);

}
