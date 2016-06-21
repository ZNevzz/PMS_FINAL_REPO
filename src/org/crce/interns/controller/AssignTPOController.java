/*
 * AssignTPOController Class contains the various methods like 
 * Redirect to Admin Home Page
 * Redirect to FTPC Home Page
 * Assign STPC by FTPC
 * Remove STPC by FTPC
 * Assign TPO by Admin
 * View Users(for Admin and FTPC)
 * 
 * @author Adarsh
 * 
 * */
package org.crce.interns.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.service.AssignTPOService;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.GetBranchService;
import org.crce.interns.validators.AddTPOValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssignTPOController {
	
	@Autowired
	private AssignTPOService userService;
	
	@Autowired
	private CheckRoleService crService;
	
	@Autowired
	private GetBranchService gbService;
	
	@Autowired
	AddTPOValidator validator;
	
        
        private static final Logger logger = Logger.getLogger(AssignTPOController.class.getName());
        
	@RequestMapping(value = "/AdminHome", method = RequestMethod.GET)	//Admin Home Page
	public ModelAndView goAdminHome(HttpServletRequest request,@ModelAttribute("command") FacultyUserBean userBean, BindingResult result) {
		//System.out.println("In Controller : Admin Home Page\n");
		logger.error("In Controller : Admin Home Page\n");
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPO", roleId))
			return new ModelAndView("403");
		else
		return new ModelAndView("Admin");
	}
	
	@RequestMapping(value = "/FTPCHome", method = RequestMethod.GET)	//FTPC Home page	
	public ModelAndView goFTPCHome(HttpServletRequest request,@ModelAttribute("notify") FacultyUserBean userBean, BindingResult result) {
		//System.out.println("In Controller : Faculty TPC Home Page\n");
		logger.error("In Controller : Faculty TPC Home Page\n");
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPCF", roleId))
			return new ModelAndView("403");
		else
		return new ModelAndView("FacultyTPC");
	}
	
	@RequestMapping(value="/ViewUsersA", method = RequestMethod.GET)//View Users for Admin
	public ModelAndView viewUsers(HttpServletRequest request) {
		//System.out.println("In Controller: View Users by Admin");
		logger.error("In Controller: View Users by Admin");
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPO", roleId))
			return new ModelAndView("403");
		else
		{
			Map<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("users", userService.viewUsers());
			return new ModelAndView("viewUserA", modelMap);
		}
	}
	
	@RequestMapping(value="/ViewUsersF", method = RequestMethod.GET)//View Users for FTPC
	public ModelAndView viewUsersF(HttpServletRequest request) {
		//System.out.println("In Controller: View Users by FTPC");
		logger.error("In Controller: View Users by FTPC");
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPCF", roleId))
			return new ModelAndView("403");
		else
		{
			Map<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("users", userService.viewUsers());
			return new ModelAndView("viewUserF", modelMap);
		}
	}


	@RequestMapping(value = "/AssignTPCF", method = RequestMethod.GET)//Call to jsp to get username
	public ModelAndView assignTPCF(HttpServletRequest request,@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		System.out.println("In Controller : Assign TPCF\n");
		
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPCF", roleId))
			return new ModelAndView("403");
		else
			return new ModelAndView("assignTPCF");
	}
	
	@RequestMapping(value = "/AssignTPO", method = RequestMethod.GET)//Call to jsp to get username
	public ModelAndView assignTPO(HttpServletRequest request,@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		//System.out.println("In Controller : Assign TPO\n");
		logger.error("In Controller : Assign TPO\n");
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPO", roleId))
			return new ModelAndView("403");
		else
		return new ModelAndView("assignTPO");	}

	@RequestMapping(value = "/RemoveTPCF", method = RequestMethod.GET)//Call to jsp to get username
	public ModelAndView removeTPCF(HttpServletRequest request,@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		//System.out.println("In Controller : Remove TPCF\n");
		logger.error("In Controller : Remove TPCF\n");
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPCF", roleId))
			return new ModelAndView("403");
		else
		return new ModelAndView("removeTPCF");
	}

	@RequestMapping(value = "/RemoveTPO", method = RequestMethod.GET)//Call to jsp to get username
	public ModelAndView removeTPO(HttpServletRequest request,@ModelAttribute("command") UserDetailsBean userBean, BindingResult result) {
		//System.out.println("In Controller : Remove TP0\n");
		logger.error("In Controller : Remove TP0\n");
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		
		if(!crService.checkRole("AssignTPO", roleId))
			return new ModelAndView("403");
		else
		return new ModelAndView("removeTPO");
	}

	@RequestMapping(value = "/SubmitAssignTPO", method = RequestMethod.POST)
	public ModelAndView createUser(HttpServletRequest request,@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		//System.out.println("In Controller: Submit Assign TPO");
                logger.error("In Controller: Submit Assign TPO");
		try{
		ModelAndView model;
		String erroMesg="";
		int a;
		
		validator.validate(userBean, bindingResult);
		
		if (bindingResult.hasErrors()) {
			//System.out.println("Binding Errors are present...");
                        logger.error("Binding Errors are present...");
			return new ModelAndView("assignTPO");
		}
		
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		
		userBean.setModifiedBy(userName);
		userBean.setModifiedDate(new Date());
		
		a=userService.assignTPO(userBean);
		//System.out.println("Value Returned from Service: "+a);
                logger.error("Value Returned from Service: "+a);
		
		if(a==0)//No such user exists in UserDetails Table
		{
			model=new ModelAndView("assignTPO");
			erroMesg+="No such user exists";
			model.addObject("erroMesg",erroMesg);
		//	return new ModelAndView("noUser");
		}
		else if(a==5)//A Non-Faculty user attempted to be assigned as TPO
		{
			model=new ModelAndView("assignTPO");
			erroMesg+="A Non-Faculty user attempted to be assigned as TPO";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("notFac");
		}
		else if(a==55){  //Already assigned TPO user attempted to be assigned as TPO
			model=new ModelAndView("assignTPO");
			erroMesg+="Already assigned TPO user attempted to be assigned as TPO";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("alTPO");
		}
		else
			model = new ModelAndView("redirect:/ViewUsersA");
		
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error("Exception ",e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/SubmitAssignTPO");
			return model;
		}
	//	return new ModelAndView("redirect:/ViewUsersA");
		//return new ModelAndView("redirect:/AdminHome");
	}
		
	@RequestMapping(value = "/SubmitAssignTPCF", method = RequestMethod.POST)
	public ModelAndView createTPCF(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("In Controller: Submit Assign TPCF");
                logger.error("In Controller: Submit Assign TPCF");
		try{
		ModelAndView model;
		String erroMesg="";
		int a;
		
		validator.validate(userBean, bindingResult);
		
		if (bindingResult.hasErrors()) {
			//System.out.println("Binding Errors are present...");
                        logger.error("Binding Errors are present...");
			return new ModelAndView("assignTPCF");
		}
		
		HttpSession session=request.getSession();
		String fUserName=(String)session.getAttribute("userName");

		String branch1=gbService.getBranch(userBean.getUserName());
		String branch2=gbService.getBranch(fUserName);
		
		if(branch1.equalsIgnoreCase(""))
		{
			model=new ModelAndView("assignTPCF");
			erroMesg+="No such user exists";
			model.addObject("erroMesg",erroMesg);
			return model;
		}
		
		if(!branch1.equalsIgnoreCase(branch2)){
			//System.out.println("Branch not same...");
                        logger.error("Branch not same");
			model=new ModelAndView("assignTPCF");
			erroMesg+="Sorry...! But you are not authorized to assign this Student as STPC";
			model.addObject("erroMesg",erroMesg);
			return model;
			//return new ModelAndView("notAuth");
		}
		
		userBean.setModifiedBy(fUserName);
		userBean.setModifiedDate(new Date());
		
		a=userService.assignTPCF(userBean);
		//System.out.println("Value Returned from Service: "+a);
                logger.error("Value Returned from Service: "+a);
		
		if(a==0)//No such user exists in UserDetails Table
		{
			model=new ModelAndView("assignTPCF");
			erroMesg+="No such user exists";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("noUser");
		}
		else if(a==3)//A Non-Student user attempted to be assigned as STPC
		{
			model=new ModelAndView("assignTPCF");
			erroMesg+="A Non-Student user attempted to be assigned as STPC";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("notStud");	
		}
		else if(a==34){  //Already assigned STPC or FTPC user attempted to be assigned as TPC
			model=new ModelAndView("assignTPCF");
			erroMesg+="User attempted to be assigned as TPC is already assigned as STPC";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("alTPC");
		}
		else
			model = new ModelAndView("redirect:/ViewUsersF");
		
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error("Exception ",e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/SubmitAssignTPCF");
			return model;
		}
	//	return new ModelAndView("redirect:/ViewUsersF");
		//return new ModelAndView("redirect:/AdminHome");
	}
	
	@RequestMapping(value = "/SubmitRemoveTPO", method = RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request,@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult) {
		//System.out.println("In Controller: Submit Remove TPO");	
                logger.error("In Controller: Submit Remove TPO");	
		try{
		ModelAndView model;
		String erroMesg="";
		int a;
		
		validator.validate(userBean, bindingResult);
		
		if (bindingResult.hasErrors()) {
			//System.out.println("Binding Errors are present...");
                    logger.error("Binding Errors are present...");
			return new ModelAndView("removeTPO");
		}
		
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		
		userBean.setModifiedBy(userName);
		userBean.setModifiedDate(new Date());
		
		a=userService.removeTPO(userBean);
		//System.out.println("Value Returned from Service: "+a);
                logger.error("Value Returned from Service: "+a);
		
		if(a==0)//No such user exists in UserDetails Table
		{
			model=new ModelAndView("removeTPO");
			erroMesg+="No such user exists";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("noUser");
		}
		else if(a==55)//User attempted to be removed as TPO is not a TPO
		{
			model=new ModelAndView("removeTPO");
			erroMesg+="User attempted to be removed as TPO is not a TPO";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("notTPO");
		}
		else
			model = new ModelAndView("redirect:/ViewUsersA");
		
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                    logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/SubmitRemoveTPO");
			return model;
		}
	//	return new ModelAndView("redirect:/ViewUsersA");
		//return new ModelAndView("redirect:/AdminHome");
	}
	
	@RequestMapping(value = "/SubmitRemoveTPCF", method = RequestMethod.POST)
	public ModelAndView deleteTPCF(@ModelAttribute("command") UserDetailsBean userBean, BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("In Controller: Submit Remove TPCF");
            logger.error("In Controller: Submit Remove TPCF");
		try{
		validator.validate(userBean, bindingResult);

		ModelAndView model;
		String erroMesg="";
		int a;
		
		if (bindingResult.hasErrors()) {
			//System.out.println("Binding Errors are present...");
                    logger.error("Binding Errors are present...");
			return new ModelAndView("removeTPCF");
		}
		
		HttpSession session=request.getSession();
		String fUserName=(String)session.getAttribute("userName");
		
		String branch1=gbService.getBranch(userBean.getUserName());
		String branch2=gbService.getBranch(fUserName);
		
		if(branch1.equalsIgnoreCase(""))
		{
			model=new ModelAndView("removeTPCF");
			erroMesg+="No such user exists";
			model.addObject("erroMesg",erroMesg);
			return model;
		}
		
		if(!branch1.equalsIgnoreCase(branch2)){
			//System.out.println("Branch not same...");
                        logger.error("Branch not same...");
			model=new ModelAndView("removeTPCF");
			erroMesg+="Sorry...! But you are not authorized to remove this Student as STPC";
			model.addObject("erroMesg",erroMesg);
			return model;
		}
		
		userBean.setModifiedBy(fUserName);
		userBean.setModifiedDate(new Date());
		
		a=userService.removeTPCF(userBean);
		//System.out.println("in Remove TPCF:Value Returned from Service: "+a);
                logger.error("in Remove TPCF:Value Returned from Service: "+a);
		
		if(a==0)//No such user exists in UserDetails Table
		{
			model=new ModelAndView("removeTPCF");
			erroMesg="No such user exists";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("noUser");
		}
		else if(a==33)//User attempted to be removed is not a STPC
		{
			model=new ModelAndView("removeTPCF");
			erroMesg+="User attempted to be removed is not a STPC";
			model.addObject("erroMesg",erroMesg);
			//return new ModelAndView("notTPC");
		}
		else
			model = new ModelAndView("redirect:/ViewUsersF");
		
		return model; 
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/SubmitRemoveTPCF");
			return model;
		}
	//	return new ModelAndView("redirect:/ViewUsersF");
		//return new ModelAndView("redirect:/AdminHome");
	}
}
