package org.crce.interns.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.ProfileService;
import org.crce.interns.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HighlightsController implements ConstantValues {

	@Autowired
	private ProfileService profileService;
	
	
	
	@RequestMapping(value="/Statistics", method = RequestMethod.GET)
	
	public ModelAndView Statistics(HttpServletRequest request) {
	
		return new ModelAndView("list");
	}

	
	@RequestMapping(value="/tpclist", method = RequestMethod.GET)
	
	public ModelAndView tpclist(@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
	
		return new ModelAndView("tpclist");
	}
	
	@RequestMapping(value="/stats", method = RequestMethod.GET)
	
	public ModelAndView stats(@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
	
		return new ModelAndView("stats");
	}

	@RequestMapping(value="/company", method = RequestMethod.GET)
	
	public ModelAndView company(@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
	
		return new ModelAndView("CompaniesPage");
	}

	


	
	
	@RequestMapping(value="/studentlist", method = RequestMethod.GET)	
	public ModelAndView studentList(
			@RequestParam("year") String curYear,
			final RedirectAttributes redirectAttributes) {
		
		Map<String, Set<String>> result = profileService.totalStudents(curYear);
		
		ModelAndView model = new ModelAndView("studentlist");
		
		model.addObject("comps",result.get(ConstantValues.COMPS));
		model.addObject("it",result.get(ConstantValues.IT));
		model.addObject("elex",result.get(ConstantValues.ELEX));
		model.addObject("prod",result.get(ConstantValues.PROD));
		
		
		return model;
	}


	
	
	@RequestMapping(value="/test-yearwise", method = RequestMethod.GET)
	
	public ModelAndView year(HttpServletRequest request) {
		profileService.listProfessionalProfile("2016");
		return new ModelAndView("list");
	}
	

}
