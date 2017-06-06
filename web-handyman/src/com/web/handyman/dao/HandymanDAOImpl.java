package com.web.handyman.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.handyman.entity.Handyman;
import com.web.handyman.entity.User;

@Repository
public class HandymanDAOImpl implements HandymanDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;			
		
	
	@Override
	public List<Handyman> getHandymen() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
					
		//create a query
		// query handymen
					
		System.out.println("Printing from HandymanDAOImpl: \n");
		
		List<Handyman> handymen = currentSession.createQuery("from Handyman").getResultList();
		
		System.out.println("Printing from HandymanDAOImpl: " + handymen);
		// return the results
		
		
		
		
		return handymen;
	}


	@Override
	public void saveHandyman(Handyman theHandyman) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		/*// Check if handyman User is empty.
		User user = theHandyman.getUser();
		
			if (user.getId() == null) {
			
				System.out.println(" NULL: " + user.getId());
			
				theHandyman.setUser(null);
			}*/
		
			// save/update the handyman
		currentSession.saveOrUpdate(theHandyman);
		
	}


	@Override
	public Handyman getHandyman(Integer theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Handyman handyman = currentSession.get(Handyman.class, theId);
		
		
		return handyman;
	}


	@Override
	public Handyman getHandyman(String userName) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Handyman handyman = null;
		
		try{
			
		handyman = (Handyman) currentSession.createQuery(""
				+ "Select h from Handyman h, User u where user_name=:userName"
				+ " and user_id=u.id")
				.setParameter("userName", userName).getSingleResult();
		}
		catch (NoResultException nre){
			//Ignore this because as per your logic this is ok!
			}
		
		if(!(handyman == null)){
		
		System.out.println("Handyman: " + handyman);
		
		
		return handyman;
		}
		
		return null;
	}


	@Override
	public Handyman getHandyman() {
		// TODO Auto-generated method stub
		return null;
	}

}
