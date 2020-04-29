package com.linktern.Services;

import java.util.ArrayList;

import com.linktern.Models.Objective;
import com.linktern.Models.Placement;

public interface IPlacementService {
	public ArrayList<Placement>GetPlacements();
	public ArrayList<Objective> GetObjectives();
	public ArrayList<Objective> GetPlacementObjectives(int id);
	public void SetNewPlacement(Placement placement);
	public void EditPlacement(Placement placement);
	public Placement GetPlacement(int id);
	public ArrayList<Objective> GetStudentObjectives(int studentId);
	public String GetObjectiveUrl(int objectiveId);

}
