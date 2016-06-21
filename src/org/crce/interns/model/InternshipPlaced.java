package org.crce.interns.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="placement_statistics_schema.internship_placed")
public class InternshipPlaced {
	String it,prod,elex,comps;
	String year;

	 @Column(name="it")
	  public String getIt() {
		return it;
	}
	public void setIt(String it) {
		this.it = it;
	}
	 @Column(name="prod")
	public String getProd() {
		return prod;
	}
	public void setProd(String prod) {
		this.prod = prod;
	}
	 @Column(name="elex")
	public String getElex() {
		return elex;
	}
	public void setElex(String elex) {
		this.elex = elex;
	}
	 @Column(name="comps")
	public String getComps() {
		return comps;
	}
	public void setComps(String comps) {
		this.comps = comps;
	}
	@Id
	 @Column(name="year")
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
   
}
