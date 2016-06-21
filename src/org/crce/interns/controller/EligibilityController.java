/**
 * Author Name: Andrea Furtado
 * Filename: EligiblityController.java	
 * Classes used by code: EligibilityService
* 
* Description: This controller is used to check eligibility of student
* 
* Functions: criteriaCheck()

 */

package org.crce.interns.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.beans.CompanyBean;
import org.crce.interns.service.CompanyService;
import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.EligibilityService;
import org.crce.interns.service.ManageProfileService;
import org.crce.interns.service.NfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EligibilityController {

	@Autowired
	private EligibilityService E_service;

	@Autowired
	private ManageProfileService manageProfileService;

	@Autowired
	private NfService nfService;
        
        private static final Logger logger = Logger.getLogger(EligibilityController.class.getName());

	String msg = "";

	@RequestMapping("/getjob")
	public ModelAndView start() {
		return new ModelAndView("tempform");
	}

	@RequestMapping("/stpcapplies")
	public ModelAndView start1() {
		return new ModelAndView("tempform2");
	}

	/**
	 * the method check whether the student is eligible and directs to fail or
	 * success page accordingly
	 * 
	 * @param request
	 * @param job_id
	 * @return
	 */
	@RequestMapping("/applyforjob")
	public ModelAndView criteriaCheck(HttpServletRequest request, @RequestParam(value = "c_id") int c_id,
			@RequestParam(value = "j_id") String job_id) {
		try {
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("userName");

			//System.out.println("This is user:" + username + "   and c_id: " + c_id);
                        logger.error("This is user:" + username + "   and c_id: " + c_id);

			/*
			 * @author Nevil Dsouza code for notification
			 * 
			 */
			List<CompanyBean> clist = manageProfileService.listCompanies();
			String companyName = "";
			int id = Integer.parseInt(job_id);
			for (CompanyBean cb : clist) {
				if (cb.getCompany_id() == id) {
					companyName = cb.getCompany_name();
				}
			}

			if (E_service.checkCriteria(username, c_id, job_id)) {
				/*
				 * @author Nevil Dsouza code for notification
				 * 
				 */

				if (nfService.addNotificationForJobApply(companyName, username)) {
					System.out.println("notification added");
				} else {
					System.out.println("notification not added");
				}

				return new ModelAndView("eligible");
			} else {
				//System.out.println("oopsie!!  you dont meet the criteria ");
                            logger.error("oopsie!!  you dont meet the criteria ");
				String msg = "Oops....You Don't Meet The Criteria";
				ModelAndView m = new ModelAndView("JobPostsCriteria");
				m.addObject("msg", msg);
				return m;
			}
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	/**
	 * this method finds the criteria associated to job_id and then returns a
	 * criteria object
	 * 
	 * @param job_id
	 * @return
	 */
	@RequestMapping("/dispcriteria")
	public ModelAndView displayCriteriaDetails(@RequestParam(value = "job_id") String job_id) {
		try {
			int criteria_id = E_service.getCriteriaId(job_id);

			System.out.println(criteria_id);

			ModelAndView model = new ModelAndView("JobPostsCriteria");
			model.addObject("criteria", E_service.getCriteria(criteria_id));
			model.addObject("job_id", job_id);

			return model;
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	@RequestMapping("/applyonbehaloffstudent")
	public ModelAndView checkCriteriaFromftpc(HttpServletRequest request, @RequestParam(value = "u_name") String uname,
			@RequestParam(value = "j_id") String job_id) {
		try {
			String userRole = (String) request.getSession(true).getAttribute("roleName");

			if (userRole.equals(ConstantValues.StudentTPCName)) {
				int criteria_id = E_service.getCriteriaId(job_id);
				if (E_service.checkCriteria(uname, criteria_id, job_id))
					return new ModelAndView("eligible");
				else {
					//System.out.println("oopsie!! !!!!  you dont meet the criteria ");
                                        logger.error("oopsie!! !!!!  you dont meet the criteria ");
					String msg = "Oops....You Don't Meet The Criteria";
					ModelAndView m = new ModelAndView("tempform2");
					m.addObject("msg", msg);
					return m;
				}
			}

			else
				return new ModelAndView("403");
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	/*
	 * added for testing
	 * 
	 * 
	 * @RequestMapping("/doCriteriaCheck") public @ResponseBody String
	 * loosesearch(@RequestParam("CHARS") String chars){ public ModelAndView
	 * doCriteriaCheck(HttpServletRequest request,@RequestParam(value="c_id")int
	 * c_id,@RequestParam(value="j_id")String job_id){ HttpSession
	 * session=request.getSession(); String
	 * username=(String)session.getAttribute("userName"); System.out.println(
	 * "This is user:"+username+"   and c_id: "+c_id);
	 * 
	 * 
	 * if(E_service.checkCriteria(username, c_id,job_id)) return new
	 * ModelAndView("eligible");
	 * 
	 * else System.out.println("oopsie!!  you dont meet the criteria "); String
	 * msg="YOU DONT MEET THE CRITERIA !!"; ModelAndView m = new
	 * ModelAndView("dispcriteria"); m.addObject("msg",msg); return m; }
	 */

}
