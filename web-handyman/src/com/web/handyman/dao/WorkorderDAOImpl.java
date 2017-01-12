package com.web.handyman.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the work order
		currentSession.saveOrUpdate(theWorkOrder);
		
		
	}

	@Override
	public WorkOrder getWorkOrder(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Retrive/read from database using primary key
		WorkOrder workorder = currentSession.get(WorkOrder.class, theId);
		
		
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

}
