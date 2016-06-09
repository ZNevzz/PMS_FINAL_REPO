package org.crce.interns.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.dao.ManageApplicantsDao;
//import org.apache.commons.collections.list.LazyList;
import org.crce.interns.model.Company;
//import org.crce.interns.model.User;
import org.crce.interns.model.UserCompany;
//import org.crce.interns.model.UserCompanyId;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("crudDao")
@Transactional
public class ManageApplicantsDaoImpl implements ManageApplicantsDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	Session session=null;
	Transaction tx=null;
	
	public void createDetails(UserCompany user){
		session=this.sessionFactory.openSession();			
		Session s = sessionFactory.openSession();
		String sql = "from Company as c where c.companyName = :n";
		Query q = s.createQuery(sql);
		q.setParameter("n", user.getCompany());
		List<Company> c = q.list();
		int company_id = c.get(0).getCompany_id();
		user.setCompany_id(company_id);
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();

		
	}
		
	
	@SuppressWarnings("unchecked")
	public List<UserCompany> retreiveDetails(String company){
		System.out.println("company= "+company);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(UserCompany.class);

		System.out.println("inside DAO: "+company);
		List<UserCompany> list=new ArrayList<UserCompany>();
		list.addAll(criteria.list());
		List<UserCompany> userList=new ArrayList<UserCompany>();
		for(UserCompany d:list){
			if(d.getCompany().equals(company)) userList.add(d);
	}
		System.out.println("outside DAO.....");
		tx.commit();
		session.close();
		
		return userList;
	}
	
	public List<Company> retrieveCompany_id(){
		List<Company> list=new ArrayList<Company>();
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(Company.class);
		list.addAll(criteria.list());
		return list;
	}
	public void deleteDetails(UserCompany user){
		
		Session s = sessionFactory.openSession();
		String sql = "from Company as c where c.companyName = :n";
		Query q = s.createQuery(sql);
		q.setParameter("n", user.getCompany());
		List<Company> c = q.list();
		int company_id = c.get(0).getCompany_id();
		
		System.out.println(company_id);
		user.setCompany_id(company_id);
		
		user=(UserCompany) sessionFactory.getCurrentSession().get(UserCompany.class,user);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

}
