/*package org.crce.interns.controller;

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
import org.crce.interns.service.ConstantValues;
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


 * Author: Cheryl
 * Classes Used: ManageProfileService, CheckRoleService
 * 				 Job,Criteria,Company,JobBean,CriteriaBean,ComanyBean
 * 
 * Description: This controller is used to add,save and view Job Profiles by TPO.
 * 				Also the date entries need to be done differently since database 
 * 				value is of type date. This controller manages data entries for 3 
 * 				different tables job,criteria and company
 

@Controller
public class ManageProfile extends HttpServlet implements ConstantValues{

	*//**
		* 
		*/
/*
private static final long serialVersionUID = 299371520070307716L;

@Autowired
private ManageProfileService manageProfileService;
@Autowired
private CompanyService companyService;
@Autowired
private CheckRoleService crService;


@RequestMapping("/")
public ModelAndView welcome() {
return new ModelAndView("index");
}




// Save new job profile
@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)

// public ModelAndView addProfile(@ModelAttribute("profileBean")ProfileBean
// profileBean,BindingResult result) {


public ModelAndView addProfile(HttpServletRequest request,@RequestParam Map<String, String> r) throws Exception {

	// manageProfileService.addProfile(profileBean);

// Create instance of JobBean, CriteriaBean, CompanyBean
	
JobBean jobBean = new JobBean();
CriteriaBean criteriaBean = new CriteriaBean();
CompanyBean companyBean = new CompanyBean();

//Set values for JobBean
jobBean.setJob_id(r.get("job_id"));
jobBean.setEvent_id(r.get("event_id"));
jobBean.setJob_description(r.get("job_description"));
jobBean.setJob_category(r.get("job_category"));
jobBean.setCtc(r.get("ctc"));
jobBean.setSkills_required(r.get("skills_required"));
jobBean.setDocs_required(r.get("docs_required"));

 Modified_date cannot be added initially hence null else
 * error occurs during database insertion
 
jobBean.setModified_date(null);

SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

*//** Below comments are trials for fixing the date accepting issue....ignore them*//*
																					
																					//Date sdf=new Date();
																					//DateFormat sdf = new SimpleDateFormat("");
																					//DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
																					//jobBean.setDrive_date(Date("drive_date"));
																					
																					//if(sdf.parse(r.get("drive_date"))==null)
																					//	jobBean.setDrive_date(null);
																					
																					//else
																					
																					
																					jobBean.setDrive_date(sdf.parse(r.get("drive_date")));
																					
																					jobBean.setCreated_by(r.get("created_by"));
																					jobBean.setCreated_date(sdf.parse(r.get("created_date")));
																					jobBean.setModified_by(r.get("modified_by"));
																					
																					//jobBean.setModified_date(sdf.parse(r.get("modified_date")));
																					
																					
																					//Set values for CriteriaBean
																					
																					criteriaBean.setCriteria_id(Integer.parseInt(r.get("criteria_id")));
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
																					
																					companyBean.setCompany_id(Integer.parseInt(r.get("company_id")));
																					companyBean.setCompany_name(r.get("company_name"));
																					companyBean.setCompany_address(r.get("company_address"));
																					
																					
																					* Since criteria_id is foreign key for company it has to be
																					* set by fetching it from criteriaBean
																					
																					
																					companyBean.setCriteria_id(criteriaBean.getCriteria_id());
																					
																					//companyBean.setCriteria(criteriaBean.getCriteria_id());
																					
																					
																					manageProfileService.addProfile(jobBean);
																					manageProfileService.addProfile(criteriaBean);
																					manageProfileService.addProfile(companyBean);
																					
																					return new ModelAndView("TPO");
																					}
																					
																					
																					//Create new job profile
																					@RequestMapping(value = "/addProfile", method = RequestMethod.GET)
																					public ModelAndView createProfile(Model model) {
																					
																					// ProfileBean profileBean = new ProfileBean();
																					
																					HttpSession session=request.getSession();
																					String roleId=(String)session.getAttribute("roleId");
																					if(!crService.checkRole("ManageProfile", roleId))
																					return new ModelAndView("403");
																					else
																					
																					{
																					JobBean jobBean = new JobBean(); // declaring
																					CriteriaBean criteriaBean = new CriteriaBean();
																					CompanyBean companyBean = new CompanyBean();
																					
																					model.addAttribute("profileBean", jobBean); // adding in model
																					model.addAttribute("profileBean", criteriaBean);
																					model.addAttribute("profileBean", companyBean);
																					
																					System.out.println("In Profile Controller");
																					return new ModelAndView("addProfile");
																					}
																					}
																					
																					
																					//Method to view the job profile
																					
																					@RequestMapping(value="/viewProfile", method = RequestMethod.GET)
																					
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
																					
																					
																					@RequestMapping(value="/CompaniesPage", method = RequestMethod.GET)
																					public ModelAndView listProfile() {
																					Map<String, Object> model = new HashMap<String, Object>();
																					//model.put("profiles",  prepareListofBean(manageProfileService.listProfile()));
																					//return new ModelAndView("viewProfile", model);
																					return new ModelAndView("CompaniesPage");
																					}
																					
																					@RequestMapping(value="/Company/companyname/{companyname}", method = RequestMethod.GET)
																					public ModelAndView Companies(@PathVariable String companyname) {
																					ModelAndView model ;
																					model = null;
																					// 1. get company list using getCompany from company dao
																					// 2. iterate company list and select a new company bean which matches with String companyname
																					// 3. model.addObject() the new company bean
																					
																					* for(Company c: list)
																					* 
																					* 
																					
																					
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
																					
																					
																					
																					
																					
																					
																					
																					@RequestMapping(value="/JobPosts/companyname/{companyname}", method = RequestMethod.GET)
																					public ModelAndView JobPosting1(@PathVariable String companyname) {
																					Map<String, Object> model = new HashMap<String, Object>();
																					model.put("profiles",  prepareListofBean(manageProfileService.listProfile()));
																					return new ModelAndView("JobPosts", model);
																					//return new ModelAndView("CompaniesPage", model);
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
																					
																					* added by @ZNevzz : status = working
																					* 
																					
																					@RequestMapping(value="/Company", method = RequestMethod.GET)
																					public ModelAndView test(
																					@RequestParam("companyname") String companyname
																					
																					) {
																					ModelAndView model ;
																					model = new ModelAndView("Company");
																					//model = null;
																					// 1. get company list using getCompany from company dao
																					// 2. iterate company list and select a new company bean which matches with String companyname
																					// 3. model.addObject() the new company bean
																					
																					* for(Company c: list)
																					* 
																					* 
																					
																					
																					//List<CompanyBean> clist = companyService.getCompany();
																					List<CompanyBean> clist = manageProfileService.listCompanies();
																					//CompanyBean cb = new CompanyBean();
																					
																					System.out.println(clist.size());
																					
																					
																					System.out.println("Company Name "+companyname);
																					
																					for( CompanyBean cb: clist){
																					System.out.println("Clist company name "+cb.getCompany_name());
																					
																					
																					
																					if(companyname.equals(cb.getCompany_name())){
																					
																					System.out.println("inside IF"+cb.getCompany_name());
																					model.addObject("company", cb);
																					
																					}
																					}
																					
																					if(companyname.equals(JPM)){
																					model.addObject("link", JPM_LINK);
																					
																					}else if(companyname.equals(DIRECTI)){
																					model.addObject("link", DIRECTI_LINK);
																					
																					}else if(companyname.equals(MS)){
																					model.addObject("link", MS_LINK);
																					
																					}else if(companyname.equals(TCS)){
																					model.addObject("link", TCS_LINK);
																					
																					}else if(companyname.equals(ACC)){
																					model.addObject("link", ACC_LINE);
																					
																					}else if(companyname.equals(ZS)){
																					model.addObject("link", ZS_LINK);
																					
																					}else if(companyname.equals(GOD)){
																					model.addObject("link", GOD_LINK);
																					
																					}else if(companyname.equals(LNT)){
																					model.addObject("link", LNT_LINK);
																					
																					}
																					
																					
																					// this was the error why the EL wasn't working. We were creating another object
																					//model = new ModelAndView("Company");
																					
																					return model;
																					
																					
																					}
																					
																					
																					}
																					*/

