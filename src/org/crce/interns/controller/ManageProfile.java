package org.crce.interns.controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.JobBean;
import org.crce.interns.model.Job;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.CompanyService;
//import org.crce.interns.model.Allotment;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.service.ManageProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * Author: Cheryl
 * Classes Used: ManageProfileService, CheckRoleService
 * 				 Job,Criteria,Company,JobBean,CriteriaBean,ComanyBean
 * 
 * Description: This controller is used to add,save and view Job Profiles by TPO.
 * 				Also the date entries need to be done differently since database 
 * 				value is of type date. This controller manages data entries for 3 
 * 				different tables job,criteria and company
 */

@Controller
public class ManageProfile extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 299371520070307716L;
	
	@Autowired
	private ManageProfileService manageProfileService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CheckRoleService crService;
	
	/*
	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
	*/
	
	

	// Save new job profile
		@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
		public ModelAndView addProfile(HttpServletRequest request,@RequestParam Map<String, String> r) throws Exception {
		
		try{
		JobBean jobBean = new JobBean();
		CriteriaBean criteriaBean = new CriteriaBean();
		CompanyBean companyBean = new CompanyBean();

		//Set values for JobBean
		//jobBean.setJob_id(r.get("job_id"));
		jobBean.setJob_id(r.get("company_id"));
		//jobBean.setEvent_id(r.get("event_id"));
		jobBean.setJob_description(r.get("job_description"));
		jobBean.setJob_category(r.get("job_category"));
		jobBean.setCtc(r.get("ctc"));
		jobBean.setSkills_required(r.get("skills_required"));
		jobBean.setDocs_required(r.get("docs_required"));

		/* Modified_date cannot be added initially hence null else
		 * error occurs during database insertion
		 */
		jobBean.setModified_date(null);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date(); 
		/** Below comments are trials for fixing the date accepting issue....ignore them*/
		
		//Date sdf=new Date();
		//DateFormat sdf = new SimpleDateFormat("");
		//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//jobBean.setDrive_date(Date("drive_date"));
		
		//if(sdf.parse(r.get("drive_date"))==null)
		//	jobBean.setDrive_date(null);
		
		//else
		
		
		jobBean.setDrive_date(sdf.parse(r.get("drive_date")));
				
		//jobBean.setCreated_by(r.get("created_by"));
		
		jobBean.setCreated_by((String)request.getSession(true).getAttribute("userName"));
		
		//jobBean.setCreated_date(sdf.parse(r.get("created_date")));
		
		jobBean.setCreated_date(date);
		jobBean.setModified_by(r.get("modified_by"));
		
		//jobBean.setModified_date(sdf.parse(r.get("modified_date")));

		
		//Set values for CriteriaBean
		
		//criteriaBean.setCriteria_id(Integer.parseInt(r.get("criteria_id")));
		criteriaBean.setCriteria_id(Integer.parseInt(r.get("company_id")));
		//criteriaBean.setCriteria_id(Integer.parseInt(r.get("company_id")));
		criteriaBean.setEligible_branches(r.get("eligible_branches"));
		criteriaBean.setEligible_branches(r.get("eligible_branches"));
		criteriaBean.setYear_of_passing(r.get("year_of_passing"));
		criteriaBean.setPlaced_students_allowed(r.get("placed_students_allowed"));
		criteriaBean.setPercentage(r.get("percentage"));
		criteriaBean.setCgpa(r.get("cgpa"));
		criteriaBean.setNo_of_live_kts_allowed(r.get("no_of_live_kts_allowed"));
		criteriaBean.setNo_of_dead_kts_allowed(r.get("no_of_dead_kts_allowed"));
		criteriaBean.setYear_gap_allowed(r.get("year_gap_allowed"));
		criteriaBean.setSsc_percentage(r.get("ssc_percentage"));
		criteriaBean.setHsc_or_dip_percentage(r.get("hsc_or_dip_percentage"));
		criteriaBean.setLast_date_to_apply(sdf.parse(r.get("last_date_to_apply")));
		
		
		//Set values for CompanyBean
		
		//companyBean.setCompany_id(Integer.parseInt(r.get("company_id")));
		//companyBean.setCompany_name(r.get("company_name"));
		//companyBean.setCompany_address(r.get("company_address"));
		
		/*
		 * Since criteria_id is foreign key for company it has to be
		 * set by fetching it from criteriaBean
		 */
		
		//companyBean.setCriteria_id(criteriaBean.getCriteria_id());
		
		//companyBean.setCriteria(criteriaBean.getCriteria_id());
		
		
		manageProfileService.addProfile(jobBean);
		manageProfileService.addProfile(criteriaBean);
		//manageProfileService.addProfile(companyBean);

		return new ModelAndView("TPO");
		}
		catch(Exception e){
			System.out.println(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/saveProfile");
			return model;
		}
	}

		
	//Create new job profile
	@RequestMapping(value = "/addProfile", method = RequestMethod.GET)
	public ModelAndView createProfile(Model model) {
		
		try{
		// ProfileBean profileBean = new ProfileBean();
		/*
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageProfile", roleId))
			return new ModelAndView("403");
		else
		*/
		{
			JobBean jobBean = new JobBean(); // declaring
			CriteriaBean criteriaBean = new CriteriaBean();
			CompanyBean companyBean = new CompanyBean();

			model.addAttribute("profileBean", jobBean); // adding in model
			model.addAttribute("profileBean", criteriaBean);
			//model.addAttribute("profileBean", companyBean);
		
			System.out.println("In Profile Controller");
			return new ModelAndView("addProfile");
		}
		}
		catch(Exception e){
			System.out.println(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("exception", "/addProfile");
			return model1;
		}
		}
	
	
	
	//Method to view the job profile
	
	/*@RequestMapping(value="/viewProfile", method = RequestMethod.GET)
	
	public ModelAndView listProfile(HttpServletRequest request) {
		
		
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageProfile", roleId))
			return new ModelAndView("403");
		else
		
		{
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("profiles",  prepareListofBean(manageProfileService.listProfile()));
			return new ModelAndView("viewJobProfile", model);
		}
	}
	*/
	
	@RequestMapping(value="/viewProfile", method = RequestMethod.GET)
	public ModelAndView listProfile() {
	
	try{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profiles",  prepareListofBean(manageProfileService.listProfile()));
		//return new ModelAndView("viewProfile", model);
		return new ModelAndView("CompaniesPage", model);
	}
	catch(Exception e){
		System.out.println(e);
		ModelAndView model1=new ModelAndView("500");
		model1.addObject("exception", "/viewProfile");
		return model1;
	}
	}
	
	@RequestMapping(value="/Company/companyname/{companyname}", method = RequestMethod.GET)
	public ModelAndView Companies(@PathVariable String companyname) {
		
	try{
		ModelAndView model ;
		model = null;
		// 1. get company list using getCompany from company dao
		// 2. iterate company list and select a new company bean which matches with String companyname
		// 3. model.addObject() the new company bean
		/*
		 * for(Company c: list)
		 * 
		 * 
		 */
		
		//List<CompanyBean> clist = companyService.getCompany();
		List<CompanyBean> clist = manageProfileService.listCompanies();
		//CompanyBean cb = new CompanyBean();
		
		System.out.println(clist.size());
		
		for( CompanyBean cb: clist){
			System.out.println("Clist company name "+cb.getCompany_name());
			System.out.println("Company Name "+companyname);
			if(companyname.equalsIgnoreCase(cb.getCompany_name())){
		//f(cb.getCompany_name().equalsIgnoreCase(companyname)){
				model.addObject("company", cb);
			}
		}
		
	
		
		model = new ModelAndView("Company");
		return model;
	}
	catch(Exception e){
		System.out.println(e);
		ModelAndView model1=new ModelAndView("500");
		model1.addObject("exception", "/Company/companyname/{companyname}");
		return model1;
	}
		
	}
	
	
	
	@RequestMapping(value="/JobPosts/companyname/{companyname}", method = RequestMethod.GET)
	public ModelAndView JobPosting1(@PathVariable String companyname) {
		
	try{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("profiles",  prepareListofBean(manageProfileService.listProfile()));
		return new ModelAndView("JobPosts", model);
		//return new ModelAndView("CompaniesPage", model);
	}
	catch(Exception e){
		System.out.println(e);
		ModelAndView model1=new ModelAndView("500");
		model1.addObject("exception", "/JobPosts/companyname/{companyname}");
		return model1;
	}
	}
	
	
	private List<JobBean> prepareListofBean(List<Job> profiles) {
		
		List<JobBean> beans = null;
		if(profiles != null && !profiles.isEmpty())
		{
			beans = new ArrayList<JobBean>();
			JobBean bean = null;
			
			
			for(Job profile : profiles)
			{
				bean = new JobBean();
				bean.setJob_id(profile.getJob_id());
				bean.setEvent_id(profile.getEvent_id());
				bean.setJob_description(profile.getJob_description());
				bean.setJob_category(profile.getJob_category());
				bean.setCtc(profile.getCtc());
				bean.setSkills_required(profile.getSkills_required());
				bean.setDocs_required(profile.getDocs_required());
				
				//bean.setJob_id(profile.getDrive_date());
				//bean.setJob_id(profile.getCreated_date());
				//bean.setJob_id(profile.getCreated_by());
				//bean.setJob_id(profile.getModified_date());
				//bean.setJob_id(profile.getModified_by());

				
				beans.add(bean);			
			}
		}
		return beans;
	}

	
	
}
