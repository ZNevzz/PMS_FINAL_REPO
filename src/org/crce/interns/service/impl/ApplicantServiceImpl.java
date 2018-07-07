package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.ApplicantDao;
import org.crce.interns.model.UserCompany;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.ApplicantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService{

	@Autowired
	ApplicantDao applicantDao;
	
	/*@Override
	public List<UserCompanyBean> viewApplicants(Integer companies) {
		// TODO Auto-generated method stub
		System.out.println("CompanyId in Service Impl :" + companies);
		List<UserCompany> userList = applicantDao.viewApplicants(companies);
		if (userList == null) {
			return null;
		}
		return convertToBean(userList);

	}*/

	public List<UserCompanyBean> convertToBean(List<UserCompany> userList) {
		// TODO Auto-generated method stub
		List<UserCompanyBean> udBeanList = new ArrayList<UserCompanyBean>();
		for (UserCompany ud : userList) {
			UserCompanyBean udBean = new UserCompanyBean();
			BeanUtils.copyProperties(ud, udBean);
			udBeanList.add(udBean);
		}
		return udBeanList;
	}

	@Override
	public List<UserDetailsBean> notifyApplicants(UserDetails ud,String curYear) {
		// TODO Auto-generated method stub
		System.out.println("UserId in Service Impl :" + ud.getUserName());
		
		List<UserDetails> userList = applicantDao.notifyApplicants(ud,curYear);
		if (userList == null) {
			return null;
		}
		return convertUserToBean(userList);
	}

	private List<UserDetailsBean> convertUserToBean(List<UserDetails> userList) {
		// TODO Auto-generated method stub
		List<UserDetailsBean> udsBeanList = new ArrayList<UserDetailsBean>();
		for (UserDetails uds : userList) {
			UserDetailsBean udsBean = new UserDetailsBean();
			BeanUtils.copyProperties(uds, udsBean);
			udsBeanList.add(udsBean);
		}
		return udsBeanList;
	}

	@Override
	public int checkNotify(String user) {
		// TODO Auto-generated method stub
		System.out.println("In Service : Check Notify");
		int check=applicantDao.checkNotify(user);
		return check;
	}

	@Override
	public List<UserCompanyBean> viewApplicants(Integer companies, String curYear) {
		// TODO Auto-generated method stub
		System.out.println("CompanyId in Service Impl :" + companies);
		List<UserCompany> userList = applicantDao.viewApplicants(companies,curYear);
		if (userList == null) {
			return null;
		}
		return convertToBean(userList);
	}

	

}
