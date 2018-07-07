package org.crce.interns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import org.crce.interns.model.*;
import org.crce.interns.service.FeedbackService;
import org.crce.interns.dao.FeedbackDao;

@Service("feedbackService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FeedbackServiceImpl implements FeedbackService {

	
	@Autowired
	private FeedbackDao feedbackDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFeedback(Feedback feedback) {
		feedbackDao.addFeedback(feedback);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Feedback> listFeedback() {
		System.out.println("inside service");
		return feedbackDao.listFeedback();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean checkUser(String user, String cName){
		
		return feedbackDao.checkUser(user, cName);
		
	}
	
}
