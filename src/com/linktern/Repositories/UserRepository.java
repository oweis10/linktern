package com.linktern.Repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linktern.DataBase.DBConnectivity;
import com.linktern.Models.Role;
import com.linktern.Models.User;

@Repository
class UserRepository implements IUserRepository{
	
	@Autowired
	public DBConnectivity dbc;

	@Override
	public User GetUserInfo(String email, String password) {
		
		
		Connection con = dbc.getConnection();
		String sql = "Select * From users as u, user_roles as ur, roles as r "
					+ "where u.user_id = ur.user_id "
				    + "and ur.role_id = r.role_id "
				    + "and u.email=? and u.password = ?";
		User user = new User();
		
		try {
			
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, email);
			pr.setString(2, password);
			ResultSet rs = pr.executeQuery();
			System.out.println(rs);
			
			while (rs.next()) {
				user.setId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setSecondName(rs.getString("second_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setMobileNumber(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setCompany(rs.getString("Company_Name"));
				user.setRole(rs.getString("role_name"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}

		return user;
	}
	
	@Override
	public ArrayList<User>GetRoleUsers(int role) {
		ArrayList<User> users = new ArrayList<User>();
		Connection con = dbc.getConnection();
		String sql2 = "call get_user("+role+")";
	try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql2);
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setFirstName(rs.getString("first_name"));
				user.setSecondName(rs.getString("second_name"));
				user.setLastName(rs.getString("last_name"));
				user.setFullName(user.getFirstName()+" "+user.getSecondName()+" "+user.getLastName());
				user.setEmail(rs.getString("email"));
				user.setMobileNumber(rs.getString("phone_number"));
				user.setAddress(rs.getString("address"));
				user.setCompany(rs.getString("Company_Name"));
				user.setRole(rs.getString("role_name"));
				users.add(user);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return users;
		
	}
	
	@Override
	public void SetNewUser(User user) {
			Connection con = dbc.getConnection();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call insert_user(?, ?, ?, ?, ?, ?,?,?)}");
			
			cStmt.setString(1, user.getFirstName());
			cStmt.setString(2, user.getLastName());
			cStmt.setString(3, user.getSecondName());
			cStmt.setString(4, user.getMobileNumber());
			cStmt.setString(5, user.getAddress());
			cStmt.setString(6, user.getCompany());
			cStmt.setInt(7,user.getRoleId());
			cStmt.registerOutParameter(8, Types.INTEGER);
			
			cStmt.execute();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
	}

	@Override
	public ArrayList<Role> GetRoles() {
		ArrayList<Role> roles = new ArrayList<Role>();
		
		Connection con = dbc.getConnection();
		String sql = "SELECT * FROM roles";
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Role role = new Role();
				role.setRole_id(rs.getInt("role_id"));
				role.setRole_name(rs.getString("role_name"));
				roles.add(role);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return roles;
	}

	@Override
	public User GetUser(int id) {
		User user = new User();
		Connection con = dbc.getConnection();
		String sql = "SELECT *,get_role_name(get_user_role(user_id)) as role_name,get_user_role(user_id)  as role_id " + 
						"FROM users WHERE"
						+ " users.user_id = "+id;
			
	
	try {
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()) {
				
			
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setSecondName(rs.getString("second_name"));
			user.setMobileNumber(rs.getString("phone_number"));
			user.setAddress(rs.getString("Address"));
			user.setCompany(rs.getString("Company_Name"));
			user.setEmail(rs.getString("Email"));
			user.setRole(rs.getString("role_name"));
			user.setRoleId(rs.getInt("role_id"));
			user.setId(rs.getInt("user_id"));
			
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
	} finally {
		
		dbc.closeConnection(con);
	}
	
	return user;
	}

	@Override
	public void EditUser(User user) {
	Connection con = dbc.getConnection();
		
		try {
			CallableStatement cStmt = con.prepareCall("{call update_user(?, ?, ?, ?, ?, ?,?,?)}");
			
			cStmt.setString(1, user.getFirstName());
			cStmt.setString(2, user.getLastName());
			cStmt.setString(3, user.getSecondName());
			cStmt.setString(4, user.getMobileNumber());
			cStmt.setString(5, user.getAddress());
			cStmt.setString(6, user.getCompany());
			cStmt.setInt(7,user.getRoleId());
			cStmt.setInt(8,user.getId());
			
			cStmt.execute();
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
	}
	
	@Override
	public ArrayList<User> GetSchoolMentorStudents(int id) {
		ArrayList<User> users = new ArrayList<User>();
		
		Connection con = dbc.getConnection();
		String sql = "call get_school_mentor_students("+id+")";
			
	
	try {
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()) {
				
			User user = new User();
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setSecondName(rs.getString("second_name"));
			user.setMobileNumber(rs.getString("phone_number"));
			user.setAddress(rs.getString("Address"));
			user.setCompany(rs.getString("Company_Name"));
			user.setEmail(rs.getString("Email"));
			user.setRole(rs.getString("role_name"));
			user.setRoleId(rs.getInt("role_id"));
			user.setId(rs.getInt("user_id"));
			users.add(user);
			
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
	} finally {
		
		dbc.closeConnection(con);
	}
	
	return users;
	}
	
	@Override
	public ArrayList<User> GetWorkMentorStudents(int id) {
		ArrayList<User> users = new ArrayList<User>();
		
		Connection con = dbc.getConnection();
		String sql = "call get_work_mentor_students("+id+")";
			
	
	try {
		
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		
		while (rs.next()) {
				
			User user = new User();
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			user.setSecondName(rs.getString("second_name"));
			user.setMobileNumber(rs.getString("phone_number"));
			user.setAddress(rs.getString("Address"));
			user.setCompany(rs.getString("Company_Name"));
			user.setEmail(rs.getString("Email"));
			user.setRole(rs.getString("role_name"));
			user.setRoleId(rs.getInt("role_id"));
			user.setId(rs.getInt("user_id"));
			users.add(user);
			
		}
		
	} catch (SQLException e) {
		
		e.printStackTrace();
		
	} finally {
		
		dbc.closeConnection(con);
	}
	
	return users;
	}
	
	
}
