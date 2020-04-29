package com.linktern.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktern.Models.Comment;
import com.linktern.Models.Task;
import com.linktern.Repositories.ITaskRepository;

@Service
class TaskService implements ITaskService{

	@Autowired
	ITaskRepository taskRepository;
	
	@Override
	public ArrayList<Task>GetTasks() {
		return taskRepository.GetTasks();
	}

	@Override
	public ArrayList<Task> GetStudentTasks(int userId) {
		return taskRepository.GetStudentTasks(userId);
	}

	@Override
	public ArrayList<Task> GetWorkMentorTasks(int userId) {
		// TODO Auto-generated method stub
		return taskRepository.GetWorkMentorTasks(userId);
	}

	@Override
	public ArrayList<Task> GetSchoolMentorTasks(int userId) {
		// TODO Auto-generated method stub
		return taskRepository.GetSchoolMentorTasks(userId);
	}

	@Override
	public void CreateNewTask(Task task) {
		taskRepository.CreateNewTask(task);
		
	}

	@Override
	public Task GetTask(int taskId) {
		// TODO Auto-generated method stub
		return taskRepository.GetTask(taskId);
	}

	@Override
	public void EditTask(Task task, int status) {
		taskRepository.EditTask(task, status);
		
	}

	@Override
	public ArrayList<Comment> GetTaskComments(int taskId) {
		// TODO Auto-generated method stub
		return taskRepository.GetTaskComments(taskId);
	}

	@Override
	public void AddComment(int taskId, int userId, String comment) {
		// TODO Auto-generated method stub
		taskRepository.AddComment(taskId, userId, comment);
	}

	@Override
	public void DeleteTask(int taskId) {
		taskRepository.DeleteTask(taskId);
		
	}

}
