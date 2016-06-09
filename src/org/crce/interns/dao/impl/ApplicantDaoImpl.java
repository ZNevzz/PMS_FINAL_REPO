package org.crce.interns.dao.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.crce.interns.dao.ApplicantDao;
import org.crce.interns.model.UserCompany;
import org.crce.interns.model.UserDetails;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ApplicantDaoImpl implements ApplicantDao{

	private boolean flag=true;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<UserCompany> viewApplicants(Integer companies) {
		// TODO Auto-generated method stub
		System.out.println("Company in Dao Impl :" + companies);
		
		Session session = sessionFactory.openSession();
		List<UserCompany> udList = session.createQuery("select uc from UserCompany uc where company_id = :cId").setParameter("cId", companies).list();
		if(udList.isEmpty())
			return null;
		
		return udList;
	}

	@Override
	public List<UserDetails> notifyApplicants(UserDetails user) {
		
		// TODO Auto-generated method stub
		System.out.println("User Id in Dao Impl :" + user);
		
		Session session = sessionFactory.openSession();
		List<UserDetails> udsList = null;
		
		String hql = "update UserDetails set notified = :notify,modifiedDate = :modD,modifiedBy = :modBy where userName = :uId";
		 
		Query query = session.createQuery(hql);
		query.setParameter("notify", flag);
		query.setParameter("uId", user.getUserName());
		query.setParameter("modD", user.getModifiedDate());
		query.setParameter("modBy", user.getModifiedBy());
		
		int rowsAffected = query.executeUpdate();
		if (rowsAffected > 0) {
		    System.out.println("Updated " + rowsAffected + " rows.");
		}
		
		return null;
	}

	@Override
	public int checkNotify(String user) {
		
		// TODO Auto-generated method stub
		UserDetails result = (UserDetails) sessionFactory.getCurrentSession().get(UserDetails.class,user);
		
		boolean check = result.isNotified();
		if(check)
		return 1;
		
		return 0;
	}

	
}
