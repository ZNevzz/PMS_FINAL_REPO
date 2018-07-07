package org.crce.interns.service.impl;


import java.util.List;

import org.crce.interns.dao.SearchDao;
import org.crce.interns.model.Company;
import org.crce.interns.model.PersonalProfile;
import org.crce.interns.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("searchService")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao searchDao;
	
	@Override
	public List<PersonalProfile> searchUser(String searchString) {
		List<PersonalProfile> userList = searchDao.searchUser(searchString);
		return userList;
	}

	@Override
	public List<Company> searchCompany(String searchString) {
		List<Company> companyList = searchDao.searchCompany(searchString);
		return companyList;
	}

}
