package org.crce.interns.controller;
import java.sql.BatchUpdateException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.beans.AptitudeBean;
import org.crce.interns.beans.EventBean;
import org.crce.interns.beans.InterviewBean;
import org.crce.interns.beans.Pre_PlacementBean;
import org.crce.interns.service.EventDetailsService;
import org.crce.interns.service.NfService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventDetailsController {

	@Autowired
	private NfService nfService;
	
	@Autowired
	private EventDetailsService eventDetailsService;
        
        private static final Logger logger = Logger.getLogger(EventDetailsController.class.getName());
	
	@RequestMapping(value="/getEventForm.html", method=RequestMethod.GET)
	public ModelAndView getEventForm(){
		ModelAndView model=new ModelAndView("fill-events");
		return model;
	}
	
	@RequestMapping(value="fill", method=RequestMethod.POST)
	public ModelAndView createEvent(HttpServletRequest request,@RequestParam Map<String, String> map) throws ParseException, ConstraintViolationException, BatchUpdateException{
		try{
		String msg="";
		ModelAndView model=new ModelAndView("fill-event-success");
		// initialize event bean
		EventBean eventBean=new EventBean();
		HttpSession session=request.getSession();
		String userName=(String)session.getAttribute("userName");
		//System.out.println("dfbdjvbjkdfvjfdk"+userName);
                logger.error("dfbdjvbjkdfvjfdk"+userName);
		eventBean.setCreated_by(userName);
		eventBean.setCreated_date(new Date());
		//eventBean.setEvent_id((map.get("event_name")));
				
		eventBean.setEvent_type(map.get("event_type"));
		//eventBean.setCompany_id(Integer.parseInt(map.get("company_id")));
		String cname=map.get("company_name");
		eventBean.setApproved((map.get("approved")));
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter2= new SimpleDateFormat("HH:mm"); 
		Date date=new Date();
		date=formatter.parse(map.get("date"));
		//System.out.println(date);
                logger.error(date);
		formatter.format(date);
		//System.out.println(date);
                logger.error(date);
		eventBean.setDate(date);
		//System.out.println("event bean val 1.................."+eventBean.getDate());
                logger.error("event bean val 1.................."+eventBean.getDate());
		eventBean.setTime(formatter2.parse(map.get("time")));
		eventBean.setVenue(map.get("venue"));
		//System.out.println("event bean val 2.................."+eventBean.getDate());
                logger.error("event bean val 2.................."+eventBean.getDate());
		model.addObject("eventBean",eventBean);
		int s=eventDetailsService.create(eventBean,cname);
		//System.out.println(s);
                logger.error(s);
		
		//create event-type beans--
		
		if(eventBean.getEvent_type().equals("aptitude")){
			//initialize aptitude bean
			AptitudeBean aptitudeBean=new AptitudeBean();
			
			//set bean
			aptitudeBean.setSubjects_to_be_prepared(map.get("subjects_to_be_prepared"));
			aptitudeBean.setTest_duration((map.get("test_duration")));
			aptitudeBean.setTest_section(map.get("test_section"));
			aptitudeBean.setEvent_id(s);
			msg+="Aptitude Event";
			model.addObject("msg",msg);
		//	model.addObject("aptitudeBean",aptitudeBean);
			eventDetailsService.create(aptitudeBean);

		}
		
		else if(eventBean.getEvent_type().equals("interview")){
			
			InterviewBean interviewBean=new InterviewBean();
			interviewBean.setInterview_type(map.get("interview_type"));
			interviewBean.setEvent_id(s);
			msg+="Interview Event";
			model.addObject("msg",msg);
			eventDetailsService.create(interviewBean);
		}
		
		else if(eventBean.getEvent_type().equals("pre_placement")){
			Pre_PlacementBean pre_placementBean=new Pre_PlacementBean();
			pre_placementBean.setAgenda(map.get("agenda"));
			pre_placementBean.setConducted_by(map.get("conducted_by"));
			pre_placementBean.setEvent_id(s);
			msg+="Pre Placement Event";
			model.addObject("msg",msg);
			eventDetailsService.create(pre_placementBean);
		}
		
			//System.out.println(eventBean.getEvent_type());
                        logger.error(eventBean.getEvent_type());
			/*
			 * @author Nevil Dsouza
			 * code for notification
			 */
			
			
			if(nfService.addNotificationForEvent(cname)){
				//System.out.println("notification added");
                                logger.error("notification added");
			}
			else{
				//System.out.println("notification not added");
                                logger.error("notification not added");
			}
		return model;
		}
		catch(Exception e)
		{
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model=new ModelAndView("500");
			model.addObject("exception", "/fill");
			return model;
		}
	}
	
}
