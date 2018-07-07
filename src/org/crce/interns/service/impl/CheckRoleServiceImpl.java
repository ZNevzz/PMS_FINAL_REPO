package org.crce.interns.service.impl;

import org.crce.interns.dao.CheckRoleDAO;
import org.crce.interns.service.CheckRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("checkRoleService")
public class CheckRoleServiceImpl implements CheckRoleService{
	 @Autowired
	 private CheckRoleDAO checkRoleDAO;

	   public void setLoginDAO(CheckRoleDAO checkRoleDAO) {
              this.checkRoleDAO = checkRoleDAO;
       }
      
	   public boolean checkRole(String functionName, String roleId){
           
		   System.out.println("In Service class...Check Role");
           
		   return checkRoleDAO.checkRole(functionName, roleId);
	   }

}
