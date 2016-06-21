/*
package org.crce.interns.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.crce.interns.model.UserDetails;
import org.crce.interns.service.ApplicantService;
import org.crce.interns.validators.SearchApplicantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicantController {

	Integer companies;
	String user;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	SearchApplicantValidator searchApplicantValidator;
	
	@RequestMapping(value = "/SearchApplicant", method = RequestMethod.GET)
	public ModelAndView searchApplicant() {
		
		ModelAndView model = new ModelAndView("searchApplicant");
		return model;
	}
	
	@RequestMapping(value = "/SubmitCompany", method = RequestMethod.POST)
	public ModelAndView submitCompany(@RequestParam("company") Integer company) {
		
		System.out.println("Company sent from front end :" + company);
		companies = company;
		return new ModelAndView("redirect:/ViewApplicant");
	}
	
	@RequestMapping(value="/ViewApplicant", method = RequestMethod.GET)
	public ModelAndView viewApplicant(BindingResult br) {
		
		System.out.println("In View Applicant: " + companies);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("users", applicantService.viewApplicants(companies));
		
		if (modelMap.isEmpty()) {
			System.out.println("Error no Model map, Model map is null");
			return new ModelAndView("403");
		}
		if(modelMap.containsValue(null))
		{
			ModelAndView model = new ModelAndView("searchApplicant");
			String errorMsg = "No applicants in selected company";
			model.addObject("errorMsg", errorMsg);
			return model;
		}

		return new ModelAndView("viewApplicant", modelMap);
	}
	
	@RequestMapping(value = "/NotifyStudent", method = RequestMethod.POST)
	public ModelAndView notifyStudent(@RequestParam("userName") String userName) {
		
		System.out.println("User sent from front end :" + userName);
		user = userName;
		return new ModelAndView("redirect:/SetNotify");
	}
	
	@RequestMapping(value="/SetNotify", method = RequestMethod.GET)
	public ModelAndView setNotify(HttpServletRequest request) {
		
		ModelAndView model;
		String errorMsg="";
		Date date = new Date(); 
		Map<String, Object> modelMap = new HashMap<String, Object>();

		
		System.out.println("In Set Notify: " + user);
		int check = applicantService.checkNotify(user);
		if(check==0)
		{
			UserDetails ud = new UserDetails();
			ud.setModifiedDate(date);
			ud.setModifiedBy((String) request.getSession(true).getAttribute("userName"));
			ud.setUserName(user);

			modelMap.put("notify", applicantService.notifyApplicants(ud));
			
			
			return new ModelAndView("success", modelMap);
		}
		else
		{
			modelMap.put("users", applicantService.viewApplicants(companies));
			model = new ModelAndView("viewApplicant",modelMap);
			errorMsg = "Student is already notified";
			model.addObject("errorMsg", errorMsg);
			
			return model;
			
		}
		
		 	
		
		
	}


}

*/

