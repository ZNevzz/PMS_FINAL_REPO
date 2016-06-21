package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

import org.crce.interns.beans.InterestedInHigherStudiesBean;
import org.crce.interns.beans.InternshipPlacedBean;
import org.crce.interns.beans.PlacementStatisticsBean;
import org.crce.interns.beans.PlacementStatsBean;
import org.crce.interns.model.InterestedInHigherStudies;
import org.crce.interns.model.InternshipPlaced;
import org.crce.interns.model.TotalNoOfStudents;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.HigherStudiesService;
import org.crce.interns.service.InternshipPlacedService;
import org.crce.interns.service.StatisticsService;
import org.crce.interns.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatisticsController {

	@Autowired
	private InternshipPlacedService ipservice;
		
	@Autowired
	private HigherStudiesService hsservice;
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private CheckRoleService crService;
	
	@Autowired
	private StatisticsService statisticsService;
        
        private static final Logger logger = Logger.getLogger(StatisticsController.class.getName());
	
	@RequestMapping(value="/addStatistics", method = RequestMethod.GET)
	public ModelAndView addStatistics(HttpServletRequest request) {
		
		PlacementStatsBean statisticsBean = new PlacementStatsBean();
		
		statisticsBean.setCompanyId(1010);		
		statisticsBean.setYear("2016");

		statisticsService.addOnce(statisticsBean);
		
		return null;		
		
	}
	
	@RequestMapping(value="/viewStatistics", method = RequestMethod.GET)
	public ModelAndView viewStatistics(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("viewStats");
		
		//statisticsService.calculateTotal("2016");
		
		Map<Integer, Map<String, PlacementStatsBean>> result = 
		statisticsService.list();
		
		//model.addObject("companyMap", statisticsService.getCompanyMap());
		model.addObject("table", result);
		
		return model;
	}
	
	@RequestMapping(value="/calculateTotalStudents", method = RequestMethod.GET)
	public ModelAndView calculateTotalStudents(HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("stats");
		statisticsService.calculateTotal("2016");
		return model;
	}
	
	@RequestMapping(value="/addH", method = RequestMethod.GET)
	public ModelAndView addStatistic(HttpServletRequest request) {
		
		return new ModelAndView("addH");
		 
	}

	
	@RequestMapping(value = "/saveH", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam Map<String,String > r){
			ModelAndView model=new ModelAndView("redirect:/listH");
				
			InterestedInHigherStudiesBean ihs=new InterestedInHigherStudiesBean();
			 InternshipPlacedBean ips=new InternshipPlacedBean();
//System.out.println(r.get("comps"));
                         logger.error(r.get("comps"));
			 ihs.setComps(r.get("comps"));
			 //System.out.println(ihs.getComps());
                         logger.error(ihs.getComps());   
			 ihs.setElex(r.get("elex"));
			 ihs.setIt(r.get("it"));
			 ihs.setProd(r.get("prod"));
			 ihs.setYear(r.get("year"));
			//System.out.println("@@@@@"+ihs.getYear());
                            logger.error("@@@@@"+ihs.getYear());
			 ips.setComps(r.get("compss"));
			 ips.setElex(r.get("elexs"));
			 ips.setIt(r.get("its"));
			 ips.setProd(r.get("prods"));
			 ips.setYear(r.get("years"));
			
			 hsservice.addHS(ihs);

			 
			 ipservice.addIP(ips);
			 
			 
			 
            return model;
}

	@RequestMapping(value="/listH", method = RequestMethod.GET)
	 public ModelAndView listEmployees(@RequestParam("year") String curYear) {
		
		return new ModelAndView("addH");

		 
	 }
	
	private List<InterestedInHigherStudiesBean> prepareListofBean(List<InterestedInHigherStudies> ihs){
		  List<InterestedInHigherStudiesBean> beans = null;
		  if(ihs != null && !ihs.isEmpty()){
		   beans = new ArrayList<InterestedInHigherStudiesBean>();
		   InterestedInHigherStudiesBean bean = null;
		   for(InterestedInHigherStudies e : ihs){
		    bean = new InterestedInHigherStudiesBean();
		   bean.setComps(e.getComps());
		   bean.setElex(e.getElex());
		   bean.setIt(e.getIt());
		   bean.setProd(e.getProd());
		   bean.setYear(e.getYear());
		    beans.add(bean);
		   }
		  }
		  return beans;
		 }

	 private List<InternshipPlacedBean> prepareListofIBean(List<InternshipPlaced> ihs){
		  List<InternshipPlacedBean> beans = null;
		  if(ihs != null && !ihs.isEmpty()){
		   beans = new ArrayList<InternshipPlacedBean>();
		   InternshipPlacedBean bean = null;
		   for(InternshipPlaced e : ihs){
		    bean = new InternshipPlacedBean();
		   bean.setComps(e.getComps());
		   bean.setElex(e.getElex());
		   bean.setIt(e.getIt());
		   bean.setProd(e.getProd());
		   bean.setYear(e.getYear());
		    beans.add(bean);
		   }
		  }
		  return beans;
		 }


	
}
