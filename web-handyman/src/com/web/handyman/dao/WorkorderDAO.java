package com.web.handyman.dao;

import java.util.List;

import com.web.handyman.entity.WorkOrder;

public interface WorkorderDAO {

	List<WorkOrder> getWorkOrders();

	void saveWorkOrder(WorkOrder theWorkOrder);

	WorkOrder getWorkOrder(int theId);

	void deleteWorkorder(int theId);

	List<WorkOrder> getMyWorkorders();


}
