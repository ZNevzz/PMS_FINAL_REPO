/*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: CertificateUploadServiceImpl.java	
* 	
* Classes used by code: CertificateUploadService,FileUploadValidator,DirectoryPathBean, IncorrectFileFormatException,MaxFileSizeExceededError
* 
* Tabes used: None 
* 
* Description: This service implementation is used to implement the methods in CertificateUploadService.java
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
import org.crce.interns.exception.IncorrectFileFormatException;
import org.crce.interns.exception.MaxFileSizeExceededError;
import org.crce.interns.service.CertificateUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service("certificateUploadService")
public class CertificateUploadServiceImpl implements CertificateUploadService {

	

	DirectoryPathBean directoryPathBean = new DirectoryPathBean();    
	
	public void handleFileUpload(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload, String username)
			throws Exception {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		//get the path for saving the resume
		String saveDirectory = directoryPathBean.getStudentFolder() + "/" + username + "/Certificates/";
		
		String type=  request.getParameter("type");
		final String fullPath = saveDirectory + fileUpload.getOriginalFilename();
		int lastDot = fullPath.lastIndexOf('.');
		
		if (!fileUpload.isEmpty()) {
			
			IncorrectFileFormatException e = new IncorrectFileFormatException();
			MaxFileSizeExceededError m = new MaxFileSizeExceededError();
			
			//File file = new File(fileUpload.getOriginalFilename());
			final String extension = FilenameUtils.getExtension(fullPath);
				
			// throws IncorrectFileFormatException if the uploaded file is not of the desired extension/type
			if(!(extension.equals("pdf") || extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")))
				throw e;
			
			//throws MaxFileSizeExceededError if the uploaded file exceeds the expected size limit
			final long size = fileUpload.getSize();
			System.out.println(size);
			if(size > 3012520)	//file size >3MB
				throw m;
			
			
			System.out.println(extension);	
			
			if (!fileUpload.getOriginalFilename().equals("")){
				File f1 = new File(fullPath);
						
				System.out.println(request.getParameter("type"));
				
				//newName : It is the entire path of the uploaded file with the timestamp of upload appended				
				String newName = fullPath.substring(0,lastDot) + "-"+ type + "-" + timeStamp + fullPath.substring(lastDot);
				File f2 = new File(newName);
				System.out.println("Saving file: " + newName);
				
				f1.renameTo(f2);
				fileUpload.transferTo(f2);
				//call to the dao 
				//resumeUploadDao.addNewResume(username,newName);
			}
					
				
		}
		
		
	}
}
