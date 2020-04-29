package com.linktern.Controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.linktern.Models.Comment;
import com.linktern.Models.Objective;
import com.linktern.Models.Placement;
import com.linktern.Models.Task;
import com.linktern.Services.IPlacementService;
import com.linktern.Services.ITaskService;

@Controller
public class TaskController {
	
	@Autowired
	ITaskService taskService;
	@Autowired
	IPlacementService placementService;
	
	@RequestMapping(value = "/studenttasks", method=RequestMethod.GET)
	public ModelAndView GetStudentsTasks(HttpSession session)
	{  
		int userId=(int) session.getAttribute("id");
		ArrayList<Task> tasks = taskService.GetStudentTasks(userId);
		return new ModelAndView("tasks","tasks", tasks);
	}
	
	@RequestMapping(value = "/schoolmentortasks", method=RequestMethod.GET)
	public ModelAndView GetSchoolMentorTasks(HttpSession session)
	{  
		int userId=(int) session.getAttribute("id");
			ArrayList<Task> tasks = taskService.GetSchoolMentorTasks(userId);
		return new ModelAndView("tasks","tasks", tasks);
	}
	
	
	@RequestMapping(value = "/workmentortasks", method=RequestMethod.GET)
	public ModelAndView GetWorkMentorTasks(HttpSession session)
	{  
		int userId=(int) session.getAttribute("id");
			ArrayList<Task> tasks = taskService.GetWorkMentorTasks(userId);
		return new ModelAndView("tasks","tasks", tasks);
	}
	
	
	@RequestMapping(value = "/createtask", method=RequestMethod.GET)
	public ModelAndView CreateTask(Model model, HttpSession session)
	{  
		int studentId=(int) session.getAttribute("id");
		ArrayList<Objective> objectives = placementService.GetStudentObjectives(studentId);
		model.addAttribute("objectives",objectives);
		return new ModelAndView("createtask","task", new Task());
	}
	
	@RequestMapping(value = "/createnewtask", method=RequestMethod.POST)
	public ModelAndView CreateNewTask(@ModelAttribute("task") Task task, HttpSession session)
	{  
		int studentId=(int) session.getAttribute("id");
		task.setStudent_id(studentId);
		taskService.CreateNewTask(task);
		ArrayList<Task> tasks = taskService.GetStudentTasks(studentId);
		return new ModelAndView("tasks","tasks", tasks);
	}
	
	@RequestMapping(value = "/getobjectiveurl/{id}", method = RequestMethod.GET)
	public @ResponseBody String GetObjectiveUrl(HttpSession session, @PathVariable("id") int id)
	{  
		String url =placementService.GetObjectiveUrl(id);
		return  url;
	}
	
	@RequestMapping(value = "/viewtask/{id}", method=RequestMethod.GET)
	public ModelAndView ViewTask(Model model, @PathVariable("id") int id, HttpSession session)
	{
		int studentId=(int) session.getAttribute("id");
		ArrayList<Objective> objectives = placementService.GetStudentObjectives(studentId);
		model.addAttribute("objectives",objectives);
		Task task = taskService.GetTask(id);
		String url =placementService.GetObjectiveUrl(task.objective_id);
		model.addAttribute("selectedurl",url);
		return new ModelAndView("viewtask","task", task);
	}
	
	@RequestMapping(value = "edittask", method=RequestMethod.POST)
	public ModelAndView EditPlacement(@ModelAttribute("task") Task task, HttpSession session)
	{
		taskService.EditTask(task);
		int userId=(int) session.getAttribute("id");
		ArrayList<Task> tasks = taskService.GetStudentTasks(userId);
		return new ModelAndView("tasks","tasks", tasks);
	}
	
	@RequestMapping(value = "/showtask/{id}", method=RequestMethod.GET)
	public ModelAndView ShowTask(Model model, @PathVariable("id") int id, HttpSession session)
	{
		int studentId=(int) session.getAttribute("id");
		ArrayList<Objective> objectives = placementService.GetStudentObjectives(studentId);
		
		model.addAttribute("objectives",objectives);
		Task task = taskService.GetTask(id);
		ArrayList<Comment> comments = taskService.GetTaskComments(id);
		String url =placementService.GetObjectiveUrl(task.objective_id);
		model.addAttribute("selectedurl",url);
		
		model.addAttribute("comments", comments);
		model.addAttribute("status", task.getTask_status());
		return new ModelAndView("showtask","task", task);
	}
	
	@RequestMapping(value = "/rejecttask", method=RequestMethod.GET)
	public ModelAndView rejectTask(@RequestParam("taskId") int id, @RequestParam("note") String note, HttpSession session)
	{
		int userId=(int) session.getAttribute("id");
		Task task = taskService.GetTask(id);
		task.setRejection_note(note);
		task.setTask_status(3);
		taskService.EditTask(task);
		ArrayList<Task> tasks = taskService.GetWorkMentorTasks(userId);
		return new ModelAndView("tasks","tasks", tasks);
	}
	
	@RequestMapping(value = "/comment", method=RequestMethod.GET)
	public ModelAndView addComment(@RequestParam("taskId") int id, @RequestParam("comment") String comment, HttpSession session)
	{
		int userId=(int) session.getAttribute("id");
		taskService.AddComment(id, userId, comment);
		ArrayList<Task> tasks = taskService.GetWorkMentorTasks(userId);
		return new ModelAndView("tasks","tasks", tasks);
	}
	
	@RequestMapping(value = "/timeline/{id}", method=RequestMethod.GET)
	public ModelAndView ShowTimeLine(Model model, @PathVariable("id") int id, HttpSession session)
	{
		Date date = new Date();
		int studentId=(int) session.getAttribute("id");
		model.addAttribute("taskDate", date.toString());
		
		ArrayList<Task> tasks = taskService.GetStudentTasks(studentId);
		model.addAttribute("tasks",tasks);
		return new ModelAndView("timeline","taskss", tasks);
	}
}
