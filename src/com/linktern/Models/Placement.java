package com.linktern.Models;


import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Placement {
	public int id;
	public int student_id;
	public String student_name;
	public int work_mentor_id;
	public String work_mentor_name;
	public int school_mentor_id;
	public String school_mentor_name;
	public String Company_Name;
	public String start_date;
	public String end_date;
	public List<Integer> objectives;
	
	
	public List<Integer> getObjectives() {
		return objectives;
	}
	public void setObjectives(List<Integer> objectives) {
		this.objectives = objectives;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getWork_mentor_id() {
		return work_mentor_id;
	}
	public void setWork_mentor_id(int work_mentor_id) {
		this.work_mentor_id = work_mentor_id;
	}
	public String getWork_mentor_name() {
		return work_mentor_name;
	}
	public void setWork_mentor_name(String work_mentor_name) {
		this.work_mentor_name = work_mentor_name;
	}
	public int getSchool_mentor_id() {
		return school_mentor_id;
	}
	public void setSchool_mentor_id(int school_mentor_id) {
		this.school_mentor_id = school_mentor_id;
	}
	public String getSchool_mentor_name() {
		return school_mentor_name;
	}
	public void setSchool_mentor_name(String school_mentor_name) {
		this.school_mentor_name = school_mentor_name;
	}
	public String getCompany_Name() {
		return Company_Name;
	}
	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
}
