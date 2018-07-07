 /*
-*
-*
-* Author Name: Crystal Cuthinho	
-* 
-* Filename: AddUserServiceImpl.java	
-* 	
-* Classes used by code: AddUserService, AddUserDao,FileUploadValidator,DirectoryPathBean, IncorrectFileFormatException,MaxFileSizeExceededError
-* 
-* Tabes used: Loader_schema.loader,User_schema.userdetails,User_schema.personal_profile,User_schema.professional_profile,User_schema.qualification
-* 
-* Description: This service implementation is used to implement the methods in AddUserService.java
-* 
-* Functions: handleFileUpload()	
-*
-*/


package org.crce.interns.service.impl;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.crce.interns.service.CopyFileService;
import org.springframework.stereotype.Service;


@Service("copyFileService")
public class CopyFileServiceImpl implements CopyFileService{

	public void copyFileorDirectory(String sourcePath, String destPath) throws Exception{
		
		File source = new File(sourcePath);
		File dest = new File(destPath);
		
		source.exists();      // First, make sure the path exists
		
		if(source.isDirectory()){	// This will tell you if it is a directory
			System.out.println("directory");
			FileUtils.copyDirectory(source, dest);
		}
		 
		else if(source.isFile()){	// This will tell you if it is a directory
			System.out.println("file");
			FileUtils.copyFile(source, dest);
		}
		
		
		
		
	}
}