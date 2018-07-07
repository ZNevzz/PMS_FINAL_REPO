package org.crce.interns.dao;

import java.util.List;

import org.crce.interns.model.PlacementStatistics;
import org.crce.interns.model.PlacementStats;
import org.crce.interns.model.QuickStats;
import org.crce.interns.model.TotalNoOfStudents;

public interface StatisticsDAO {
	
	public List<PlacementStats> list();
	public void add(PlacementStats placementStats);
	public void calculateTotal(String year);
	public TotalNoOfStudents getTotalNoOfStudents(String year);
	
	public List<QuickStats> getQuickStatsList(String year);
	public List<PlacementStats> getPlacementStatsList(String year);
}
