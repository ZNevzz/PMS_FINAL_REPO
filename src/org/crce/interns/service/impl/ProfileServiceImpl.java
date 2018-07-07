/**
 * @author Nevil Dsouza
 *
 *	Profile Service
 *	DEPENDENCIES: UpdateProfileController, Profile, ProfileDAOImpl
 *
 */

package org.crce.interns.service.impl;




import java.util.List;
import java.util.Map;
import java.util.Set;

import org.crce.interns.beans.PersonalProfileBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.ProfileDAO;
import org.crce.interns.dao.SelectedApplicantsDao;
import org.crce.interns.model.PersonalProfile;
import org.crce.interns.model.ProfessionalProfile;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.ProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("profileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProfileServiceImpl implements ProfileService{
//public class ProfileServiceImpl{
	
	
	@Autowired
	private ProfileDAO profileDAO;
	
	@Autowired(required=true)
	private SelectedApplicantsDao selectDao;
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDetailsBean getProfile(UserDetailsBean userDetailsBean) {
		//Profile result = profileDAOImpl.getProfile(user);
		
		
		
			UserDetails userDetails=new UserDetails();
			userDetails.setUserName(userDetailsBean.getUserName());
			
			
			UserDetails result = profileDAO.getProfile(userDetails);
			
			
			if(result == null){
				System.out.println("Returned NULL");
			}
			
			BeanUtils.copyProperties(result,userDetailsBean);
			
			
			return userDetailsBean;
		
	}
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ProfessionalProfileBean getProfile(ProfessionalProfileBean professionalProfileBean) {
		//Profile result = profileDAOImpl.getProfile(user);
		
		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		professionalProfile.setUserName(professionalProfileBean.getUserName());
		
		ProfessionalProfile result = profileDAO.getProfile(professionalProfile);
		
		if(result == null){
			System.out.println("Returned NULL");
		}		
		
		
		BeanUtils.copyProperties(result,professionalProfileBean);
		return professionalProfileBean;
	}
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PersonalProfileBean getProfile(PersonalProfileBean personalProfileBean) {
		//Profile result = profileDAOImpl.getProfile(user);
		
		PersonalProfile personalProfile=new PersonalProfile();
		personalProfile.setUserName(personalProfileBean.getUserName());
		
		PersonalProfile result = profileDAO.getProfile(personalProfile);
		
		if(result == null){
			System.out.println("Returned NULL");
		}		
		
		BeanUtils.copyProperties(result,personalProfileBean);
		return personalProfileBean;
	}	
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ProfessionalProfileBean updateProfessionalProfile(ProfessionalProfileBean professionalProfileBean) {
		
		ProfessionalProfile professionalProfile=new ProfessionalProfile();
		BeanUtils.copyProperties(professionalProfileBean,professionalProfile);
		
		ProfessionalProfile result = profileDAO.updateProfessionalProfile(professionalProfile);
		
		
		if(result == null){
			System.out.println("Returned NULL");
		}
		
		BeanUtils.copyProperties(result,professionalProfileBean);
		return professionalProfileBean;
	}
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public PersonalProfileBean updatePersonalProfile(PersonalProfileBean personalProfileBean) {
		
		PersonalProfile personalProfile=new PersonalProfile();
		BeanUtils.copyProperties(personalProfileBean,personalProfile);
		
		PersonalProfile result = profileDAO.updatePersonalProfile(personalProfile);
		
		
		if(result == null){
			System.out.println("Returned NULL");
		}
		
		BeanUtils.copyProperties(result,personalProfileBean);
		return personalProfileBean;
		
	}
	
	/**	GET details from database
	*	
	*	Calls DAO to get details of user
	*	@param	Profile user
	*	@return Profile result 
	*
	*/
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public UserDetailsBean updateUserDetails(UserDetailsBean userDetailsBean) {
		
		UserDetails userDetails=new UserDetails();
		BeanUtils.copyProperties(userDetailsBean,userDetails);
		
		UserDetails result = profileDAO.updateUserDetails(userDetails);
		
		
		if(result == null){
			System.out.println("Returned NULL");
		}
		
		BeanUtils.copyProperties(result,userDetailsBean);
		return userDetailsBean;
	}
	
	@SuppressWarnings("null")
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<String> listProfessionalProfile(String year){
		/*
		List<ProfessionalProfileBean> result = null;
		
		List<ProfessionalProfile> temp = profileDAO.listProfessionalProfile(year);
		
		for( ProfessionalProfile p : temp){
			
			
			ProfessionalProfileBean pb = new ProfessionalProfileBean();
			BeanUtils.copyProperties(p, pb);
			result.add(pb);
		}
		
		System.out.println(result.toString());
		return result;
		*/
		
		List<String> result= null;
		
		result = profileDAO.listProfessionalProfile(year);
		
		System.out.println(result.toString());
		return result;
	}
	
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Map<String, Set<String>> totalStudents(String year){
		return profileDAO.totalStudents(year);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean check(String userName){
		
		return selectDao.check(userName);
	}
	
}
