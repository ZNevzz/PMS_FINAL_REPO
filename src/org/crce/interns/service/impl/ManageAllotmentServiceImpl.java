package org.crce.interns.service.impl;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.beans.DirectoryPathBean;
import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.ManageAllotmentDao;
import org.crce.interns.exception.IncorrectFileFormatException;
import org.crce.interns.exception.MaxFileSizeExceededError;
import org.crce.interns.model.Allotment;
import org.crce.interns.model.UserCompany;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.ManageAllotmentService;
import org.crce.interns.validators.FileUploadValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/*
 * Author: Cheryl
 * Classes Used: ManageAllotmentDao,AllotmentBean,Allotment
 * 
 * Description: Handles the file upload function and copyProperties
 */

@Service("manageAllotmentService")

//The below line is required else code doesn't work...common error of skipping this line

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class ManageAllotmentServiceImpl implements ManageAllotmentService{

	@Autowired
	private ManageAllotmentDao manageAllotmentDao;
	
	@Autowired
    FileUploadValidator validator;
	
	//Path of directory in which the file should be uploaded
	
	//private String saveDirectory = "C:/work/";
	DirectoryPathBean directoryPathBean = new DirectoryPathBean();
	String saveDirectory = directoryPathBean.getRoomAllotmentFolder()+ "/";
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addAllotment(AllotmentBean allotmentBean) {
		// TODO Auto-generated method stub
		
		System.out.println(saveDirectory);
		allotmentBean.setFileUpload(saveDirectory);
		Allotment allotment = new Allotment();
		
		/*
		 * Copies values from Allotment in model class 
		 * to AllotmentBean.
		 * Hence beans will hold light weight data which is better to 
		 * store in database.
		 */
		
		BeanUtils.copyProperties(allotmentBean, allotment);
		//profile.setRole_id("1");

		manageAllotmentDao.createAllotment(allotment);
	}

	/* ** Newly added comments
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Allotment> listAllotment() {
		// TODO Auto-generated method stub
		return manageAllotmentDao.listAllotment();
	}
	** */
	
	@Override
	public List<AllotmentBean> listAllotment(Allotment allot) {
		// TODO Auto-generated method stub
		System.out.println("Room Allotment in Service Impl :" );
		List<Allotment> allotList = manageAllotmentDao.listAllotment(allot);
		if (allotList == null) {
			return null;
		}
		return convertToBean(allotList);
		
		

	}

	

	private List<AllotmentBean> convertToBean(List<Allotment> allotList) {
		// TODO Auto-generated method stub
		List<AllotmentBean> udsBeanList = new ArrayList<AllotmentBean>();
		for (Allotment uds : allotList) {
			AllotmentBean udsBean = new AllotmentBean();
			BeanUtils.copyProperties(uds, udsBean);
			udsBeanList.add(udsBean);
		}
		return udsBeanList;
	}

	@Override
	public void handleFileUpload(HttpServletRequest request, CommonsMultipartFile fileUpload) throws Exception {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		final String fullPath = saveDirectory + fileUpload.getOriginalFilename();
		int lastDot = fullPath.lastIndexOf('.');
		
		if (!fileUpload.isEmpty()) {
			
			IncorrectFileFormatException e = new IncorrectFileFormatException();
			MaxFileSizeExceededError m = new MaxFileSizeExceededError();
			
			final String extension = FilenameUtils.getExtension(fullPath);
			
			// throws IncorrectFileFormatException if the uploaded file is not of the desired extension/type
			if(!(extension.equals("pdf") || extension.equals("doc") || extension.equals("docx") || extension.equals("odt") || extension.equals("png") || extension.equals("jpg") || extension.equals("jpeg")))
				throw e;
			
			//throws MaxFileSizeExceededError if the uploaded file exceeds the expected size limit
			final long size = fileUpload.getSize();
			System.out.println(size);
			if(size > 2012520)
				throw m;

			if (!fileUpload.getOriginalFilename().equals(""))
				try {
					
					File f1 = new File(fullPath);
					String newName = fullPath.substring(0,lastDot) + "-" + timeStamp + fullPath.substring(lastDot);
					File f2 = new File(newName);
					System.out.println("Saving file: " + newName);
					f1.renameTo(f2);
					fileUpload.transferTo(f2);
					//fileUpload.transferTo(new File(saveDirectory +fileUpload.getOriginalFilename()));
					
				} catch (IllegalStateException n) {
					// TODO Auto-generated catch block
					n.printStackTrace();
				} catch (IOException o) {
					// TODO Auto-generated catch block
					o.printStackTrace();
				}

		}
		
		//manageAllotmentDao.addNewResume(saveDirectory + fileUpload.getOriginalFilename());

	}

}