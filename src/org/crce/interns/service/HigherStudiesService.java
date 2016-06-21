package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.InterestedInHigherStudiesBean;
import org.crce.interns.model.InterestedInHigherStudies;
import org.crce.interns.model.InternshipPlaced;

public interface HigherStudiesService {

	public void addHS(InterestedInHigherStudiesBean ihs);
	public List<InterestedInHigherStudies> listIhs();
	
}
