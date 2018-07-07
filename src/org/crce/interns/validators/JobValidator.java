package org.crce.interns.validators;

import org.crce.interns.beans.JobBean;
import org.crce.interns.model.Job;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class JobValidator implements Validator{

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return Job.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		JobBean jobBean = (JobBean) obj;
		System.out.println(jobBean.getJob_id() + " : Job ID in Validator");
		System.out.println(jobBean.getJob_description() + " : Description in Validator");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job_id", "company_name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "docs_required", "documents.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ctc", "company_name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job_category", "job_category.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "drive_date", "drive_date.required");
	}


}
