package org.crce.interns.controller;
import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.PersonalProfileBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.service.ManageApplicantsService;
import org.crce.interns.service.ProfileService;
import org.crce.interns.validators.AddApplicantsValidator;
import org.crce.interns.validators.DeleteApplicantsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import org.apache.log4j.Logger;

/**
*
* @author Rashmi
* Task: Adds/Deletes Applicant entries from list of applicants for a job
* Dependency: ManageApplicantsService.java
*/

@Controller("manageUsersController")
public class ManageApplicantsController {

	@Autowired
	private ManageApplicantsService crudService;

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	@Qualifier("addApplicantsValidator")
	private AddApplicantsValidator addApplicantsValidator;
	
	@Autowired
	@Qualifier("deleteApplicantsValidator")
	private DeleteApplicantsValidator deleteApplicantsValidator;
        
        private static final Logger logger = Logger.getLogger(ManageApplicantsController.class.getName());
	
	@RequestMapping(value = "/manage.html", method = RequestMethod.GET)
	public ModelAndView gotomanagelist() {
		ModelAndView model = null;
		model = new ModelAndView("manage-list");
		return model;
	}
	
	@RequestMapping(value = "/view.html", method = RequestMethod.GET)
	public ModelAndView gotoviewcandidate() {
		ModelAndView model = null;
		model = new ModelAndView("view-candidate");
		return model;
	}

	// @SuppressWarnings("unused")

	@RequestMapping(value = "/viewclist.html", method = RequestMethod.POST)
	public ModelAndView viewcandidate(@RequestParam("company") String company,
			@RequestParam("year") String year) {
		try{ 
		ModelAndView model;

		 //System.out.println("inside controller"+company);
                logger.error("inside controller"+company);
		 
		 model = new ModelAndView("candidate-list");
		 
		 if(year.equals("")){
			 year=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		 }
		 
		 year=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		 
		 List<UserCompanyBean> userBeanList=new ArrayList<UserCompanyBean>();
		/* userBeanList.addAll(crudService.retreiveDetails(company));*/
		 userBeanList.addAll(crudService.retreiveDetails(company, year));
		
		 List<ProfessionalProfileBean> professionalProfileBeanList=new ArrayList<ProfessionalProfileBean>();
		 List<PersonalProfileBean> personalProfileBeanList=new ArrayList<PersonalProfileBean>();
		
		/* ProfessionalProfileBean professionalProfileBean=new ProfessionalProfileBean();
		 PersonalProfileBean personalProfileBean=new PersonalProfileBean();
*/
		 //System.out.println("inside controller..........");
                 logger.error("inside controller..........");
		
		 for(UserCompanyBean d:userBeanList) {
			 System.out.println(d.getUsername());
			 
			 ProfessionalProfileBean professionalProfileBean=new ProfessionalProfileBean();
			 PersonalProfileBean personalProfileBean=new PersonalProfileBean();
			 
			 
			 professionalProfileBean.setUserName(d.getUsername());
			 personalProfileBean.setUserName(d.getUsername());
			 professionalProfileBeanList.add(profileService.getProfile(professionalProfileBean));
			 personalProfileBeanList.add(profileService.getProfile(personalProfileBean));
			 System.out.println(professionalProfileBean.getUserName());
		 
			 model.addObject("company", company);
			 model.addObject("userList",userBeanList);
			 model.addObject("professionalProfileBeanList",professionalProfileBeanList);
			 model.addObject("personalProfileBeanList",personalProfileBeanList);
		 }
		 return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/viewclist");
			return model;
		}
		 
	}

	@RequestMapping(value = "/managelist.html", method = RequestMethod.POST )
	public ModelAndView cruddetails(@RequestParam(value = "option") String option) {
		try{
		ModelAndView model;
		UserCompanyBean userBean = new UserCompanyBean();
		
		if (option.equals("Add"))
			model = new ModelAndView("add-candidate");
		else if (option.equals("Delete"))
			model = new ModelAndView("delete-candidate");
		else
			model = null;
		 model.addObject("userBean",userBean);
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/managelist");
			return model;
		}
	}

	@RequestMapping(value = "/addcandidate.html", method = RequestMethod.POST)
	public ModelAndView addcandidate(@ModelAttribute("userBean") UserCompanyBean userBean, BindingResult bindingResult) {
		try{
		ModelAndView model;
		String msg="";
		addApplicantsValidator.validate(userBean, bindingResult);
		
		if (bindingResult.hasErrors()) {
			//System.out.println("Binding Errors are present...");
                    logger.error("Binding Errors are present...");
			model = new ModelAndView("add-candidate");
		} else{
			int c=crudService.createDetails(userBean);
			if(c==1) {
				model=new ModelAndView("add-candidate");
				msg+="This entry already exists. No Worries!";
				model.addObject("msg",msg);
			}
			else if(c==2){
				model=new ModelAndView("add-candidate");
				msg+="This company isn't enrolled with us. (Something wrong with company name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==3){
				model=new ModelAndView("add-candidate");
				msg+="This user account doesn't exist. (Something wrong with user name?)";
				model.addObject("msg",msg);
				
			}
			else
			model = new ModelAndView("add-success");
		}
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                    logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/addcandidate");
			return model;
		}
	}

