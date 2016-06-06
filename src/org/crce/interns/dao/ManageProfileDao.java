package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.beans.JobBean;
import org.crce.interns.model.Company;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.Job;

//import org.crce.interns.model.Profile;

public interface ManageProfileDao {

	//public void createProfile(Profile profile);
	public void createProfile(Job job);
	public void createProfile(Criteria criteria);
	public void createProfile(Company company);
	public List<Job> listProfile();
	public List<Company> listCompanies();

}
