package org.crce.interns.service.impl;

import java.util.List;

import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.dao.CompanyDao;
import org.crce.interns.dao.CriteriaDao;
import org.crce.interns.model.Criteria;
import org.crce.interns.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("criteriaService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class CriteriaServiceImpl implements CriteriaService {

	//static int criteria_id=1;
	@Autowired
	private CriteriaDao criteriaDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)	
	public void addCriteria(Criteria criteria) {
		//criteria.setCriteria_id(criteria_id);
		criteriaDao.addCriteria(criteria);
		//criteria_id++;
	}
	
	@Override  
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 public List<CriteriaBean> getCriteria() {  
	  return criteriaDao.getCriteria();  
	 }  
	
}
