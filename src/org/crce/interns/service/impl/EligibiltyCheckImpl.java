/**
 * Author Name: Andrea Furtado
 *
 * Filename: EligibilityCheckImpl.java
 *
 * Classes used by code: Criteria,CriteriaBean,	ProfessionalProfile ,ProfessionalBean,EligibilityDaoImpl
 * 							QualificationBean,Qualification
 *  
 *  Description: This controller is uses the dao methods for retrieving the objects for checking the criteria
 * 
 *  Functions: getCriteria(), getQualifications() ,getProfessionalProfile(),getCriteriaId(),checkCriteria()
 *  
 */
package org.crce.interns.service.impl;

import java.util.Date;

import org.crce.interns.beans.CriteriaBean;
import org.crce.interns.beans.ProfessionalProfileBean;
import org.crce.interns.beans.QualificationBean;
import org.crce.interns.dao.EligibilityDao;
import org.crce.interns.model.Criteria;
import org.crce.interns.model.ProfessionalProfile;
import org.crce.interns.model.Qualification;
import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.EligibilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("E_service")
public class EligibiltyCheckImpl implements EligibilityService {

	@Autowired
	private EligibilityDao edao;

	/**
	 * this method copies criteria  object having id as c_id  to bean 
	 * @param c_id
	 */
	public CriteriaBean getCriteria(int c_id) {

		Criteria criteria = edao.getCriterias(c_id);
		CriteriaBean criteriaBean = new CriteriaBean();
		BeanUtils.copyProperties(criteria, criteriaBean);
		return criteriaBean;
	}

	
	/**
	 * this method copies professionalProfile object of given username to  a bean 
	 * @param username
	 */
	public ProfessionalProfileBean getProfessionalProfile(String username) {
		ProfessionalProfile pp = edao.getProfessionalProfile(username);
		ProfessionalProfileBean pd = new ProfessionalProfileBean();
		BeanUtils.copyProperties(pp, pd);
		return pd;

	}
	
	/**
	 * this method copies qualification object of given username to a bean 
	 * @param username
	 */
	public QualificationBean getQualifications(String username) {
		Qualification q = edao.getQualification(username);
		QualificationBean qb = new QualificationBean();
		BeanUtils.copyProperties(q, qb);
		return qb;

	}

	/**
	 * this method returns the criteria id of criteria for a job having id as job_id
	 * @param job_id
	 */
	public int getCriteriaId(String job_id) {
		int c_id;
		c_id = edao.getCriteriaId(job_id);//
		return c_id;
	}

	/**
	 * this method uses the above method to fetch the required beans and uses the parameters of beans  for comparing 
	 * @param username ,criteria_id ,job_id
	 */
	public boolean checkCriteria(String username, int criteria_id, String job_id) {
		int i = 0;
		CriteriaBean c = getCriteria(criteria_id);
		Date cur_date = new Date();
		if (cur_date.compareTo(c.getLast_date_to_apply()) <= 0) //to check if last date to apply has expired
		{
			ProfessionalProfileBean p = getProfessionalProfile(username);
				
			// check if student is placed
			if (p.getStatus().equalsIgnoreCase(ConstantValues.PLACED)) {
				if(!c.getPlaced_students_allowed().equalsIgnoreCase(ConstantValues.ALLOWED))
				{	
					System.out.println(c.getPlaced_students_allowed());
					return false;
				}
					String job_category = edao.getJobCategory(job_id);

					String student_job_category = edao.getJobCategory(edao.getStudentJob(username));

					if (job_category.equalsIgnoreCase(ConstantValues.DREAM) && student_job_category.equalsIgnoreCase(ConstantValues.DREAM)) {
							System.out.println("you already have a dream job");
							return false;
					}
					if (job_category.equalsIgnoreCase(ConstantValues.NONDREAM) && student_job_category.equalsIgnoreCase(ConstantValues.DREAM)) {
					System.out.println("you have a dream job and this is a non-dream");
					return false;
					}

			}
			
			String branch = p.getBranch();
			String criteria_br[] = c.getEligible_branches().split(",");//to check whether student belongs to the branch

			for (i = 0; i < criteria_br.length; i++) {

				System.out.println("Inside for::::::::");
				if (branch.equalsIgnoreCase(criteria_br[i])) {
					QualificationBean q = getQualifications(username);
					// check the student's qualification
					
					System.out.println("Inside percent::::::::"+q.getDeg_per()+" crit "+c.getPercentage());
					System.out.println("Inside hsc::::::::"+q.getHsc_or_dip_per()+" crit "+c.getHsc_or_dip_percentage());
					System.out.println("Inside ssc::::::::"+q.getSsc_per()+" crit "+c.getSsc_percentage());
					System.out.println("Inside drops::::::::"+q.getDrops()+" crit "+c.getYear_gap_allowed());
					
					if (Double.parseDouble(q.getDeg_per()) >= Double.parseDouble(c.getPercentage())
							&& Double.parseDouble(q.getHsc_or_dip_per()) >= Double.parseDouble(c.getHsc_or_dip_percentage())
							&& Double.parseDouble(q.getSsc_per()) >= Double.parseDouble(c.getSsc_percentage())
							&& Double.parseDouble(q.getDrops()) <= Double.parseDouble(c.getYear_gap_allowed())
							) {
						
						return true;
					} else {
						System.out.println("dont meet the qualification criteria");
						break;
					}
				}
			}
			if (i == criteria_br.length)
				System.out.println("you dont belong to the branch mentioned in criteria ");

		} else
			System.out.println("last date to apply has expired");

		return false;
	}

}
