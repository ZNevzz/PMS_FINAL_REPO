package org.crce.interns.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crce.interns.model.Company;
import org.crce.interns.model.PersonalProfile;
import org.crce.interns.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

/*Author melwyn95
 *Commented by melwyn95
 This class contains 3 methods
 1>welcomeSearch
 2>searchUser
 3>searchCompany
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
        
        private static final Logger logger = Logger.getLogger(SearchController.class.getName());

	/*
	 * This method is used to handle the urlmapping for the searchbar
	 */
	@RequestMapping(value = "/searchHome", method = RequestMethod.GET)
	public ModelAndView welcomeSearch() {
		//System.out.println("searchBar");
                logger.error("searchBar");
		return new ModelAndView("searchbar");
	}

	/*
	 * This method take's a searchString and checks is occurance in the userName
	 * filed of userDstails
	 */
	@RequestMapping(value = "/SearchUser", method = RequestMethod.GET)
	public ModelAndView searchUser(@RequestParam("searchString") String searchString) {
		try {
			//System.out.println(searchString);
                        logger.error(searchString);
			List<PersonalProfile> userDetailsList = null;
			if (!searchString.equals(""))
				userDetailsList = searchService.searchUser(searchString);
			Map<String, Object> modelMap = new HashMap<>();
			modelMap.put("userList", userDetailsList);
			return new ModelAndView("searchbar", modelMap);
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	/*
	 * This method take's a searchString and checks is occurance in the
	 * comnpanyName
	 */
	@RequestMapping(value = "/SearchCompany", method = RequestMethod.GET)
	public ModelAndView searchCompany(@RequestParam("searchString") String searchString) {
		try {
			//System.out.println(searchString);
                        logger.error(searchString);
			List<Company> companyList = null;
			if (!searchString.matches("\\s*"))
				companyList = searchService.searchCompany(searchString);
			Map<String, Object> modelMap = new HashMap<>();
			modelMap.put("companyList", companyList);
			return new ModelAndView("searchbar", modelMap);
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	/*
	 * This method searches for both students and companies and returns a
	 * combined list of companies and students in JSON format this method works
	 * with the autocomplete functionality
	 */
	@RequestMapping(value = "/Search", method = RequestMethod.GET)
	public @ResponseBody String searchCombined(@RequestParam("CHARS") String searchString) {
		//System.out.println(searchString);
                logger.error(searchString);
		List<Company> companyList = null;
		List<PersonalProfile> userDetailsList = null;

		if (!searchString.matches("\\s*")) {
			companyList = searchService.searchCompany(searchString);
			userDetailsList = searchService.searchUser(searchString);
		}

		JsonArray jarray = new JsonArray();
		for (Company c : companyList) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("name", c.getCompany_name());
			jobj.addProperty("id", c.getCompany_id());
			jobj.addProperty("type", "company");
			jarray.add(jobj);
		}
		for (PersonalProfile p : userDetailsList) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("name", p.getName());
			jobj.addProperty("id", p.getUserName());
			jobj.addProperty("type", "user");
			jarray.add(jobj);
		}

		//System.out.println(jarray);
                    logger.error(jarray);
		return jarray.toString();
	}
}
