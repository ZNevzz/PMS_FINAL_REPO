package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.UserCompany;
import org.crce.interns.model.UserDetails;

public interface ApplicantDao {

	List<UserCompany> viewApplicants(Integer companies);

	//List<UserDetails> notifyApplicants(String user);
	
	List<UserDetails> notifyApplicants(UserDetails user);

	int checkNotify(String user);

	
}

