/*
 * AssignTPCServiceImpl Class contains all logic related operations.
 * 
 * AssignTPCServiceImpl Class contains the implementations for various methods like 
 * 
 * Assign TPC(for STPC and FTPC)
 * Remove TPC(for STPC and FTPC)
 * Assign special task to FTPC
 * View Users and View Tasks
 * 
 * @author Adarsh
 * 
 * */
package org.crce.interns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.beans.FacultyUserBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.AssignTPCDao;
import org.crce.interns.dao.ProfileDAO;
import org.crce.interns.model.FacultyUser;
import org.crce.interns.model.RMUser;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.AssignTPCService;
import org.crce.interns.service.ConstantValues;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AssignTPCServiceImpl implements AssignTPCService,ConstantValues {
	@Autowired
	private AssignTPCDao assignTPCDao;
	
	@Autowired
	private ProfileDAO profDaO;

	/* Methods to Insert the data */
	@Override
	public int assignTPC(UserDetailsBean userBean) {
		System.out.println("In ServiceImpl: Assign TPC");
	
		UserDetails checkUser = new UserDetails();
		RMUser rmuser = new RMUser();

		String st;
		checkUser.setUserName(userBean.getUserName());

		checkUser = assignTPCDao.getUser(checkUser);//Call to fetch User by his Username
		if (checkUser == null) {
			System.out.println("Error:No User Defined" + "\n");
			return 0;
		}
		checkUser.setModifiedBy(userBean.getModifiedBy());
		checkUser.setModifiedDate(userBean.getModifiedDate());
		
		System.out.println("User Role ID from JSP : " + userBean.getRoleId() + "\n");
		
		String roleID = userBean.getRoleId();
		rmuser = assignTPCDao.getUserRole(roleID);//Call to fetch User by his RoleID
		
		System.out.println("User Id in RM Table: " + rmuser.getRole_id());
		System.out.println("User Role in RM Table: " + rmuser.getUserRole());
		System.out.println("User Role ID from DB : " + checkUser.getRoleId() + "\n");
	
		st = userBean.getRoleId();
		
		/*
		 * 1-Student 2-Faculty 3-Student-TPC 4-Faculty-TPC
		 */
		
		if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.STPCId)||checkUser.getRoleId().equalsIgnoreCase(ConstantValues.FTPCId)) {
			return 34;	//Return 34 if User is already a TPC
		}		
		else if (st.equalsIgnoreCase(ConstantValues.StudentId)) {	//Check if User is a Student

			if (checkUser.getRoleId().equalsIgnoreCase(userBean.getRoleId())) {
				System.out.println("Before update Student Role ID : " + checkUser.getRoleId() + "\n");
				checkUser.setRoleId("3");	//Update RoleID to make him STPC
				System.out.println("After update Student Role ID : " + checkUser.getRoleId() + "\n");
				assignTPCDao.assignTPC(checkUser);
				return 1;	//Return 1 for normal execution
			} else {
				System.out.println("Invalid Input: Student" + "\n");
				return 3;	//Return 3 if not a Student
			}
		} 
		else if (st.equalsIgnoreCase(ConstantValues.FacultyId)) {	//Check if User is a Student
			System.out.println(userBean.getRoleId());
			if (checkUser.getRoleId().equalsIgnoreCase(userBean.getRoleId())) {
				System.out.println("Before update Faculty Role ID : " + checkUser.getRoleId() + "\n");
				checkUser.setRoleId("4");	//Update RoleID to make him FTPC
				System.out.println("After update Faculty Role ID : " + checkUser.getRoleId() + "\n");
				assignTPCDao.assignTPCFac(checkUser);
				return 1;	//Return 1 for normal execution
			} else {
				System.out.println("Invalid Input : Faculty" + "\n");
				return 4;	//Return 4 if not a Faculty
			}
		}
		else {
			System.out.println("Error : No Such User Exists");
			return 0;	//Return 0 if no such User exists
		}
	}

	@Override
	public int insertWork(FacultyUserBean fuserBean) {
		System.out.println("In ServiceImpl: Assign Task");
		
		FacultyUser fuser = new FacultyUser();
		fuser.setUserName(fuserBean.getUserName());

		fuser = assignTPCDao.getFacultyUser(fuser);
		
		if (fuser == null) {
			System.out.println("Error: No such User Defined" + "\n");
			return 0;	//Return 0 if no such User exists
		}
		
		System.out.println("UserWork in Service with Bean: " + fuserBean.getUserWork());
		
		if(fuserBean.getUserWork().equalsIgnoreCase("01"))
		{
			fuser.setUserWork(ConstantValues.task1);
		}
		if(fuserBean.getUserWork().equalsIgnoreCase("02"))
		{
			fuser.setUserWork(ConstantValues.task2);
		}
		if(fuserBean.getUserWork().equalsIgnoreCase("03"))
		{
			fuser.setUserWork(ConstantValues.task3);
		}
		if(fuserBean.getUserWork().equalsIgnoreCase("04"))
		{
			fuser.setUserWork(ConstantValues.task4);
		}
		
		System.out.println("Username in Service IMPL :" + fuser.getUserName());
		System.out.println("UserWork in Service IMPL :" + fuser.getUserWork());

		assignTPCDao.insertWork(fuser);
		return 1;	//Return 1 for normal execution
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

	public List<FacultyUserBean> convertToBeanFaculty(List<FacultyUser> userList) {
		System.out.println("In ServiceImpl: Convert to Bean :FTPC Special Role User ");
		
		List<FacultyUserBean> userBeanList = new ArrayList<FacultyUserBean>();
		
		for (FacultyUser fuser : userList) {
			FacultyUserBean fuserBean = new FacultyUserBean();
			BeanUtils.copyProperties(fuser, fuserBean);
			userBeanList.add(fuserBean);
		}
		return userBeanList;
	}

	@Override
	public int removeTPC(UserDetailsBean userBean) {
		System.out.println("In ServiceImpl: Remove TPC");
		
		UserDetails checkUser = new UserDetails();
		checkUser.setUserName(userBean.getUserName());

		checkUser = assignTPCDao.getUser(checkUser);
		
		if (checkUser == null) {
			System.out.println("Error: No User Defined" + "\n");
			return 0;	//Return 0 if no such User exists
		}
		
		checkUser.setModifiedBy(userBean.getModifiedBy());
		checkUser.setModifiedDate(userBean.getModifiedDate());

		if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.STPCId)) { //Check if STPC
			System.out.println("Before update Student Role : " + checkUser.getRoleId() + "\n");
			checkUser.setRoleId("1");// 1 is Student & 3 is Student tpc
			System.out.println("After update Student Role : " + checkUser.getRoleId() + "\n");
			assignTPCDao.removeTPC(checkUser);
			return 1;	//Return 1 for normal execution
		} else if (checkUser.getRoleId().equalsIgnoreCase(ConstantValues.FTPCId)) { //Check if FTPC
			System.out.println("Before update Faculty Role : " + checkUser.getRoleId() + "\n");
			checkUser.setRoleId("2");// 2 is faculty & 4 is Fac tpc
			System.out.println("After update Faculty Role : " + checkUser.getRoleId() + "\n");
			assignTPCDao.removeTPCFac(checkUser);
			return 1;	//Return 1 for normal execution
		}
		else {
			System.out.println("Service :Error (LE) : No Such User Exists Last Error");
			return 33;	//Return 33 if User is not a TPC
		}
	}

	@Override
	public List<UserDetailsBean> viewUsers() {
		System.out.println("In ServiceImpl: View Users");
		
		List<UserDetails> userList = assignTPCDao.viewUsers();
		
		return convertToBean(userList);
	}

	@Override
	public List<FacultyUserBean> viewFacultyTasks() {
		System.out.println("In ServiceImpl: View Tasks");
		
		List<FacultyUser> userList = assignTPCDao.viewFacultyTasks();
		
		return convertToBeanFaculty(userList);
	}

	@Override
	@Transactional
	public List<UserDetailsBean> viewTPCs(String year) {
		System.out.println("In ServiceImpl: View Current Year TPCs");
		List<String> usernameList=profDaO.listProfessionalProfile(year);
		System.out.println("Size of the list from ProfessionalProfile Table: "+usernameList.size());
		List<UserDetails> userList = assignTPCDao.viewUsers();
		
		List<UserDetailsBean> userListBean=convertToBean(userList);
		System.out.println("userListBean size "+userListBean.size());
		
		List<UserDetailsBean> userListBeanDisp= new ArrayList<UserDetailsBean>();
		
		for(String s:usernameList)
		{	
			System.out.println("String from ProfessionalProfile Table: "+s);
		
			for(int i=0;i<userListBean.size();i++){
				System.out.println("String in UserDetails Table: "+userListBean.get(i).getUserName());
			if(s.equalsIgnoreCase(userListBean.get(i).getUserName()))
			{
				userListBeanDisp.add(userListBean.get(i));
				break;
			}
			}
		
		}
		return userListBeanDisp;
	}


}
