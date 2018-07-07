/*
 * AssignTPOServiceImpl Class contains all logic related operations.
 * 
 * AssignTPOServiceImpl Class contains the implementations for various methods like 
 * 
 * Assign TPO(for FTPC)
 * Remove TPO(for FTPC)
 * Assign TPC(for STPC)
 * Remove TPC(for STPC)
 * View Users
 * 
 * @author Adarsh
 * 
 * */
package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.AssignTPODao;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.AssignTPOService;
import org.crce.interns.service.ConstantValues;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssignTPOServiceImpl implements AssignTPOService,ConstantValues {
	@Autowired
	private AssignTPODao userDao;

	@Override
	public int assignTPO(UserDetailsBean userBean) {
		System.out.println("In ServiceImpl: Assign TPO");
		
		UserDetails checkUser = new UserDetails();
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
			return 0;
		}
		
		checkUser.setModifiedBy(userBean.getModifiedBy());
		checkUser.setModifiedDate(userBean.getModifiedDate());

		if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.TPOId)) {
			return 55;	//Return 55 if User is already a TPO
		}

		if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.FacultyId)	//Check if Faculty or FTPC
				|| checkUser.getRoleId().equalsIgnoreCase(ConstantValues.FTPCId)){
			System.out.println("Before update Faculty Role ID : " + checkUser.getRoleId() + "\n");
			checkUser.setRoleId("5");	//Update RoleID to make him TPO
			System.out.println("After update Faculty Role ID : " + checkUser.getRoleId() + "\n");
			userDao.assignTPO(checkUser);
			return 1;	//Return 1 for normal execution
		}

		else {
			System.out.println("Invalid Input : Faculty ");
			return 5;	//Return 5 if User is not a Faculty or FTPC
		}
	}

	@Override
	public int assignTPCF(UserDetailsBean userBean) {
		System.out.println("In ServiceImpl: Assign TPCF");
	
		UserDetails checkUser = new UserDetails();
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser); //Get the User

		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
			return 0;
		}
		
		checkUser.setModifiedBy(userBean.getModifiedBy());
		checkUser.setModifiedDate(userBean.getModifiedDate());
		
		if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.STPCId)) {
			return 34;	//Return 34 if User is already a STPC
		}
		else if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.StudentId)){
			System.out.println("Before update Student Role ID : " + checkUser.getRoleId() + "\n");
			checkUser.setRoleId("3");	//Update RoleID to make him STPC
			System.out.println("After update Student Role ID : " + checkUser.getRoleId() + "\n");
			userDao.assignTPO(checkUser);
			return 1;	//Return 1 for normal execution
		}
		else {
			System.out.println("Service :Invalid Input : Student");
			return 3;	//Return 3 if User is not a Student
		}
	}
	
	
	@Override
	public List<UserDetailsBean> viewUsers() {
		System.out.println("In ServiceImpl: View Users");
		
		List<UserDetails> userList = userDao.viewUsers();
		
		return convertToBean(userList);
	}

	public List<UserDetailsBean> convertToBean(List<UserDetails> userList) {
		System.out.println("In ServiceImpl: Convert to Bean : UserDetails ");
		
		List<UserDetailsBean> userBeanList = new ArrayList<UserDetailsBean>();
		
		for (UserDetails user : userList) {
			UserDetailsBean userBean = new UserDetailsBean();
			BeanUtils.copyProperties(user, userBean);
			userBeanList.add(userBean);
		}
		
		return userBeanList;
	}

	@Override
	public int removeTPO(UserDetailsBean userBean) {
		System.out.println("In ServiceImpl: Remove TPC");
		
		UserDetails checkUser = new UserDetails();
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Service: Error : No User Defined" + "\n");
			return 0;	//Return 0 if no such User exists
		}
		
		checkUser.setModifiedBy(userBean.getModifiedBy());
		checkUser.setModifiedDate(userBean.getModifiedDate());
		
		if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.TPOId)) { //Check if TPO
			System.out.println("Before update Faculty Role : " + checkUser.getRoleId() + "\n");
			checkUser.setRoleId("2");	//Update RoleID to make him Faculty
			System.out.println("After update Faculty Role : " + checkUser.getRoleId() + "\n");
			userDao.removeTPO(checkUser);
			return 1;	//Return 1 for normal execution
		}
		else {
			System.out.println("Service: Error(LE): No Such User Exists");
			return 55;	//Return 55 if User is not a TPO
		}
	}

	@Override
	public int removeTPCF(UserDetailsBean userBean) {
		System.out.println("In ServiceImpl: Remove TPCF");
				
		UserDetails checkUser = new UserDetails();
		checkUser.setUserName(userBean.getUserName());

		checkUser = userDao.getUser(checkUser);

		if (checkUser == null) {
			System.out.println("Service: Error : No User Defined" + "\n");
			return 0;	//Return 0 if no such User exists
		}

		checkUser.setModifiedBy(userBean.getModifiedBy());
		checkUser.setModifiedDate(userBean.getModifiedDate());
		
		if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.STPCId)) {
			System.out.println("Before update Faculty Role : " + checkUser.getRoleId() + "\n");
			checkUser.setRoleId("1");	//Update RoleID to make him Student
			System.out.println("After update Faculty Role : " + checkUser.getRoleId() + "\n");
			userDao.removeTPO(checkUser);
			return 1;	//Return 1 for normal execution
		}
		else {
			System.out.println("Service: Error(LE): No Such User Exists");
			return 33; 	//Return 33 if User is not a STPC
		}
	
	}

}
