package org.crce.interns.validators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.crce.interns.beans.AllotmentBean;
import org.crce.interns.model.Allotment;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
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
		//if(allotment.getDrive_date()==null)
			//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "drive_date", "roomDriveDate.required");

		
		
	}

	public int validateRound(String roundName) {
		// TODO Auto-generated method stub
		
		if(roundName.isEmpty())
			return 0;
		
		return 1;
	}

	public int validateDate(Date drive_date) {
		// TODO Auto-generated method stub
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date();
        
        
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
        */
		if(drive_date==null || drive_date.before(curDate))
			return 0;
		
		return 1;
		
	}

	public int validateRoom(String room_no) {
		// TODO Auto-generated method stub
		
		if(room_no.isEmpty())
			return 0;
		
		return 1;
	}

}
