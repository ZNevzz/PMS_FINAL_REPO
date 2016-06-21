/*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: ManageUserController.java	
* 	
* Classes used by code: ManageUserService, CheckRoleService,StudentBean,FacultyBean
* 
* Tabes used: User_schema.userdetails,User_schema.personal_profile,User_schema.professional_profile,User_schema.qualification
* 
* Description: This controller is used to add student/add faculty (as well as create directories for them)/remove user .
* 				Can be done only by tpo/admin.
* 
* Functions: addStudent(), addFaculty() ,welcomeStudent(),welcomeFaculty(),removeUser(), removeUser1()		
*
*/



package org.crce.interns.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.beans.FacultyBean;
import org.crce.interns.beans.StudentBean;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.DirectoryService;
import org.crce.interns.service.ManageUserService;
import org.crce.interns.validators.AddFacultyValidator;
import org.crce.interns.validators.AddStudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ManageUserController {

	@Autowired
	private ManageUserService manageUserService;
	@Autowired
	private CheckRoleService crService;
	
	@Autowired
	AddStudentValidator addStudentValidator;

	@Autowired
	AddFacultyValidator addFacultyValidator;

	 @Autowired
	 private DirectoryService directoryService;
         
         private static final Logger logger = Logger.getLogger(ManageUserController.class.getName());
	
	//actually adding student
	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(HttpServletRequest request, @ModelAttribute("studentBean")StudentBean studentBean,BindingResult result) {
		
		ModelAndView model = new ModelAndView("addStudent"); 
		try {
			addStudentValidator.validate(studentBean, result);
			if (result.hasErrors()) {
				//System.out.println("Binding Errors are present...");
                                logger.error("Binding Errors are present...");
				return new ModelAndView("addStudent");
			}

			manageUserService.addStudent(request, studentBean);
			model.addObject("success", 1);
			directoryService.createStudentFolder();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			
			//System.out.println(e.toString());
                        logger.error(e.toString());
			model.addObject("error", 1);
		}
		return model;
	}
	
	//actually adding faculty
	@RequestMapping(value = "/registerFaculty", method = RequestMethod.POST)
	public ModelAndView addFaculty(HttpServletRequest request,@ModelAttribute("facultyBean")FacultyBean facultyBean,BindingResult result) {
		
		ModelAndView model = new ModelAndView("addFaculty");
		try{
			addFacultyValidator.validate(facultyBean, result);
			if (result.hasErrors()) {
				//System.out.println("Binding Errors are present...");
                                logger.error("Binding Errors are present...");
				return new ModelAndView("addFaculty");
			}
		manageUserService.addFaculty(request, facultyBean);
		model.addObject("success", 1);
		directoryService.createFacultyFolder();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			
			//System.out.println(e.toString());
                    logger.error(e.toString());
			model.addObject("error", 1);
		}
		return model;
		
	}
	
	
	//to navigate to addStudent.jsp 
	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public ModelAndView welcomeStudent(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageUser", roleId))
			return new ModelAndView("403");
		else
		{
			StudentBean studentBean = new StudentBean(); // declaring

			model.addAttribute("studentBean", studentBean); // adding in model

			return new ModelAndView("addStudent");
		}
	}
	
	//to navigate to addFaculty.jsp
	@RequestMapping(value = "/addfaculty", method = RequestMethod.GET)
	public ModelAndView welcomeFaculty(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageUser", roleId))
			return new ModelAndView("403");
		else
		{
			FacultyBean facultyBean = new FacultyBean(); // declaring

			model.addAttribute("facultyBean", facultyBean); // adding in model
			return new ModelAndView("addFaculty");
		}
	}
	
	
	//to navigate to removeUser.jsp
	@RequestMapping(value = "/removeuser", method = RequestMethod.GET)
	public ModelAndView removeUser(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageUser", roleId))
			return new ModelAndView("403");
		else
		return new ModelAndView("removeUser");		
	}
	
	//actually removing user
	@RequestMapping(value = "/removeUser", method = RequestMethod.POST)
	public ModelAndView removeUser1(@ModelAttribute("command")  StudentBean studentBean,
			BindingResult result, @RequestParam("username")String username) {
		
		ModelAndView model = new ModelAndView("removeUser");
		try{
		
		manageUserService.removeUser(studentBean, username);
		model.addObject("success", 1);
		}	
		catch (Exception e) {
			
			//System.out.println(e.toString());
                        logger.error(e.toString());
			model.addObject("error", 1);
		}
		return model;
	}

}

