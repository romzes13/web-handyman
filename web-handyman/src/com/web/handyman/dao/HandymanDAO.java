package com.web.handyman.dao;

import java.util.List;

import com.web.handyman.entity.Handyman;

public interface HandymanDAO {

	List<Handyman> getHandymen();

	void saveHandyman(Handyman theHandyman);

	Handyman getHandyman(Integer theId);

	Handyman getHandyman();

	Handyman getHandyman(String userName);

}
