package org.crce.interns.service.impl;

import org.crce.interns.dao.AssignRoleDao;
import org.crce.interns.model.FunctionMaster;
import org.crce.interns.model.FunctionRole;
import org.crce.interns.service.AssignRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("assignRoleService")
public class AssignRoleServiceImpl implements AssignRoleService {
	@Autowired
	private AssignRoleDao ard;

	public void setArd(AssignRoleDao ard) {
		this.ard = ard;
	}
	public void assignRole(FunctionMaster fm,FunctionRole fr,int a)
	{
		System.out.println("Inside AssignRole service");
		ard.save(fm, fr,a);
	}
	public int checkFunction(String s)
	{
		return ard.checkFunction(s);
	}
}
