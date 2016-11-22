package com.vtracker.service;

import java.util.List;

import com.vtracker.entity.Volunteer;

public interface VolunteerService {

	public Volunteer getVolunteer(int id);
	public void saveVolunteer(Volunteer theVolunteer);
	public List<Volunteer> getAllVolunteers();
	public void deleteVolunteer(int id);
}
