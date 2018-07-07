package org.crce.interns.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.crce.interns.dao.StatisticsDAO;
import org.crce.interns.model.PlacementStats;
import org.crce.interns.model.ProfessionalProfile;
import org.crce.interns.model.QuickStats;
import org.crce.interns.model.TotalNoOfStudents;
import org.crce.interns.model.TotalStudents;
import org.crce.interns.model.UserDetails;
import org.crce.interns.service.ConstantValues;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("statisticsDAO")
public class StatisticsDAOImpl implements StatisticsDAO, ConstantValues {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<PlacementStats> list() {

		List<PlacementStats> listStats = null;

		listStats = sessionFactory.getCurrentSession().createCriteria(PlacementStats.class).list();

		return listStats;
	}

	@Override
	public void add(PlacementStats placementStats) {
		sessionFactory.getCurrentSession().saveOrUpdate(placementStats);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void calculateTotal(String year) {
		/*
		 * List<ProfessionalProfile> l =
		 * sessionFactory.getCurrentSession().createCriteria(ProfessionalProfile
		 * .class).list(); for (ProfessionalProfile i : l)
		 * System.out.println(i);
		 */
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProfessionalProfile.class);
		criteria.add(Restrictions.eq("year", year));
		List<ProfessionalProfile> l = criteria.list();

		criteria = sessionFactory.getCurrentSession().createCriteria(UserDetails.class);
		criteria.add(Restrictions.eq("roleId", "1"));
		List<UserDetails> studentList = criteria.list();

		//13
		System.out.println("Statsdaoimpl : " + studentList.size());
		
		List<ProfessionalProfile> compsList = new ArrayList<>();
		List<ProfessionalProfile> elexList = new ArrayList<>();
		List<ProfessionalProfile> itList = new ArrayList<>();
		List<ProfessionalProfile> prodsList = new ArrayList<>();
		for (ProfessionalProfile i : l) {
			System.out.println("*****" + i.getUserName() + "  " + contains(studentList, i.getUserName()));
			if (contains(studentList, i.getUserName())) {
				if (i.getBranch() != null) {
					System.out.println(i.getUserName());
					if (i.getBranch().equals(ELEX)) {
						elexList.add(i);
						System.out.println("ElexList : " + i.getUserName());
					} else if (i.getBranch().equals(IT)) {
						itList.add(i);
						System.out.println("ItList : " + i.getUserName());
					} else if (i.getBranch().equals(COMPS)) {
						compsList.add(i);
						System.out.println("CompsList : " + i.getUserName());
					} else if (i.getBranch().equals(PROD)) {
						prodsList.add(i);
						System.out.println("ProdList : " + i.getUserName());
					}
				}
			}
		}
		TotalNoOfStudents totalNoOfStudents = new TotalNoOfStudents();
		totalNoOfStudents.setYear(year);
		totalNoOfStudents.setComps(compsList.size());
		totalNoOfStudents.setElex(elexList.size());
		totalNoOfStudents.setIt(itList.size());
		totalNoOfStudents.setProd(prodsList.size());
		sessionFactory.getCurrentSession().saveOrUpdate(totalNoOfStudents);
	}

	private boolean contains(List<UserDetails> studentList, String userName) {
		for (UserDetails student : studentList) {
			if (student.getUserName().equals(userName))
				return true;
		}
		return false;
	}

	@Override
	public TotalNoOfStudents getTotalNoOfStudents(String year) {
		List<TotalNoOfStudents> totalList = sessionFactory.getCurrentSession().createCriteria(TotalNoOfStudents.class)
				.add(Restrictions.eq("year", year)).list();
		return totalList.get(0);
	}

	@Override
	public List<QuickStats> getQuickStatsList(String year) {
		List<QuickStats> quickStatsList = sessionFactory.getCurrentSession().createCriteria(QuickStats.class).add(Restrictions.eq("year", year)).list();
		return quickStatsList;
	}

	@Override
	public List<PlacementStats> getPlacementStatsList(String year) {
		List<PlacementStats> placementStatsList = sessionFactory.getCurrentSession().createCriteria(PlacementStats.class).add(Restrictions.eq("year", year)).list();
		return placementStatsList;
	}

}
