package org.crce.interns.service.impl;
import org.crce.interns.dao.*;
import org.crce.interns.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	 @Autowired
	 private LoginDAO loginDAO;

	   public void setLoginDAO(LoginDAO loginDAO) {
              this.loginDAO = loginDAO;
       }
      
	   public String checkLogin(String userName, String userPassword){
           
		   System.out.println("In Service class...Check Login");
           
		   return loginDAO.checkLogin(userName, userPassword);
	   }
	   
	   public int getStudentByid(String userName,String user)
		{
			System.out.println("In Service class...Get Student By ID");
			return loginDAO.getStudentById(userName,user);
		}
		public boolean getNotification(String userName)
		{
			System.out.println("In Service class...Get Notification");
			return loginDAO.getNotification(userName);
		}
		public String checkSR(String userName){
	           
			   System.out.println("In Service class...Check Login");
	           
			   return loginDAO.checkSpecialRole(userName);
		   }
	}