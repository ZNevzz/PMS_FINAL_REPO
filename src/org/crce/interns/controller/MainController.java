package org.crce.interns.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	/*
	 * @RequestMapping("/CompaniesPage") public String companiespage() { return
	 * "CompaniesPage"; }
	 * 
	 * 
	 * @RequestMapping("/JobPosts") public ModelAndView
	 * JobPosts(HttpServletRequest request) { ModelAndView model = new
	 * ModelAndView("JobPosts"); model.addObject("companyname",
	 * request.getParameter("companyname")); return model; }
	 */

	@RequestMapping("/JobApplicants")
	public ModelAndView JobApplicants(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("JobApplicants");
		model.addObject("companyname", request.getParameter("companyname"));
		return model;
	}

	@RequestMapping("/EventsPages")
	public ModelAndView EventsPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("EventsPage");
		return model;
	}

	/*
	 * @RequestMapping("/Company") public ModelAndView
	 * company(HttpServletRequest request) { ModelAndView model = new
	 * ModelAndView("Company"); model.addObject("companyname",
	 * request.getParameter("companyname")); return model; }
	 */
	@RequestMapping("/JobPostsCriteria")
	public ModelAndView JobPostsCriteria(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("JobPostsCriteria");
		model.addObject("companyname", request.getParameter("companyname"));
		return model;
	}

	@RequestMapping("/addJobPost")
	public String addjobpost() {
		return "addJobPost";
	}

	@RequestMapping("/CompanyFeedback")
	public String companyfeedback() {
		return "CompanyFeedback";
	}

	@RequestMapping("/EventsPage")
	public String eventspage() {
		return "EventsPage";
	}
	
	@RequestMapping("/FAQ")
	public String FAQ() {
		return "FAQ";
	}
	@RequestMapping("/about_us")
	public String about_us() {
		return "about_us";
	}
	@RequestMapping("/")
	public String homepage() {
		return "home";
	}
}