	@RequestMapping(value = "/deletecandidate.html", method = RequestMethod.POST)
	public ModelAndView deletecandidate(@ModelAttribute("userBean") UserCompanyBean userBean, BindingResult bindingResult) {
		try{
		ModelAndView model;
		int c=0;
		String msg="";
		deleteApplicantsValidator.validate(userBean, bindingResult);
	
		if (bindingResult.hasErrors()) {
			//System.out.println("Binding Errors are present...");
                        logger.error("Binding Errors are present...");
			model = new ModelAndView("delete-candidate");
		} else{
			
			c=crudService.deleteDetails(userBean);

			if(c==2){
				model=new ModelAndView("delete-candidate");
				msg+="This company isn't enrolled with us. (Something wrong with company name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==3){
				model=new ModelAndView("delete-candidate");
				msg+="This user account doesn't exist. (Something wrong with user name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==0){
				model=new ModelAndView("delete-candidate");
				msg+="This entry doesn't exist";
				model.addObject("msg",msg);				
			}
			else
				model = new ModelAndView("delete-success");
		}
			return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/deletecandidate");
			return model;
		}
	}

	@RequestMapping(value = "viewApplicants", method = RequestMethod.GET)
	public ModelAndView viewApplicants(@RequestParam("companyname") String company,
			@RequestParam("year") String year,
			final RedirectAttributes redirectAttributes) {
		try{ 
		ModelAndView model;

		 //System.out.println("inside controller"+company);
                logger.error("inside controller"+company);
		 
		 model = new ModelAndView("redirect:/viewsclist.html");
		 
		 if(year.equals("")){
			 year=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		 }
		 
		 
		 
		 List<UserCompanyBean> userBeanList=new ArrayList<UserCompanyBean>();
		 userBeanList.addAll(crudService.retreiveDetails(company, year));
		
		 List<ProfessionalProfileBean> professionalProfileBeanList=new ArrayList<ProfessionalProfileBean>();
		 List<PersonalProfileBean> personalProfileBeanList=new ArrayList<PersonalProfileBean>();
		
		/* ProfessionalProfileBean professionalProfileBean=new ProfessionalProfileBean();
		 PersonalProfileBean personalProfileBean=new PersonalProfileBean();
*/
		 //System.out.println("inside controller..........");
		
		 for(UserCompanyBean d:userBeanList) {
			 System.out.println(d.getUsername());
			 
			 ProfessionalProfileBean professionalProfileBean=new ProfessionalProfileBean();
			 PersonalProfileBean personalProfileBean=new PersonalProfileBean();
			 
			 
			 professionalProfileBean.setUserName(d.getUsername());
			 personalProfileBean.setUserName(d.getUsername());
			 professionalProfileBeanList.add(profileService.getProfile(professionalProfileBean));
			 personalProfileBeanList.add(profileService.getProfile(personalProfileBean));
			 System.out.println(professionalProfileBean.getUserName());
		

			 redirectAttributes.addFlashAttribute("company", company);
			 redirectAttributes.addFlashAttribute("year", year);
			 redirectAttributes.addFlashAttribute("userList",userBeanList);
			 redirectAttributes.addFlashAttribute("professionalProfileBeanList",professionalProfileBeanList);
			 redirectAttributes.addFlashAttribute("personalProfileBeanList",personalProfileBeanList);
			 
			 
			 //model.addObject("company", company);
			 //model.addObject("userList",userBeanList);
			 //model.addObject("professionalProfileBeanList",professionalProfileBeanList);
			 //model.addObject("personalProfileBeanList",personalProfileBeanList);
		 }
		 return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/viewclist");
			return model;
		}
		 
	}
}



