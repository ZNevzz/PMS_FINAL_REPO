/**
 * @author Nevil Dsouza ZNevzz
 *	Description : Service interface for profile related operations
 *	DEPENDENCIES: 
 * 	brans and model-	PersonalProfileBean;ProfessionalProfileBean;UserDetailsBean;
 */
package org.crce.interns.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.crce.interns.beans.PersonalProfileBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.ProfessionalProfile;

//@Service("profileService")
public interface ProfileService {
	
	public UserDetailsBean getProfile(UserDetailsBean userDetailsBean);
	
	public ProfessionalProfileBean getProfile(ProfessionalProfileBean professionalProfileBean);
	
	public PersonalProfileBean getProfile(PersonalProfileBean personalProfileBean);
	
	public ProfessionalProfileBean updateProfessionalProfile(ProfessionalProfileBean professionalProfileBean);
	
	public PersonalProfileBean updatePersonalProfile(PersonalProfileBean personalProfileBean);
	
	public UserDetailsBean updateUserDetails(UserDetailsBean userDetailsBean);
	
	public List<String> listProfessionalProfile(String year);
		
	public Map<String, Set<String>> totalStudents(String year);
	
	public boolean check(String userName);

}
