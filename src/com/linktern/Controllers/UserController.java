package com.linktern.Controllers;


import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value ="/logout", method=RequestMethod.GET)
	public ModelAndView login( HttpSession session)
	{
		session.invalidate();
		return new ModelAndView("login", "user", new User());
	}
	
	@RequestMapping(value="/loginrequest", method=RequestMethod.POST)
	public ModelAndView Requestlogin(@ModelAttribute("user") @Valid User user, BindingResult rs, Model invalid, HttpSession session, ModelMap modelMap)
	{
		int x = 5;
		if(rs.hasErrors())
		{
			 return new ModelAndView("login");
		}
		else
		{
			User userInfo = userService.GetLoggedInUserInfo(user.getEmail(), user.getPassword());
			
			if(userInfo.getEmail() != null)
			{
				session.setAttribute("user", userInfo);
				session.setAttribute("name", userInfo.getFirstName());
				session.setAttribute("role", userInfo.getRole());
				session.setAttribute("id", userInfo.getId());
				return new ModelAndView("index");
			}
			else
			{
				invalid.addAttribute("invalid", "Wrong username or password!");
				return new ModelAndView("login");
			}
		}
			
	}
	
	@RequestMapping(value = "/students", method=RequestMethod.GET)
	public ModelAndView GetStudents(HttpSession session)
	{  
		int roleId=4;
		ArrayList<User> users = userService.GetRoleUsers(roleId);
		return new ModelAndView("users","users", users);
	}
	
	@RequestMapping(value = "/workmentors", method=RequestMethod.GET)
	public ModelAndView GetWorkMentors(HttpSession session)
	{  
		int roleId=2;
		ArrayList<User> users = userService.GetRoleUsers(roleId);
		return new ModelAndView("users","users", users);
	}
	@RequestMapping(value = "/schoolmentors", method=RequestMethod.GET)
	public ModelAndView GetSchoolMentors(HttpSession session)
	{  
		int roleId=3;
		ArrayList<User> users = userService.GetRoleUsers(roleId);
		return new ModelAndView("users","users", users);
	}
	
	@RequestMapping(value = "/viewuser/{id}", method=RequestMethod.GET)
	public ModelAndView ViewUser(Model model, @PathVariable("id") int id)
	
	{	
		model.addAttribute("roles", userService.GetRoles());
		User user = userService.GetUser(id);
		model.addAttribute("selectedRole", user.getRoleId());
		return new ModelAndView("viewuser","user", user);
	}
	
	@RequestMapping(value = "/setuser", method=RequestMethod.GET)
	public ModelAndView setUser(Model model)
	{
		
		model.addAttribute("roles", userService.GetRoles());
		
		return new ModelAndView("setuser", "user", new User());
	}
	
	@RequestMapping(value = "/updateuser", method=RequestMethod.POST)
	public ModelAndView EditUser(@ModelAttribute("user") User user)
	{
		userService.EditUser(user);
		ArrayList<User> users = userService.GetRoleUsers(user.getRoleId());
		return new ModelAndView("users","users", users);
	}
	
	@RequestMapping(value = "/setnewuser", method=RequestMethod.POST)
	public ModelAndView SetNewUser(@ModelAttribute("user") User user, HttpServletResponse response)
	{
		userService.SetNewUser(user);
		ArrayList<User> users = userService.GetRoleUsers(user.getRoleId());
		return new ModelAndView("users","users", users);
	}
	
	@RequestMapping(value = "/schoolmentorstudents", method=RequestMethod.GET)
	public ModelAndView GetSchoolMentorStudents(HttpSession session)
	{  
		int userId = (int) session.getAttribute("id");
		ArrayList<User> users = userService.GetSchoolMentorStudents(userId);
		return new ModelAndView("users","users", users);
	}
	
	@RequestMapping(value = "/workmentorstudents", method=RequestMethod.GET)
	public ModelAndView GetWorkMentorStudents(HttpSession session)
	{  
		int userId = (int) session.getAttribute("id");
		ArrayList<User> users = userService.GetWorkMentorStudents(userId);
		return new ModelAndView("users","users", users);
	}
	
}
