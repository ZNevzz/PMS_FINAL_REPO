package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.beans.CompanyBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.exception.IncorrectFileFormatException;
import org.crce.interns.exception.MaxFileSizeExceededError;
import org.crce.interns.model.Allotment;
import org.crce.interns.service.CheckRoleService;
import org.crce.interns.service.LoginService;
import org.crce.interns.service.ManageAllotmentService;
import org.crce.interns.service.ManageProfileService;
import org.crce.interns.validators.AllotmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

/*
 * Author: Cheryl
 * Classes Used: ManageAllotmentService, CheckRoleService, LoginService 
 * 				 Allotment,AllotmentBean
 * Description: This controller is used to add,save and view room allotment by faculty TPC
 */

@Controller
public class ManageAllotment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3205005179545325725L;

	@Autowired
	private ManageAllotmentService manageAllotmentService;

	@Autowired
	private ManageProfileService manageProfileService;
	
	@Autowired
	private AllotmentValidator allotmentValidator;
	
	@Autowired
	private CheckRoleService crService;

	@Autowired
	public LoginService loginService;
        
        private static final Logger logger = Logger.getLogger(ManageAllotment.class.getName());

/*
	@RequestMapping("/")
	public ModelAndView welcome() {
				return new ModelAndView("index");
	}*/
	
	/* -----------------------------------------------------------------------------------------------------------------------  */

	
	//changes made @Crystal
	//Method to save allotment details
	@RequestMapping(value = "/saveAllotment", method = RequestMethod.POST)
	public ModelAndView addAllotment(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload,@ModelAttribute("allotmentBean")AllotmentBean allotmentBean,BindingResult result) throws Exception {
		
		try {
				//ModelAndView model =  new ModelAndView("addAllotment");
				List<CompanyBean> companyList = manageProfileService.listCompanies();
			    Map<String, String> companyMap = new LinkedHashMap<String,String>();
			            for(CompanyBean cb : companyList){
			            	companyMap.put(cb.getCompany_name(), cb.getCompany_name());
			            }
			    ModelAndView model = new ModelAndView("addAllotment","companies",companyMap);  
			    
			   /* allotmentValidator.validate(allotmentBean, result);
				
				if (result.hasErrors()) {
					System.out.println("Binding Errors are present...");
					return model;
				}
				*/
			
				try{
				
					
			
						//System.out.println("after db entry");
						manageAllotmentService.handleFileUpload(request,fileUpload);
			
						manageAllotmentService.addAllotment(allotmentBean);
						model.addObject("success", 1);
			
					} 
				catch (IncorrectFileFormatException e) {
			
						//System.out.println(e);
                                                logger.error(e);
						model.addObject("error", 1);
						
			
					} 
				catch (MaxFileSizeExceededError m) {
			
						//System.out.println(m);
                                                logger.error(m);
						model.addObject("error1", 1);
			
					}
				
				
					return model;
				} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println(e);
                                logger.error(e);
				ModelAndView model1=new ModelAndView("500");
				model1.addObject("exception", "/saveAllotment");
				return model1;
			}
	}

	/*
	 * @RequestMapping(value = "/addAllotment", method = RequestMethod.GET)
	 * public ModelAndView createAllotment(@ModelAttribute("command")
	 * AllotmentBean allotmentBean , BindingResult result) {
	 * 
	 * Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("allotments",
	 * prepareListofBean(manageAllotmentService.listAllotment())); return new
	 * ModelAndView("addAllotment", model); }
	 */

	// Method to create a new allotment
	
	/* -----------------------------------------------------------------------------------------------------------------------  */

	
	//Method to create a new allotment
	@RequestMapping(value = "/addAllotment", method = RequestMethod.GET)
	public ModelAndView createAllotment(HttpServletRequest request,Model model) {
		
		
		  try {
			  	//Authentication is commented
			 
			  	/* 
					HttpSession session=request.getSession();
					String roleId=(String)session.getAttribute("roleId");
					String user=(String)session.getAttribute("userName");
					String name=loginService.checkSR(user);
					if(!(crService.checkRole("ManageAllotment", roleId)&&name.equals("ROOM_ALLOTMENT"))) // changed hardcoded string @Crystal
					return new ModelAndView("403");
					else
			  	 */
			
			
			  	{
			  		AllotmentBean allotmentBean = new AllotmentBean(); // declaring
			  		Allotment allot = new Allotment();
			  		model.addAttribute("allotmentBean", allotmentBean); // adding in model
			  		Map<String, Object> model1 = new HashMap<String, Object>();
			  		model1.put("allotments",  prepareListofBean(manageAllotmentService.listAllotment(allot)));
			  		
			  		List<CompanyBean> companyList = manageProfileService.listCompanies();
				    Map<String, String> companyMap = new LinkedHashMap<String,String>();
				            for(CompanyBean cb : companyList){
				            	companyMap.put(cb.getCompany_name(), cb.getCompany_name());
				            }
					
					return new ModelAndView("addAllotment","companies",companyMap);
			  		//return new ModelAndView("addAllotment");
			  	}
		  	} 
		  catch (Exception e) {
			  		// TODO Auto-generated catch block
			  		//System.out.println(e);
                                        logger.error(e);
			  		ModelAndView model1=new ModelAndView("500");
			  		model1.addObject("exception", "/addAllotment");
			  		return model1;
		  	}
		}

	/* -----------------------------------------------------------------------------------------------------------------------  */
	
	//Method to view allotment details
	
	@RequestMapping(value="/viewAllotment", method = RequestMethod.GET)
	public ModelAndView listAllotment(HttpServletRequest request,@ModelAttribute("command") Allotment allotmentBean,BindingResult bindingResult) {
		
		
		try {
				/* **
			 		//Authentication is commented
			
					HttpSession session=request.getSession();
					String roleId=(String)session.getAttribute("roleId");
					if(!crService.checkRole("ManageAllotment", roleId))
					return new ModelAndView("403");
					else
			
				 ** */
				{
					Map<String, Object> model = new HashMap<String, Object>();
					model.put("allotments",  prepareListofBean(manageAllotmentService.listAllotment(allotmentBean)));
					//model.put("allotments",manageAllotmentService.listAllotment(allotmentBean) );
				
					if (model.isEmpty()) {
						System.out.println("Error no Model , Model is null");
						return new ModelAndView("403");
					}
				
					return new ModelAndView("viewAllotment", model);
				}
			} 
		catch (Exception e) {
				// TODO Auto-generated catch block
				//System.out.println(e);
                                logger.error(e);
				ModelAndView model1=new ModelAndView("500");
				model1.addObject("exception", "/viewAllotment");
				return model1;
			}
	}

	// Used to display information regarding allotment

	private List<AllotmentBean> prepareListofBean(List<AllotmentBean> list) {
		List<AllotmentBean> beans = null;
		if (list != null && !list.isEmpty()) {
			beans = new ArrayList<AllotmentBean>();
			AllotmentBean bean = null;
			for (AllotmentBean allotment : list) {
				bean = new AllotmentBean();
				bean.setAllotment_id(allotment.getAllotment_id());
				bean.setCompany_name(allotment.getCompany_name());
				bean.setDrive_date(allotment.getDrive_date());
				bean.setJob_description(allotment.getJob_description());
				bean.setRoom_no(allotment.getRoom_no());
				bean.setRound_no(allotment.getRound_no());
				beans.add(bean);
			}
		}
		return beans;
	}

	// Ignore the below code
	/*
	 * 
	 * @RequestMapping(value = "/addAllotment", method = RequestMethod.GET)
	 * public ModelAndView createAllotment(Model model) { AllotmentBean
	 * allotmentBean = new AllotmentBean(); // declaring
	 * 
	 * model.addAttribute("allotmentBean", allotmentBean); // adding in model
	 * 
	 * return new ModelAndView("addAllotment"); }
	 * 
	 * @RequestMapping(value = "/viewAllotment", method = RequestMethod.GET)
	 * public ModelAndView createAllotment(@ModelAttribute("command")
	 * AllotmentBean allotment, BindingResult result) {
	 * 
	 * Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("categories", categoryService.getCategories()); return new
	 * ModelAndView("addCategory", model); return new
	 * ModelAndView("addAllotment"); }
	 * 
	 * @RequestMapping(value = "/add", method = RequestMethod.GET) public
	 * ModelAndView addEmployee(@ModelAttribute("command") EmployeeBean
	 * employeeBean , BindingResult result) {
	 * 
	 * Map<String, Object> model = new HashMap<String, Object>();
	 * model.put("employees",
	 * prepareListofBean(employeeService.listEmployeess())); return new
	 * ModelAndView("addEmployee", model); }
	 * 
	 */
	
	/* ----------------------------------------------------------------------------------------------- */

	@RequestMapping("/list")
	public ModelAndView list() {
		
		try {
			
			return new ModelAndView("list");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("exception", "/list");
			return model1;
		}
	}

	@RequestMapping("/tpclist")
	public ModelAndView tpclist() {
		try {
			
			return new ModelAndView("tpclist");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("exception", "/tpclist");
			return model1;
		}
	}
	
	@RequestMapping("/studentlist")
	public ModelAndView studentlist() {
		try {
			
			return new ModelAndView("studentlist");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("exception", "/studentlist");
			return model1;
		}
	}

	@RequestMapping("/dept")
	public ModelAndView dept() {
		try {
			
			return new ModelAndView("dept");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("exception", "/dept");
			return model1;
		}
	}

	@RequestMapping("/stats")
	public ModelAndView stats() {
		try {
			
			return new ModelAndView("stats");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("exception", "/stats");
			return model1;
		}
	}


	@RequestMapping("/company")
	public ModelAndView company() {
		try {
			
			return new ModelAndView("company");
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println(e);
                        logger.error(e);
			ModelAndView model1=new ModelAndView("500");
			model1.addObject("exception", "/company");
			return model1;
		}
	}

}
