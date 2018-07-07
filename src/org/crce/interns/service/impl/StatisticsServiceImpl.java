package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.PlacementStatisticsBean;
import org.crce.interns.beans.PlacementStatsBean;
import org.crce.interns.dao.CompanyDao;
import org.crce.interns.dao.ManageApplicantsDao;
import org.crce.interns.dao.ManageProfileDao;
import org.crce.interns.dao.ProfileDAO;
import org.crce.interns.dao.StatisticsDAO;
import org.crce.interns.model.Company;
import org.crce.interns.model.PlacementStatistics;
import org.crce.interns.model.PlacementStats;
import org.crce.interns.model.QuickStats;
import org.crce.interns.model.TotalNoOfStudents;
import org.crce.interns.model.UserCompany;
import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.StatisticsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("statisticsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StatisticsServiceImpl implements StatisticsService, ConstantValues {

	@Autowired
	private StatisticsDAO statisticsDAO;
	
	@Autowired
	private ManageApplicantsDao crudDao;
	
	@Autowired
	private ManageProfileDao manageProfileDao;

	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private ProfileDAO profileDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	
	public Map<Integer, Map<String, PlacementStatsBean>> list() {
		// TODO Auto-generated method stub
		
		List<PlacementStatsBean> listBean = new ArrayList<PlacementStatsBean>();
		
		Set<Integer> company = new HashSet<Integer>();
		
		Map<Integer, Map<String, PlacementStatsBean>> result =
				new HashMap<Integer, Map<String, PlacementStatsBean>>();
		
		Map<String, PlacementStatisticsBean> branch = null;
				
		
		
		
		List<PlacementStats> list = statisticsDAO.list();
		
		//calculate(list);
		
		
		
		for( PlacementStats ps: list){
			
			if(!company.contains(ps.getCompanyId())){
				company.add(ps.getCompanyId());						
			}
			
			PlacementStatsBean temp = new PlacementStatsBean();			
			BeanUtils.copyProperties(ps,temp);
			listBean.add(temp);
			
		}
		/*
		for( Integer i: company){
			
			branch = new HashMap<String, PlacementStatisticsBean>();
			
			for(PlacementStatsBean j : listBean){
				
				
				if(j.getCompanyId() == i){
					
					if(j.getBranch().equals(COMPS)){
						branch.put(COMPS, j);
						
					}else if(j.getBranch().equals(IT)){
						branch.put(IT, j);
						
					}else if(j.getBranch().equals(ELEX)){
						branch.put(ELEX, j);
						
					}else if(j.getBranch().equals(PROD)){
						branch.put(PROD, j);
						
					}
					
					
				}
				
			}
			
			result.put(i, branch);
			
		}
		*/
		
		return result;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOnce(PlacementStatsBean statisticsBean){
				
		
		
		// fetch branch-wise list of usernames
		Map<String, Set<String>> result = profileDao.totalStudents(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
		
		for(String i: BRANCHES){
			
			//statisticsBean.setBranch(i);		
			//statisticsBean.setTotalNoOfStudents(result.get(i).size());
			PlacementStats placementStatistics= new PlacementStats();
			BeanUtils.copyProperties(statisticsBean,placementStatistics);
			statisticsDAO.add(placementStatistics);
		}
		
		
		
		// get current year
		
		
		//statisticsBean.setCreatedBy((String)request.getSession(true).getAttribute("userName"));
		//statisticsBean.setCreatedDate(new Date());
		//statisticsBean.setModifiedBy("");
		//statisticsBean.setModifiedDate(null);
		//statisticsBean.setNoApplied(3);
		//statisticsBean.setNoDualPlaced(1);
		//statisticsBean.setNoJoined(3);
		
		
		
		
		
		
	}
	
	/*
	 * ALGORITHM FOR CALCULATING STATISTICS
	 * ALGORITHM
1.company_id and company_name will be hardcoded in DB

2.get details from placement_statistics_schema.placement_statistics in service. If values are empty in its fields, then goto 3 else goto 4

3.
A.get details of no_applied
get details from job_schema.applicant_company
<<<<<<< HEAD
This gives count(username) group by branch where branch=�Computer Engineering� company=�companyName�
=======
This gives count(username) group by branch where branch=�Computer Engineering� company=�companyName�
>>>>>>> c728019207724db2fa8826f5f30b727a59ec25b8
similarly for it,prod,elex

Set the values branch,  no_applied in the table;

B.get details of total_no_of_students
get details from user_schema.professional_profile
<<<<<<< HEAD
This gives count(username) group by branch  where branch=�Computer Engineering�
=======
This gives count(username) group by branch  where branch=�Computer Engineering�
>>>>>>> c728019207724db2fa8826f5f30b727a59ec25b8
similarly for it,prod,elex

Set the values   total_no_of_students in the table;

C.no_selected
get details from placement_statistics_schema.quick_stats
<<<<<<< HEAD
count(username) group by branch where branch=�Computer Engineering� company=�companyName�

Set the values no_selected in the table;

D. no_joined leave blank�
=======
count(username) group by branch where branch=�Computer Engineering� company=�companyName�

Set the values no_selected in the table;

D. no_joined leave blank�
>>>>>>> c728019207724db2fa8826f5f30b727a59ec25b8

E. no_dual_placed

In in placement_statistics_schema.quick_stats :-
for each branch
for each username:
		If  count(company_id) > 1 :
			No_dual_placed ++ 
	
Set the values no_dual_placed in the table;

4.once all values are set , Get each row and store in bean.
Return list of beans to front end. Done (y)

	 */
	
	
	public void calculate(List<PlacementStatistics> list){
		
		
		Set<Integer> companySet = new HashSet<Integer>();
		Map<Integer, String> companyMap = new LinkedHashMap<Integer, String>();
		
		Set<Integer> applicantSet = new HashSet<Integer>();		
		List<UserCompany> noAppliedList = null;
		Map<Integer, Integer> noAppliedMap = new LinkedHashMap<Integer, Integer>();
		
		
		//generate set of company id in company
		List<Company> companyList= companyDao.getCompany();
				System.out.println("size="+companyList.size());
		
		
		//Set<Integer> statisticsSet = new HashSet<Integer>();
		
		
		
		// 
		
		for(Company cb: companyList){
			
			companySet.add(cb.getCompany_id());
			companyMap.put(cb.getCompany_id(), cb.getCompany_name());
		}
		
		System.out.println("from company = "+companySet.toString());
		
		//generate set of company id in applicant_company
		applicantSet = crudDao.retrieveCompanyId();
		
		System.out.println("from applicant = "+applicantSet.toString());
		
		Iterator<Integer> i = companySet.iterator();
		while(i.hasNext()){
			if(!applicantSet.contains(i.next())){
				Integer te = i.next();
				companySet.remove(i.next());
			}
			
		}
		
		// set of companies which will be displayed in Stats table
		System.out.println("RESULT = "+companySet.toString());		
		
		// fetch branch-wise list of usernames
		Map<String, Set<String>> result = profileDao.totalStudents(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
				
		//SUCCESSFULL
		//System.out.println("COMPS = "+result.get(COMPS).toString());		
		
		
		
		//continue calculations
		// no applied
		
		//Iterator<Entry<Integer, String>> j = companyMap.entrySet().iterator();
		
		/*
		companySet = companyMap.keySet();
		i = companySet.iterator();
		
		while(i.hasNext()){
			Integer j = i.next();
			System.out.println("k : "+j+" v: "+crudDao.retreiveDetails(companyMap.get(j)).size());
			noAppliedMap.put( j, crudDao.retreiveDetails(companyMap.get(j)).size()); 
			
		}
		
		System.out.println("noAppliedMap = "+noAppliedMap.toString());
		*/
		
		
		
	}
	
	public Map<Integer, String> getCompanyMap(){
		Map<Integer, String> companyMap = new LinkedHashMap<Integer, String>();
		List<Company> companyList= companyDao.getCompany();
		for(Company cb: companyList){
					
			companyMap.put(cb.getCompany_id(), cb.getCompany_name());
		}
		return companyMap;
		
	}
	
	@Override
	public void calculateTotal(String year) {
		statisticsDAO.calculateTotal(year);
	}

	@Override
	public TotalNoOfStudents getTotalNoOfStudents(String year) {
		return statisticsDAO.getTotalNoOfStudents(year);
	}
	
	@Override
	public List<QuickStats> getQuickStatsList(String year) {
		return statisticsDAO.getQuickStatsList(year);
	}

	@Override
	public List<PlacementStats> getPlacementStatsList(String year) {
		return statisticsDAO.getPlacementStatsList(year);
	}

}
