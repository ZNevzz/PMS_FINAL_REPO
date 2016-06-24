package org.crce.interns.service;

public interface ConstantValues {
	
	// FTPC SPECIAL ROLES
	public String task1 = "PLACEMENT_REPORT";
	public String task2 = "ROOM_ALLOTMENT";
	public String task3 = "COUNSELLING_REPORT";
	public String task4 = "FEEDBACK_REPORT";
	
	
	// ROLE ID
	public String StudentId = "1";
	public String FacultyId = "2";
	public String STPCId = "3";
	public String FTPCId = "4";
	public String TPOId = "5";
	public String AdminId = "6";
	
	// ROLE NAMES
	public String StudentName = "Student";
	public String StudentTPCName = "StudentTPC";
	public String Faculty = "Faculty";
	public String FacultyTPC = "FacultyTPC";
	public String Admin = "Admin";
	public String TPO = "TPO";
	
	// COMPANY NAMES
	public String JPM = "JP Morgan";
	public String DIRECTI = "Direct i";
	public String MS = "Morgan Stanley";
	public String TCS = "Tata Consultancy Services";
	public String ACC = "Accenture";
	public String ZS = "ZS Associates";
	public String GOD = "Godrej";
	public String LNT = "Laursen & Tubro";
	
	// COMPANY ABOUT US URL
	public String JPM_LINK = "https://www.jpmorgan.com/country/IN/EN/about";
	public String DIRECTI_LINK = "http://www.directi.com";
	public String MS_LINK = "http://www.morganstanley.com/about-us/global-offices/india";
	public String TCS_LINK = "http://www.tcs.com/Pages/default.aspx";
	public String ACC_LINE = "https://www.accenture.com/in-en";
	public String ZS_LINK = "http://www.zsassociates.com/careers/india.aspx";
	public String GOD_LINK = "http://www.godrejcareers.com/";
	public String LNT_LINK = "http://www.larsentoubro.com/";
	
	//NOTIFICATION CATEGORIES	
	public String JOB = "JOB";
	public String ELIGIBLE = "ELIGIBLE";
	public String EVENT = "EVENT";
	public String TEST = "TEST";
	public String COUNSELLING = "COUNSELLING";
	public String SELECTED = "SELECTED";
	public String ROOM = "ROOM";
	public String EMAIL = "EMAIL";
	public String ROLE = "ROLE";
	public String DOWNLOAD = "DOWNLOAD";
	
	//NOTIFICATION TYPES
	public String GROUP = "GROUP";
	public String USER = "USER";
	public String ALL = "ALL";
	
	
	//NOTIFICATION CATEGORY-WISE MESSAGE
	public String JOB_M1 = "A new job has been posted for ";
	
	public String ELIGIBLE_M1 = "Your Job Application for ";
	public String ELIGIBLE_M2 = " has been successfully accepted.";
	
	public String EVENT_M = "A new event has been scheduled for";
	
	public String TEST_M = "";
	
	public String COUNSELLING_M = "You have been selected to give a counselling report based on your placement experience for ";
		
	public String SELECTED_M = "Congratulations !! You have been selected as an employee for ";
	
	public String ROOM_M = "Check out the room allotment";
	
	public String EMAIL_M = "";
	
	public String ROLE_M = "";
	
	public String DOWNLOAD_M = "";
	
	
	// BRANCHES
	public String COMPS = "Computer Engineering";
	public String IT = "Information Technology";
	public String ELEX = "Electronics Engineering";
	public String PROD = "Production Engineering";
	public String[] BRANCHES = new String[]{COMPS, IT, ELEX ,PROD}; 
	
	// EVENT TYPES
	public String APTI = "Aptitude";
	public String INTERVIEW = "Interview";
	public String PRE = "Pre-Placement Talk";
	
	// INTERVIEW TYPES
	public String GD = "Group Discussion";
	public String TECH = "Technical";
	public String HR = "H.R.";
	public String COD = "Coding";


	// STUDENT PLACEMENT STATUS
	public String PLACED = "Placed";
	public String DREAM ="Dream";
	public String NONDREAM ="Nondream";
	public String ALLOWED ="Yes";
	
	public String JOB_URL1 = "JobPosts?companyname=";
	public String JOB_URL2 = "&amp;year=";
	public String ELIGIBLE_URL = "viewclist.html?company=";
	public String EVENT_URL = "ViewEvents";
	public String TEST_URL = "TEST";
	public String COUNSELLING_URL = "displist";
	public String SELECTED_URL = "SELECTED";
	public String ROOM_URL = "ROOM";
	public String EMAIL_URL = "EMAIL";
	public String ROLE_URL = "ROLE";
	public String DOWNLOAD_URL = "DOWNLOAD";
	
}

