/*
 * Authors:
 * 			@Melwyn
 * 			@Leon
 * Function: Sending an e-mail
 * Dependency : SendEmailService.java, CheckRoleService.java, PersonalEmailValidator.java
 */
package org.crce.interns.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.crce.interns.beans.CompanyBean;

import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.ManageProfileService;
import org.crce.interns.service.SendEmailService;

import org.crce.interns.validators.PersonalEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
//import org.crce.interns.validators.SendEmailValidator;

@Controller("sendEmailController")
public class SendEmailController {

	// @Autowired
	// private JavaMailSender javaMailSender;
	@Autowired
	public SendEmailService sendEmailService;
	@Autowired
	private CheckRoleService crService;

	@Autowired
	private ManageProfileService manageProfileService;
        
        private static final Logger logger = Logger.getLogger(SendEmailController.class.getName());

	/*
	 * Return Type: Boolean-True/False Function: Checks for Files
	 */

	/*
	 * public boolean checkFile(String name) { String path =
	 * "C:\\Users\\Leon\\Desktop\\Email_Temp"; File folder = new File(path);
	 * File[] listOfFiles = folder.listFiles(); for (int
	 * i=0;i<listOfFiles.length;i++) {
	 * System.out.println(listOfFiles[i].getName()); if
	 * (listOfFiles[i].getName().equals(name)) return true; } return false; }
	 */

	/*
	 * Return Type: Void Function: Deletes the copy of the file made for
	 * uploading in Email_Temp directory
	 */

	/*
	 * public void deleteFiles() { String path =
	 * "C:\\Users\\Leon\\Desktop\\Email_Temp"; File folder = new File(path);
	 * File[] files = folder.listFiles(); for (File f:files) f.delete(); }
	 */

	/*
	 * Return Type: ModelAndView Function: Sends an email along with a
	 * attachemnts to multiple recipients
	 */

	/**
	 * 
	 * @param request
	 * @param file
	 * @return ModelAndView
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(value = "/GroupSubmitEmail", method = RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request,
			@RequestParam(value = "fileUpload") CommonsMultipartFile[] file) throws IllegalStateException, IOException {
		try {
			//String[] receivers = request.getParameterValues("receiver");
			//for (String i : receivers) {
			//	System.out.println(i);
			//}
			List<CompanyBean> companyList = manageProfileService.listCompanies();
			Map<String, String> companyMap = new LinkedHashMap<String, String>();
			companyList.stream().forEach((companyBean) -> {
				companyMap.put(companyBean.getCompany_name(), companyBean.getCompany_name());
			});
			ModelAndView model = new ModelAndView("Email", "companies", companyMap);
			// boolean flag = false;
			// SendEmailValidator sendEmailValidator = new SendEmailValidator();
			// if
			// (sendEmailValidator.validateRecipients(request.getParameter("receiver")))
			// {
			model = sendEmailService.sendMail(request, file);
			model.addObject("success", "Email Sent Sucessfully");
			model.addObject("companies", companyMap);
			System.out.println(model);
			return model;
			// } else {
			// model.addObject("error1", "Group name not proper");
			// return model;
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/GroupSubmitEmail! Email not sent!");
			return new ModelAndView("500");

		}
	}

	/*
	 * Return Type: ModelAndView Function: Displays The Compose an e-mail page
	 * for group
	 */

