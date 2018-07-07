package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.QuickStats;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("selectDao")
@Transactional
public interface SelectedApplicantsDao {
	public void createDetails(QuickStats user);
	public int checkDetails(QuickStats user);
	public List<QuickStats> retrieveDetails(String company);
	public List<QuickStats> retrieveDetails(String company, String year);
	public void deleteDetails(QuickStats user);
	public boolean check(String userName);
}
