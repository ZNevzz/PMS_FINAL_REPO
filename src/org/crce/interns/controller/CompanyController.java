package org.crce.interns.controller;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.model.Company;
import org.crce.interns.model.Criteria;
import org.crce.interns.service.CompanyService;
import org.crce.interns.service.CriteriaService;
import org.crce.interns.validators.CompanyFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {

	@Autowired
    CompanyFormValidator companyValidator;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired 
	private CriteriaService criteriaService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		System.out.println("HELLO");
		return new ModelAndView("index");
	}
	 private Company prepareCompanyModel(CompanyBean companyBean){
			Company company = new Company();
			company.setCompany_address(companyBean.getCompany_address());
			company.setCompany_name(companyBean.getCompany_name());
			return company;
		}
	 
	 
	 @RequestMapping(value = "/addCompany", method = RequestMethod.GET)
		public ModelAndView addCompany(Model model) {
		 
		 CompanyBean companyBean=new CompanyBean();
		 model.addAttribute("companyBean",companyBean);
			System.out.println("in controller1");
			return new ModelAndView("addCompany");
		}
	 @RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
		public ModelAndView saveCompany(  @ModelAttribute("companyBean") CompanyBean companyBean, 
				BindingResult result) {
		 
		 
		 companyValidator.validate(companyBean, result);
			if (result.hasErrors()) {
		System.out.println("Error in form");
     
     return new ModelAndView("addCompany");
 }
			Company company = prepareCompanyModel(companyBean);
			
			companyService.addCompany(company);
			return new ModelAndView("companysuccess");
		}

}
