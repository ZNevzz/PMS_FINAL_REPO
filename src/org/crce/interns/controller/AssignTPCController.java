/*
 * AssignTPCController Class contains the various methods like 
 * Redirect to TPO Home Page
 * Assign TPC
 * Remove TPC
 * Assign special task to FTPC
 * View Users and View Tasks
 * 
 * @author Adarsh
 * 
 * */
package org.crce.interns.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.service.AssignTPCService;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.validators.AddTPCTaskValidator;
import org.crce.interns.validators.AddTPCValidator;
import org.crce.interns.validators.RemoveTPCValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AssignTPCController {

	@Autowired
	private AssignTPCService userService;

	@Autowired
	AddTPCValidator validator;

	@Autowired
	RemoveTPCValidator rvmvalidator;

	@Autowired
	AddTPCTaskValidator addTPCTaskValidator;

	@Autowired
	private CheckRoleService crService;
        
        private static final Logger logger = Logger.getLogger(AssignTPCController.class.getName());

	@RequestMapping(value = "/TPOHome", method = RequestMethod.GET) // Home Page
																	// of TPO
	public ModelAndView goTPOHome(HttpServletRequest request, @ModelAttribute("command") FacultyUserBean userBean,
			BindingResult result) {
		try {
			//System.out.println("In Controller : TPO Home Page\n");
                        logger.error("In Controller : TPO Home Page\n");

			HttpSession session = request.getSession();
			String roleId = (String) session.getAttribute("roleId");

			//new authorization
			if (!crService.checkRole("/TPOHome", roleId))
				return new ModelAndView("403");
			else
				return new ModelAndView("TPO");
		} catch (Exception e) {
                        logger.error("Exception in /TPOHome",e);
			return new ModelAndView("500");
		}
	}

	@RequestMapping(value = "/ViewUsersT", method = RequestMethod.GET) // View
																		// Users
																		// for
																		// TPO
	public ModelAndView viewUsers(HttpServletRequest request) {
		//System.out.println("In Controller: View Users by TPO");
                logger.error("In Controller: View Users by TPO");

		HttpSession session = request.getSession();
		String roleId = (String) session.getAttribute("roleId");

		//new authorization
		if (!crService.checkRole("/ViewUsersT", roleId))
			return new ModelAndView("403");
		else {
			Map<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("users", userService.viewUsers());
			return new ModelAndView("viewUserA", modelMap);
		}
	}

	@RequestMapping(value = "/ViewFacultyTasks", method = RequestMethod.GET) // View
																				// tasks
																				// assigned
																				// to
																				// FTPC
	public ModelAndView viewFacultyTasks(HttpServletRequest request) {
		try {
			//System.out.println("In Controller: View TPC Tasks");
                        logger.error("In Controller: View TPC Tasks");

			HttpSession session = request.getSession();
			String roleId = (String) session.getAttribute("roleId");

			//new authorization
			if (!crService.checkRole("/ViewFacultyTasks", roleId))
				return new ModelAndView("403");
			else {
				Map<String, Object> modelMap = new HashMap<String, Object>();
				modelMap.put("fusers", userService.viewFacultyTasks());
				return new ModelAndView("viewFacultyTasks", modelMap);
			}
		} catch (Exception e) {
                        logger.error("Exception /ViewFacultyTasks ",e);
			return new ModelAndView("500");
		}
	}

	@RequestMapping(value = "/InsertWork", method = RequestMethod.GET) // Call
																		// to
																		// jsp
																		// to
																		// get
																		// the
																		// task
	public ModelAndView createUserWork(HttpServletRequest request, @ModelAttribute("command") FacultyUserBean userBean,
			BindingResult result) {
		try {
			//System.out.println("In Controller: Assign TPC Work\n");
                        logger.error("In Controller: Assign TPC Work\n");
			HttpSession session = request.getSession();
			String roleId = (String) session.getAttribute("roleId");

			//new authorization
			if (!crService.checkRole("/InsertWork", roleId))
				return new ModelAndView("403");
			else {
				Map<String, Object> modelMap = new HashMap<String, Object>();
				modelMap.put("fusers", userService.viewFacultyTasks());
				return new ModelAndView("insertWork", modelMap);
			}
		} catch (Exception e) {
                        logger.error("Exception ",e);
			return new ModelAndView("500");
		}
	}

	@RequestMapping(value = "/AssignTPC", method = RequestMethod.GET) // Call to
																		// jsp
																		// to
																		// get
																		// username
																		// and
																		// role
	public ModelAndView assignTPC(HttpServletRequest request, @ModelAttribute("command") UserDetailsBean userBean,
			BindingResult result) {
		try {
			//System.out.println("In Controller: Assign TPC\n");
                        logger.error("In Controller Assign TPC");
			HttpSession session = request.getSession();
			String roleId = (String) session.getAttribute("roleId");

			
			if (!crService.checkRole("AssignTPC", roleId))
				return new ModelAndView("403");
			else
				return new ModelAndView("assignTPC");
		} catch (Exception e) {
                        logger.error("Exception /AssignTPC ",e);
			return new ModelAndView("500");
		}
	}

	@RequestMapping(value = "/RemoveTPC", method = RequestMethod.GET) // Call to
																		// jsp
																		// to
																		// get
																		// usernam
	public ModelAndView removeTPC(HttpServletRequest request, @ModelAttribute("command") UserDetailsBean userBean,
			BindingResult result) {
		try {
			//System.out.println("In Controller: Remove TPC\n");
                        logger.error("RemoveTPC");
			HttpSession session = request.getSession();
			String roleId = (String) session.getAttribute("roleId");

			//new authorization
			if (!crService.checkRole("/RemoveTPC", roleId))
				return new ModelAndView("403");
			else
				return new ModelAndView("removeTPC");
		} catch (Exception e) {
                        logger.error("Exception Remove TPC ",e);
			return new ModelAndView("500");
		}
	}

	//authorization done - unauthorized call redirected to 405.jsp
	@RequestMapping(value = "/SubmitAssignTPC", method = RequestMethod.POST)
	public ModelAndView submitAssignTPC(HttpServletRequest request, @ModelAttribute("command") UserDetailsBean userBean,
			/* @ModelAttribute("fuserBean")FacultyUserBean fuserBean, */ BindingResult bindingResult) {
		//System.out.println("In Controller: Submit Assign TPC");
                logger.error("In Controller: Submit Assign TPC");
		try {
			ModelAndView model;
			String erroMesg = "";
			int a;

			validator.validate(userBean, bindingResult);

			if (bindingResult.hasErrors()) {
				//System.out.println("Binding Errors are present...");
                                logger.error("Binding Errors are present...");
				return new ModelAndView("assignTPC");
			}

			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");

			userBean.setModifiedBy(userName);
			userBean.setModifiedDate(new Date());

			a = userService.assignTPC(userBean);
			//System.out.println("Value Returned from Service: " + a);
                        logger.error("Value Returned from Service: " + a);

			if (a == 0)// No such user exists in UserDetails Table
			{
				model = new ModelAndView("assignTPC");
				erroMesg += "No such user exists";
				model.addObject("erroMesg", erroMesg);
				// return new ModelAndView("noUser");
			} else if (a == 3)// A Non-Student user attempted to be assigned as
								// STPC
			{
				model = new ModelAndView("assignTPC");
				erroMesg += "A Non-Student user attempted to be assigned as STPC";
				model.addObject("erroMesg", erroMesg);
				// return new ModelAndView("notStud");
			} else if (a == 4)// A Non-Faculty user attempted to be assigned as
								// STPC
			{
				model = new ModelAndView("assignTPC");
				erroMesg += "A Non-Faculty user attempted to be assigned as FTPC";
				model.addObject("erroMesg", erroMesg);
				// return new ModelAndView("notFac");
			} else if (a == 34) { // Already assigned STPC or FTPC user
									// attempted to be assigned as TPC
				model = new ModelAndView("assignTPC");
				erroMesg += "Already assigned STPC or FTPC user attempted to be assigned as TPC";
				model.addObject("erroMesg", erroMesg);
				// return new ModelAndView("alTPC");
			} else
				model = new ModelAndView("redirect:/ViewUsersT");

			return model;
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error("Exception ",e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/SubmitAssignTPC");
			return model;
		}
		// return new ModelAndView("redirect:/ViewUsersT");
		// return new ModelAndView("redirect:/TPOHome");
	}

	@RequestMapping(value = "/SubmitInsertWork", method = RequestMethod.POST)
	public ModelAndView createWork(@ModelAttribute("command") FacultyUserBean fuserBean, BindingResult bindingResult) {
		//System.out.println("In Controller: Submit TPC Work");
                logger.error("In Controller: Submit TPC Work");
		try {
			ModelAndView model;
			String erroMesg = "";
			int a;

			addTPCTaskValidator.validate(fuserBean, bindingResult);

			if (bindingResult.hasErrors()) {
				System.out.println("Binding Errors are present...");
				return new ModelAndView("insertWork");
			}

			a = userService.insertWork(fuserBean);
			System.out.println("Value Returned from Service: " + a);

			if (a == 0)// No such user exists in Table
			{
				model = new ModelAndView("insertWork");
				erroMesg += "No such user exists";
				model.addObject("erroMesg", erroMesg);
				// return new ModelAndView("noUser");
			} else
				model = new ModelAndView("redirect:/ViewFacultyTasks");

			return model;
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error("Exception ",e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/SubmitInsertWork");
			return model;
		}
		// return new ModelAndView("redirect:/ViewFacultyTasks");
	}

	@RequestMapping(value = "/SubmitRemoveTPC", method = RequestMethod.POST)
	public ModelAndView submitRemoveTPC(HttpServletRequest request, @ModelAttribute("command") UserDetailsBean userBean,
			BindingResult bindingResult) {
		//System.out.println("In Controller: Submit Remove TPC");
                logger.error("In Controller: Submit Remove TPC");
		try {
			int a;
			ModelAndView model;
			String erroMesg = "";

			rvmvalidator.validate(userBean, bindingResult);

			if (bindingResult.hasErrors()) {
				//System.out.println("Binding Errors are present...");
                                logger.error("Binding Errors are present...");
				return new ModelAndView("removeTPC");
			}

			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");

			userBean.setModifiedBy(userName);
			userBean.setModifiedDate(new Date());

			a = userService.removeTPC(userBean);
			//System.out.println("Value Returned from Service: " + a);
                        logger.error("Value Returned from Service: " + a);

			if (a == 0)// No such user exists in UserDetails Table
			{
				model = new ModelAndView("removeTPC");
				erroMesg += "No such user exists";
				model.addObject("erroMesg", erroMesg);
				// return new ModelAndView("noUser");
			} else if (a == 33)// User attempted to be removed is not a TPC
			{
				model = new ModelAndView("removeTPC");
				erroMesg += "User attempted to be removed from TPC post is not a TPC";
				model.addObject("erroMesg", erroMesg);
				// return new ModelAndView("notTPC");
			} else
				model = new ModelAndView("redirect:/ViewUsersT");

			return model;
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error("Exception ",e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/SubmitRemoveTPC");
			return model;
		}
		// return new ModelAndView("redirect:/ViewUsersT");
		// return new ModelAndView("redirect:/TPOHome");
	}

	/*
	 * @RequestMapping(value="/ViewCurrentTPC", method =
	 * RequestMethod.GET)//View Users for TPO public ModelAndView
	 * viewCurrentTPC(HttpServletRequest request) { System.out.println(
	 * "In Controller: View Current Year TPCs"); String year="2016"; Map<String,
	 * Object> modelMap = new HashMap<String, Object>(); modelMap.put("users",
	 * userService.viewTPCs(year)); return new ModelAndView("viewUserT",
	 * modelMap); }
	 */
}
