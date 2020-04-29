package com.linktern.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linktern.DataBase.DBConnectivity;
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
	
	
}
