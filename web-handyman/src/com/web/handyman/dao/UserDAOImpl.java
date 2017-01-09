package com.web.handyman.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.handyman.entity.Handyman;
import com.web.handyman.entity.User;
import com.web.handyman.entity.WorkOrder;

@Repository
public class UserDAOImpl implements UserDAO {
	
		// need to inject session factory
		@Autowired
		private SessionFactory sessionFactory;

		@Override
		public List<User> getUsers() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//create a query
			// query students
			System.out.println("Printing from UserDAOImpl: \n");
						List<User> users = currentSession.createQuery("from User").getResultList();
						
						//displayStudents(theStudents);
						
			
			//Query<User> theQuery = currentSession.createQuery("from User", User.class);
			
			// execute query and get a result list
			//List<User> users = theQuery.getResultList();
						
			// Test creating and adding user
						
						
						/*User user = new User();
						user.setUserName("Anton");
						
						WorkOrder workOrder = new WorkOrder("First work order", "Fix lights", 200, "Warrensburgh", user);
						
						Set<WorkOrder> workOrdersSet = new HashSet<WorkOrder>();
						workOrdersSet.add(workOrder);
						
						currentSession.save(user);
						currentSession.save(workOrder);
						*/
						
						
			
			System.out.println("Printing from UserDAOImpl: " + users);
			// return the results
			
			return users;
		}

		@Override
		public List<Handyman> getHandymen() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void saveUser(User user) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			// save/update the user
			currentSession.saveOrUpdate(user);
			
			
		}

		@Override
		public User getUser(int theId) {
			
			// get the current hibernate session
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			
			// Retrieve/read from database using primary key
			
			User user = currentSession.get(User.class, theId);
			
			return user;
		}

}
