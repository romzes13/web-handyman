package com.web.handyman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.handyman.dao.WorkorderDAO;
import com.web.handyman.entity.WorkOrder;

@Service
public class WorkorderServiceImpl implements WorkorderService {
	
	// need to inject user DAO
	@Autowired
	private WorkorderDAO workorderDAO;

	@Override
	@Transactional
	public List<WorkOrder> getWorkOrders() {
		
		
		return workorderDAO.getWorkOrders();
	}

	@Override
	@Transactional
	public void saveWorkOrder(WorkOrder theWorkOrder) {
		
		workorderDAO.saveWorkOrder(theWorkOrder);
		
	}

	@Override
	@Transactional
	public WorkOrder getWorkOrder(int theId) {
		
		
		
		return workorderDAO.getWorkOrder(theId);
	}

	@Override
	@Transactional
	public void deleteWorkorder(int theId) {
		
		workorderDAO.deleteWorkorder(theId);
		
	}

	@Override
	@Transactional
	public List<WorkOrder> getMyWorkOrders() {
		
		
		return workorderDAO.getMyWorkorders();
	}

}
