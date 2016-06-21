
/**
 * @author Nevil Dsouza ZNevzz
 *	Description : Handles all functions related to view and edit student profile. 
 *	View pages : Called by LoginController when student logs in
 *	DEPENDENCIES: 
 * 	beans-	PersonalProfileBean;ProfessionalProfileBean;UserDetailsBean;
 * 	service-ProfileService;CheckRoleService;SearchService;
 */
package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.crce.interns.beans.Event_detailsBean;
import org.crce.interns.beans.LoginForm;
import org.crce.interns.beans.PersonalProfileBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.Company;
import org.crce.interns.model.PersonalProfile;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.ProfileService;
import org.crce.interns.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import org.apache.log4j.Logger;

@Controller
public class UpdateProfileController {

	@Autowired
	private ProfileService profileService;
	@Autowired
	private CheckRoleService crService;
	@Autowired
	private SearchService searchService;
        
        private static final Logger logger = Logger.getLogger(UpdateProfileController.class.getName());

	// ------------------------------------------------------------------------------------------------------
	// //

	/**
	 * GET details from database + POST login details
	 * 
	 * @author Nevil Dsouza
	 * @param HttpServletRequest
	 * @return MOdelAndView RoleName.jsp
	 *
	 *         returns data from userdetails,personal,professional tables
	 *
	 */

	@RequestMapping(value = "/viewprofile", method = RequestMethod.GET)

