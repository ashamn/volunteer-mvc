package com.vtracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vtracker.dao.VolunteerDAO;
import com.vtracker.entity.Volunteer;

@Service
public class VolunteerServiceImp implements VolunteerService {

	@Autowired
	private VolunteerDAO volunteerDAO;
	
	@Override
	@Transactional
	public Volunteer getVolunteer(int id) {
		Volunteer theVolunteer = volunteerDAO.getVolunteer(id);
		return theVolunteer;
	}

	@Override
	@Transactional
	public void saveVolunteer(Volunteer theVolunteer) {
		volunteerDAO.createVolunteer(theVolunteer);
	}

	@Override
	@Transactional
	public List<Volunteer> getAllVolunteers() {
		List<Volunteer> volunteer = volunteerDAO.getAllVolunteers();
		return volunteer;
	}

	@Override
	@Transactional
	public void deleteVolunteer(int id) {
		volunteerDAO.deleteVolunteer(id);
	}

}
