package org.crce.interns.controller;

import org.apache.log4j.Logger;
import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.model.Criteria;
import org.crce.interns.service.CriteriaService;
import org.crce.interns.validators.CriteriaFormValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CriteriaController {

	@Autowired
	CriteriaFormValidator criteriaValidator;

	@Autowired
	private CriteriaService criteriaService;
        
        private static final Logger logger = Logger.getLogger(CriteriaController.class.getName());

	@RequestMapping(value = "/addCriteria", method = RequestMethod.GET)
	public ModelAndView addCriteria(Model model) {
		try {
			CriteriaBean criteriaBean = new CriteriaBean();
			model.addAttribute("criteriaBean", criteriaBean);
			//System.out.println("in controller11");
			return new ModelAndView("addCriteria");
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	@RequestMapping(value = "/saveCriteria", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("criteriaBean") CriteriaBean criteriaBean, BindingResult result)
			throws Exception {
		try {
			criteriaValidator.validate(criteriaBean, result);
			if (result.hasErrors()) {
				//System.out.println("Error in form");
                                logger.error("Error in form");
				return new ModelAndView("addCriteria");
			}

			Criteria criteria = prepareCriteriaModel(criteriaBean);
			criteriaService.addCriteria(criteria);
			return new ModelAndView("redirect:/addCompany");
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	private Criteria prepareCriteriaModel(CriteriaBean criteriaBean) {
		try {
			Criteria criteria = new Criteria();
			BeanUtils.copyProperties(criteriaBean, criteria);
			return criteria;
		} catch (Exception e) {
                        logger.error(e);
			return new Criteria();
		}
	}

}
