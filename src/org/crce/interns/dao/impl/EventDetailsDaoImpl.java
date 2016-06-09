package org.crce.interns.dao.impl;

import java.sql.BatchUpdateException;
import java.util.List;

import org.crce.interns.dao.EventDetailsDao;
import org.crce.interns.model.Aptitude;
import org.crce.interns.model.Company;
import org.crce.interns.model.Event;
import org.crce.interns.model.Interview;
import org.crce.interns.model.Pre_Placement;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("eventDetailsDao")
public class EventDetailsDaoImpl implements EventDetailsDao{
	@Autowired
	private SessionFactory sessionFactory;
	Session session=null;
	Transaction tx=null;
	Event e=null;
	public void create(Event event,String cname) {
		
		try {
			System.out.println(event.getEvent_type()); 
			session=this.sessionFactory.openSession();
			String sql = "from Company as c where c.companyName = :n";
			Query q = session.createQuery(sql);
			q.setParameter("n", cname);
			List<Company> c = q.list();
			int company_id = c.get(0).getCompany_id();
			event.setCompany_id(company_id);
			tx=session.beginTransaction();			
			session.save(event);
			tx.commit();
		} catch (HibernateException e) {
				e.printStackTrace();
		}
		
	}
	
	
	public void create(Aptitude bean){
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(bean);		
		tx.commit();

	}
	
	public void create(Pre_Placement bean){
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(bean);
		
		tx.commit();

	}
	
	public void create(Interview bean){
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.save(bean);
		
		tx.commit();

	}

}
