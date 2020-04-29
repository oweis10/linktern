package com.linktern.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.linktern.Models.Objective;
import com.linktern.Models.Placement;
import com.linktern.Services.IPlacementService;
import com.linktern.Services.IUserService;

@Controller
public class PlacementController {
	
	@Autowired
	IPlacementService placementService;
	@Autowired
	IUserService userService;
	
	
	@RequestMapping(value = "/setplacement", method=RequestMethod.GET)
	public ModelAndView setPlacement(Model model)
	{
		model.addAttribute("students", userService.GetRoleUsers(4));
		model.addAttribute("workMentors", userService.GetRoleUsers(2));
		model.addAttribute("schoolMentors", userService.GetRoleUsers(3));
		model.addAttribute("objectives", placementService.GetObjectives());
		
		return new ModelAndView("setplacement", "placement", new Placement());
	}
	@RequestMapping(value = "/placements", method=RequestMethod.GET)
	public ModelAndView GetPlacements()
	{
		ArrayList<Placement> placements = placementService.GetPlacements();
		return new ModelAndView("placements","placements", placements);
	}
	
	@RequestMapping(value = "/setnewplacement", method=RequestMethod.POST)
	public ModelAndView SetNewPlacement(@ModelAttribute("placement") Placement placement, HttpServletResponse response)
	{
		placementService.SetNewPlacement(placement);
		ArrayList<Placement> placements = placementService.GetPlacements();
		return new ModelAndView("placements","placements", placements);
	}
	
	@RequestMapping(value = "/viewplacement/{id}", method=RequestMethod.GET)
	public ModelAndView ViewPlacement(Model model, @PathVariable("id") int id)
	{
		ArrayList<Objective> allObjectives = placementService.GetObjectives();
		ArrayList<Objective> placementObjectives = placementService.GetPlacementObjectives(id);
		ArrayList<Objective> objectives = new ArrayList<Objective>();
		
		
		
		try {
			
		for(Objective all: allObjectives){ 
			boolean flag = true;
			if(all != null)
			{
				for(Objective sub : placementObjectives)
				{ 
					if(sub != null)
					{
						if(all.getId() == sub.getId())
						{ // listOfPhones.remove(phone);
							flag = false;
							// wrong again itr.remove(); // right call }
						}
					}
				
				}
				if(flag == true) {
					objectives.add(all);
				}
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		model.addAttribute("students", userService.GetRoleUsers(4));
		model.addAttribute("workMentors", userService.GetRoleUsers(2));
		model.addAttribute("schoolMentors", userService.GetRoleUsers(3));
		model.addAttribute("objectives", objectives);
		model.addAttribute("selectedObjectives", placementObjectives);
		Placement placement = placementService.GetPlacement(id);
		return new ModelAndView("viewplacement","placement", placement);
	}
	
	@RequestMapping(value = "editplacement", method=RequestMethod.POST)
	public ModelAndView EditPlacement(@ModelAttribute("placement") Placement placement)
	{
		placementService.EditPlacement(placement);
		ArrayList<Placement> placements = placementService.GetPlacements();
		return new ModelAndView("placements","placements", placements);
	}
	
}
