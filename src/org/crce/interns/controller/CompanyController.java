/*
*
* Author Name:Anu Anna Issac
* 
* Filename:CompanyController.java	
* 	
* Classes used by code:CompanyService,FeedbackValidator,Feedback
* 
* Tabes used:Company
* 
* Description: This controller is used to help the admin add  details of the companies.
* 
*Functions:saveCompany,addCompany,welcome,prepareCompanyModel
*
*/

package org.crce.interns.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.FeedbackBean;
import org.crce.interns.model.Company;
import org.crce.interns.model.Criteria;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.CompanyService;
import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.CriteriaService;
import org.crce.interns.service.ManageProfileService;
import org.crce.interns.validators.CompanyFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class CompanyController implements ConstantValues{

	@Autowired
    CompanyFormValidator companyValidator;
	
	@Autowired
	private CheckRoleService crService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired 
	private CriteriaService criteriaService;
	
	@Autowired
	private ManageProfileService manageProfileService;
	
	
        
        private static final Logger logger = Logger.getLogger(CompanyController.class.getName());
	/*
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("HELLO");
		return new ModelAndView("index");
	}
	*/
	 private Company prepareCompanyModel(CompanyBean companyBean){
			Company company = new Company();
			company.setCompany_address(companyBean.getCompany_address());
			company.setCompany_name(companyBean.getCompany_name());
			return company;
		}
	 
	 
	 @RequestMapping(value = "/addCompany", method = RequestMethod.GET)
		public ModelAndView addCompany(HttpServletRequest request, Model model) {
		 
		 try{
			 
			 HttpSession session=request.getSession();
			 String roleId=(String)session.getAttribute("roleId");
				
				//new authorization
				if(!crService.checkRole("/addCompany", roleId))
					return new ModelAndView("403");
				else{
						CompanyBean companyBean=new CompanyBean();
						model.addAttribute("companyBean",companyBean);
						System.out.println("in controller1");
						return new ModelAndView("addCompany");
				}
			
		 }
		 catch(Exception e){
				//System.out.println(e);
                                logger.error(e);

				ModelAndView model1=new ModelAndView("500");
				model1.addObject("message", "Your session has timed out. Please login again");
		 		//model.addObject("url", "form");

				return model1;
			}

		}
	 
	//authorization done - unauthorized call redirected to 405.jsp
	 @RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
		public ModelAndView saveCompany(  HttpServletRequest request,@ModelAttribute("companyBean") CompanyBean companyBean, 
				BindingResult result,final RedirectAttributes redirectAttributes) {
		 
		 try{
		 companyValidator.validate(companyBean, result);
			if (result.hasErrors()) {
		//System.out.println("Error in form");
                            logger.error("Error in form");
     
     return new ModelAndView("addCompany");
         }
			Company company = prepareCompanyModel(companyBean);
			HttpSession session=request.getSession();
			String user=(String)session.getAttribute("userName");
			System.out.println(user);
			
			//this was giving problem so commented @melwyn95
			companyService.addCompany(user,company);

//			return new ModelAndView("companysuccess");

			
			redirectAttributes.addFlashAttribute("msg", "Data added successfully");
			
			
			ModelAndView model1=new ModelAndView("redirect:/addCompany");
			//model1.addObject("message", "Data added successfully ");
			return model1;
			
		
	 }
	 catch(Exception e){
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("message", "Your session has timed out. Please login again");
	 		model1.addObject("url", "form");

			return model1;
		}


}
	 
	 
	 //////////////////////////////////////////////////////////////////////////////////////////////////////
	 //pankaj modified following to make company images fade
	 
		@RequestMapping(value = "/getValuesToFed")
		public @ResponseBody String giveImageValue() {
			
			System.out.println("inside fader... ");			
			
						//list of companies
			List<CompanyBean> companyList = manageProfileService.listCompanies();
			//System.out.println("cl "+companyList.size());
			
						//list of criteria
			List<CriteriaBean> critList = criteriaService.getCriteria();
			//System.out.println("crl "+critList.size());
			 
			Map<String,Integer> fader = new HashMap<String,Integer>();
			
			for(CompanyBean c : companyList){
				
				for(CriteriaBean cr: critList){
					
					if(c.getCompany_id() == cr.getCriteria_id()){
							
						//String ldta = new SimpleDateFormat("MM/dd/yyyy").format(cr.getLast_date_to_apply());
						//String today = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
						try{
						 if(new Date().after(cr.getLast_date_to_apply())){
							 fader.put(c.getCompany_name(), 0);
						 }
						 else{
							 fader.put(c.getCompany_name(), 1);
						 }
						 
						 //System.out.println("fa "+c.getCompany_name()+"- "+fader.get(c.getCompany_name()));
						}
						catch(Exception e){
							System.out.println(e);
						}
					}
				}
				
			}
			
			
			/*
			Set<String> keys = fader.keySet();
			
			for(String i: keys){
				System.out.print(i+" "+fader.get(i));
			}
			*/
			
			return new Gson().toJson(fader);
		}
	 
}
