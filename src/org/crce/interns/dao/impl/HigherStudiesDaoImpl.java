package org.crce.interns.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.crce.interns.beans.InterestedInHigherStudiesBean;
import org.crce.interns.dao.HigherStudiesDao;
import org.crce.interns.model.Feedback;
import org.crce.interns.model.InterestedInHigherStudies;
import org.crce.interns.model.TotalNoOfStudents;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("interestedinhigherstudiesDao")

public class HigherStudiesDaoImpl implements HigherStudiesDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addHS(InterestedInHigherStudiesBean ihs) {
		System.out.println("in dao"+ihs.getYear());
		InterestedInHigherStudies ihss=new InterestedInHigherStudies();
		BeanUtils.copyProperties(ihs,ihss);
		System.out.println(ihss.getYear()+"!!!!!!");
		System.out.println(ihs.getYear()+"!!!!!");
		sessionFactory.getCurrentSession().save(ihss);
	}
	
	@SuppressWarnings("unchecked")
	public InterestedInHigherStudies listIhs(String year) {
		
				
		
		List<InterestedInHigherStudies> totalList = sessionFactory.getCurrentSession().createCriteria(InterestedInHigherStudies.class)
				.add(Restrictions.eq("year", year)).list();
		System.out.println("inside dao size of list = " + totalList.size());

		return  totalList.get(0);

		
		
		
			}



}
