package org.crce.interns.dao.impl;


import org.hibernate.SessionFactory;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import org.crce.interns.model.*;

import java.util.List;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.dao.*;
@Repository("companyDao")
public class CompanyDaoImpl implements CompanyDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCriteria(Criteria criteria) {
		try{
		System.out.println("In DAO CRITERIA");
		System.out.println(criteria.getCgpa());
			sessionFactory.getCurrentSession().saveOrUpdate(criteria);
		
			System.out.println("in dao criteria after");
		}
		

		catch (ConstraintViolationException e) {
			System.out.println("error");
			
		}
		catch(DataIntegrityViolationException e){
			System.out.println("error");
			
		}	

	}
	public void addCompany(Company company) {
		
//company.setCriteriaId(company.getCompany_id());
		try{
			sessionFactory.getCurrentSession().saveOrUpdate(company);
			System.out.println("after dao");
			//int cid=company.getCompany_id();
			
			int cid=company.getCompanyId();
			
			System.out.println("after dao1");
			System.out.println(cid);
			
			//company.setCriteria_id(cid);
			company.setCriteriaId(cid);
			
			sessionFactory.getCurrentSession().saveOrUpdate(company);
			
			}
		catch (ConstraintViolationException e) {
			System.out.println("error1");
		}
	 
	   catch(DataIntegrityViolationException e){
		   System.out.println("error2");
			
	   }	
			}
	@SuppressWarnings("unchecked")
	public List<CompanyBean> getCompany() { 
		
		  return (List<CompanyBean>) sessionFactory.getCurrentSession().createCriteria(CompanyBean.class).list();  
		 }  
	}