	/**
	 * 
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/GroupSendMail")
	public ModelAndView email_welcome(HttpServletRequest request) {

		try {
			//System.out.println("Mapped to /sendMail");
                        logger.error("Mapped to /GroupSendMail");
			HttpSession session = request.getSession();
			String roleId = (String) session.getAttribute("roleId");
			if (!crService.checkRole("SendEmail", roleId)) {
				return new ModelAndView("403");
			} else {
				List<CompanyBean> companyList = manageProfileService.listCompanies();
				Map<String, String> companyMap = new LinkedHashMap<String, String>();
				companyList.stream().forEach((companyBean) -> {
					companyMap.put(companyBean.getCompany_name(), companyBean.getCompany_name());
				});
				return new ModelAndView("Email", "companies", companyMap);
			}

			// return new ModelAndView("Email");
			// return new ModelAndView("Final");
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/GroupSendMail");
			return model;
		}
	}

	/**
	 * 
	 * @param request
	 * @return ModelAndView
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/personalMail")
	public ModelAndView individualMail(HttpServletRequest request) {
		try {
			//System.out.println("Mapped to personalMail");
                        logger.error("Mapped to personalMail");
			HttpSession session = request.getSession();
			String roleId = (String) session.getAttribute("roleId");
			if (!crService.checkRole("SendEmail", roleId)) {
				return new ModelAndView("403");
			} else {

				return new ModelAndView("EmailForm");
			}
			// return new ModelAndView("EmailForm");
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/personalMail!");
			return model;

		}

	}

	/**
	 * 
	 * @param request
	 * @param file
	 * @return ModelAndView
	 * @throws IllegalStateException
	 * @throws IOException
	 */

	@RequestMapping(method = RequestMethod.POST, value = "/SendPersonalMail")
	public ModelAndView submitIndividualMail(HttpServletRequest request,
			@RequestParam(value = "fileUpload") CommonsMultipartFile[] file) throws IllegalStateException, IOException {
		try {
			ModelAndView model = new ModelAndView("EmailForm");
			PersonalEmailValidator personalEmailValidator = new PersonalEmailValidator();
			if (personalEmailValidator.validateEmail(request.getParameter("receiver"))) {
				model = sendEmailService.sendPersonalMail(request, file);
				model.addObject("success", "Email Sent Sucessfully");
				System.out.println(model);
				return model;
			} else {
				model.addObject("error1", "One of the email IDs isn't correctly formed");
				return model;
			}
		} catch (Exception e) {
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model = new ModelAndView("500");
			model.addObject("exception", "/sendPersonalMail! Mail wasn't sent!");
			return model;
		}

	}

	/*
	 * Return Type: ModelAndView Function: Displays The Compose an e-mail page
	 */
	/*
	 * @RequestMapping(method=RequestMethod.GET, value="/") public ModelAndView
	 * welcome() { return new ModelAndView("EmailForm"); }
	 */
}

/*
 * System.out.println(request.getParameter("message"));
 * System.out.println(request.getParameter("subject"));
 * System.out.println(request.getParameter("receiver"));
 * 
 * String path = "C:\\Users\\Leon\\Desktop\\Email_Temp\\"; if (file.length > 0
 * && file != null) { System.out.println("Inside If"); for (CommonsMultipartFile
 * f : file) { if (!f.getOriginalFilename().equals("")) {
 * System.out.println(path + f.getOriginalFilename()); f.transferTo(new
 * File(path + f.getOriginalFilename())); } } }
 * 
 * String input = request.getParameter("receiver"); String[] emailIds =
 * input.split(" ");
 * 
 * 
 * javaMailSender.send(new MimeMessagePreparator() { public void
 * prepare(MimeMessage mimeMessage) throws javax.mail.MessagingException,
 * IllegalStateException, IOException { System.out.println("Throws Exception");
 * MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,
 * true, "UTF-8");
 * 
 * //mimeMessageHelper.setTo(request.getParameter("receiver"));
 * 
 * mimeMessageHelper.setTo(emailIds);
 * 
 * mimeMessageHelper.setSubject(request.getParameter("subject"));
 * 
 * mimeMessageHelper.setText(request.getParameter("message"));
 * 
 * for (CommonsMultipartFile f:file) { if (checkFile(f.getOriginalFilename()))
 * mimeMessageHelper.addAttachment(f.getOriginalFilename(), new
 * File(path+f.getOriginalFilename())); } } });
 * 
 * 
 * deleteFiles(); ModelAndView model = new ModelAndView("Result");
 */
