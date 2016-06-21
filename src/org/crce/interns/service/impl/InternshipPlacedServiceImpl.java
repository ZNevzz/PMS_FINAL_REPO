package org.crce.interns.service.impl;

import java.util.List;

import org.crce.interns.beans.InternshipPlacedBean;
import org.crce.interns.dao.HigherStudiesDao;
import org.crce.interns.dao.InternshipPlacedDao;
import org.crce.interns.model.InterestedInHigherStudies;
import org.crce.interns.model.InternshipPlaced;
import org.crce.interns.service.InternshipPlacedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("internshipplacedService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class InternshipPlacedServiceImpl implements InternshipPlacedService {

	@Autowired
	private InternshipPlacedDao hsDao;
	
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addIP(InternshipPlacedBean ihs) {
		hsDao.addIP(ihs);
	
}
	public List<InternshipPlaced> listIhs() {
		System.out.println("inside service");
		return hsDao.listIhs();
	}

}
