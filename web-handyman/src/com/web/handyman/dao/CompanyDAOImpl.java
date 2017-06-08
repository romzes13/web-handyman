package com.web.handyman.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.handyman.entity.Company;
/**
 * 
 * @author roman
 *
 */

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Company> getCompanies() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		List<Company> companies = currentSession.createQuery("Select c from Company c").getResultList();
		System.out.println("List of companies: " + companies);
					
		
		return companies;
	}

}