package org.crce.interns.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

//import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.JobBean;
import org.crce.interns.model.Job;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.CompanyService;
import org.crce.interns.service.ConstantValues;
//import org.crce.interns.model.Allotment;
//import org.crce.interns.beans.ProfileBean;
import org.crce.interns.service.ManageProfileService;
import org.crce.interns.service.NfService;
import org.crce.interns.service.impl.EmailNotificationServiceImpl;
import org.crce.interns.validators.CriteriaFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
public class ManageProfile extends HttpServlet implements ConstantValues {

	/**
	 * 
	 */
	private static final long serialVersionUID = 299371520070307716L;

	@Autowired
	private ManageProfileService manageProfileService;

	@Autowired
	private CompanyService companyService;
	
	//@Autowired
	//private JobValidator jobValidator;
	
	@Autowired
	private CriteriaFormValidator critValidator;

	@Autowired
	private CheckRoleService crService;

	@Autowired
	private NfService nfService;

	@Autowired
	private EmailNotificationServiceImpl emailNotificationService;
        
        private static final Logger logger = Logger.getLogger(ManageProfile.class.getName());

/*	
	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
*/
	
	/* -----------------------------------------------------------------------------------------------------------------  */

		// Save new job profile
	
		@RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
		public ModelAndView addProfile(HttpServletRequest request,@RequestParam Map<String, String> r /*,
				@Valid JobBean jobBean,BindingResult bindingResult,@Valid CriteriaBean criteriaBean,BindingResult bindingResult2*/) throws Exception {
		
		try{
				JobBean jobBean = new JobBean();
				CriteriaBean criteriaBean = new CriteriaBean();
				CompanyBean companyBean = new CompanyBean();

				//Set values for JobBean
				//jobBean.setJob_id(r.get("job_id"));
				jobBean.setJob_id(r.get("company_id"));
				jobBean.setEvent_id(r.get("company_id"));
				jobBean.setJob_description(r.get("job_description"));
				jobBean.setJob_category(r.get("job_category"));
				jobBean.setCtc(r.get("ctc"));
				jobBean.setSkills_required(r.get("skills_required"));
				jobBean.setDocs_required(r.get("docs_required"));

				/* Modified_date cannot be added initially hence null else
				 * error occurs during database insertion
				 */
				jobBean.setModified_date(null);
		
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
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
		
				jobBean.setYear(Integer.toString(Calendar.getInstance().get(Calendar.YEAR)));
		
				//jobBean.setModified_date(sdf.parse(r.get("modified_date")));

		
				//Set values for CriteriaBean
		
				//criteriaBean.setCriteria_id(Integer.parseInt(r.get("criteria_id")));
				criteriaBean.setCriteria_id(Integer.parseInt(r.get("company_id")));
				//System.out.println(criteriaBean.getCriteria_id());
                                logger.error(criteriaBean.getCriteria_id());
				
				//criteriaBean.setEligible_branches(r.get("eligible_branches"));
				//System.out.println(r.get("eligible_branches"));
		
				String[] val = request.getParameterValues("eligible_branches");
				String e="";
				for(String i: val){
									e=e+" , "+i;
					}
		
				criteriaBean.setEligible_branches(e);
		
				criteriaBean.setYear_of_passing(r.get("year_of_passing"));
				criteriaBean.setPlaced_students_allowed(r.get("placed_students_allowed"));
				//System.out.println("Placed :::<<"+r.get("placed_students_allowed")+">>>");
                                logger.error("Placed :::<<"+r.get("placed_students_allowed")+">>>");    
				criteriaBean.setPercentage(r.get("percentage"));
				criteriaBean.setCgpa(r.get("cgpa"));
				criteriaBean.setNo_of_live_kts_allowed(r.get("no_of_live_kts_allowed"));
				criteriaBean.setNo_of_dead_kts_allowed(r.get("no_of_dead_kts_allowed"));
				criteriaBean.setYear_gap_allowed(r.get("year_gap_allowed"));
				criteriaBean.setSsc_percentage(r.get("ssc_percentage"));
				criteriaBean.setHsc_or_dip_percentage(r.get("hsc_or_dip_percentage"));
				criteriaBean.setLast_date_to_apply(sdf.parse(r.get("last_date_to_apply")));
				
				/*
				
				jobValidator.validate(jobBean, bindingResult);
				critValidator.validate(criteriaBean, bindingResult2);
				
				if(bindingResult.hasErrors()||bindingResult2.hasErrors())
				{
					if(bindingResult2.hasErrors())
						System.out.println("Criteria has errors");
					else
						System.out.println("Job bean has errors");
					List<CompanyBean> companyList = manageProfileService.listCompanies();
				    Map<Integer, String> companyMap = new LinkedHashMap<Integer,String>();
				            for(CompanyBean cb : companyList){
				            	companyMap.put(cb.getCompany_id(), cb.getCompany_name());
				            }
					
				    ModelAndView model = new ModelAndView("addProfile","companies",companyMap);
				    //model.addObject("success", 1);
					return model;
				}
				
				
				*/
				
				
				
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
		
				/* @author Nevil Dsouza
				 * code for notifications
				 */
		
				List<CompanyBean> clist = manageProfileService.listCompanies();
				String companyName="";
				int id = Integer.parseInt(jobBean.getJob_id()); 
				for( CompanyBean cb: clist){
						if(cb.getCompany_id()==id){
							companyName = cb.getCompany_name();
						}
			
				}
		
				
		
				if(nfService.addNotificationForJobPost(companyName)){
					System.out.println("notification added");
				}
				else{
					System.out.println("notification not added");
				}
				//emailNotificationService.sendEmailNotification(receivers, category, message);
		
				manageProfileService.addProfile(jobBean);
				manageProfileService.addProfile(criteriaBean);
				//manageProfileService.addProfile(companyBean);
		
		
				
				
				//List<CompanyBean> companyList = manageProfileService.listCompanies();
			    Map<Integer, String> companyMap = new LinkedHashMap<Integer,String>();
			            for(CompanyBean cb : clist){
			            	companyMap.put(cb.getCompany_id(), cb.getCompany_name());
			            }
				
			    ModelAndView model = new ModelAndView("addProfile","companies",companyMap);
			    model.addObject("success", 1);
				return model;
		
				//ModelAndView model = new ModelAndView("addProfile");
				//model.addObject("success", 1);
				//return model;
				
		
				//return new ModelAndView("TPO");
		}
		catch(Exception e){
			//System.out.println(e);
                    logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/saveProfile");
			return model;
		}
	}