/*package org.crce.interns.controller;
import java.util.ArrayList;
import java.util.List;
import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.model.Company;
import org.crce.interns.model.UserCompany;
import org.crce.interns.service.ManageApplicantsService;
import org.crce.interns.validators.AddApplicantsValidator;
import org.crce.interns.validators.DeleteApplicantsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


*//**
*
* @author Rashmi
* Task: Adds/Deletes Applicant entries from list of applicants for a job
* Dependency: ManageApplicantsService.java
*//*


@Controller("manageUsersController")
public class ManageApplicantsController {

	@Autowired
	private ManageApplicantsService crudService;

	@Autowired
	@Qualifier("addApplicantsValidator")
	private AddApplicantsValidator addApplicantsValidator;
	
	@Autowired
	@Qualifier("deleteApplicantsValidator")
	private DeleteApplicantsValidator deleteApplicantsValidator;
	
	@RequestMapping(value = "/manage.html", method = RequestMethod.GET)
	public ModelAndView gotomanagelist() {
		ModelAndView model = null;
		model = new ModelAndView("manage-list");
		return model;
	}
	
//	@RequestMapping(value = "/view.html", method = RequestMethod.GET)
	
	@RequestMapping(value = "/view-candidate.html", method = RequestMethod.GET)
	public ModelAndView gotoviewcandidate() {
		ModelAndView model = null;
		model = new ModelAndView("view-candidate");
		return model;
	}

	// @SuppressWarnings("unused")

	@RequestMapping(value = "/viewclist.html", method = RequestMethod.POST)
	public ModelAndView viewcandidate(@RequestParam("company") String company) {
		ModelAndView model;

		System.out.println("inside controller"+company);
		 
		model = new ModelAndView("candidate-list");
		 List<UserCompany> userList=new ArrayList<UserCompany>();
		 userList.addAll(crudService.retreiveDetails(company));
		 System.out.println("inside controller..........");
		// for(UserCompany d:userList) System.out.println(d.getUsername()+" "+d.getCompany());
		 model.addObject("userList",userList);
		return model;
	}


//	@RequestMapping(value = "/managelist.html", method = RequestMethod.POST )

	@RequestMapping(value = "/showlist.html", method = RequestMethod.POST )

	public ModelAndView cruddetails(@RequestParam(value = "option") String option) {
		ModelAndView model;
		UserCompanyBean userBean = new UserCompanyBean();
		
		if (option.equals("Add"))
			model = new ModelAndView("add-candidate");
		else if (option.equals("Delete"))
			model = new ModelAndView("delete-candidate");
		else
			model = null;
		 model.addObject("userBean",userBean);
		return model;
	}

	@RequestMapping(value = "/addcandidate.html", method = RequestMethod.POST)
	public ModelAndView addcandidate(@ModelAttribute("userBean") UserCompanyBean userBean, BindingResult bindingResult) {
		ModelAndView model;

		String msg="";
		addApplicantsValidator.validate(userBean, bindingResult);
		
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			model = new ModelAndView("add-candidate");
		} else{
			int c=crudService.createDetails(userBean);
			if(c==1) {
				model=new ModelAndView("add-candidate");
				msg+="This entry already exists. No Worries!";
				model.addObject("msg",msg);
			}
			else if(c==2){
				model=new ModelAndView("add-candidate");
				msg+="This company isn't enrolled with us. (Something wrong with company name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==3){
				model=new ModelAndView("add-candidate");
				msg+="This user account doesn't exist. (Something wrong with user name?)";
				model.addObject("msg",msg);
				
			}
			else
			model = new ModelAndView("add-success");
		}
		return model;

	//	UserCompanyBean userBean = new UserCompanyBean();
	//	userBean.setUsername(name);
	//	userBean.setCompany(company);
	//	System.out.println(userBean.getUsername());

		crudService.createDetails(userBean);
		addApplicantsValidator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			model = new ModelAndView("add-candidate");
		} else
		model = new ModelAndView("add-success");
		//model.addAttribute(userBean);
		return model;
		
		

	}

	@RequestMapping(value = "/deletecandidate.html", method = RequestMethod.POST)
	public ModelAndView deletecandidate(@ModelAttribute("userBean") UserCompanyBean userBean, BindingResult bindingResult) {
		ModelAndView model;
		int c=0;
		String msg="";
		deleteApplicantsValidator.validate(userBean, bindingResult);
	
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			model = new ModelAndView("delete-candidate");
		} else{
			
			c=crudService.deleteDetails(userBean);

			if(c==2){
				model=new ModelAndView("delete-candidate");
				msg+="This company isn't enrolled with us. (Something wrong with company name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==3){
				model=new ModelAndView("delete-candidate");
				msg+="This user account doesn't exist. (Something wrong with user name?)";
				model.addObject("msg",msg);
				
			}
			else
				model = new ModelAndView("delete-success");
		}
			return model;

		//UserCompanyBean userBean = new UserCompanyBean();
		//UserCompanyId uci=new UserCompanyId();
		//uci.setUsername(name);
	//	uci.setCompany_id();
	//	userBean.setId(uci);
		//userBean.setUsername(name);
		//userBean.setCompany(company);
		crudService.deleteDetails(userBean);
		addApplicantsValidator.validate(userBean, bindingResult);
		if (bindingResult.hasErrors()) {
			System.out.println("Binding Errors are present...");
			model = new ModelAndView("delete-candidate");
		} else
		model = new ModelAndView("delete-success");
		return model;

	}

}
*/