package com.linktern.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.linktern.DataBase.DBConnectivity;
import com.linktern.Models.Comment;
import com.linktern.Models.Placement;
import com.linktern.Models.Task;
@Repository
public class TaskRepository implements ITaskRepository {
	@Autowired
	public DBConnectivity dbc;
	@Override
	public ArrayList<Task> GetTasks() {
		ArrayList<Task> tasks = new ArrayList<Task>();
		
	
		
		Connection con = dbc.getConnection();
		String sql = "	SELECT  " + 
				"	    task_id, " + 
				"	    task_title, " + 
				"	    task_description, " + 
				"	    task_status, " + 
				"	    student_id, " + 
				"	    get_user_name(student_id) as student_name, " + 
				"	    get_user_name(get_work_mentor(student_id)) as work_mentor_name, " + 
				"	    rejection_note, " + 
				"	    objective_id, " + 
				"	    get_objective_name(objective_id) as objective_name " + 
				"	FROM " + 
				"	    tasks " ;
	

try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Task task = new Task();
				task.setTask_id(rs.getInt("task_id"));
				task.setTask_status(rs.getInt("task_status"));
				task.setStudent_id(rs.getInt("student_id"));
				task.setObjective_id(rs.getInt("objective_id"));
				task.setTask_title(rs.getString("task_title"));
				task.setTask_description(rs.getString("task_description"));
				task.setStudent_name(rs.getString("student_name"));
				task.setWork_mentor_name(rs.getString("work_mentor_name"));
				task.setRejection_note(rs.getString("rejection_note"));
				task.setObjective_name(rs.getString("objective_name"));
				tasks.add(task);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return tasks;
	}
	public ArrayList<Task> GetStudentTasks(int userId) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		
	
		
		Connection con = dbc.getConnection();
		String sql = "	SELECT  " + 
				"	    task_id, " + 
				"	    task_title, " + 
				"	    task_description, " + 
				"	    task_status, " + 
				"	    student_id, " + 
				"	    get_user_name(student_id) as student_name, " +  
				"	    rejection_note, " + 
				"	    objective_id, " + 
				"	    get_objective_name(objective_id) as objective_name " + 
				"	FROM " + 
				"	    tasks " + 
				"	WHERE " + 
				"	    student_id= "+userId;
	

try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Task task = new Task();
				task.setTask_id(rs.getInt("task_id"));
				task.setTask_status(rs.getInt("task_status"));
				task.setStudent_id(rs.getInt("student_id"));
				task.setObjective_id(rs.getInt("objective_id"));
				task.setTask_title(rs.getString("task_title"));
				task.setTask_description(rs.getString("task_description"));
				task.setStudent_name(rs.getString("student_name"));
				task.setRejection_note(rs.getString("rejection_note"));
				task.setObjective_name(rs.getString("objective_name"));
				tasks.add(task);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return tasks;
	}
	@Override
	public ArrayList<Task> GetWorkMentorTasks(int userId) {
		ArrayList<Task> tasks = new ArrayList<Task>();
		
	
		
		Connection con = dbc.getConnection();
		String sql = "	SELECT  " + 
				"	    task_id, " + 
				"	    task_title, " + 
				"	    task_description, " + 
				"	    task_status, " + 
				"	    GET_OBJECTIVE_NAME(objective_id) as objective_name " + 
				"	FROM " + 
				"	    tasks " + 
				"	WHERE " + 
				"	    GET_WORK_MENTOR(student_id) = "+userId;
	

		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Task task = new Task();
				task.setTask_id(rs.getInt("task_id"));
				task.setTask_status(rs.getInt("task_status"));
				task.setObjective_name(rs.getString("objective_name"));
				task.setTask_title(rs.getString("task_title"));
				task.setTask_description(rs.getString("task_description"));
				tasks.add(task);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return tasks;
	}
	@Override
	public ArrayList<Task> GetSchoolMentorTasks(int userId) {
ArrayList<Task> tasks = new ArrayList<Task>();
		
	
		
		Connection con = dbc.getConnection();
		String sql = "	SELECT  " + 
				"	    task_id, " + 
				"	    task_title, " + 
				"	    task_description, " + 
				"	    task_status, " + 
				"	    student_id, " + 
				"	    get_user_name(student_id) as student_name, " + 
				"	    get_user_name(get_work_mentor(student_id)) as work_mentor_name, " + 
				"	    rejection_note, " + 
				"	    objective_id, " + 
				"	    get_objective_name(objective_id) as objective_name " + 
				"	FROM " + 
				"	    tasks " + 
				"	WHERE " + 
				"	    GET_SCHOOL_MENTOR(student_id) = "+userId+
				"   AND  "+
				"	    task_status = 2";
	

try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Task task = new Task();
				task.setTask_id(rs.getInt("task_id"));
				task.setTask_status(rs.getInt("task_status"));
				task.setStudent_id(rs.getInt("student_id"));
				task.setObjective_id(rs.getInt("objective_id"));
				task.setTask_title(rs.getString("task_title"));
				task.setTask_description(rs.getString("task_description"));
				task.setStudent_name(rs.getString("student_name"));
				task.setWork_mentor_name(rs.getString("work_mentor_name"));
				task.setRejection_note(rs.getString("rejection_note"));
				task.setObjective_name(rs.getString("objective_name"));
				tasks.add(task);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return tasks;
	}
	@Override
	public void CreateNewTask(Task task) {
		Connection con = dbc.getConnection();
		String insertTask = "INSERT INTO tasks "
						  + "SET task_title = ?, task_description = ?, "
						  + "task_status = 1, student_id = ?, objective_id = ?";
		
		try {
			
			PreparedStatement pr = con.prepareStatement(insertTask);

			
			pr.setString(1, task.getTask_title());
			pr.setString(2, task.getTask_description());
			pr.setInt(3,task.getStudent_id());
			pr.setInt(4,task.getObjective_id());
			
			pr.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
	}
	
	public Task GetTask(int taskId) {
		
		Task task = new Task();
		Connection con = dbc.getConnection();
		String sql = "	SELECT  " + 
				"	    task_id, " + 
				"	    task_title, " + 
				"	    task_description, " + 
				"	    task_status, " + 
				"	    student_id, " + 
				"	    get_user_name(student_id) as student_name, " +  
				"	    rejection_note, " + 
				"	    objective_id, " + 
				"	    get_objective_name(objective_id) as objective_name " + 
				"	FROM " + 
				"	    tasks where task_id = " + taskId;
	

		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				
				task.setTask_id(rs.getInt("task_id"));
				task.setTask_status(rs.getInt("task_status"));
				task.setStudent_id(rs.getInt("student_id"));
				task.setObjective_id(rs.getInt("objective_id"));
				task.setTask_title(rs.getString("task_title"));
				task.setTask_description(rs.getString("task_description"));
				task.setStudent_name(rs.getString("student_name"));
				task.setRejection_note(rs.getString("rejection_note"));
				task.setObjective_name(rs.getString("objective_name"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return task;
	}
	
	public void EditTask(Task task) {
		Connection con = dbc.getConnection();
		String updateSql = "call update_task(?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement pr = con.prepareStatement(updateSql);

			
			pr.setInt(1, task.getObjective_id());
			pr.setString(2, task.getTask_title());
			pr.setString(3,task.getTask_description());
			pr.setInt(4,task.getTask_status());
			pr.setString(5,task.getRejection_note());
			pr.setInt(6,task.getTask_id());
			
			pr.execute();
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
	}
	
	
	public ArrayList<Comment> GetTaskComments(int taskId) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		Connection con = dbc.getConnection();
		String sql = "SELECT get_user_name(tc.user_id) as user_name, tc.task_comment "
				+ "FROM task_comments as tc"
				+ " Where tc.task_id = "+ taskId;
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setUserName(rs.getString("user_name"));
				comment.setContent(rs.getString("task_comment"));
				comments.add(comment);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return comments;
	}
	
	public void AddComment(int taskId, int userId, String comment) {
		Connection con = dbc.getConnection();
		String sql = "Insert INTO task_comments (task_id, user_id,task_comment) "
				+ "VALUES (?,?,?)";
		try {
			
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setInt(1, taskId);
			pr.setInt(2, userId);
			pr.setString(3, comment);
			
			pr.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
	}


	
}
