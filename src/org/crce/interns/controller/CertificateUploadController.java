/*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: CertificateUploadController.java	
* 	
* Classes used by code: CertificateUploadService,FileUploadValidator,FileUpload
* 
* Tables used: None
* 
* Description: This controller is used to navigate to UploadCertificate.jsp and upload certificates by student
* 
* Functions: welcome(), certificateUpload() 
*
*/


package org.crce.interns.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.exception.IncorrectFileFormatException;
import org.crce.interns.exception.MaxFileSizeExceededError;
import org.crce.interns.model.FileUpload;
import org.crce.interns.service.CertificateUploadService;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.ResumeUploadService;
import org.crce.interns.validators.FileUploadValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CertificateUploadController {
	
	@Autowired
	private CertificateUploadService certificateUploadService;
	
	@Autowired
    FileUploadValidator validator;
	
	@Autowired
	private CheckRoleService crService;
        
        private static final Logger logger = Logger.getLogger(CertificateUploadController.class.getName());
	
	//used to navigate to CertificateUpload.jsp
	
		@RequestMapping("certificateUpload")
		public ModelAndView welcome(HttpServletRequest request) {
						
			HttpSession session=request.getSession();
			String role =  (String)session.getAttribute("roleId");

			/*if(!crService.checkRole("CertificateUpload", role))
				return new ModelAndView("403");
			else*/

				return new ModelAndView("UploadCertificate");
		}

		//used to actually upload the file
		@RequestMapping(value = "/uploadCertificate", method = RequestMethod.POST)
		public ModelAndView certificateUpload(HttpServletRequest request,
				@RequestParam(required = false) CommonsMultipartFile fileUpload,  @ModelAttribute("fileUpload1") FileUpload fileUpload1,BindingResult result)
						throws Exception {
			
			String type = request.getParameter("type");
			ModelAndView model = new ModelAndView("UploadCertificate");
			model.addObject(type, 1);
			
			
			try {
				
				//fileUpload1 : this is the request parameter model attribute of FileUpload type
				fileUpload1.setFile(fileUpload);
				
				//System.out.println(fileUpload1.getFile().getSize());
				
				
				
				validator.validate(fileUpload1, result);
				
				//if no file is uploaded
				if (fileUpload1.getFile().getSize() == 0) {
					//System.out.println("Error in form");
                                    logger.error("Error in form");
		            
		            return model;
				}
				
				String username = (String)request.getSession(true).getAttribute("userName");
				//System.out.println("in try");
                                logger.error("in try");
				
				//calls the service to actually upload the file
				certificateUploadService.handleFileUpload(request, fileUpload, username);
				model.addObject("success", 1);
				
			} catch (IncorrectFileFormatException e) {
				
				//System.out.println(e);			
                            logger.error(e);			
				model.addObject("error", 1);	// so that the jsp catches the error
			
				
			} catch (MaxFileSizeExceededError m) {
				
				//System.out.println(m);
                                logger.error(m);
				model.addObject("error1", 1); 	// so that the jsp catches the error
			
			}
			
			return model;
		}

}
