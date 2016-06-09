package org.crce.interns.validators;

import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.model.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class SearchApplicantValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		
		// TODO Auto-generated method stub
		
		return UserDetails.class.equals(paramClass);

	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		// TODO Auto-generated method stub
		
		UserDetailsBean userBean = (UserDetailsBean) obj;
		System.out.println(userBean.getUserName() + " : User Name in Validator");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "username.required");
	}

}
