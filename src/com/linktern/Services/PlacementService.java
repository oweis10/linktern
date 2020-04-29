package com.linktern.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linktern.Models.Objective;
import com.linktern.Models.Placement;
import com.linktern.Repositories.IPlacementRepository;

@Service
class PlacementService implements IPlacementService{

	@Autowired
	IPlacementRepository placementRepository;
	
	@Override
	public ArrayList<Placement>GetPlacements() {
		return placementRepository.GetPlacements();
	}
	
	public ArrayList<Objective> GetObjectives()
	{
		return placementRepository.GetObjectives();
	}
	
	public void SetNewPlacement(Placement placement)
	{
		placementRepository.SetNewPlacement(placement);
	}

	@Override
	public void EditPlacement(Placement placement) {
		placementRepository.EditPlacement(placement);
		
	}

	@Override
	public Placement GetPlacement(int id) {
		return placementRepository.GetPlacement(id);
	}

	@Override
	public ArrayList<Objective> GetPlacementObjectives(int id) {
		return placementRepository.GetPlacementObjectives(id);
	}

	@Override
	public ArrayList<Objective> GetStudentObjectives(int studentId) {
		return placementRepository.GetStudentObjectives(studentId);
	}

	@Override
	public String GetObjectiveUrl(int objectiveId) {
		// TODO Auto-generated method stub
		return placementRepository.GetObjectiveUrl(objectiveId);
	}

}
