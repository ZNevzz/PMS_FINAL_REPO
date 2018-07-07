package org.crce.interns.beans;

import java.util.Date;

// Room Allotment Entries(room_allotment.allotment)

public class AllotmentBean{

	private Integer allotment_id;
	private String company_name;
	private String round_no;
	private String room_no;
	private String job_description;
	private Date drive_date;
	private String fileUpload;
	private String year;
	
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getRound_no() {
		return round_no;
	}
	public void setRound_no(String round_no) {
		this.round_no = round_no;
	}
	public String getRoom_no() {
		return room_no;
	}
	public void setRoom_no(String room_no) {
		this.room_no = room_no;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}
	
	public Date getDrive_date() {
		return drive_date;
	}
	public void setDrive_date(Date drive_date) {
		this.drive_date = drive_date;
	}
	public Integer getAllotment_id() {
		return allotment_id;
	}
	public void setAllotment_id(Integer allotment_id) {
		this.allotment_id = allotment_id;
	}
	
	public String getFileUpload() {
		return fileUpload;
	}
	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