/*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: ManageUserController.java	
* 	
* Classes used by code: ManageUserService, CheckRoleService,StudentBean,FacultyBean
* 
* Tabes used: User_schema.userdetails,User_schema.personal_profile,User_schema.professional_profile,User_schema.qualification
* 
* Description: This controller is used to add student/add faculty (as well as create directories for them)/remove user .
* 				Can be done only by tpo/admin.
* 
* Functions: addStudent(), addFaculty() ,welcomeStudent(),welcomeFaculty(),removeUser(), removeUser1()		
*




package org.crce.interns.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.crce.interns.beans.FacultyBean;
import org.crce.interns.beans.StudentBean;
import org.crce.interns.model.Student;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.DirectoryService;
import org.crce.interns.service.ManageUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ManageUserController {

	@Autowired
	private ManageUserService manageUserService;
	@Autowired
	private CheckRoleService crService;
	
	 @Autowired
	 private DirectoryService directoryService;
	
	//actually adding student
	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(HttpServletRequest request, @ModelAttribute("studentBean")StudentBean studentBean,BindingResult result) {
		
		ModelAndView model = new ModelAndView("addStudent"); 
		try {
			manageUserService.addStudent(request, studentBean);
			model.addObject("success", 1);
			directoryService.createStudentFolder();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			
			System.out.println(e.toString());
			model.addObject("error", 1);
		}
		return model;
	}
	
	//actually adding faculty
	@RequestMapping(value = "/registerFaculty", method = RequestMethod.POST)
	public ModelAndView addFaculty(HttpServletRequest request,@ModelAttribute("facultyBean")FacultyBean facultyBean,BindingResult result) {
		
		ModelAndView model = new ModelAndView("addFaculty");
		try{
		manageUserService.addFaculty(request, facultyBean);
		model.addObject("success", 1);
		directoryService.createFacultyFolder();
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			
			System.out.println(e.toString());
			model.addObject("error", 1);
		}
		return model;
		
	}
	
	
	//to navigate to addStudent.jsp 
	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public ModelAndView welcomeStudent(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageUser", roleId))
			return new ModelAndView("403");
		else
		{
			StudentBean studentBean = new StudentBean(); // declaring

			model.addAttribute("studentBean", studentBean); // adding in model

			return new ModelAndView("addStudent");
		}
	}
	
	//to navigate to addFaculty.jsp
	@RequestMapping(value = "/addfaculty", method = RequestMethod.GET)
	public ModelAndView welcomeFaculty(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageUser", roleId))
			return new ModelAndView("403");
		else
		{
			FacultyBean facultyBean = new FacultyBean(); // declaring

			model.addAttribute("facultyBean", facultyBean); // adding in model
			return new ModelAndView("addFaculty");
		}
	}
	
	
	//to navigate to removeUser.jsp
	@RequestMapping(value = "/removeuser", method = RequestMethod.GET)
	public ModelAndView removeUser(HttpServletRequest request) {
		HttpSession session=request.getSession();
		String roleId=(String)session.getAttribute("roleId");
		if(!crService.checkRole("ManageUser", roleId))
			return new ModelAndView("403");
		else
		return new ModelAndView("removeUser");		
	}
	
	//actually removing user
	@RequestMapping(value = "/removeUser", method = RequestMethod.POST)
	public ModelAndView removeUser1(@ModelAttribute("command")  StudentBean studentBean,
			BindingResult result, @RequestParam("username")String username) {
		
		ModelAndView model = new ModelAndView("removeUser");
		try{
		
		manageUserService.removeUser(studentBean, username);
		model.addObject("success", 1);
		}	
		catch (Exception e) {
			
			System.out.println(e.toString());
			model.addObject("error", 1);
		}
		return model;
	}

}
*/