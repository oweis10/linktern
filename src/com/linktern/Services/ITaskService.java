package com.linktern.Services;

import java.util.ArrayList;

import com.linktern.Models.Comment;
import com.linktern.Models.Task;

public interface ITaskService {
	public void CreateNewTask(Task task);
	public ArrayList<Task>GetTasks();
	public ArrayList<Task> GetWorkMentorTasks(int userId);
	public ArrayList<Task> GetSchoolMentorTasks(int userId);
	public ArrayList<Task> GetStudentTasks(int userId);
	public Task GetTask(int taskId);
	public void EditTask(Task task);
	public ArrayList<Comment> GetTaskComments(int taskId);
	public void AddComment(int taskId, int userId, String comment);
}
