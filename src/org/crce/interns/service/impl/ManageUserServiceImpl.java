/*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: ManageUserServiceImpl.java	
* 	
* Classes used by code: ManageUserService, ManageUserDao,Faculty, Student
* 
* Tabes used: User_schema.userdetails,User_schema.personal_profile,User_schema.professional_profile,User_schema.qualification
* 
* Description: This service implementation is used to implement the methods in ManageUserService.java
* 
* Functions: addStudent(), addFaculty(), removeUser()
*
*/

package org.crce.interns.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.crce.interns.beans.FacultyBean;
import org.crce.interns.beans.StudentBean;
import org.crce.interns.dao.ManageUserDao;
import org.crce.interns.model.Faculty;
import org.crce.interns.model.Student;
import org.crce.interns.service.ManageUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;




@Service("manageUserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ManageUserServiceImpl implements ManageUserService {
	
	@Autowired
	private ManageUserDao manageUserDao;
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addStudent(HttpServletRequest request,StudentBean studentBean) {
		
		Date dNow = new Date( );
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy-MM-dd");
		String temp = ft.format(dNow);
		
		Student student = new Student();
		String userName = request.getSession().getAttribute("userName").toString();
		//converts bean to model
		BeanUtils.copyProperties(studentBean, student);
		student.setRole_id("1");
		student.setCreated_by(userName);
		student.setCreated_date(temp);
		manageUserDao.createStudent(student);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFaculty(HttpServletRequest request,FacultyBean facultyBean) {
		
		Date dNow = new Date( );
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy-MM-dd");
		String temp = ft.format(dNow);
		
		Faculty faculty = new Faculty();
		String userName = request.getSession().getAttribute("userName").toString();
		
		//converts bean to model
		BeanUtils.copyProperties(facultyBean, faculty);
		faculty.setRole_id("2");
		faculty.setCreated_by(userName);
		faculty.setCreated_date(temp);
		manageUserDao.createFaculty(faculty);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public int removeUser(StudentBean studentBean, String username){
		
		Student student = new Student();
		student.setRollno(username);
		student = manageUserDao.getUser(student);
		
		if (student == null) {
			System.out.println("Error:No User Defined" + "\n");
			return 0;
		}
		//converts bean to model
		BeanUtils.copyProperties(studentBean, student);
		
		manageUserDao.deleteUser(student, username);
		return 255;
	}

}
