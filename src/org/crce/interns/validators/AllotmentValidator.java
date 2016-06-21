package org.crce.interns.validators;

import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.model.Allotment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AllotmentValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return Allotment.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
		AllotmentBean allotment = (AllotmentBean) obj;
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company_name", "roomComapny.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "round_no", "roomRoundNo.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "room_no", "roomNo.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "drive_date", "roomDriveDate.required");
		
		
	}

}
