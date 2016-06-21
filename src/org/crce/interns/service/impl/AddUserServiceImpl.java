/*
*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: AddUserServiceImpl.java	
* 	
* Classes used by code: AddUserService, AddUserDao,FileUploadValidator,DirectoryPathBean, IncorrectFileFormatException,MaxFileSizeExceededError
* 
* Tabes used: Loader_schema.loader,User_schema.userdetails,User_schema.personal_profile,User_schema.professional_profile,User_schema.qualification
* 
* Description: This service implementation is used to implement the methods in AddUserService.java
* 
* Functions: handleFileUpload()	
*
*/



package org.crce.interns.service.impl;


import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.crce.interns.beans.DirectoryPathBean;
import org.crce.interns.dao.AddUserDao;
import org.crce.interns.exception.IncorrectFileFormatException;
import org.crce.interns.exception.MaxFileSizeExceededError;
import org.crce.interns.model.FileUpload;
import org.crce.interns.service.AddUserService;
import org.crce.interns.validators.FileUploadValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;



@Service("addUserService")
public class AddUserServiceImpl implements AddUserService {

	@Autowired
	private AddUserDao addUserDao;
	
	@Autowired
    FileUploadValidator validator;

	//in order to get the path to save the csv file
    DirectoryPathBean directoryPathBean = new DirectoryPathBean();
	//private String saveDirectory = directoryPathBean.getCsvFolder()+"\\";
        
    // actually uploads the file
	public void handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload,String userName)
			throws Exception {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String saveDirectory = directoryPathBean.getCsvFolder() + "/"  + timeStamp + "/";
		
        
		final String fullPath = saveDirectory + fileUpload.getOriginalFilename();
		if (!fileUpload.isEmpty()) {

			// user defined exceptions
			IncorrectFileFormatException e = new IncorrectFileFormatException();
			MaxFileSizeExceededError m = new MaxFileSizeExceededError();
			
			
			//File file = new File(fileUpload.getOriginalFilename());
			final String extension = FilenameUtils.getExtension(fullPath);
			final String fileName = FilenameUtils.getName(fullPath);
			System.out.println(fileName);
									
			if(!(extension.equals("csv")))	// if the file format is not .csv
				throw e;
			
			
			final long size = fileUpload.getSize();
			System.out.println(size);
			if(size > 1212520)			// if the file size exceeds 1MB
				throw m;
			
			System.out.println("Saving file: " + fileUpload.getOriginalFilename());
			System.out.println(extension);	
			
			boolean created = false;
			
			//creating folders in the specified path
			File files = new File(saveDirectory);
	        if (!files.exists()) {
	            System.out.println("Something doesnt exist");
	            if (files.mkdirs()) {
	                System.out.println("created");
	                created = true;
	            } else {
	                created = false;
	            }
	        }
	            
			if (!fileUpload.getOriginalFilename().equals(""))

				fileUpload.transferTo(new File(saveDirectory + fileUpload.getOriginalFilename()));
			addUserDao.loadCopyFile("loader_schema.loader",timeStamp,userName,fileName);
		}
		

	}
	
	
}
