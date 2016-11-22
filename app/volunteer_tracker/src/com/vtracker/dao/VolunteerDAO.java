package com.vtracker.dao;

import java.util.List;

import com.vtracker.entity.Volunteer;

public interface VolunteerDAO {
	
	public Volunteer getVolunteer(int id);
	public void createVolunteer(Volunteer theVolunteer);
	public List<Volunteer> getAllVolunteers();
	public void deleteVolunteer(int id);
}
