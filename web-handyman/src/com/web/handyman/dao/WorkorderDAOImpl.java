package com.web.handyman.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.web.handyman.entity.User;
import com.web.handyman.entity.WorkOrder;

@Repository
public class WorkorderDAOImpl implements WorkorderDAO {

	// need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<WorkOrder> getWorkOrders() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		// query workorders
		System.out.println("Printing from WorkordersDAOImpl: \n");
		List<WorkOrder> workorders = currentSession.createQuery("from WorkOrder").getResultList();	
		
		System.out.println("Printing from UserDAOImpl: " + workorders);
					
					
		
		
		return workorders;
	}

	@Override
	public void saveWorkOrder(WorkOrder theWorkOrder) {
		System.out.println(" \n Printing from WorkOrder : \n");
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = theWorkOrder.getUser();
		System.out.println("workorder: " + theWorkOrder);
		System.out.println("user: " + user);
		if (user.getId() == null) {
			
			System.out.println(" NULL: " + user.getId());
			
			theWorkOrder.setUser(null);
		}
		
		System.out.println("\n Boolean is set to : " + theWorkOrder.getIsCompleated() +"\n");
		
		//save/update the work order
		currentSession.saveOrUpdate(theWorkOrder);
		
		
	}

	@Override
	public WorkOrder getWorkOrder(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Retrive/read from database using primary key
		
		 WorkOrder workorder = currentSession.get(WorkOrder.class, theId);
		
		// Lazy fetching 
		//WorkOrder workorder = currentSession.load(WorkOrder.class, theId);
		
		
		return workorder;
	}

	@Override
	public void deleteWorkorder(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		WorkOrder workorder = currentSession.get(WorkOrder.class, theId);
		
		System.out.println("Deleteing workorder: " + workorder);
		//currentSession.remove(workorder);
		
		Query theQuery = currentSession.createQuery("delete from WorkOrder where id=:workorderId");
		theQuery.setParameter("workorderId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<WorkOrder> getMyWorkorders() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			//model.addObject("username", userDetail.getUsername());
			System.out.println("Logged in user is: " + userDetail.getUsername());
			
			
			String tempName = userDetail.getUsername();
			//create a query
			/*List<WorkOrder> workorders = currentSession.createQuery("from WorkOrder").getResultList();	*/
			
			List<WorkOrder> workorders =  (List<WorkOrder>) currentSession.createQuery("from WorkOrder"
 + " w left join w.user as u where user_name=:tempName").setParameter("tempName", tempName).getResultList();
								
			System.out.println("My workorders: \n" + workorders);
			
			/*for (WorkOrder temp : workorders) {
				System.out.println(temp);
			}*/
			
			for(int i=0; i<workorders.size(); i++){
				//Object[] row =  workorders.get(0);
				//Company company = (Company)row[0];
				//Employee employee = (Employee)row[1];
				
				//WorkOrder workorder = (WorkOrder)row[0];
				
				
				System.out.println(workorders.get(i));
			}
			
			return workorders;
		  }
		  
		  
		return null;
	}

	

}
