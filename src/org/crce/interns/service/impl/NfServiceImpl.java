/**
 * @author Nevil Dsouza ZNevzz
 *	Description : Service impl for notification related operations
 *	DEPENDENCIES: 
 * 	brans and model-	PersonalProfileBean;ProfessionalProfileBean;UserDetailsBean;NotificationBean;
 * 	DAO-	NfDAO
 */
package org.crce.interns.service.impl;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.crce.interns.beans.NotificationBean;
import org.crce.interns.beans.PersonalProfileBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.NfDAO;
import org.crce.interns.model.Notification;
import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.NfService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("NfService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class NfServiceImpl implements NfService, ConstantValues{
	
	
	@Autowired
	private NfDAO nfDAO;
	
	@Autowired
    private EmailNotificationServiceImpl emailNotificationService;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void checkNf() {
		System.out.print("inside Nf service");
		nfDAO.checkNf();
		nfDAO.displayXmlDatabaseInConsole();
		
	}
	
	
	/*@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void checkNf() {
		System.out.print("inside Nf service");
		nfDAO.checkNf();
		nfDAO.displayXmlDatabaseInConsole();
		
	}*/
	
	//-----------------------------------------------------------------------------------------------------------
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<NotificationBean> getNf
	(UserDetailsBean userDetailsBean,ProfessionalProfileBean professionalProfileBean,
			PersonalProfileBean personalProfileBean){
		
		List<Notification> nfList= new LinkedList<Notification>();
		List<NotificationBean> nfBeanList= new LinkedList<NotificationBean>();

		nfList = nfDAO.getNotificationDatabase().getNotifications();
		
		// filteration FOR LOOP
		for(Notification i: nfList){

			NotificationBean temp = new NotificationBean();			
			BeanUtils.copyProperties(i, temp);
			
			//BeanUtils.copyProperties(source, target);
			
			// ALL USERS
			if(temp.getType().equals(ALL)){
				nfBeanList.add(temp);
			}
			
			// PARTICULAR USER
			else if(temp.getType().equals(USER)){
				if(temp.getUserOrGroupId().equals(userDetailsBean.getUserName())){
					nfBeanList.add(temp);
				
				}
			}
			
			
			// USER GROUP
			else if(temp.getType().equals(GROUP)){
				
				// USER BRANCH
				if(temp.getUserOrGroupId().equals(professionalProfileBean.getBranch())){
					nfBeanList.add(temp);
					
				}
				
				// USER ROLE
				else if(temp.getUserOrGroupId().equals(userDetailsBean.getRoleId())){
					nfBeanList.add(temp);
					
				}
				
			}
			
			
			//nfBeanList.add(temp);
		}
		
		

		
//		System.out.println(nfList.size());

		return nfBeanList; 
	}
	
	//-----------------------------------------------------------------------------------------------------------
	public List<NotificationBean> sortByDate(List<NotificationBean> dateUnSorted){
		
		
		
		
		Collections.sort(dateUnSorted, new Comparator<NotificationBean>() {
	        
		 	DateFormat f = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
	        @Override
	        public int compare(NotificationBean n1, NotificationBean n2) {
	            try {	            		            
	            			
	                return f.parse(n2.getDateTime()).compareTo(f.parse(n1.getDateTime()));
	            } catch (ParseException e) {
	                throw new IllegalArgumentException(e);
	            }
	        }
	    });
		
		
		return dateUnSorted;
		
	}
	//-----------------------------------------------------------------------------------------------------------
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotification(NotificationBean n){
		
		Notification temp = new Notification();
		BeanUtils.copyProperties(n, temp);
		
		if(nfDAO.addNotification(temp)){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotificationForJobApply(String companyName, String userName){
		Notification temp = new Notification();
		
		temp.setType(USER);
		temp.setCategory(ELIGIBLE);
		temp.setMessage(ELIGIBLE_M1+companyName+ELIGIBLE_M2);
		temp.setUrl(ELIGIBLE_URL+companyName);
		temp.setUserOrGroupId(userName);		
		temp.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()));
		
		
		//BeanUtils.copyProperties(n, temp);
		
		if(nfDAO.addNotification(temp)){
			return true;
		}
		else{
			return false;
		}
			
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotificationForJobPost(String companyName){
		Notification temp = new Notification();
		
		temp.setType(ALL);
		temp.setCategory(JOB);
		temp.setMessage(JOB_M1+companyName);
		temp.setUrl(JOB_URL1+companyName+JOB_URL2);
		temp.setUserOrGroupId(ALL);		
		temp.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()));

		if(nfDAO.addNotification(temp)){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotificationForEvent(String companyName){
		Notification temp = new Notification();
		
		temp.setType(ALL);
		temp.setCategory(EVENT);
		temp.setMessage(EVENT_M+companyName);
		temp.setUrl(EVENT_URL);
		temp.setUserOrGroupId(ALL);		
		temp.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()));

		if(nfDAO.addNotification(temp)){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotificationForApplicantRemoval(String companyName,
			String userName){
		Notification temp = new Notification();
		
		temp.setType(USER);
		temp.setCategory(ELIGIBLE);
		temp.setMessage(APPLICANTS_MSG3+companyName+APPLICANTS_MSG4);
		temp.setUrl(APPLICANTS_URL1+companyName+APPLICANTS_URL2);
		temp.setUserOrGroupId(userName);		
		temp.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()));

		if(nfDAO.addNotification(temp)){
			
			/*emailNotificationService.sendEmailNotification(
					temp.getUserOrGroupId(), temp.getCategory(), temp.getMessage()
					);*/
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotificationForApplicantAddition(String companyName,
			String userName){
		Notification temp = new Notification();
		
		temp.setType(USER);
		temp.setCategory(ELIGIBLE);
		temp.setMessage(APPLICANTS_MSG1+companyName+APPLICANTS_MSG2);
		temp.setUrl(APPLICANTS_URL1+companyName+APPLICANTS_URL2);
		temp.setUserOrGroupId(userName);		
		temp.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()));

		if(nfDAO.addNotification(temp)){
			/*emailNotificationService.sendEmailNotification(
					temp.getUserOrGroupId(), temp.getCategory(), temp.getMessage()
					);*/
			
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotificationForSelectedRemoval(String companyName,
			String userName){
		Notification temp = new Notification();
		
		temp.setType(USER);
		temp.setCategory(SELECTED);
		temp.setMessage(SELECTED_MSG3+companyName+SELECTED_MSG4);
		temp.setUrl(APPLICANTS_URL1+companyName+APPLICANTS_URL2);
		temp.setUserOrGroupId(userName);		
		temp.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()));

		if(nfDAO.addNotification(temp)){
			/*
			emailNotificationService.sendEmailNotification(
					temp.getUserOrGroupId(), temp.getCategory(), temp.getMessage()
					);
			*/
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean addNotificationForSelectedAddition(String companyName,
			String userName){
		Notification temp = new Notification();
		
		temp.setType(USER);
		temp.setCategory(SELECTED);
		temp.setMessage(SELECTED_MSG1+companyName+SELECTED_MSG2);
		temp.setUrl(APPLICANTS_URL1+companyName+APPLICANTS_URL2);
		temp.setUserOrGroupId(userName);		
		temp.setDateTime(new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()));

		if(nfDAO.addNotification(temp)){
			/*
			emailNotificationService.sendEmailNotification(
					temp.getUserOrGroupId(), temp.getCategory(), temp.getMessage()
					);*/
			
			return true;
		}
		else{
			return false;
		}
		
		
	}


	
}
