package org.crce.interns.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.log4j.Logger;

import org.crce.interns.beans.LoginForm;
import org.crce.interns.beans.NotifyForm;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.DirectoryService;
import org.crce.interns.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController{

	
	@Autowired
	public LoginService loginService;
	
	@Autowired
	private CheckRoleService crService;
        
   	@Autowired
    private DirectoryService directoryService;
        
        private static final Logger logger = Logger.getLogger(LoginController.class.getName()); 
    
   	//----------------------------------------------------------------------------------------------------------
	

	
	@RequestMapping("/")

	public ModelAndView welcome() throws ParseException {
		
		try{
				//System.out.println("return model");
                                logger.error("Return Model : Mapping /");
                /**
                 * Year changing logic
                 * @author Leon
                 * Starts here
                 * Have taken 25th May(month is 0-based) and 25th July as threshold date
                 * As by this time all placement activities are done
                 * and system is fed with data for the next batch
                 * Works perfectly fine and . If any issues, Please tell me.
                 */
                String startDate = Integer.toString(Calendar.getInstance().get(Calendar.YEAR))+"-04-25";
                String endDate = Integer.toString(Calendar.getInstance().get(Calendar.YEAR))+"-06-25";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = sdf.parse(startDate);
                Date d2 = sdf.parse(endDate);
                /*
                if(d1.compareTo(d2)<0){
                    System.out.println("d1 is after");
                }*/
                //Timestamp basis for logging
                //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
                Date currentDate = new Date(); //gets current date
                if((currentDate.after(d1)) && (currentDate.before(d2))){
                directoryService.createSystemFolders();
                }
                /**
                 * End of @author Leon's code
                 */
                return new ModelAndView("redirect:/form");
		}
		catch(Exception e){
			//System.out.println(e);
                    logger.error("Exception in / ",e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/");
			return model;
		}


	}
	
   	//----------------------------------------------------------------------------------------------------------
	@RequestMapping(value="/form" , method = RequestMethod.GET)  
  	public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response) {

	try
	{
		//System.out.println("Inside Login Controller");
                logger.error("Inside Login Controller /form");
		LoginForm loginForm = new LoginForm();
		ModelAndView model=null;
		model = new ModelAndView("Login");
		model.addObject("loginForm", loginForm);
		
		return model;	
	}
	catch(Exception e)
	{
		//System.out.println(e);
            logger.error("Exception in /form ",e);
		ModelAndView model=new ModelAndView("500");
		model.addObject("exception", "loginForm");
		return model;
	}
	}

	//----------------------------------------------------------------------------------------------------------	
	@RequestMapping(value="/logged-out" , method = RequestMethod.GET)  
  	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
	try{
		//System.out.println("Inside Controller");	
            logger.error("Inside /logged-out");
		ModelAndView model=null;		
		model = new ModelAndView("redirect:/sign-out");				
		return model;
	}
	catch(Exception e){
		//System.out.println(e);
            logger.error("Exception in /logged-out ",e);
		ModelAndView model=new ModelAndView("500");
		model.addObject("exception", "/logged-out");
		return model;
	}
		
	}
   	//----------------------------------------------------------------------------------------------------------	
	@RequestMapping(value="/logged" ,method = RequestMethod.POST)
	public ModelAndView processForm(HttpServletRequest request,
			 @Valid LoginForm loginForm, BindingResult result) {



	try
	{
		//System.out.println("Inside Controller");
            logger.error("Inside /logged");
		ModelAndView model=null;	
		// get role
		String role=loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());		
		
	
		/**
		 * @author Nevil Dsouza @ZNevzz
		 * below code if changed by me, because role checking will be done in
		 * UpdateProfileController since,
		 * page re direction is done from UpdateProfileController.login() method actor-wise
		 */
		model = new ModelAndView("redirect:/viewprofile");
		
		if(role.equals("Student")){
							    
		    request.getSession(true).setAttribute("userName", request.getParameter("userName") );
		    request.getSession(true).setAttribute("roleId", "1" );		    
		    request.getSession(true).setAttribute("roleName", "Student" );
		    return model;
		    
		}else if(role.equals("FacultyTPC")){
			
			request.getSession(true).setAttribute("userName", request.getParameter("userName") );
		    request.getSession(true).setAttribute("roleId", "4" );		    
		    request.getSession(true).setAttribute("roleName", "FacultyTPC" );
		    
			return model;
			
		}else if(role.equals("StudentTPC")){
			
			request.getSession(true).setAttribute("userName", request.getParameter("userName") );
		    request.getSession(true).setAttribute("roleId", "3" );		    
		    request.getSession(true).setAttribute("roleName", "StudentTPC" );
		    
			return model;
		}
		else if(role.equals("TPO"))
		{
			request.getSession(true).setAttribute("userName", request.getParameter("userName") );
		    request.getSession(true).setAttribute("roleId", "5" );		    
		    request.getSession(true).setAttribute("roleName", "TPO" );
			return model;
		}
		else if(role.equals("Admin"))
		{
			request.getSession(true).setAttribute("userName", request.getParameter("userName") );
		    request.getSession(true).setAttribute("roleId", "6" );		    
		    request.getSession(true).setAttribute("roleName", "Admin");
			return model;
		}
		else if(role.equals("Faculty"))
		{
			request.getSession(true).setAttribute("userName", request.getParameter("userName") );
		    request.getSession(true).setAttribute("roleId", "2" );		    
		    request.getSession(true).setAttribute("roleName", "Faculty");
			return model;
		}
		else{
			
			result.rejectValue("userName","invaliduser");
			model = new ModelAndView("Login");
			return model;
		}
	}

	catch(Exception e)
	{
		//System.out.println(e);
            logger.error("Exception in /logged ",e);
		ModelAndView model=new ModelAndView("500");
		model.addObject("exception", "Logged page");
		return model;
	}
}
	

   	//----------------------------------------------------------------------------------------------------------	


	
   	//----------------------------------------------------------------------------------------------------------
}
