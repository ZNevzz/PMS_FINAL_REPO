/*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: OfferLetterUploadController.java	
* 	
* Classes used by code: OfferLetterUploadService, CheckRoleService,FileUploadValidator,FileUpload
* 
* Tabes used: None
* 
* Description: This controller is used to upload offer letters by student
* 
* Functions: welcome(), offerLetterUpload() 
*
*/

package org.crce.interns.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.exception.IncorrectFileFormatException;
import org.crce.interns.exception.MaxFileSizeExceededError;
import org.crce.interns.model.FileUpload;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.OfferLetterUploadService;
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
public class OfferLetterUploadController {

	@Autowired
	private OfferLetterUploadService offerLetterUploadService;

	@Autowired
	FileUploadValidator validator;

	@Autowired
	private CheckRoleService crService;
        
        private static final Logger logger = Logger.getLogger(OfferLetterUploadController.class.getName());

	// used to navigate to OfferLetterUpload.jsp
	@RequestMapping("offerLetterUpload")
	public ModelAndView welcome(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("roleId");

		/*
		 * if(!crService.checkRole("OfferLetterUpload", role)) return new
		 * ModelAndView("403"); else
		 */

		return new ModelAndView("OfferLetterUpload");
	}

	// used to actually upload the file
	@RequestMapping(value = "/uploadOfferLetter", method = RequestMethod.POST)
	public ModelAndView offerLetterUpload(HttpServletRequest request,
			@RequestParam(required = false) CommonsMultipartFile fileUpload,
			@ModelAttribute("fileUpload1") FileUpload fileUpload1, BindingResult result) throws Exception {

		ModelAndView model = new ModelAndView("OfferLetterUpload");

		try {

			// fileUpload1 : this is the request parameter model attribute of
			// FileUpload type
			fileUpload1.setFile(fileUpload);
			//System.out.println(fileUpload1.getFile().getSize());

			validator.validate(fileUpload1, result);

			// if no file is uploaded
			if (fileUpload1.getFile().getSize() == 0) {
				System.out.println("Error in form");

				return model;
			}

			String username = (String) request.getSession(true).getAttribute("userName");
			//System.out.println("in try");

			// calls the service to actually upload the file
			offerLetterUploadService.handleFileUpload(request, fileUpload, username);

			model.addObject("success", 1);

		} catch (IncorrectFileFormatException e) {
			//System.out.println(e);
                        logger.error(e);
			model.addObject("error", 1); // so that the jsp catches the error

		} catch (MaxFileSizeExceededError m) {
			System.out.println(m);
                        logger.error(m);
			model.addObject("error1", 1); // so that the jsp catches the error

		}

		return model;
	}
}
