package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.QuickStatsBean;
import org.crce.interns.dao.SelectedApplicantsDao;
import org.crce.interns.model.QuickStats;
import org.crce.interns.service.SelectedApplicantsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectedApplicantsServiceImpl implements SelectedApplicantsService{

 	@Autowired(required=true)
	private SelectedApplicantsDao selectDao;
	
 	public int createDetails(QuickStatsBean userBean){
		QuickStats user=new QuickStats();
		BeanUtils.copyProperties(userBean, user);
		int c=selectDao.checkDetails(user);
		if(c==0)
			selectDao.createDetails(user);
		return c;

	}
	
	@SuppressWarnings("unchecked")
	public List<QuickStatsBean> retrieveDetails(String company){
		List<QuickStats> userList=new ArrayList<QuickStats>();
		List<QuickStatsBean> userBeanList=new ArrayList<QuickStatsBean>();
		userList=selectDao.retrieveDetails(company);
		
		for(QuickStats d:userList){
			System.out.println("d=  "+d.getUsername());
			QuickStatsBean userCompanyBean=new QuickStatsBean();
			BeanUtils.copyProperties(d,userCompanyBean);
			System.out.println("userCompanyBean= "+userCompanyBean.getUsername());
			userBeanList.add(userCompanyBean);
		}
		for(QuickStatsBean d:userBeanList){
			System.out.println("userBeanList=  "+d.getUsername());
		}
		return userBeanList;
	}
	
	
	 public List<QuickStatsBean> retrieveDetails(String company, String year){
		List<QuickStats> userList=new ArrayList<QuickStats>();
		List<QuickStatsBean> userBeanList=new ArrayList<QuickStatsBean>();
		userList=selectDao.retrieveDetails(company, year);
		//userList.addAll(crudDao.retreiveDetails(company));
		//UserCompanyBean userCompanyBean=new UserCompanyBean();
		
		for(QuickStats d:userList){
			System.out.println("d=  "+d.getUsername());
			//userBeanList.add(userCompanyBean);
			QuickStatsBean userCompanyBean=new QuickStatsBean();
			BeanUtils.copyProperties(d,userCompanyBean);
			System.out.println("userCompanyBean= "+userCompanyBean.getUsername());
			userBeanList.add(userCompanyBean);
		}
		/*for(UserCompanyBean d:userBeanList){
			System.out.println("userBeanList=  "+d.getUsername());
		}*/
		return userBeanList;
	}

	 
	
	public int deleteDetails(QuickStatsBean userBean){
		QuickStats user=new QuickStats();
		BeanUtils.copyProperties(userBean, user);
		//selectDao.deleteDetails(user);
		int c=selectDao.checkDetails(user);
		System.out.println("c="+c);
		if(c==1)
			selectDao.deleteDetails(user);
		return c;
	}

}
