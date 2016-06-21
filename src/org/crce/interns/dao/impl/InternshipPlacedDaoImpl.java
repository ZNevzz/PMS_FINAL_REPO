package org.crce.interns.dao.impl;

import java.util.Calendar;
import java.util.List;

import org.crce.interns.beans.InternshipPlacedBean;
import org.crce.interns.dao.InternshipPlacedDao;
import org.crce.interns.model.Feedback;
import org.crce.interns.model.InterestedInHigherStudies;
import org.crce.interns.model.InternshipPlaced;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("internshipplacedDao")

public class InternshipPlacedDaoImpl implements InternshipPlacedDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addIP(InternshipPlacedBean ihs) {
		InternshipPlaced ihss=new 	InternshipPlaced();
		
		BeanUtils.copyProperties(ihs,ihss);
		System.out.println("&&&&&&"+ihss.getYear());
		System.out.println(ihs.getYear()+"&&&&&&&");
		sessionFactory.getCurrentSession().save(ihss);
	}
	
	@SuppressWarnings("unchecked")
	public List<InternshipPlaced> listIhs() {
List<InternshipPlaced> list = null;
		


		
		
		String y = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT U FROM InternshipPlaced U WHERE U.year = :curYear");
		query.setParameter("curYear", y);
		list = query.list();
		
		System.out.println("inside dao size of list = " + list.size());
		
		return list;
	}



}
