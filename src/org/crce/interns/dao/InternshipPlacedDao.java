package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.beans.InternshipPlacedBean;
import org.crce.interns.model.Feedback;
import org.crce.interns.model.InterestedInHigherStudies;
import org.crce.interns.model.InternshipPlaced;

public interface InternshipPlacedDao {

	public List<InternshipPlaced> listIhs();
	
	public void addIP(InternshipPlacedBean ihs);
	
}
