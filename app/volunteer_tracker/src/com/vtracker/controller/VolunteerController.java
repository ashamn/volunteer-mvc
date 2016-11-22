package com.vtracker.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.vtracker.entity.Volunteer;
import com.vtracker.service.VolunteerService;

@Controller
@RequestMapping("/")
public class VolunteerController {
	
	@Autowired
	private VolunteerService volunteerService;
	
	@GetMapping("/")
	public String getVolunteer(Model theModel){
		List<Volunteer> volunteers = volunteerService.getAllVolunteers();
		theModel.addAttribute("volunteersVar", volunteers);
		return "index";
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Volunteer>> getVolunteerAPI(){
		List<Volunteer> volunteers = volunteerService.getAllVolunteers();
		return new ResponseEntity<List<Volunteer>>(volunteers, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addVolunteerAPI(@RequestBody Volunteer volunteer, UriComponentsBuilder ucBuilder){		
		volunteerService.saveVolunteer(volunteer);        
        return new ResponseEntity<String>("true", HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateVolunteerAPI(@RequestBody Volunteer volunteer, UriComponentsBuilder ucBuilder){		
		volunteerService.saveVolunteer(volunteer);        
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteVolunteerAPI(@RequestBody Volunteer volunteer, UriComponentsBuilder ucBuilder){	
		
		Volunteer theVolunteer = volunteerService.getVolunteer(volunteer.id);
		
		if(theVolunteer == null)
		return new ResponseEntity<String>("false", HttpStatus.NOT_FOUND);
		
		volunteerService.deleteVolunteer(theVolunteer.id);;        
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
	
	
}
