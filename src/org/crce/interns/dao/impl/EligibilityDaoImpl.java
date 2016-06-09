package org.crce.interns.dao.impl;





import org.crce.interns.dao.EligibilityDao;
import org.crce.interns.model.Company;
import org.crce.interns.model.Company_job;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.ProfessionalProfile;
import org.crce.interns.model.Qualification;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EligibilityDaoImpl implements EligibilityDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	

	public Criteria getCriterias(int criteria_id) {
		
		Criteria c=null;
		 try {
			c= (Criteria)sessionFactory.getCurrentSession().createQuery("select c from Criteria c where criteria_id = :cid").setParameter("cid", criteria_id).uniqueResult();
		} catch (HibernateException e) {
	
			e.printStackTrace();
		}
		
		 return c;
	}
	
	public ProfessionalProfile getProfessionalProfile(String username){	
		ProfessionalProfile p=null;
	
		try {
			p=(ProfessionalProfile) sessionFactory.getCurrentSession().createQuery("select new ProfessionalProfile(userName,branch,status,year) from ProfessionalProfile where userName = :uid").setParameter("uid",username).uniqueResult();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		
		return p;
	}

	public Qualification getQualification(String username)
	{
		Qualification q=null;
		try {
			 q=(Qualification) sessionFactory.getCurrentSession().createQuery("select new Qualification( username,ssc_per , hsc_or_dip_per,s6_kt, deg_per, deg_kt,drops) from Qualification where username = :uid").setParameter("uid",username).uniqueResult();
		} catch (HibernateException e) {
		
			e.printStackTrace();
		}
		
		return q;
	}

	public int getCriteriaId(String job_id) {
		
		Company company= null;
		try {
			Company_job cj= (Company_job)sessionFactory.getCurrentSession().createQuery("select c from Company_job c where job_id = :job_id").setParameter("job_id", job_id).uniqueResult();;
			company = (Company) sessionFactory.getCurrentSession().createQuery("select c from Company c where company_id = :c_id").setParameter("c_id", cj.getCompany_id()).uniqueResult();
			
		} catch (NonUniqueResultException e) {
			e.printStackTrace();
		}
	
		return company.getCriteria_id();
	}
	
	public String getJobCategory(String job_id)
	{
		String s=(String) sessionFactory.getCurrentSession().createQuery("select job_category from Job where job_id= :jid").setParameter("jid", job_id).uniqueResult();
		
		return s;
	}
	
	public String getStudentJob(String u_name){
		String s=(String) sessionFactory.getCurrentSession().createQuery("select job_id from Professional_Profile_job where username= :x").setParameter("x", u_name).uniqueResult();

		return s;
	}
}