package org.crce.interns.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.ApplicantService;
import org.crce.interns.service.ManageProfileService;
import org.crce.interns.validators.SearchApplicantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ApplicantController {

	Integer companies;
	String user;

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private ManageProfileService manageProfileService;
	
	@Autowired
	SearchApplicantValidator searchApplicantValidator;
	
        private static final Logger logger = Logger.getLogger(ApplicantController.class.getName());
	/* ---------------------------------------------------------------------------------------------------------------------  */
	
	@RequestMapping(value = "/SearchApplicant", method = RequestMethod.GET)
	public ModelAndView searchApplicant() {
		
		try {
				ModelAndView model = new ModelAndView("searchApplicant");
				
				List<CompanyBean> companyList = manageProfileService.listCompanies();
			    Map<Integer, String> companyMap = new LinkedHashMap<Integer,String>();
			            for(CompanyBean cb : companyList){
			            	companyMap.put(cb.getCompany_id(), cb.getCompany_name());
			            }
				
				return new ModelAndView("searchApplicant","companies",companyMap);
				
				//return model;
			} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println(e);
                                logger.error("Exception in /SearchApplicant ",e);
				ModelAndView model1=new ModelAndView("500");
				model1.addObject("exception", "/SearchApplicant");
				return model1;
			}
	}
	
	
	/* -----------------------------------------------------------------------------------------------------------------------  */

	
	@RequestMapping(value = "/SubmitCompany", method = RequestMethod.POST)
	public ModelAndView submitCompany(@RequestParam("company") Integer company) {
		
		try {
				//System.out.println("Company sent from front end :" + company);
                                logger.error("/SubmitCompany-->\"Company sent from front end :" + company);
				companies = company;
				return new ModelAndView("redirect:/ViewApplicant");
			} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println(e);
                                logger.error("EXCEPTION in /submitCompany ",e);
				ModelAndView model1=new ModelAndView("500");
				model1.addObject("exception", "/SubmitCompany");
				return model1;
			}
	}
	
	
	/* -------------------------------------------------------------------------------------------------------------------------  */

	
	@RequestMapping(value="/ViewApplicant", method = RequestMethod.GET)
	public ModelAndView viewApplicant(@ModelAttribute("command") UserDetailsBean userBean,BindingResult bindingResult,@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
		
		
		
		try {
				//System.out.println("In View Applicant: " + companies);
                                logger.error("In View Applicant: "+ companies);
				Map<String, Object> modelMap = new HashMap<String, Object>();
				//modelMap.put("users", applicantService.viewApplicants(companies));
				modelMap.put("users", applicantService.viewApplicants(companies,curYear));
			
				if (modelMap.isEmpty()) {
					//System.out.println("Error no Model map, Model map is null");
                                        logger.error("Error no Model map, Model map is null");
					return new ModelAndView("403");
				}
				if(modelMap.containsValue(null))
				{
					ModelAndView model = new ModelAndView("searchApplicant");
					String errorMsg = "No applicants in selected company";
					model.addObject("errorMsg", errorMsg);
					return model;
				}

				return new ModelAndView("viewApplicant", modelMap);
			} 
		catch (Exception e) {
					// TODO Auto-generated catch block
					//System.out.println(e);
                                        logger.error("Exception in /ViewApplicant ",e);
					ModelAndView model1=new ModelAndView("500");
					model1.addObject("exception", "/ViewApplicant");
					return model1;
			}
	}
	
	
	/* -----------------------------------------------------------------------------------------------------------------------  */

	@RequestMapping(value = "/NotifyStudent", method = RequestMethod.GET)
	public ModelAndView notifyStudent(@RequestParam("userName") String userName,@ModelAttribute("command") UserDetailsBean userBean,BindingResult bindingResult,
			@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
	
			try {
					//	UserDetailsBean userBean =new UserDetailsBean();
					//userBean.setUserName(userName);
					ModelAndView model;
					String errorMsg="";
					Map<String, Object> modelMap = new HashMap<String, Object>();
					
					if(userName.equalsIgnoreCase("")){
						modelMap.put("users", applicantService.viewApplicants(companies,curYear));
						model = new ModelAndView("viewApplicant",modelMap);
						/*		model = new ModelAndView("viewApplicant",modelMap);
						 */		
						//modelMap.put("users", applicantService.viewApplicants(companies));

						errorMsg = "User name cannot be empty";
						model.addObject("errorMsg", errorMsg);

						return model;
					}
					searchApplicantValidator.validate(userBean, bindingResult);
					//System.out.println("User sent from front end :" + userName);
                                        logger.error("User sent from front end :" + userName);
					user = userName;
					return new ModelAndView("redirect:/SetNotify");
				} 
			catch (Exception e) {
					// TODO Auto-generated catch block
					//System.out.println(e);
                                        logger.error("EXCEPTION in /NotifyStudent",e);
					ModelAndView model1=new ModelAndView("500");
					model1.addObject("exception", "/NotifyStudent");
					return model1;
			}
	}
	
	
	/* -----------------------------------------------------------------------------------------------------------------------  */

	
	@RequestMapping(value="/SetNotify", method = RequestMethod.GET)
	public ModelAndView setNotify(HttpServletRequest request,@ModelAttribute("command") UserDetailsBean userBean,BindingResult bindingResult
			,@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
		
			try {
					ModelAndView model;
					String errorMsg="";
					Date date = new Date(); 
					Map<String, Object> modelMap = new HashMap<String, Object>();
					//if(userName.equalsIgnoreCase("")){
					modelMap.put("users", applicantService.viewApplicants(companies,curYear));
                                        logger.error("In Set Notify: " + user);
					//System.out.println("In Set Notify: " + user);
					int check = applicantService.checkNotify(user);
					if(check==0)
					{
						UserDetails ud = new UserDetails();
						ud.setModifiedDate(date);
						ud.setModifiedBy((String) request.getSession(true).getAttribute("userName"));
						ud.setUserName(user);

						modelMap.put("notify", applicantService.notifyApplicants(ud,curYear));
				
						model = new ModelAndView("viewApplicant", modelMap);
						model.addObject("success", 1);
						//return new ModelAndView("viewApplicant", modelMap);
						return model;
					}
					else
					{
						modelMap.put("users", applicantService.viewApplicants(companies,curYear));
						model = new ModelAndView("viewApplicant",modelMap);
						errorMsg = "Student is already notified";
						model.addObject("errorMsg", errorMsg);
				
						return model;
				
					}
			} 
			catch (Exception e) {
					// TODO Auto-generated catch block
					//System.out.println(e);
                                        logger.error("Exception in /SetNotify ",e);
					ModelAndView model1=new ModelAndView("500");
					model1.addObject("exception", "/SetNotify");
					return model1;
			}
		
		
		}
}