	public ModelAndView login(HttpServletRequest request) {

		System.out.println("Inside UpdateProfile Controller");

		try {
			String userName = (String) request.getSession(true).getAttribute("userName");
			String roleId = (String) request.getSession(true).getAttribute("roleId");

			// if(!crService.checkRole("UpdateProfile", roleId))
			// return new ModelAndView("403");
			// else
			// {
			ModelAndView model = null;

			UserDetailsBean userDetailsBean = new UserDetailsBean();
			ProfessionalProfileBean professionalProfileBean = new ProfessionalProfileBean();
			PersonalProfileBean personalProfileBean = new PersonalProfileBean();

			userDetailsBean.setUserName(userName);
			userDetailsBean = profileService.getProfile(userDetailsBean);

			userDetailsBean.setAccountActive("YES");
			userDetailsBean.setCurrentState("online");
			userDetailsBean.setLastLogin(new Date());
			userDetailsBean.setModifiedBy(userDetailsBean.getUserName());
			userDetailsBean.setModifiedDate(new Date());

			professionalProfileBean.setUserName(userName);
			personalProfileBean.setUserName(userName);

			userDetailsBean = profileService.updateUserDetails(userDetailsBean);

			professionalProfileBean = profileService.getProfile(professionalProfileBean);
			personalProfileBean = profileService.getProfile(personalProfileBean);

			request.getSession(true).setAttribute("name", personalProfileBean.getName());
			request.getSession(true).setAttribute("branch", professionalProfileBean.getBranch());
			request.getSession(true).setAttribute("year", professionalProfileBean.getYear());

			String roleName = (String) request.getSession(true).getAttribute("roleName");

			if (roleName.equals("Student")) {
				model = new ModelAndView("Student");

			} else if (roleName.equals("StudentTPC")) {

				model = new ModelAndView("Student");

			} else if (roleName.equals("Faculty")) {
				model = new ModelAndView("Faculty");

			} else if (roleName.equals("FacultyTPC")) {
				model = new ModelAndView("FacultyTPC");

			} else if (roleName.equals("TPO")) {
				model = new ModelAndView("TPO");

			} else if (roleName.equals("Admin")) {
				model = new ModelAndView("Admin");
			}

			model.addObject("userDetails", userDetailsBean);
			model.addObject("professionalProfile", professionalProfileBean);
			model.addObject("personalProfile", personalProfileBean);

			return model;
		}
		// }
		catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("message", "Your session has timed out. Please login again");
			model.addObject("url", "form");

			return model;
		}
	}

	// -----------------------------------------------------------------------------------------//
	/**
	 * GET form to edit profile
	 * 
	 * @author Nevil Dsouza
	 * @param HttpServletRequest
	 * @return MOdelAndView viewprofile.jsp
	 *
	 *         returns form to edit personal,professional tables
	 *
	 */

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editProfessionalProfile(HttpServletRequest request) {

		System.out.println("Inside UpdateProfile Controller");
		try {
			String id = (String) request.getSession(true).getAttribute("userName");
			String roleId = (String) request.getSession(true).getAttribute("roleId");

			ModelAndView model = null;
			model = new ModelAndView("viewprofile");

			UserDetailsBean userDetailsBean = new UserDetailsBean();
			ProfessionalProfileBean professionalProfileBean = new ProfessionalProfileBean();
			PersonalProfileBean personalProfileBean = new PersonalProfileBean();

			userDetailsBean.setUserName(id);
			professionalProfileBean.setUserName(id);
			personalProfileBean.setUserName(id);

			userDetailsBean = profileService.getProfile(userDetailsBean);
			professionalProfileBean = profileService.getProfile(professionalProfileBean);
			personalProfileBean = profileService.getProfile(personalProfileBean);

			model.addObject("userDetails", userDetailsBean);
			model.addObject("professionalProfile", professionalProfileBean);
			model.addObject("personalProfile", personalProfileBean);

			return model;
			// }
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("message", "Your session has timed out. Please login again");
			model.addObject("url", "form");
			return model;
		}
	}

	// ------------------------------------------------------------------------------------------------------------------
	/**
	 * POST edit profile form to database
	 * 
	 * @author Nevil Dsouza
	 * @param HttpServletRequest,@RequestParam
	 *            Map<String, String>,HttpServletResponse
	 * @return MOdelAndView Student.jsp
	 *
	 *         persists values from form to database
	 *
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateProfessionalProfile(@RequestParam Map<String, String> r, HttpServletRequest request) {

		System.out.println("Inside UpdateProfile Controller");

		try {

			String id = (String) request.getSession(true).getAttribute("userName");
			String roleId = (String) request.getSession(true).getAttribute("roleId");

			ModelAndView model = null;
			model = new ModelAndView("redirect:/viewprofile");

			ProfessionalProfileBean professionalProfileBean = new ProfessionalProfileBean();
			UserDetailsBean userDetailsBean = new UserDetailsBean();
			PersonalProfileBean personalProfileBean = new PersonalProfileBean();

			professionalProfileBean.setUserName(id);
			userDetailsBean.setUserName(id);
			personalProfileBean.setUserName(id);

			professionalProfileBean = profileService.getProfile(professionalProfileBean);
			personalProfileBean = profileService.getProfile(personalProfileBean);
			// set values from Map to Bean
			professionalProfileBean.setFieldOfInterest(r.get("fieldOfInterest"));
			professionalProfileBean.setAchievements(r.get("achievements"));
			professionalProfileBean.setProjects(r.get("projects"));
			professionalProfileBean.setInternships(r.get("internships"));
			professionalProfileBean.setCoCurricularActivities(r.get("coCurricularActivities"));
			professionalProfileBean.setExtraCurricularActivities(r.get("extraCurricularActivities"));
			professionalProfileBean.setModifiedBy((String) request.getSession(true).getAttribute("userName"));
			professionalProfileBean.setModifiedDate(new Date());

			personalProfileBean.setCorrespondenceAddress(r.get("correspondenceAddress"));
			personalProfileBean.setPermanentAddress(r.get("permanentAddress"));
			personalProfileBean.setModifiedBy((String) request.getSession(true).getAttribute("userName"));
			personalProfileBean.setModifiedDate(new Date());

			personalProfileBean = profileService.updatePersonalProfile(personalProfileBean);
			professionalProfileBean = profileService.updateProfessionalProfile(professionalProfileBean);

			return model;
			// }
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("message", "Your session has timed out. Please login again");
			model.addObject("url", "form");

			return model;
		}
	}

	// -----------------------------------------------------------------------------------------//
	/**
	 * POST logout details in database
	 * 
	 * @author Nevil Dsouza
	 * @param HttpServletRequest
	 * @return MOdelAndView Login.jsp
	 *
	 *         invalidates Session and persists logout details in database
	 *
	 */
	@RequestMapping(value = "/sign-out", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {

		System.out.println("Inside UpdateProfile Controller");
		try {

			ModelAndView model = null;
			model = new ModelAndView("redirect:/form");

			UserDetailsBean userDetailsBean = new UserDetailsBean();
			userDetailsBean.setUserName((String) request.getSession(true).getAttribute("userName"));
			userDetailsBean = profileService.getProfile(userDetailsBean);

			userDetailsBean.setCurrentState("offline");
			userDetailsBean.setModifiedBy(userDetailsBean.getUserName());
			userDetailsBean.setModifiedDate(new Date());
			userDetailsBean = profileService.updateUserDetails(userDetailsBean);

			request.getSession(true).invalidate();

			// model.addObject("loginForm", loginForm);

			return model;
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("message", "Your session has timed out. Please login again");
			model.addObject("url", "form");

			return model;
		}

	}

	// -----------------------------------------------------------------------------------------//

	// -----------------------------------------------------
	// extra
	/*
	 * @RequestMapping(value="/update-password", method = RequestMethod.POST)
	 * public ModelAndView updateUserDetails(@RequestParam("username") String
	 * username,@RequestParam("password") String password) {
	 * 
	 * System.out.println("Inside Controller");
	 * 
	 * ModelAndView model=null;
	 * 
	 * 
	 * UserDetailsBean userDetailsBean= new UserDetailsBean();
	 * ProfessionalProfileBean professionalProfileBean=new
	 * ProfessionalProfileBean(); PersonalProfileBean personalProfileBean=new
	 * PersonalProfileBean();
	 * 
	 * 
	 * 
	 * 
	 * userDetailsBean.setUserName(username);
	 * 
	 * professionalProfileBean.setUserName(username);
	 * personalProfileBean.setUserName(username);
	 * 
	 * 
	 * userDetailsBean = profileService.getProfile(userDetailsBean);
	 * professionalProfileBean =
	 * profileService.getProfile(professionalProfileBean); personalProfileBean =
	 * profileService.getProfile(personalProfileBean);
	 * 
	 * 
	 * 
	 * userDetailsBean = profileService.updateUserDetails(userDetailsBean);
	 * 
	 * 
	 * 
	 * model = new ModelAndView("viewprofile"); model.addObject("change",true);
	 * model.addObject("userDetails",userDetailsBean);
	 * model.addObject("professionalProfile",professionalProfileBean);
	 * model.addObject("personalProfile",personalProfileBean);
	 * 
	 * return model; }
	 */
	// -----------------------------------------------------
	// extra
	@RequestMapping(value = "/nevz-feedback", method = RequestMethod.GET)
	public ModelAndView f(HttpServletRequest request) {
		try {
			System.out.println("Inside UpdateController");
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("userName");
			String roleId = (String) session.getAttribute("roleId");
			/*
			 * if(!crService.checkRole("UpdateProfile", roleId)) return new
			 * ModelAndView("403"); else {
			 */
			ModelAndView model = null;

			model = new ModelAndView("FeedbackForm");

			return model;
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
		// }
	}

	// -----------------------------------------------------
	// extra
	@RequestMapping(value = "/nevz-feedbacks", method = RequestMethod.GET)
	public ModelAndView fs(HttpServletRequest request) {
		try {
			System.out.println("Inside Controller");
			HttpSession session = request.getSession();
			String id = (String) session.getAttribute("userName");
			String roleId = (String) session.getAttribute("roleId");
			/*
			 * if(!crService.checkRole("UpdateProfile", roleId)) return new
			 * ModelAndView("403"); else {
			 */
			ModelAndView model = null;

			model = new ModelAndView("feedbacks");

			return model;
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
		// }
	}

	// ----------------------------------------------------------------------------------------------

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	public @ResponseBody String getanswer(@RequestParam(value = "num1") int n1, @RequestParam(value = "num2") int n2) {
		int n3 = n1 + n2;
		String result = "result is" + n3;
		return result;
	}

	// ----------------------------------------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------
	// AJAX test controller method
	@RequestMapping("/test")
	public ModelAndView helloajax1() {
		return new ModelAndView("test", "message", "Spring with ajax and jquery");
	}

	@RequestMapping("/test2")
	public ModelAndView helloajax2() {
		return new ModelAndView("test2", "message", "Spring with ajax and jquery");
	}

	// ----------------------------------------------------------------------------------------------

	@RequestMapping("/looseSearch")
	public @ResponseBody String loosesearch(@RequestParam("CHARS") String chars) {
		try {
			List<PersonalProfile> userDetailsList = new ArrayList<PersonalProfile>();
			userDetailsList = searchService.searchUser(chars);
			System.out.println(userDetailsList.size());

			// ObjectMapper obj= new ObjectMapper();

			// return userDetailsList.get(0);

			return new Gson().toJson(userDetailsList);
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			// ModelAndView model=new ModelAndView("500");
			// model.addObject("exception", "/viewprofile");
			return "exception at /looseSearch";
		}
	}

	@RequestMapping("/looseSearch2")
	public @ResponseBody String loosesearch2(@RequestParam("CHARS") String chars) {
		try {

			List<Company> companyList = new ArrayList<Company>();
			companyList = searchService.searchCompany(chars);
			//System.out.println(companyList.size());
                        logger.error(companyList.size());

			// ObjectMapper obj= new ObjectMapper();

			// return userDetailsList.get(0);

			return new Gson().toJson(companyList);
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			// ModelAndView model=new ModelAndView("500");
			// model.addObject("exception", "/viewprofile");
			return "exception at /looseSearch2";
		}

	}

	@RequestMapping(value = "/searchProfile", method = RequestMethod.GET)

	public ModelAndView search(final RedirectAttributes redirectAttributes, @RequestParam String userName) {

		try {
			//System.out.println("Inside UpdateProfile Controller");
                        logger.error("Inside UpdateProfile Controller");

			ModelAndView model = null;

			UserDetailsBean userDetailsBean = new UserDetailsBean();
			ProfessionalProfileBean professionalProfileBean = new ProfessionalProfileBean();
			PersonalProfileBean personalProfileBean = new PersonalProfileBean();

			userDetailsBean.setUserName(userName);
			professionalProfileBean.setUserName(userName);
			personalProfileBean.setUserName(userName);

			userDetailsBean = profileService.getProfile(userDetailsBean);
			professionalProfileBean = profileService.getProfile(professionalProfileBean);
			personalProfileBean = profileService.getProfile(personalProfileBean);

			redirectAttributes.addFlashAttribute("userDetails", userDetailsBean);
			redirectAttributes.addFlashAttribute("professionalProfile", professionalProfileBean);
			redirectAttributes.addFlashAttribute("personalProfile", personalProfileBean);

			if (userDetailsBean.getRoleId().equals("1") || userDetailsBean.getRoleId().equals("3")) {
				model = new ModelAndView("redirect:/searchStudent");
			} else {
				model = new ModelAndView("redirect:/searchStaff");
			}

			return model;
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("message", "Your session has timed out. Please login again");
			model.addObject("url", "form");

			return model;
		}
	}

	@RequestMapping(value = "/searchStaff", method = RequestMethod.GET)

	public ModelAndView searchStaff(@ModelAttribute("userDetails") final UserDetailsBean userDetailsBean,
			@ModelAttribute("professionalProfile") final ProfessionalProfileBean professionalProfileBean,
			@ModelAttribute("personalProfile") final PersonalProfileBean personalProfileBean) {

		try {

			ModelAndView model = new ModelAndView("searchStaff");
			model.addObject("userDetails", userDetailsBean);
			model.addObject("professionalProfile", professionalProfileBean);
			model.addObject("personalProfile", personalProfileBean);
			return model;

		} catch (Exception e) {
			//System.out.println(e);
                    logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("message", "Your session has timed out. Please login again");
			model.addObject("url", "form");

			return model;
		}

	}

	@RequestMapping(value = "/searchStudent", method = RequestMethod.GET)

	public ModelAndView searchStudent(@ModelAttribute("userDetails") final UserDetailsBean userDetailsBean,
			@ModelAttribute("professionalProfile") final ProfessionalProfileBean professionalProfileBean,
			@ModelAttribute("personalProfile") final PersonalProfileBean personalProfileBean) {

		try {

			ModelAndView model = new ModelAndView("searchStudent");
			model.addObject("userDetails", userDetailsBean);
			model.addObject("professionalProfile", professionalProfileBean);
			model.addObject("personalProfile", personalProfileBean);
			return model;

		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("message", "Your session has timed out. Please login again");
			model.addObject("url", "form");

			return model;
		}

	}
}

/*

*/
