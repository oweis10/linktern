package com.linktern.Models;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class Task {
	public int task_id;
	public String  task_title;
	public String  task_description;
	public int task_status;
	public int student_id;
	public String  student_name;
	public String work_mentor_name;
	public String  rejection_note;
	public int objective_id;
	public String objective_name;
	public File task_file;
	
	public File getTask_file() {
		return task_file;
	}
	public void setTask_file(File task_file) {
		this.task_file = task_file;
	}
	public String getObjective_name() {
		return objective_name;
	}
	public void setObjective_name(String objective_name) {
		this.objective_name = objective_name;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
	public String getTask_description() {
		return task_description;
	}
	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}
	public int getTask_status() {
		return task_status;
	}
	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getWork_mentor_name() {
		return work_mentor_name;
	}
	public void setWork_mentor_name(String work_mentor_name) {
		this.work_mentor_name = work_mentor_name;
	}
	public String getRejection_note() {
		return rejection_note;
	}
	public void setRejection_note(String rejection_note) {
		this.rejection_note = rejection_note;
	}
	public int getObjective_id() {
		return objective_id;
	}
	public void setObjective_id(int objective_id) {
		this.objective_id = objective_id;
	}
    
    
}
