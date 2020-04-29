package com.linktern.Controllers;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.linktern.Models.User;
import com.linktern.Services.IUserService;

@Controller
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@RequestMapping(value = {"/login", "/"}, method=RequestMethod.GET)
	public ModelAndView login(Model model)
	{
		model.addAttribute("url", "home");
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(value="/loginrequest", method=RequestMethod.POST)
	public String Requestlogin(@ModelAttribute("user") User user, Model invalid, HttpSession session)
	{
		User userInfo = userService.GetLoggedInUserInfo(user.getEmail(), user.getPassword());
		if(userInfo.getEmail() != null)
		{
			invalid.addAttribute("invalid", "Invalid Login!");
			session.setAttribute("user", userInfo);
			session.setAttribute("name", userInfo.getFirstName());
			session.setAttribute("role", userInfo.getRole());
			session.setAttribute("id", userInfo.getId());
			return "index";
		}
		else
		{
			return "login";
		}
			
	}
	
	@RequestMapping(value = "/students", method=RequestMethod.GET)
	public ModelAndView GetStudents(HttpSession session)
	{  
		int roleId=4;
		ArrayList<User> users = userService.GetRoleUsers(roleId);
		return new ModelAndView("students","users", users);
	}
	
	@RequestMapping(value = "/workmentors", method=RequestMethod.GET)
	public ModelAndView GetWorkMentors(HttpSession session)
	{  
		int roleId=2;
		ArrayList<User> users = userService.GetRoleUsers(roleId);
		return new ModelAndView("workmentors","users", users);
	}
	@RequestMapping(value = "/schoolmentors", method=RequestMethod.GET)
	public ModelAndView GetSchoolMentors(HttpSession session)
	{  
		int roleId=3;
		ArrayList<User> users = userService.GetRoleUsers(roleId);
		return new ModelAndView("schoolmentors","users", users);
	}
	
}
