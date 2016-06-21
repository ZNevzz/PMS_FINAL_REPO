package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Logger;

import org.crce.interns.beans.PersonalProfileBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.QuickStatsBean;
import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.service.ProfileService;
import org.crce.interns.service.SelectedApplicantsService;
import org.crce.interns.validators.AddSelectedValidator;
import org.crce.interns.validators.DeleteSelectedValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller("SelectedApplicantsController")
public class SelectedApplicantsController {

 	@Autowired(required=true)
	private SelectedApplicantsService selectService;

	@Autowired
	private ProfileService profileService;

	@Autowired
	@Qualifier("addSelectedValidator")
	private AddSelectedValidator addSelectedValidator;
	
	@Autowired
	@Qualifier("deleteSelectedValidator")
	private DeleteSelectedValidator deleteSelectedValidator;
        
        private static final Logger logger = Logger.getLogger(SelectedApplicantsController.class.getName());

	@RequestMapping(value = "/manageselected.html", method = RequestMethod.GET)
	public ModelAndView gotomanagelist() {
		ModelAndView model = null;
		model = new ModelAndView("manage-selected-list");
		return model;
	}
	
	@RequestMapping(value = "/views.html", method = RequestMethod.GET)
	public ModelAndView gotoviewcandidate() {
		ModelAndView model = null;
		model = new ModelAndView("view-selected");
		return model;
	}

	// @SuppressWarnings("unused")

	@RequestMapping(value = "/viewsclist.html", method = RequestMethod.GET)
	public ModelAndView viewcandidate(@ModelAttribute("company") String company,
			@ModelAttribute("year") String year,
			@ModelAttribute("userList") List<UserCompanyBean> userBeanList,
			@ModelAttribute("professionalProfileBeanList") List<ProfessionalProfileBean> professionalProfileBeanList,
			@ModelAttribute("personalProfileBeanList") List<PersonalProfileBean> personalProfileBeanList) {
		try{
		ModelAndView moel;

		 //System.out.println("inside controller"+company);
                    logger.error("inside controller"+company);
		 
		 ModelAndView model = new ModelAndView("JobApplicants");
		 
		 //String year=Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
		 
		 List<QuickStatsBean> quickStatsList=new ArrayList<QuickStatsBean>();
		 quickStatsList.addAll(selectService.retrieveDetails(company,year));
		
		 List<ProfessionalProfileBean> selectedProf=new ArrayList<ProfessionalProfileBean>();
		 List<PersonalProfileBean> selectedPersonal=new ArrayList<PersonalProfileBean>();
		
	
		 //System.out.println("inside controller..........");
		
		 for(QuickStatsBean d:quickStatsList) {
			 System.out.println(d.getUsername());
			 
			 ProfessionalProfileBean professionalProfileBean=new ProfessionalProfileBean();
			 PersonalProfileBean personalProfileBean=new PersonalProfileBean();
			 
			 
			 professionalProfileBean.setUserName(d.getUsername());
			 personalProfileBean.setUserName(d.getUsername());
			 selectedProf.add(profileService.getProfile(professionalProfileBean));
			 selectedPersonal.add(profileService.getProfile(personalProfileBean));
			 System.out.println(professionalProfileBean.getUserName());
		 
			 model.addObject("company", company);
			 
			 model.addObject("userList",userBeanList);
			 model.addObject("professionalProfileBeanList",professionalProfileBeanList);
			 model.addObject("personalProfileBeanList",personalProfileBeanList);

			 
			 
			 model.addObject("quickStatsList",quickStatsList);
			 model.addObject("selectedProf",selectedProf);
			 model.addObject("selectedPersonal",selectedPersonal);
		 }
		 return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/viewsclist");
			return model;
		}
		 	}

	@RequestMapping(value = "/manageslist.html", method = RequestMethod.POST )
	public ModelAndView cruddetails(@RequestParam(value = "option") String option) {
		try{
		ModelAndView model;
		QuickStatsBean userBean = new QuickStatsBean();
		String company=new String();
		if (option.equals("Add"))
			model = new ModelAndView("add-selected");
		else if (option.equals("Delete"))
			model = new ModelAndView("delete-selected");
		else
			model = null;
		 model.addObject("userBean",userBean);
		 model.addObject("company",company);
		 return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/manageslist");
			return model;
		}
	}

	@RequestMapping(value = "/addselected.html", method = RequestMethod.POST)
	public ModelAndView addselected( @ModelAttribute("userBean") QuickStatsBean userBean,  BindingResult bindingResult) {
		try{
			ModelAndView model;
		String msg="";
		addSelectedValidator.validate(userBean, bindingResult);
		
		if (bindingResult.hasErrors()) {
			//System.out.println("Binding Errors are present...");
                        logger.error("Binding Errors are present...");
			model = new ModelAndView("add-selected");
		} 
		
		else{
			
			int c=selectService.createDetails(userBean);
		
			if(c==1) {
				model=new ModelAndView("add-selected");
				msg+="This entry already exists. No Worries!";
				model.addObject("msg",msg);
			}
			
			else if(c==2){
				model=new ModelAndView("add-selected");
				msg+="This company isn't enrolled with us. (Something wrong with company name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==3){
				model=new ModelAndView("add-selected");
				msg+="This user account doesn't exist. (Something wrong with user name?)";
				model.addObject("msg",msg);
				
			}
			else{
				System.out.println("company is................"+userBean.getCompany_name());
				selectService.createDetails(userBean);
				model = new ModelAndView("add-selected-success");
			}
		}
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/addselected");
			return model;
		}

	}

	@RequestMapping(value = "/deleteselected.html", method = RequestMethod.POST)
	public ModelAndView deleteselected(@ModelAttribute("userBean") QuickStatsBean userBean, BindingResult bindingResult) {
		try{
		ModelAndView model;
		int c=0;
		String msg="";

		deleteSelectedValidator.validate(userBean, bindingResult);
		
		if(bindingResult.hasErrors()){
			//System.out.println("Binding Errors are present...");
                        logger.error("Binding Errors are present...");
			model = new ModelAndView("delete-selected");
		}
		
		else{
			
			c=selectService.deleteDetails(userBean);

			if(c==2){
				model=new ModelAndView("delete-selected");
				msg+="This company isn't enrolled with us. (Something wrong with company name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==3){
				model=new ModelAndView("delete-selected");
				msg+="This user account doesn't exist. (Something wrong with user name?)";
				model.addObject("msg",msg);
				
			}
			else if(c==0){
				model=new ModelAndView("delete-selected");
				msg+="This entry doesn't exist";
				model.addObject("msg",msg);				
			}

			else{
				selectService.deleteDetails(userBean);
				model = new ModelAndView("delete-selected-success");
			}
		}
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/deleteselected");
			return model;
		}
	}

 
}
