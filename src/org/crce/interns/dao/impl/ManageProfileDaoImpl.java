/*package org.crce.interns.dao.impl;


//import org.crce.interns.model.Allotment;
import org.crce.interns.model.Company;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.Job;

import java.util.List;

import org.crce.interns.beans.JobBean;
import org.crce.interns.dao.ManageProfileDao;
//import org.crce.interns.model.Profile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



 * Author: Cheryl
 * Classes Used: Job,Criteria,Company
 * 
 * Description: This DAO is used to save data entries for 3 
 * 				different tables job,criteria and company.
 * 				It also returns values in case of view Profile
 

@Repository("manageProfileDao")

public class ManageProfileDaoImpl implements ManageProfileDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public void createProfile(Profile profile) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().saveOrUpdate(profile);	
	}
	
	
	
	public void createProfile(Job job) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(job);	
	}

	public void createProfile(Criteria criteria) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(criteria);	
	}

	@SuppressWarnings("unchecked")
	public List<Job> listProfile() {
		// TODO Auto-generated method stub
		return (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).list();
		//return (List<Allotment>) sessionFactory.openSession().createCriteria(Allotment.class).list();
	}

	//@Override
	public void createProfile(Company company) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(company);			
	}
	
	
	
	 * added by @ZNevzz
	 * ?
	 
	
	public List<Company> listCompanies(){
		// TODO Auto-generated method stub
		return (List<Company>) sessionFactory.getCurrentSession().createCriteria(Company.class).list();
		//return (List<Allotment>) sessionFactory.openSession().createCriteria(Allotment.class).list();
	}
	 
}
*/
package org.crce.interns.dao.impl;


//import org.crce.interns.model.Allotment;
import org.crce.interns.model.Company;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.Job;

import java.util.Calendar;
import java.util.List;

import org.crce.interns.beans.JobBean;
import org.crce.interns.dao.ManageProfileDao;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.crce.interns.model.Profile;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/*
 * Author: Cheryl
 * Classes Used: Job,Criteria,Company
 * 
 * Description: This DAO is used to save data entries for 3 
 * 				different tables job,criteria and company.
 * 				It also returns values in case of view Profile
 */

@Repository("manageProfileDao")

public class ManageProfileDaoImpl implements ManageProfileDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*
	public void createProfile(Profile profile) {
		// TODO Auto-generated method stub

		sessionFactory.getCurrentSession().saveOrUpdate(profile);	
	}
	*/
	
	
	public void createProfile(Job job) {
		// TODO Auto-generated method stub
		
		/*Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT job FROM Job job WHERE job.year = :curYear and job.job_id is not null");
		
		String curYear=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		query.setParameter("curYear",curYear);
		*/
		sessionFactory.getCurrentSession().save(job);	//change made @Crystal	
		
		
	}

	public void createProfile(Criteria criteria) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(criteria);	//change made @Crystal	
	}

	@SuppressWarnings("unchecked")
	//Added String curYear
	public List<Job> listProfile(String curYear) {
		// TODO Auto-generated method stub
		
		List<Job> result = null;
		
		if(curYear.equals(""))
		{
			
			curYear=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
				
		}
		//return (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).list();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT job FROM Job job WHERE job.year = :curYear");
		query.setParameter("curYear", curYear);
		
		result = query.list();
		return result;
		
	}

	//@Override
	
	public void createProfile(Company company) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(company);		//change made @Crystal	
	}
	
	
	/*
	 * added by @ZNevzz
	 * ?
	 */
	
	public List<Company> listCompanies(){
		// TODO Auto-generated method stub
		return (List<Company>) sessionFactory.getCurrentSession().createCriteria(Company.class).list();
		//return (List<Allotment>) sessionFactory.openSession().createCriteria(Allotment.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	//Added String curYear
	public List<Job> listJob(String curYear) {
		// TODO Auto-generated method stub
		
		List<Job> result = null;
		
		if(curYear.equals(""))
		{
			
			curYear=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
				
		}
		//return (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).list();
		
		Query query = sessionFactory.getCurrentSession()
				.createQuery("SELECT job FROM Job job WHERE job.year = :curYear");
		query.setParameter("curYear", curYear);
		
		result = query.list();
		return result;

		
		//return (List<Job>) sessionFactory.getCurrentSession().createCriteria(Job.class).list();
	}

	 
}