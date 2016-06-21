/*
 * AddStudentValidator Validator Class performs the Validation for  
 * 
 * Blank rollno 
 * Blank name
 * Blank year
 * Blank date of birth
 * Blank mobile 
 * Blank email-id
 * Blank ssc percentage
 * Blank hsc/diploma percentage
 * Blank gender
 * 
 * @author Adarsh
 * 
 * */
package org.crce.interns.validators;

import org.crce.interns.beans.StudentBean;
import org.crce.interns.model.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddStudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		// TODO Auto-generated method stub
		return Student.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rollno", "rollno.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year", "year.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobile", "mobile.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ssc_per", "ssc_per.required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hsc_or_dip_per", "hsc_or_dip_per.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "gender.required");
	}

}
