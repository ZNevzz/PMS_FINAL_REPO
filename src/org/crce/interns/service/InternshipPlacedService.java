package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.InternshipPlacedBean;
import org.crce.interns.model.InternshipPlaced;

public interface InternshipPlacedService {

	public void addIP(InternshipPlacedBean ips);
	public List<InternshipPlaced> listIhs();
	
}
