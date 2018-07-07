package org.crce.interns.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.dao.CriteriaDao;
import org.crce.interns.model.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

@Repository("criteriaDao")

public class CriteriaDaoImpl implements CriteriaDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCriteria(Criteria criteria) {
		try{
		System.out.println("In DAO CRITERIA "+criteria.getLast_date_to_apply());
		System.out.println(criteria.getCgpa());
			
			sessionFactory.getCurrentSession().saveOrUpdate(criteria);
			int cid=criteria.getCriteria_id();
			System.out.println("in dao criteria after");
			
		}
		

		catch (ConstraintViolationException e) {
			System.out.println("error");
			
		}
		catch(DataIntegrityViolationException e){
			System.out.println("error");
			
		}	

	
	}

	@SuppressWarnings("unchecked")
	public List<CriteriaBean> getCriteria() {  
		  //return (List<CriteriaBean>) sessionFactory.getCurrentSession().createCriteria(CriteriaBean.class).list();
		
			List<Criteria> crit = sessionFactory.getCurrentSession().createCriteria(Criteria.class).list();
			List<CriteriaBean> result = new ArrayList<CriteriaBean>(); 
			
			for(Criteria i: crit){
				
				CriteriaBean temp = new CriteriaBean();
				
				BeanUtils.copyProperties(i, temp);
				
				result.add(temp);
			}
			
			return result;
		 }  
}
