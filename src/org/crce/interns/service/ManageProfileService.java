package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.JobBean;
//import org.crce.interns.model.Allotment;
import org.crce.interns.model.Company;
import org.crce.interns.model.Job;

//import org.crce.interns.beans.ProfileBean;

public interface ManageProfileService {

	//public void addProfile(ProfileBean profileBean);
	//public void addProfile(TryBean tryBean);
	public void addProfile(JobBean jobBean);
	public void addProfile(CriteriaBean criteriaBean);
	public void addProfile(CompanyBean companyBean);
	public List<Job> listProfile();
	public List<CompanyBean> listCompanies();
}
