package com.web.handyman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.handyman.dao.CompanyDAO;
import com.web.handyman.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDAO companyDAO;
	
	@Override
	@Transactional
	public List<Company> getCompanies() {
		// TODO Auto-generated method stub
		
		return companyDAO.getCompanies();
	}

}
