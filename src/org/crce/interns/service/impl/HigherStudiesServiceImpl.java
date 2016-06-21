package org.crce.interns.service.impl;

import java.util.List;

import org.crce.interns.beans.InterestedInHigherStudiesBean;
import org.crce.interns.dao.FeedbackDao;
import org.crce.interns.dao.HigherStudiesDao;
import org.crce.interns.model.Feedback;
import org.crce.interns.model.InterestedInHigherStudies;
import org.crce.interns.service.HigherStudiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("interestedinhigherstudiesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class HigherStudiesServiceImpl implements HigherStudiesService{

	@Autowired
	private HigherStudiesDao hsDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addHS(InterestedInHigherStudiesBean ihs) {
		System.out.println(ihs.getYear()+"in service");
		hsDao.addHS(ihs);
	}
	
	public List<InterestedInHigherStudies> listIhs() {
		System.out.println("inside service");
		return hsDao.listIhs();
	}

	
}
