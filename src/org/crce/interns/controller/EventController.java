/*
 * EventController Class contains the various methods like 
 * Insert month to view event details
 * 
 * @author Adarsh
 * 
 * */
package org.crce.interns.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.crce.interns.beans.Event_detailsBean;
import org.crce.interns.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {
	Integer months;

	@Autowired
	private EventService eventService;
        
        private static final Logger logger = Logger.getLogger(EventController.class.getName());

	@RequestMapping(value = "/InsertMonth", method = RequestMethod.GET) // Call to jsp to get the month number
	public ModelAndView insertMonth(@ModelAttribute("command") Event_detailsBean edBean, BindingResult result) {
		//System.out.println("In Controller : Insert Month");
                logger.error("In Controller : Insert Month");
		
		return new ModelAndView("insertMonth");
	}

	@RequestMapping(value = "/SubmitMonth", method = RequestMethod.GET)
	public ModelAndView submitMonth(@RequestParam("month") Integer month) {
		//System.out.println("In Controller : Submit Month");
                logger.error("In Controller : Submit Month");
		
		//System.out.println("Month sent from front end :" + month);
                logger.error("Month sent from front end :" + month);
		months = month;
		
		return new ModelAndView("redirect:/ViewEvents");
	}

	@RequestMapping(value = "/ViewEvents", method = RequestMethod.GET) // View event details
	public ModelAndView viewEvents() {
		System.out.println("In Controller : View Events");
		try{
			ModelAndView model;
			String erroMesg = "";
			
		//System.out.println("In View Events: " + months);
                        logger.error("In View Events: " + months);
		Map<String, Object> modelMap = new HashMap<String, Object>();

		List<Event_detailsBean> eventList = eventService.viewEvents(months);
		modelMap.put("events", eventList);
		
		if (modelMap.isEmpty()) {
			//System.out.println("Error no Model map, Model map is null");
                        logger.error("Error no Model map, Model map is null");
			return new ModelAndView("403");
		}

		if (modelMap.containsValue(null))// If no events in the selected month display this
		{
			model = new ModelAndView("insertMonth");
			erroMesg += "No events in this month";
			model.addObject("erroMesg", erroMesg);
			// System.out.println("No events in selected month");
			// return new ModelAndView("noEvents");
		} 
		else{
		Map<Integer, String> companyMap = new HashMap<Integer, String>();
		for (Event_detailsBean i : eventList) {
			companyMap.put(i.getCompany_id(), eventService.getCompanyName(i.getCompany_id()));
		}
		//System.out.println("Companies Name Map Size" + companyMap.size());
                logger.error("Companies Name Map Size" + companyMap.size());
		modelMap.put("companyMap", companyMap);
		model = new ModelAndView("viewEvents", modelMap);
		String msgcurrevent = new String();
		Date d =new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int currmonth = cal.get(Calendar.MONTH);
		if(currmonth == (months-1)){
			msgcurrevent = msgcurrevent.concat("for current month");
			
		}
		
		
		model.addObject("msgcurrevent",msgcurrevent);
		
		// return new ModelAndView("viewEvents", modelMap);
		}
		return model;
		}
		catch(Exception e)
			{
				//System.out.println(e);
                                logger.error(e);
				ModelAndView model=new ModelAndView("500");
				model.addObject("exception", "/ViewEvents");
				return model;
			}
	}
}
