/**
 * @author Nevil Dsouza ZNevzz
 *	Description : Service interface for notification related operations
 *	DEPENDENCIES: 
 * 	brans and model-	PersonalProfileBean;ProfessionalProfileBean;UserDetailsBean;NotificationBean;
 */

package org.crce.interns.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.crce.interns.beans.NotificationBean;
import org.crce.interns.beans.PersonalProfileBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.Notification;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public interface NfService {
	
	public void checkNf();
	
	public List<NotificationBean> getNf
	(UserDetailsBean userDetailsBean,ProfessionalProfileBean professionalProfileBean,
			PersonalProfileBean personalProfileBean);
	
	public List<NotificationBean> sortByDate(List<NotificationBean> dateUnSorted);
			
	public boolean addNotification(NotificationBean n);
	
	public boolean addNotificationForJobApply(String companyName, String userName);
		
	public boolean addNotificationForJobPost(String companyName);
		
	public boolean addNotificationForEvent(String companyName);
	
	public boolean addNotificationForApplicantRemoval(String companyName,String username);
	
	public boolean addNotificationForApplicantAddition(String companyName,String userName);
		
	public boolean addNotificationForSelectedRemoval(String companyName,String userName);
	
	public boolean addNotificationForSelectedAddition(String companyName,String userName);
	
	
}
