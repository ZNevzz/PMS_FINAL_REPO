/*package org.crce.interns.service.impl;


import java.util.LinkedList;
import java.util.List;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.JobBean;
import org.crce.interns.beans.NotificationBean;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.dao.ManageProfileDao;
//import org.crce.interns.model.Allotment;
import org.crce.interns.model.Company;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.Job;
import org.crce.interns.model.Notification;
//import org.crce.interns.model.Profile;
import org.crce.interns.service.ManageProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


 * Author: Cheryl
 * Classes Used: ManageProfileDao,JobCriteria,Company,JobBean,CriteriaBean,CompanyBean
 * 
 * Description: Handles the copyProperties for bean
 

@Service("manageProfileService")

//The below line is required else code doesn't work...common error of skipping this line

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ManageProfileServiceImpl implements ManageProfileService{
	
	@Autowired
	private ManageProfileDao manageProfileDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(JobBean jobBean) {
		// TODO Auto-generated method stub
		Job job = new Job();
		
		
		 * Copies values from Job in model class 
		 * to JobBean.
		 * Hence beans will hold light weight data which is better to 
		 * store in database.
		 
		
		BeanUtils.copyProperties(jobBean, job);
		manageProfileDao.createProfile(job);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(CriteriaBean criteriaBean) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		BeanUtils.copyProperties(criteriaBean, criteria);
		manageProfileDao.createProfile(criteria);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Job> listProfile() {
		// TODO Auto-generated method stub
		return manageProfileDao.listProfile();
	}

	//@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(CompanyBean companyBean) {
		// TODO Auto-generated method stub
		Company company = new Company();
		BeanUtils.copyProperties(companyBean, company);
		manageProfileDao.createProfile(company);
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(TryBean tryBean) {
		// TODO Auto-generated method stub
		
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		Profile profile = new Profile();
		BeanUtils.copyProperties(profileBean, profile);
		//profile.setRole_id("1");

		manageProfileDao.createProfile(profile);
	}
	
	
	
	 * 
	 * added by @ZNevzz
	 *
	
	 
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CompanyBean> listCompanies(){
		
		List<Company> nfList= manageProfileDao.listCompanies();
		List<CompanyBean> nfBeanList= new LinkedList<CompanyBean>();
		
		for( Company c: nfList){
			//System.out.println(c);
			CompanyBean cb = new CompanyBean();
			BeanUtils.copyProperties(c, cb);
			nfBeanList.add(cb);
			
		}
		System.out.println((nfBeanList.size()));
		return nfBeanList;
	}
	
	
}
*/



package org.crce.interns.service.impl;


import java.util.LinkedList;
import java.util.List;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.JobBean;
import org.crce.interns.beans.NotificationBean;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.dao.ManageProfileDao;
//import org.crce.interns.model.Allotment;
import org.crce.interns.model.Company;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.Job;
import org.crce.interns.model.Notification;
//import org.crce.interns.model.Profile;
import org.crce.interns.service.ManageProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
 * Author: Cheryl
 * Classes Used: ManageProfileDao,JobCriteria,Company,JobBean,CriteriaBean,CompanyBean
 * 
 * Description: Handles the copyProperties for bean
 */

@Service("manageProfileService")

//The below line is required else code doesn't work...common error of skipping this line

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ManageProfileServiceImpl implements ManageProfileService{
	
	@Autowired
	private ManageProfileDao manageProfileDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(JobBean jobBean) {
		// TODO Auto-generated method stub
		Job job = new Job();
		
		/*
		 * Copies values from Job in model class 
		 * to JobBean.
		 * Hence beans will hold light weight data which is better to 
		 * store in database.
		 */
		
		BeanUtils.copyProperties(jobBean, job);
		manageProfileDao.createProfile(job);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(CriteriaBean criteriaBean) {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		BeanUtils.copyProperties(criteriaBean, criteria);
		manageProfileDao.createProfile(criteria);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Job> listProfile(String curYear) {
		// TODO Auto-generated method stub
		//return manageProfileDao.listProfile();
		return manageProfileDao.listProfile(curYear);
	}

	//@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(CompanyBean companyBean) {
		// TODO Auto-generated method stub
		Company company = new Company();
		BeanUtils.copyProperties(companyBean, company);
		manageProfileDao.createProfile(company);
	}

	/*
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(TryBean tryBean) {
		// TODO Auto-generated method stub
		
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addProfile(ProfileBean profileBean) {
		// TODO Auto-generated method stub
		Profile profile = new Profile();
		BeanUtils.copyProperties(profileBean, profile);
		//profile.setRole_id("1");

		manageProfileDao.createProfile(profile);
	}
	*/
	
	/*
	 * 
	 * added by @ZNevzz
	 *
	
	 */
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<CompanyBean> listCompanies(){
		
		List<Company> nfList= manageProfileDao.listCompanies();
		List<CompanyBean> nfBeanList= new LinkedList<CompanyBean>();
		
		for( Company c: nfList){
			
			CompanyBean cb = new CompanyBean();
			BeanUtils.copyProperties(c, cb);
			nfBeanList.add(cb);
			
		}
		System.out.println((nfBeanList.size()));
		return nfBeanList;
	}

	//@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<JobBean> listJob(String curYear) {
		// TODO Auto-generated method stub
		List<Job> nfList= manageProfileDao.listJob(curYear);
		List<JobBean> nfBeanList= new LinkedList<JobBean>();
		
		for( Job c: nfList){
			
			JobBean cb = new JobBean();
			BeanUtils.copyProperties(c, cb);
			nfBeanList.add(cb);
			
		}
		System.out.println((nfBeanList.size()));
		return nfBeanList;
	}
	
	
}