package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.dao.ManageApplicantsDao;
import org.crce.interns.model.Company;
import org.crce.interns.model.UserCompany;
import org.crce.interns.service.ManageApplicantsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @author Rashmi
* Task: Adds/Deletes Applicant entries from list of applicants for a job
* Dependency: ManageApplicantsDao.java
*/



//import org.crce.interns.service;
@Service("crudService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ManageApplicantsServiceImpl implements ManageApplicantsService{
	@Autowired
	private ManageApplicantsDao crudDao;

	public int createDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		int c=crudDao.checkDetails(user);
		if(c==0)
		crudDao.createDetails(user);
		return c;
/*
	public void createDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		//System.out.println("Service "+user.getUsername()+user.getCompany_id());
		crudDao.createDetails(user);
*/
	}
	
	@SuppressWarnings("unchecked")
	public List<UserCompanyBean> retreiveDetails(String company){
		List<UserCompany> userList=new ArrayList<UserCompany>();
		List<UserCompanyBean> userBeanList=new ArrayList<UserCompanyBean>();
		userList=crudDao.retreiveDetails(company);
		//userList.addAll(crudDao.retreiveDetails(company));
		//UserCompanyBean userCompanyBean=new UserCompanyBean();
		
		for(UserCompany d:userList){
			System.out.println("d=  "+d.getUsername());
			//userBeanList.add(userCompanyBean);
			UserCompanyBean userCompanyBean=new UserCompanyBean();
			BeanUtils.copyProperties(d,userCompanyBean);
			System.out.println("userCompanyBean= "+userCompanyBean.getUsername());
			userBeanList.add(userCompanyBean);
		}
	/*	for(UserCompanyBean d:userBeanList){
			System.out.println("userBeanList=  "+d.getUsername());
		}*/
		return userBeanList;
	}
	

	
	public int deleteDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		int c=crudDao.checkDetails(user);
		System.out.println("c="+c);
		if(c==1)
			crudDao.deleteDetails(user);
		return c;	
		}

	public List<Company> retrieveCompany_id(){
		List<Company> list=new ArrayList<Company>();
		list.addAll(crudDao.retrieveCompany_id());
		return list;
	}

	@Override
	public List<UserCompanyBean> retreiveDetails(String company, String year) {
		// TODO Auto-generated method stub
		List<UserCompany> userList=new ArrayList<UserCompany>();
		 		List<UserCompanyBean> userBeanList=new ArrayList<UserCompanyBean>();
		 		userList=crudDao.retreiveDetails(company, year);
		 	//userList.addAll(crudDao.retreiveDetails(company));
		 		//UserCompanyBean userCompanyBean=new UserCompanyBean();
		 		
		 		for(UserCompany d:userList){
		 		System.out.println("d=  "+d.getUsername());
		 		//userBeanList.add(userCompanyBean);
		 		UserCompanyBean userCompanyBean=new UserCompanyBean();
		 		BeanUtils.copyProperties(d,userCompanyBean);
		 			System.out.println("userCompanyBean= "+userCompanyBean.getUsername());
		 			userBeanList.add(userCompanyBean);
		 		}
		 	/*	for(UserCompanyBean d:userBeanList){
		 			System.out.println("userBeanList=  "+d.getUsername());
		 	}*/
		 		return userBeanList;
	}
	
/*	public void deleteDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		crudDao.deleteDetails(user);
	}
*/


}



/*package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.dao.ManageApplicantsDao;
import org.crce.interns.model.Company;
import org.crce.interns.model.UserCompany;
import org.crce.interns.service.ManageApplicantsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

*//**
*
* @author Rashmi
* Task: Adds/Deletes Applicant entries from list of applicants for a job
* Dependency: ManageApplicantsDao.java
*//*



//import org.crce.interns.service;
@Service("crudService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class ManageApplicantsServiceImpl implements ManageApplicantsService{
	@Autowired
	private ManageApplicantsDao crudDao;

	public int createDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		int c=crudDao.checkDetails(user);
		if(c==0)
		crudDao.createDetails(user);
		return c;

	public void createDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		//System.out.println("Service "+user.getUsername()+user.getCompany_id());
		crudDao.createDetails(user);

	}
	
	@SuppressWarnings("unchecked")
	public List<UserCompany> retreiveDetails(String company){
		List<UserCompany> userList=new ArrayList<UserCompany>();
		userList.addAll(crudDao.retreiveDetails(company));
		return userList;
	}
	

	
	public int deleteDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		int c=crudDao.checkDetails(user);
		System.out.println("c="+c);
		if(c==0||c==1)
			crudDao.deleteDetails(user);
		return c;	}

	public List<Company> retrieveCompany_id(){
		List<Company> list=new ArrayList<Company>();
		list.addAll(crudDao.retrieveCompany_id());
		return list;
	}
	
	public void deleteDetails(UserCompanyBean userBean){
		UserCompany user=new UserCompany();
		BeanUtils.copyProperties(userBean, user);
		crudDao.deleteDetails(user);
	}



}
*/