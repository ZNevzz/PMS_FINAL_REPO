package org.crce.interns.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.crce.interns.dao.SelectedApplicantsDao;
import org.crce.interns.model.Company;
import org.crce.interns.model.ProfessionalProfile;
import org.crce.interns.model.QuickStats;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SelectedApplicantsDaoImpl implements SelectedApplicantsDao{

 	@Autowired
	private SessionFactory sessionFactory;
 	
	Session session=null;
	Transaction tx=null;
	
	// to create an entry 
	public void createDetails(QuickStats user){
		session=this.sessionFactory.openSession();
		
		String year=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		System.out.println(year+"----------------------------------------------------------"+year);
		user.setYear(year);

		Session s = sessionFactory.openSession();
		String sql = "from Company as c where c.company_name = :n";
		Query q = s.createQuery(sql);
		q.setParameter("n", user.getCompany_name());
		List<Company> c = q.list();
		int company_id = c.get(0).getCompany_id();
		user.setCompany_id(company_id);
		tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		
	}

	@SuppressWarnings("unchecked")
	public int checkDetails(QuickStats user){
		
		session=this.sessionFactory.openSession();
		Criteria criteria=session.createCriteria(QuickStats.class);

	//when input already exists in the db
	List<QuickStats> userList=new ArrayList<QuickStats>();
	userList.addAll(criteria.list());
	for(QuickStats d:userList){
		if(d.getCompany_name().equals(user.getCompany_name())&&d.getUsername().equals(user.getUsername())){
			return 1; 
		}
	}
	
	session.close();
	
	Session s = sessionFactory.openSession();
	int flag=0;
	
	//to check if user name is valid- if account exists
	String sql="from ProfessionalProfile as u";
	Query q = s.createQuery(sql);
	List<ProfessionalProfile> u=q.list();
	for(ProfessionalProfile d:u){
		if(d.getUserName().equals(user.getUsername())){
			flag=1;
		}
	}
	System.out.println("after user check");
	if(flag==0)
		return 3;
	
	//to check if company name exists in the db
	flag=0;
	sql = "from Company as c";
	q = s.createQuery(sql);
	List<Company> c = q.list();
	
	for(Company d:c){
		if(d.getCompany_name().equals(user.getCompany_name())){
			flag=1;
		}
	}
	
	if(flag==0){
		return 2;
	}
	System.out.println("after company check");

	
	s.close();
	
	return 0;
	
}
		
		//to retrieve and print the list
		
	@SuppressWarnings("unchecked")
	public List<QuickStats> retrieveDetails(String company){
		System.out.println("company= "+company);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(QuickStats.class);

		System.out.println("inside DAO: "+company);
		List<QuickStats> list=new ArrayList<QuickStats>();
		list.addAll(criteria.list());
		List<QuickStats> userList=new ArrayList<QuickStats>();
		for(QuickStats d:list){
			if(d.getCompany_name().equals(company)) userList.add(d);
	}
		System.out.println("outside DAO.....");
		tx.commit();
		session.close();
		
		return userList;

	}
	
	
	 public List<QuickStats> retrieveDetails(String company, String year){
		
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria criteria=session.createCriteria(QuickStats.class);

		System.out.println("inside DAO: "+company);
		List<QuickStats> list=new ArrayList<QuickStats>();
		list.addAll(criteria.list());
		List<QuickStats> userList=new ArrayList<QuickStats>();
		
		for(QuickStats d:list){
			if(d.getCompany_name().equals(company) && d.getYear().equals(year)) userList.add(d);
	    }
		
		System.out.println("outside DAO.....");
		tx.commit();
		session.close();
		
		return userList;
	}

	 
	
	public void deleteDetails(QuickStats user){
		
		Session s = sessionFactory.openSession();
		String sql = "from Company as c where c.company_name = :n";
		Query q = s.createQuery(sql);
		q.setParameter("n", user.getCompany_name());
		List<Company> c = q.list();
		int company_id = c.get(0).getCompany_id();
		
		System.out.println(company_id);
		user.setCompany_id(company_id);
		
		user=(QuickStats) sessionFactory.getCurrentSession().get(QuickStats.class,user);
		session=this.sessionFactory.openSession();
		tx=session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

	/**
	 * added by Nevil
	 */
	@SuppressWarnings("unchecked")
	@Override	
	public boolean check(String userName){
						
		
		String year=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT U.username FROM QuickStats U WHERE U.year = :curYear AND U.username = :username");
		query.setParameter("curYear", year);
		query.setParameter("username", userName);
		
		
		if(query.list().size()>=1){
			
			return true;
		}
		return false;
		
		
	}
}
