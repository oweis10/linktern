package com.linktern.Repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.linktern.DataBase.DBConnectivity;
import com.linktern.Models.Objective;
import com.linktern.Models.Placement;

@Repository
class PlacementRepository implements IPlacementRepository {

	@Autowired
	public DBConnectivity dbc;
	
	@Override
	public ArrayList<Placement> GetPlacements() {
		
		
		ArrayList<Placement> placements = new ArrayList<Placement>();
		
		Connection con = dbc.getConnection();
		String sql = "SELECT student_id, " + 
						"get_user_name(student_id) as student_name, " + 
						"get_user_name(school_mentor_id) as school_mentor_name, " +
						"get_user_name(work_mentor_id) as work_mentor_name, " +
						"    work_mentor_id, " + 
						"    school_mentor_id, " + 
						"    Company_name, " + 
						"    id, " + 
						"    start_date, " + 
						"    end_date " + 
						"FROM placements";
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Placement placement = new Placement();
				placement.setId(rs.getInt("id"));
				placement.setStudent_id(rs.getInt("student_id"));
				placement.setSchool_mentor_id(rs.getInt("school_mentor_id"));
				placement.setWork_mentor_id(rs.getInt("work_mentor_id"));
				placement.setStudent_name(rs.getString("student_name"));
				placement.setSchool_mentor_name(rs.getString("school_mentor_name"));
				placement.setWork_mentor_name(rs.getString("work_mentor_name"));
				placement.setCompany_Name(rs.getString("Company_Name"));
				placement.setStart_date(rs.getDate("start_date").toString());
				placement.setEnd_date(rs.getDate("end_date").toString());
				placements.add(placement);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return placements;
	}
	
	public ArrayList<Objective> GetObjectives()
	{
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		
		Connection con = dbc.getConnection();
		String sql = "SELECT * FROM objectives";
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Objective objective = new Objective();
				objective.setId(rs.getInt("objective_id"));
				objective.setName(rs.getString("objective_name"));
				objective.setUrl(rs.getString("objective_url"));
				objectives.add(objective);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return objectives;
	}

	@Override
	public void SetNewPlacement(Placement placement) {
		Connection con = dbc.getConnection();
		
		try {
			
			CallableStatement cStmt = con.prepareCall("{call insert_placement(?, ?, ?, ?, ?, ?, ?)}");
			
			cStmt.setInt(1, placement.getStudent_id());
			cStmt.setInt(2, placement.getWork_mentor_id());
			cStmt.setInt(3, placement.getSchool_mentor_id());
			cStmt.setString(4, placement.getCompany_Name());
			cStmt.setString(5, placement.getStart_date());
			cStmt.setString(6,placement.getEnd_date());
			cStmt.registerOutParameter(7, Types.INTEGER);
			
			cStmt.execute();
			
			int placementId = cStmt.getInt(7);
			Iterator it = placement.getObjectives().iterator(); 
			while(it.hasNext())
			{
				int i = Integer.parseInt(it.next().toString());
				String sql = "INSERT INTO placement_objectives VALUES (?,?)";
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setInt(1, placementId);
				pr.setInt(2, i);
				pr.executeUpdate();
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
	}

	@Override
	public void EditPlacement(Placement placement) {
		Connection con = dbc.getConnection();
		String updateSql = "call update_placement(?,?,?,?,?,?,?)";
		
		try {
			
			PreparedStatement pr = con.prepareStatement(updateSql);

			
			pr.setInt(1, placement.getStudent_id());
			pr.setInt(2, placement.getWork_mentor_id());
			pr.setInt(3, placement.getSchool_mentor_id());
			pr.setString(4, placement.getCompany_Name());
			pr.setString(5, placement.getStart_date());
			pr.setString(6,placement.getEnd_date());
			pr.setInt(7,placement.getId());
			
			pr.execute();
			
			int placementId = placement.getId();
			Iterator it = placement.getObjectives().iterator();
			
			String deleteSql = "DELETE FROM placement_objectives " + 
					"WHERE placement_id = "+placementId;
			
			Statement stm = con.createStatement();
			stm.executeUpdate(deleteSql);
			
			while(it.hasNext())
			{
				int i = Integer.parseInt(it.next().toString());
				String sql = "INSERT INTO placement_objectives VALUES (?,?)";
				PreparedStatement pr2 = con.prepareStatement(sql);
				pr2.setInt(1, placementId);
				pr2.setInt(2, i);
				pr2.executeUpdate();
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
	}

	@Override
	public Placement GetPlacement(int id) {
		Placement placement = new Placement();
		
		Connection con = dbc.getConnection();
		String sql = "SELECT student_id, " + 
						"get_user_name(student_id) as student_name, " + 
						"get_user_name(school_mentor_id) as school_mentor_name, " +
						"get_user_name(work_mentor_id) as work_mentor_name, " +
						"    work_mentor_id, " + 
						"    school_mentor_id, " + 
						"    Company_name, " + 
						"    id, " + 
						"    start_date, " + 
						"    end_date " + 
						"FROM placements WHERE id = "+id;
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
					
				placement.setId(rs.getInt("id"));
				placement.setStudent_id(rs.getInt("student_id"));
				placement.setSchool_mentor_id(rs.getInt("school_mentor_id"));
				placement.setWork_mentor_id(rs.getInt("work_mentor_id"));
				placement.setStudent_name(rs.getString("student_name"));
				placement.setSchool_mentor_name(rs.getString("school_mentor_name"));
				placement.setWork_mentor_name(rs.getString("work_mentor_name"));
				placement.setCompany_Name(rs.getString("Company_Name"));
				placement.setStart_date(rs.getDate("start_date").toString());
				placement.setEnd_date(rs.getDate("end_date").toString());
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return placement;
	}

	@Override
	public ArrayList<Objective> GetPlacementObjectives(int id) {
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		
		Connection con = dbc.getConnection();
		String sql = "SELECT o.objective_id, objective_name, objective_url "
				+ "FROM placement_objectives as po, objectives as o "
				+ "WHERE o.objective_id = po.objective_id and po.placement_id = "+ id;
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Objective objective = new Objective();
				objective.setId(rs.getInt("objective_id"));
				objective.setName(rs.getString("objective_name"));
				objective.setUrl(rs.getString("objective_url"));
				objectives.add(objective);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return objectives;
	}

	public ArrayList<Objective> GetStudentObjectives(int studentId)
	{
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		
		Connection con = dbc.getConnection();
		String sql = "SELECT o.objective_id, o.objective_name, o.objective_url "
					+ "FROM placements as p, placement_objectives as po, objectives as o "
					+ "WHERE po.placement_id = p.id and o.objective_id = po.objective_id "
					+ "and p.student_id = "+ studentId;
		
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Objective objective = new Objective();
				objective.setId(rs.getInt("objective_id"));
				objective.setName(rs.getString("objective_name"));
				objective.setUrl(rs.getString("objective_url"));
				objectives.add(objective);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return objectives;
	}

	@Override
	public String GetObjectiveUrl(int objectiveId) {
		
		Connection con = dbc.getConnection();
		String sql = "SELECT * FROM objectives Where objective_id = "+objectiveId;
		String objective = null;
		try {
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				objective = rs.getString("objective_url");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			dbc.closeConnection(con);
		}
		
		return objective;
	}

	
}
