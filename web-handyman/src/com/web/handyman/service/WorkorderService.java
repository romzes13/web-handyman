package com.web.handyman.service;

import java.util.List;

import com.web.handyman.entity.WorkOrder;

public interface WorkorderService {

	public List<WorkOrder> getWorkOrders();

	public void saveWorkOrder(WorkOrder theWorkOrder);

	public WorkOrder getWorkOrder(int theId);

	public void deleteWorkorder(int theId);

	public List<WorkOrder> getMyWorkOrders();

	public List<WorkOrder> getMyWorkOrdersPending();

}