	/* ---------------------------------------------------------------------------------------------------------------- */
		
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
		
						//System.out.println("In Profile Controller");
						
						List<CompanyBean> companyList = manageProfileService.listCompanies();
					    Map<Integer, String> companyMap = new LinkedHashMap<Integer,String>();
					            for(CompanyBean cb : companyList){
					            	companyMap.put(cb.getCompany_id(), cb.getCompany_name());
					            }
						
						return new ModelAndView("addProfile","companies",companyMap);
					}
				}
			catch(Exception e){
				//System.out.println(e);
                            logger.error(e);
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
		
	/* --------------------------------------------------------------------------------------------------------------- */
	
	@RequestMapping(value="/viewProfile", method = RequestMethod.GET)
	public ModelAndView listProfile(@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
	
		try{
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("profiles",  prepareListofBean(manageProfileService.listProfile(curYear)));
				//return new ModelAndView("viewProfile", model);
				return new ModelAndView("CompaniesPage", model);
			}
		catch(Exception e){
				//System.out.println(e);
                                logger.error(e);
				ModelAndView model1=new ModelAndView("500");
				model1.addObject("exception", "/viewProfile");
				return model1;
			}
	}
	
	
	/* --------------------------------------------------------------------------------------------------------------- */

		@RequestMapping(value="/CompaniesPage", method = RequestMethod.GET)
		public ModelAndView listProfile1() {
		
			try{
					Map<String, Object> model = new HashMap<String, Object>();
					//model.put("profiles",  prepareListofBean(manageProfileService.listProfile()));
					//return new ModelAndView("viewProfile", model);
					return new ModelAndView("CompaniesPage");
				}
			catch(Exception e){
					//System.out.println(e);
                                        logger.error(e);
					ModelAndView model1=new ModelAndView("500");
					model1.addObject("exception", "/CompaniesPage");
					return model1;
				}
		}
	
	/* --------------------------------------------------------------------------------------------------------------- */

	
	@RequestMapping(value="/JobPosts", method = RequestMethod.GET)

	
	public ModelAndView Companies(@RequestParam("companyname") String companyname,@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
	
		
			try{
					ModelAndView model ;
					model = null;
		
					List<CompanyBean> clist = manageProfileService.listCompanies();
					Map<Integer, String> companyMapID = new HashMap<Integer, String>();
					Map<String, Integer> companyMapName = new HashMap<String, Integer>();
		
					//CompanyBean cb = new CompanyBean();
		
					System.out.println(clist.size());
		
					CompanyBean c ;
		
					for( CompanyBean cb: clist){
						//System.out.println("Clist company name "+cb.getCompany_name());
						//System.out.println("Company Name "+companyname);
						c = new CompanyBean();
						c = cb ;
						System.out.println("C id "+c.getCompany_id());
						System.out.println("Cany Name "+c.getCompany_name());
			
						companyMapID.put(c.getCompany_id(), c.getCompany_name());
						//System.out.println("Cany map get "+companyMapID.get(c.getCompany_id()));
                                                logger.error("Cany map get "+companyMapID.get(c.getCompany_id()));
						companyMapName.put(c.getCompany_name(), c.getCompany_id());
						
						/*
							if(companyname.equalsIgnoreCase(cb.getCompany_name())){
							//f(cb.getCompany_name().equalsIgnoreCase(companyname)){
							model.addObject("company", cb);
							break;
							}
						 */
					}
		
					model = new ModelAndView("JobPosts");
		
		
					List<JobBean> jlist = manageProfileService.listJob(curYear);
					//System.out.println(jlist.size());
                                        logger.error(jlist.size());
					for( JobBean jb: jlist){
							//CompanyBean cb = new CompanyBean();
							System.out.println("Jlist job id "+jb.getJob_id());
							//if(cb.getCriteria_id().equals(jb.getJob_id())){
							//f(cb.getCompany_name().equalsIgnoreCase(companyname)){
							//System.out.println("List size "+jlist.size());
							//System.out.println("List job id "+jb.getJob_id());
							int a=Integer.parseInt(jb.getJob_id());
			
							//System.out.println(companyMapID.get(a));
                                                        logger.error(companyMapID.get(a));
			
			
							if(companyname.equalsIgnoreCase(companyMapID.get(a))){
									model.addObject("job", jb);
									break;
				
							}
					}
	
					return model;
			}
			catch(Exception e){
					//System.out.println(e);
                            logger.error(e);
					ModelAndView model1=new ModelAndView("500");
					model1.addObject("exception", "/JobPosts");
					return model1;
			}
	
		}
	
	
	/* --------------------------------------------------------------------------------------------------------------- */

	
	@RequestMapping(value="/JobPosts/companyname/{companyname}", method = RequestMethod.GET)
	public ModelAndView JobPosting1(@PathVariable String companyname,@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
		
		try{
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("profiles",  prepareListofBean(manageProfileService.listProfile(curYear)));
				return new ModelAndView("JobPosts", model);
				//return new ModelAndView("CompaniesPage", model);
			}
		catch(Exception e){
				//System.out.println(e);
				logger.error(e);
                                ModelAndView model1=new ModelAndView("500");
				model1.addObject("exception", "/JobPosts/companyname/{companyname}");
				return model1;
		}
	}
	
	
	/* --------------------------------------------------------------------------------------------------------------- */

	
		//changes
	
		/*
		 * added by @ZNevzz : status = working
		 * 
		 */
		@RequestMapping(value="/Company", method = RequestMethod.GET)
		public ModelAndView test(@RequestParam("companyname") String companyname) {
			
			try {
					
					ModelAndView model ;
					model = new ModelAndView("Company");
				
				
					List<CompanyBean> clist = manageProfileService.listCompanies();
				
					//System.out.println(clist.size());
                                        logger.error(clist.size());
				
				
					//System.out.println("Company Name "+companyname);
                                        logger.error("Company Name "+companyname);
				
					for( CompanyBean cb: clist){
						//System.out.println("Clist company name "+cb.getCompany_name());
                                            logger.error("Clist company name "+cb.getCompany_name());
					
					
					
					if(companyname.equals(cb.getCompany_name())){
							
						//System.out.println("inside IF"+cb.getCompany_name());
                                                logger.error("inside IF"+cb.getCompany_name());
						model.addObject("company", cb);
						
					}
				}
					if(companyname.equals(JPM)){

						model.addObject("link", JPM_LINK);
						
					}else if(companyname.equals(DIRECTI)){
						model.addObject("link", DIRECTI_LINK);
						
					}else if(companyname.equals(MS)){
						model.addObject("link", MS_LINK);
						
					}else if(companyname.equals(TCS)){
						model.addObject("link", TCS_LINK);
						
					}else if(companyname.equals(ACC)){
						model.addObject("link", ACC_LINE);
						
					}else if(companyname.equals(ZS)){
						model.addObject("link", ZS_LINK);
						
					}else if(companyname.equals(GOD)){
						model.addObject("link", GOD_LINK);
						
					}else if(companyname.equals(LNT)){
						model.addObject("link", LNT_LINK);
						
					}
					return model;
				

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println(e);
                                logger.error(e);
				ModelAndView model1=new ModelAndView("500");
				model1.addObject("exception", "/Company");
				return model1;
			}
		
			
		}
		/*
			// this was the error why the EL wasn't working. We were creating another object
			//model = new ModelAndView("Company");
			
		
		}

		
	/* --------------------------------------------------------------------------------------------------------------- */

	
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

/*  -------------------------------------------------------------------------------------------------------------------- */

/*package org.crce.interns.controller;

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
import org.crce.interns.service.ConstantValues;
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

>>>>>>> frcrceinterns-master

			// this was the error why the EL wasn't working. We were creating
			// another object
			// model = new ModelAndView("Company");

			return model;
		} catch (Exception e) {
			return new ModelAndView("500");
		}
	}

	private List<JobBean> prepareListofBean(List<Job> profiles) {

		List<JobBean> beans = null;
		if (profiles != null && !profiles.isEmpty()) {
			beans = new ArrayList<JobBean>();
			JobBean bean = null;

			for (Job profile : profiles) {
				bean = new JobBean();
				bean.setJob_id(profile.getJob_id());
				bean.setEvent_id(profile.getEvent_id());
				bean.setJob_description(profile.getJob_description());
				bean.setJob_category(profile.getJob_category());
				bean.setCtc(profile.getCtc());
				bean.setSkills_required(profile.getSkills_required());
				bean.setDocs_required(profile.getDocs_required());

				// bean.setJob_id(profile.getDrive_date());
				// bean.setJob_id(profile.getCreated_date());
				// bean.setJob_id(profile.getCreated_by());
				// bean.setJob_id(profile.getModified_date());
				// bean.setJob_id(profile.getModified_by());

				beans.add(bean);
			}
		}
		return beans;
	}

}

/*
 * package org.crce.interns.controller;
 * 
 * import java.text.SimpleDateFormat; import java.util.Map;
 * 
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpSession;
 * 
 * import java.util.ArrayList; import java.util.Date; import java.util.HashMap;
 * import java.util.List;
 * 
 * //import org.crce.interns.beans.AllotmentBean; import
 * org.crce.interns.beans.CompanyBean; import
 * org.crce.interns.beans.CriteriaBean; import org.crce.interns.beans.JobBean;
 * import org.crce.interns.model.Job; import
 * org.crce.interns.service.CheckRoleService; import
 * org.crce.interns.service.CompanyService; import
 * org.crce.interns.service.ConstantValues; //import
 * org.crce.interns.model.Allotment; //import
 * org.crce.interns.beans.ProfileBean; import
 * org.crce.interns.service.ManageProfileService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * 
 * Author: Cheryl Classes Used: ManageProfileService, CheckRoleService
 * Job,Criteria,Company,JobBean,CriteriaBean,ComanyBean
 * 
 * Description: This controller is used to add,save and view Job Profiles by
 * TPO. Also the date entries need to be done differently since database value
 * is of type date. This controller manages data entries for 3 different tables
 * job,criteria and company
 * 
 * 
 * @Controller public class ManageProfile extends HttpServlet implements
 * ConstantValues{
 * 
 *//**
	* 
	*/
/*
 * private static final long serialVersionUID = 299371520070307716L;
 * 
 * @Autowired private ManageProfileService manageProfileService;
 * 
 * @Autowired private CompanyService companyService;
 * 
 * @Autowired private CheckRoleService crService;
 * 
 * 
 * @RequestMapping("/") public ModelAndView welcome() { return new
 * ModelAndView("index"); }
 * 
 * 
 * 
 * 
 * // Save new job profile
 * 
 * @RequestMapping(value = "/saveProfile", method = RequestMethod.POST)
 * 
 * // public ModelAndView addProfile(@ModelAttribute("profileBean")ProfileBean
 * // profileBean,BindingResult result) {
 * 
 * 
 * public ModelAndView addProfile(HttpServletRequest request,@RequestParam
 * Map<String, String> r) throws Exception {
 * 
 * // manageProfileService.addProfile(profileBean);
 * 
 * // Create instance of JobBean, CriteriaBean, CompanyBean
 * 
 * JobBean jobBean = new JobBean(); CriteriaBean criteriaBean = new
 * CriteriaBean(); CompanyBean companyBean = new CompanyBean();
 * 
 * //Set values for JobBean jobBean.setJob_id(r.get("job_id"));
 * jobBean.setEvent_id(r.get("event_id"));
 * jobBean.setJob_description(r.get("job_description"));
 * jobBean.setJob_category(r.get("job_category")); jobBean.setCtc(r.get("ctc"));
 * jobBean.setSkills_required(r.get("skills_required"));
 * jobBean.setDocs_required(r.get("docs_required"));
 * 
 * Modified_date cannot be added initially hence null else error occurs during
 * database insertion
 * 
 * jobBean.setModified_date(null);
 * 
 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
 * 
 *//**
	 * Below comments are trials for fixing the date accepting issue....ignore
	 * them
	 */
/*
 * 
 * //Date sdf=new Date(); //DateFormat sdf = new SimpleDateFormat("");
 * //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 * //jobBean.setDrive_date(Date("drive_date"));
 * 
 * //if(sdf.parse(r.get("drive_date"))==null) // jobBean.setDrive_date(null);
 * 
 * //else
 * 
 * 
 * jobBean.setDrive_date(sdf.parse(r.get("drive_date")));
 * 
 * jobBean.setCreated_by(r.get("created_by"));
 * jobBean.setCreated_date(sdf.parse(r.get("created_date")));
 * jobBean.setModified_by(r.get("modified_by"));
 * 
 * //jobBean.setModified_date(sdf.parse(r.get("modified_date")));
 * 
 * 
 * //Set values for CriteriaBean
 * 
 * criteriaBean.setCriteria_id(Integer.parseInt(r.get("criteria_id")));
 * criteriaBean.setEligible_branches(r.get("eligible_branches"));
 * criteriaBean.setEligible_branches(r.get("eligible_branches"));
 * criteriaBean.setYear_of_passing(r.get("year_of_passing"));
 * criteriaBean.setPlaced_students_allowed(r.get("placed_students_allowed"));
 * criteriaBean.setPercentage(r.get("percentage"));
 * criteriaBean.setCgpa(r.get("cgpa"));
 * criteriaBean.setNo_of_live_kts_allowed(r.get("no_of_live_kts_allowed"));
 * criteriaBean.setNo_of_dead_kts_allowed(r.get("no_of_dead_kts_allowed"));
 * criteriaBean.setYear_gap_allowed(r.get("year_gap_allowed"));
 * criteriaBean.setSsc_percentage(r.get("ssc_percentage"));
 * criteriaBean.setHsc_or_dip_percentage(r.get("hsc_or_dip_percentage"));
 * criteriaBean.setLast_date_to_apply(sdf.parse(r.get("last_date_to_apply")));
 * 
 * 
 * //Set values for CompanyBean
 * 
 * companyBean.setCompany_id(Integer.parseInt(r.get("company_id")));
 * companyBean.setCompany_name(r.get("company_name"));
 * companyBean.setCompany_address(r.get("company_address"));
 * 
 * 
 * Since criteria_id is foreign key for company it has to be set by fetching it
 * from criteriaBean
 * 
 * 
 * companyBean.setCriteria_id(criteriaBean.getCriteria_id());
 * 
 * //companyBean.setCriteria(criteriaBean.getCriteria_id());
 * 
 * 
 * manageProfileService.addProfile(jobBean);
 * manageProfileService.addProfile(criteriaBean);
 * manageProfileService.addProfile(companyBean);
 * 
 * return new ModelAndView("TPO"); }
 * 
 * 
 * //Create new job profile
 * 
 * @RequestMapping(value = "/addProfile", method = RequestMethod.GET) public
 * ModelAndView createProfile(Model model) {
 * 
 * // ProfileBean profileBean = new ProfileBean();
 * 
 * HttpSession session=request.getSession(); String
 * roleId=(String)session.getAttribute("roleId");
 * if(!crService.checkRole("ManageProfile", roleId)) return new
 * ModelAndView("403"); else
 * 
 * { JobBean jobBean = new JobBean(); // declaring CriteriaBean criteriaBean =
 * new CriteriaBean(); CompanyBean companyBean = new CompanyBean();
 * 
 * model.addAttribute("profileBean", jobBean); // adding in model
 * model.addAttribute("profileBean", criteriaBean);
 * model.addAttribute("profileBean", companyBean);
 * 
 * System.out.println("In Profile Controller"); return new
 * ModelAndView("addProfile"); } }
 * 
 * 
 * //Method to view the job profile
 * 
 * @RequestMapping(value="/viewProfile", method = RequestMethod.GET)
 * 
 * public ModelAndView listProfile(HttpServletRequest request) {
 * 
 * 
 * HttpSession session=request.getSession(); String
 * roleId=(String)session.getAttribute("roleId");
 * if(!crService.checkRole("ManageProfile", roleId)) return new
 * ModelAndView("403"); else
 * 
 * { Map<String, Object> model = new HashMap<String, Object>();
 * model.put("profiles", prepareListofBean(manageProfileService.listProfile()));
 * return new ModelAndView("viewJobProfile", model); } }
 * 
 * 
 * @RequestMapping(value="/CompaniesPage", method = RequestMethod.GET) public
 * ModelAndView listProfile() { Map<String, Object> model = new HashMap<String,
 * Object>(); //model.put("profiles",
 * prepareListofBean(manageProfileService.listProfile())); //return new
 * ModelAndView("viewProfile", model); return new ModelAndView("CompaniesPage");
 * }
 * 
 * @RequestMapping(value="/Company/companyname/{companyname}", method =
 * RequestMethod.GET) public ModelAndView Companies(@PathVariable String
 * companyname) { ModelAndView model ; model = null; // 1. get company list
 * using getCompany from company dao // 2. iterate company list and select a new
 * company bean which matches with String companyname // 3. model.addObject()
 * the new company bean
 * 
 * for(Company c: list)
 * 
 * 
 * 
 * 
 * //List<CompanyBean> clist = companyService.getCompany(); List<CompanyBean>
 * clist = manageProfileService.listCompanies(); //CompanyBean cb = new
 * CompanyBean();
 * 
 * System.out.println(clist.size());
 * 
 * for( CompanyBean cb: clist){ System.out.println("Clist company name "
 * +cb.getCompany_name()); System.out.println("Company Name "+companyname);
 * if(companyname.equalsIgnoreCase(cb.getCompany_name())){
 * //f(cb.getCompany_name().equalsIgnoreCase(companyname)){
 * 
 * model.addObject("company", cb);
 * 
 * 
 * } }
 * 
 * 
 * model = new ModelAndView("Company"); return model;
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * @RequestMapping(value="/JobPosts/companyname/{companyname}", method =
 * RequestMethod.GET) public ModelAndView JobPosting1(@PathVariable String
 * companyname) { Map<String, Object> model = new HashMap<String, Object>();
 * model.put("profiles", prepareListofBean(manageProfileService.listProfile()));
 * return new ModelAndView("JobPosts", model); //return new
 * ModelAndView("CompaniesPage", model); }
 * 
 * 
 * private List<JobBean> prepareListofBean(List<Job> profiles) {
 * 
 * List<JobBean> beans = null; if(profiles != null && !profiles.isEmpty()) {
 * beans = new ArrayList<JobBean>(); JobBean bean = null;
 * 
 * 
 * for(Job profile : profiles) { bean = new JobBean();
 * bean.setJob_id(profile.getJob_id()); bean.setEvent_id(profile.getEvent_id());
 * bean.setJob_description(profile.getJob_description());
 * bean.setJob_category(profile.getJob_category());
 * bean.setCtc(profile.getCtc());
 * bean.setSkills_required(profile.getSkills_required());
 * bean.setDocs_required(profile.getDocs_required());
 * 
 * //bean.setJob_id(profile.getDrive_date());
 * //bean.setJob_id(profile.getCreated_date());
 * //bean.setJob_id(profile.getCreated_by());
 * //bean.setJob_id(profile.getModified_date());
 * //bean.setJob_id(profile.getModified_by());
 * 
 * 
 * beans.add(bean); } } return beans; }
 * 
 * added by @ZNevzz : status = working
 * 
 * 
 * @RequestMapping(value="/Company", method = RequestMethod.GET) public
 * ModelAndView test(
 * 
 * @RequestParam("companyname") String companyname
 * 
 * ) { ModelAndView model ; model = new ModelAndView("Company"); //model = null;
 * // 1. get company list using getCompany from company dao // 2. iterate
 * company list and select a new company bean which matches with String
 * companyname // 3. model.addObject() the new company bean
 * 
 * for(Company c: list)
 * 
 * 
 * 
 * 
 * //List<CompanyBean> clist = companyService.getCompany(); List<CompanyBean>
 * clist = manageProfileService.listCompanies(); //CompanyBean cb = new
 * CompanyBean();
 * 
 * System.out.println(clist.size());
 * 
 * 
 * System.out.println("Company Name "+companyname);
 * 
 * for( CompanyBean cb: clist){ System.out.println("Clist company name "
 * +cb.getCompany_name());
 * 
 * 
 * 
 * if(companyname.equals(cb.getCompany_name())){
 * 
 * System.out.println("inside IF"+cb.getCompany_name());
 * model.addObject("company", cb);
 * 
 * } }
 * 
 * if(companyname.equals(JPM)){ model.addObject("link", JPM_LINK);
 * 
 * }else if(companyname.equals(DIRECTI)){ model.addObject("link", DIRECTI_LINK);
 * 
 * }else if(companyname.equals(MS)){ model.addObject("link", MS_LINK);
 * 
 * }else if(companyname.equals(TCS)){ model.addObject("link", TCS_LINK);
 * 
 * }else if(companyname.equals(ACC)){ model.addObject("link", ACC_LINE);
 * 
 * }else if(companyname.equals(ZS)){ model.addObject("link", ZS_LINK);
 * 
 * }else if(companyname.equals(GOD)){ model.addObject("link", GOD_LINK);
 * 
 * }else if(companyname.equals(LNT)){ model.addObject("link", LNT_LINK);
 * 
 * }
 * 
 * 
 * // this was the error why the EL wasn't working. We were creating another
 * object //model = new ModelAndView("Company");
 * 
 * return model;
 * 
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * 
 * package org.crce.interns.controller;
 * 
 * import java.text.SimpleDateFormat; import java.util.Map;
 * 
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpSession;
 * 
 * import java.util.ArrayList; import java.util.Date; import java.util.HashMap;
 * import java.util.List;
 * 
 * //import org.crce.interns.beans.AllotmentBean; import
 * org.crce.interns.beans.CompanyBean; import
 * org.crce.interns.beans.CriteriaBean; import org.crce.interns.beans.JobBean;
 * import org.crce.interns.model.Job; import
 * org.crce.interns.service.CheckRoleService; import
 * org.crce.interns.service.CompanyService; //import
 * org.crce.interns.model.Allotment; //import
 * org.crce.interns.beans.ProfileBean; import
 * org.crce.interns.service.ManageProfileService; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * 
 * Author: Cheryl Classes Used: ManageProfileService, CheckRoleService
 * Job,Criteria,Company,JobBean,CriteriaBean,ComanyBean
 * 
 * Description: This controller is used to add,save and view Job Profiles by
 * TPO. Also the date entries need to be done differently since database value
 * is of type date. This controller manages data entries for 3 different tables
 * job,criteria and company
 * 
 * 
 * @Controller public class ManageProfile extends HttpServlet{
 * 
 *//**
	* 
	*/
/*
 * private static final long serialVersionUID = 299371520070307716L;
 * 
 * @Autowired private ManageProfileService manageProfileService;
 * 
 * @Autowired private CompanyService companyService;
 * 
 * @Autowired private CheckRoleService crService;
 * 
 * 
 * @RequestMapping("/") public ModelAndView welcome() { return new
 * ModelAndView("index"); }
 * 
 * 
 * 
 * 
 * // Save new job profile
 * 
 * @RequestMapping(value = "/saveProfile", method = RequestMethod.POST) public
 * ModelAndView addProfile(HttpServletRequest request,@RequestParam Map<String,
 * String> r) throws Exception {
 * 
 * try{ JobBean jobBean = new JobBean(); CriteriaBean criteriaBean = new
 * CriteriaBean(); CompanyBean companyBean = new CompanyBean();
 * 
 * //Set values for JobBean //jobBean.setJob_id(r.get("job_id"));
 * jobBean.setJob_id(r.get("company_id"));
 * //jobBean.setEvent_id(r.get("event_id"));
 * jobBean.setJob_description(r.get("job_description"));
 * jobBean.setJob_category(r.get("job_category")); jobBean.setCtc(r.get("ctc"));
 * jobBean.setSkills_required(r.get("skills_required"));
 * jobBean.setDocs_required(r.get("docs_required"));
 * 
 * Modified_date cannot be added initially hence null else error occurs during
 * database insertion
 * 
 * jobBean.setModified_date(null);
 * 
 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); Date date = new
 * Date();
 *//**
	 * Below comments are trials for fixing the date accepting issue....ignore
	 * them
	 *//*
	 * 
	 * //Date sdf=new Date(); //DateFormat sdf = new SimpleDateFormat("");
	 * //DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 * //jobBean.setDrive_date(Date("drive_date"));
	 * 
	 * //if(sdf.parse(r.get("drive_date"))==null) //
	 * jobBean.setDrive_date(null);
	 * 
	 * //else
	 * 
	 * 
	 * jobBean.setDrive_date(sdf.parse(r.get("drive_date")));
	 * 
	 * //jobBean.setCreated_by(r.get("created_by"));
	 * 
	 * jobBean.setCreated_by((String)request.getSession(true).getAttribute(
	 * "userName"));
	 * 
	 * //jobBean.setCreated_date(sdf.parse(r.get("created_date")));
	 * 
	 * jobBean.setCreated_date(date);
	 * jobBean.setModified_by(r.get("modified_by"));
	 * 
	 * //jobBean.setModified_date(sdf.parse(r.get("modified_date")));
	 * 
	 * 
	 * //Set values for CriteriaBean
	 * 
	 * //criteriaBean.setCriteria_id(Integer.parseInt(r.get("criteria_id")));
	 * criteriaBean.setCriteria_id(Integer.parseInt(r.get("company_id")));
	 * //criteriaBean.setCriteria_id(Integer.parseInt(r.get("company_id")));
	 * criteriaBean.setEligible_branches(r.get("eligible_branches"));
	 * criteriaBean.setEligible_branches(r.get("eligible_branches"));
	 * criteriaBean.setYear_of_passing(r.get("year_of_passing"));
	 * criteriaBean.setPlaced_students_allowed(r.get("placed_students_allowed"))
	 * ; criteriaBean.setPercentage(r.get("percentage"));
	 * criteriaBean.setCgpa(r.get("cgpa"));
	 * criteriaBean.setNo_of_live_kts_allowed(r.get("no_of_live_kts_allowed"));
	 * criteriaBean.setNo_of_dead_kts_allowed(r.get("no_of_dead_kts_allowed"));
	 * criteriaBean.setYear_gap_allowed(r.get("year_gap_allowed"));
	 * criteriaBean.setSsc_percentage(r.get("ssc_percentage"));
	 * criteriaBean.setHsc_or_dip_percentage(r.get("hsc_or_dip_percentage"));
	 * criteriaBean.setLast_date_to_apply(sdf.parse(r.get("last_date_to_apply"))
	 * );
	 * 
	 * 
	 * //Set values for CompanyBean
	 * 
	 * //companyBean.setCompany_id(Integer.parseInt(r.get("company_id")));
	 * //companyBean.setCompany_name(r.get("company_name"));
	 * //companyBean.setCompany_address(r.get("company_address"));
	 * 
	 * 
	 * Since criteria_id is foreign key for company it has to be set by fetching
	 * it from criteriaBean
	 * 
	 * 
	 * //companyBean.setCriteria_id(criteriaBean.getCriteria_id());
	 * 
	 * //companyBean.setCriteria(criteriaBean.getCriteria_id());
	 * 
	 * 
	 * manageProfileService.addProfile(jobBean);
	 * manageProfileService.addProfile(criteriaBean);
	 * //manageProfileService.addProfile(companyBean);
	 * 
	 * return new ModelAndView("TPO"); } catch(Exception e){
	 * System.out.println(e); ModelAndView model=new ModelAndView("500");
	 * model.addObject("exception", "/saveProfile"); return model; } }
	 * 
	 * 
	 * //Create new job profile
	 * 
	 * @RequestMapping(value = "/addProfile", method = RequestMethod.GET) public
	 * ModelAndView createProfile(Model model) {
	 * 
	 * try{ // ProfileBean profileBean = new ProfileBean();
	 * 
	 * HttpSession session=request.getSession(); String
	 * roleId=(String)session.getAttribute("roleId");
	 * if(!crService.checkRole("ManageProfile", roleId)) return new
	 * ModelAndView("403"); else
	 * 
	 * { JobBean jobBean = new JobBean(); // declaring CriteriaBean criteriaBean
	 * = new CriteriaBean(); CompanyBean companyBean = new CompanyBean();
	 * 
	 * model.addAttribute("profileBean", jobBean); // adding in model
	 * model.addAttribute("profileBean", criteriaBean);
	 * //model.addAttribute("profileBean", companyBean);
	 * 
	 * System.out.println("In Profile Controller"); return new
	 * ModelAndView("addProfile"); } } catch(Exception e){
	 * System.out.println(e); ModelAndView model1=new ModelAndView("500");
	 * model1.addObject("exception", "/addProfile"); return model1; } }
	 * 
	 * 
	 * 
	 * //Method to view the job profile
	 * 
	 * @RequestMapping(value="/viewProfile", method = RequestMethod.GET)
	 * 
	 * public ModelAndView listProfile(HttpServletRequest request) {
	 * 
	 * 
	 * HttpSession session=request.getSession(); String
	 * roleId=(String)session.getAttribute("roleId");
	 * if(!crService.checkRole("ManageProfile", roleId)) return new
	 * ModelAndView("403"); else
	 * 
	 * { Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("profiles",
	 * prepareListofBean(manageProfileService.listProfile())); return new
	 * ModelAndView("viewJobProfile", model); } }
	 * 
	 * 
	 * @RequestMapping(value="/viewProfile", method = RequestMethod.GET) public
	 * ModelAndView listProfile() {
	 * 
	 * try{ Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("profiles",
	 * prepareListofBean(manageProfileService.listProfile())); //return new
	 * ModelAndView("viewProfile", model); return new
	 * ModelAndView("CompaniesPage", model); } catch(Exception e){
	 * System.out.println(e); ModelAndView model1=new ModelAndView("500");
	 * model1.addObject("exception", "/viewProfile"); return model1; } }
	 * 
	 * 
	 * 
	 * @RequestMapping(value="/CompaniesPage", method = RequestMethod.GET)
	 * public ModelAndView listProfile1() { Map<String, Object> model = new
	 * HashMap<String, Object>(); //model.put("profiles",
	 * prepareListofBean(manageProfileService.listProfile())); //return new
	 * ModelAndView("viewProfile", model); return new
	 * ModelAndView("CompaniesPage"); }
	 * 
	 * @RequestMapping(value="/JobPosts", method = RequestMethod.GET) public
	 * ModelAndView Companies(@RequestParam String companyname) {
	 * 
	 * try{ ModelAndView model ; model = null;
	 * 
	 * List<CompanyBean> clist = manageProfileService.listCompanies();
	 * Map<Integer, String> companyMapID = new HashMap<Integer, String>();
	 * Map<String, Integer> companyMapName = new HashMap<String, Integer>();
	 * 
	 * //CompanyBean cb = new CompanyBean();
	 * 
	 * System.out.println(clist.size());
	 * 
	 * CompanyBean c ;
	 * 
	 * for( CompanyBean cb: clist){ //System.out.println("Clist company name "
	 * +cb.getCompany_name()); //System.out.println("Company Name "
	 * +companyname); c = new CompanyBean(); c = cb ; System.out.println("C id "
	 * +c.getCompany_id()); System.out.println("Cany Name "
	 * +c.getCompany_name());
	 * 
	 * companyMapID.put(c.getCompany_id(), c.getCompany_name());
	 * System.out.println("Cany map get "+companyMapID.get(c.getCompany_id()));
	 * companyMapName.put(c.getCompany_name(), c.getCompany_id());
	 * 
	 * if(companyname.equalsIgnoreCase(cb.getCompany_name())){
	 * //f(cb.getCompany_name().equalsIgnoreCase(companyname)){
	 * model.addObject("company", cb); break; }
	 * 
	 * }
	 * 
	 * model = new ModelAndView("JobPosts");
	 * 
	 * 
	 * List<JobBean> jlist = manageProfileService.listJob();
	 * System.out.println(jlist.size()); for( JobBean jb: jlist){ //CompanyBean
	 * cb = new CompanyBean(); System.out.println("Jlist job id "
	 * +jb.getJob_id()); //if(cb.getCriteria_id().equals(jb.getJob_id())){
	 * //f(cb.getCompany_name().equalsIgnoreCase(companyname)){
	 * //System.out.println("List size "+jlist.size()); //System.out.println(
	 * "List job id "+jb.getJob_id()); int a=Integer.parseInt(jb.getJob_id());
	 * 
	 * System.out.println(companyMapID.get(a));
	 * 
	 * 
	 * if(companyname.equalsIgnoreCase(companyMapID.get(a))){
	 * model.addObject("job", jb); break;
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * 
	 * return model; } catch(Exception e){ System.out.println(e); ModelAndView
	 * model1=new ModelAndView("500"); model1.addObject("exception",
	 * "/Company/companyname/{companyname}"); return model1; }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @RequestMapping(value="/JobPosts/companyname/{companyname}", method =
	 * RequestMethod.GET) public ModelAndView JobPosting1(@PathVariable String
	 * companyname) {
	 * 
	 * try{ Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("profiles",
	 * prepareListofBean(manageProfileService.listProfile())); return new
	 * ModelAndView("JobPosts", model); //return new
	 * ModelAndView("CompaniesPage", model); } catch(Exception e){
	 * System.out.println(e); ModelAndView model1=new ModelAndView("500");
	 * model1.addObject("exception", "/JobPosts/companyname/{companyname}");
	 * return model1; } }
	 * 
	 * 
	 * 
	 * //changes
	 * 
	 * 
	 * added by @ZNevzz : status = working
	 * 
	 * 
	 * @RequestMapping(value="/Company", method = RequestMethod.GET) public
	 * ModelAndView test(
	 * 
	 * @RequestParam("companyname") String companyname
	 * 
	 * ) { ModelAndView model ; model = new ModelAndView("Company"); //model =
	 * null; // 1. get company list using getCompany from company dao // 2.
	 * iterate company list and select a new company bean which matches with
	 * String companyname // 3. model.addObject() the new company bean
	 * 
	 * for(Company c: list)
	 * 
	 * 
	 * 
	 * 
	 * //List<CompanyBean> clist = companyService.getCompany();
	 * List<CompanyBean> clist = manageProfileService.listCompanies();
	 * //CompanyBean cb = new CompanyBean();
	 * 
	 * System.out.println(clist.size());
	 * 
	 * 
	 * System.out.println("Company Name "+companyname);
	 * 
	 * for( CompanyBean cb: clist){ System.out.println("Clist company name "
	 * +cb.getCompany_name());
	 * 
	 * 
	 * 
	 * if(companyname.equals(cb.getCompany_name())){
	 * 
	 * System.out.println("inside IF"+cb.getCompany_name());
	 * model.addObject("company", cb);
	 * 
	 * } }
	 * 
	 * if(companyname.equals(JPM)){ model.addObject("link", JPM_LINK);
	 * 
	 * }else if(companyname.equals(DIRECTI)){ model.addObject("link",
	 * DIRECTI_LINK);
	 * 
	 * }else if(companyname.equals(MS)){ model.addObject("link", MS_LINK);
	 * 
	 * }else if(companyname.equals(TCS)){ model.addObject("link", TCS_LINK);
	 * 
	 * }else if(companyname.equals(ACC)){ model.addObject("link", ACC_LINE);
	 * 
	 * }else if(companyname.equals(ZS)){ model.addObject("link", ZS_LINK);
	 * 
	 * }else if(companyname.equals(GOD)){ model.addObject("link", GOD_LINK);
	 * 
	 * }else if(companyname.equals(LNT)){ model.addObject("link", LNT_LINK);
	 * 
	 * }
	 * 
	 * 
	 * // this was the error why the EL wasn't working. We were creating another
	 * object //model = new ModelAndView("Company");
	 * 
	 * return model;
	 * 
	 * 
	 * }
	 * 
	 * 
	 * private List<JobBean> prepareListofBean(List<Job> profiles) {
	 * 
	 * List<JobBean> beans = null; if(profiles != null && !profiles.isEmpty()) {
	 * beans = new ArrayList<JobBean>(); JobBean bean = null;
	 * 
	 * 
	 * for(Job profile : profiles) { bean = new JobBean();
	 * bean.setJob_id(profile.getJob_id());
	 * bean.setEvent_id(profile.getEvent_id());
	 * bean.setJob_description(profile.getJob_description());
	 * bean.setJob_category(profile.getJob_category());
	 * bean.setCtc(profile.getCtc());
	 * bean.setSkills_required(profile.getSkills_required());
	 * bean.setDocs_required(profile.getDocs_required());
	 * 
	 * //bean.setJob_id(profile.getDrive_date());
	 * //bean.setJob_id(profile.getCreated_date());
	 * //bean.setJob_id(profile.getCreated_by());
	 * //bean.setJob_id(profile.getModified_date());
	 * //bean.setJob_id(profile.getModified_by());
	 * 
	 * 
	 * beans.add(bean); } } return beans; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 */