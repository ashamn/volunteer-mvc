package com.vtracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vtracker.entity.Volunteer;

@Repository
public class VolunteerDAOImpl implements VolunteerDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Volunteer getVolunteer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Volunteer theVolunteer = currentSession.get(Volunteer.class, id);
		return theVolunteer;
	}

	@Override
	public void createVolunteer(Volunteer theVolunteer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theVolunteer);
	}

	@Override
	public List<Volunteer> getAllVolunteers() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Volunteer> volunteers = currentSession.createQuery("from Volunteer", Volunteer.class).getResultList();
		return volunteers;
		
	}

	@Override
	public void deleteVolunteer(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.createQuery("delete from Volunteer where id=:vid")
						.setParameter("vid", id)
						.executeUpdate();
	}

}
