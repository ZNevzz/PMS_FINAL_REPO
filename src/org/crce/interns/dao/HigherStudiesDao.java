package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.beans.InterestedInHigherStudiesBean;
import org.crce.interns.model.Feedback;
import org.crce.interns.model.InterestedInHigherStudies;

public interface HigherStudiesDao {

	
	public void addHS(InterestedInHigherStudiesBean ihs);
	public List<InterestedInHigherStudies> listIhs();
			
	
}
