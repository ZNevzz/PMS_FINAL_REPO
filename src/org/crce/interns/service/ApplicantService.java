package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;

public interface ApplicantService {

	public List<UserCompanyBean> viewApplicants(Integer companies);

	public List<UserDetailsBean> notifyApplicants(UserDetails ud);

	public int checkNotify(String user);
	
}
