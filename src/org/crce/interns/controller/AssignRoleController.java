package org.crce.interns.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;


import org.crce.interns.beans.AssignRoleBean;
import org.crce.interns.model.FunctionMaster;
import org.crce.interns.model.FunctionRole;
import org.crce.interns.service.AssignRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AssignRoleController {
	@Autowired
	public AssignRoleService ars;
        
        private static final Logger logger = Logger.getLogger(AssignRoleController.class.getName());
	
	@RequestMapping(value="/AssignRole", method = RequestMethod.GET)
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {

	try
	{

		//System.out.println("return model");
                logger.error("return model /AssignRole ");
		AssignRoleBean assignRole=new AssignRoleBean();
		ModelAndView model=null;
		model=new ModelAndView("AssignRole");
		model.addObject("assignRole",assignRole);
		return model;
	}

	catch(Exception e)
	{
		//System.out.println(e);
                logger.error("Exception in AssignRole ",e);
		ModelAndView model=new ModelAndView("500");
		model.addObject("exception", "/AssignRole");
		return model;
	}
	}
	
	
	
	@RequestMapping(value="/roleAssigned")
	public ModelAndView assignRole(HttpServletRequest request, HttpServletResponse response, 
			@Valid AssignRoleBean arb,BindingResult result){ 
	try
	{	
		//System.out.println("return model");
                logger.error("return model /roleAssigned");
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("userName");

		if (result.hasErrors())
		{
			ModelAndView model=new ModelAndView("AssignRole");
			model.addObject("assignRole",arb);
			return model;
		}

		FunctionMaster fm=new FunctionMaster();
		FunctionRole fr=new FunctionRole();
		fm.setFunctionName(arb.getFunctionName());
		fm.setFunctionUrl(arb.getFunctionURL());

		fm.setCreatedBy(user);
		fm.setCreatedDate(new Date());
		fr.setRoleId(arb.getRoleId());
		int a=ars.checkFunction(arb.getFunctionName());
		
		ars.assignRole(fm, fr,a);
		//System.out.println("Success");
                logger.error("Success in role Assigned");
		return new ModelAndView("roleAssigned");
	}
	catch(Exception e)
	{
		//System.out.println(e);
                logger.error("Exception roleAssigned ",e);
		ModelAndView model=new ModelAndView("500");
		model.addObject("exception", "/RoleAssigned");
		return model;
	}
	}
}
