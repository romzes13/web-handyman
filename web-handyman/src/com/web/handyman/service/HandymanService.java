package com.web.handyman.service;

import java.util.List;

import com.web.handyman.entity.Handyman;

public interface HandymanService {

	List<Handyman> getHandymen();

	void saveHandyman(Handyman theHandyman);

	Handyman getHandyman(Integer theId);

	Handyman getHandyman();

}
