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
	public String INF = "Infosys";
	public String NSE = "National Stock Exchange of India";
	public String WIP = "Wipro";
	public String NER = "Kansai Nerolac Paints";
	public String AMD = "Amdocs";
	public String SYN = "Syntel";
	public String HSBC = "HSBC";
	public String TM = "Tech Mahindra";
	public String HP = "Hewlett-Packard";
	public String MH = "Mahindra";
	public String FB = "Federal Bank";
	public String CG = "Capgemini";
	public String PAT = "Patni";
	public String GIT = "Godrej Infotech";
	public String MAQ = "MAQ Software";
	public String CSI = "CSI Technologies";
	public String GOG = "Google";
	public String QUI = "Quinnox";
	public String GEN = "Genesys";
	public String IBM = "IBM";
	public String WF = "Weatherford";
	
	String[] cNames = new String[]{
			JPM,DIRECTI,MS,TCS,ACC,ZS,GOD,LNT,INF,NSE,WIP,NER,AMD,SYN,HSBC,TM,HP,MH,
			FB,CG,PAT,GIT,MAQ,MAQ,CSI,GOG,QUI,GEN,IBM,WF
	};
	
	// COMPANY ABOUT US URL
	public String JPM_LINK = "https://www.jpmorgan.com/country/IN/EN/about";
	public String DIRECTI_LINK = "http://www.directi.com";
	public String MS_LINK = "http://www.morganstanley.com/about-us/global-offices/india";
	public String TCS_LINK = "http://www.tcs.com/Pages/default.aspx";
	public String ACC_LINE = "https://www.accenture.com/in-en";
	public String ZS_LINK = "http://www.zsassociates.com/careers/india.aspx";
	public String GOD_LINK = "http://www.godrejcareers.com/";
	public String LNT_LINK = "http://www.larsentoubro.com/";
	public String INF_LINK = "https://www.infosys.com/";
	public String NSE_LINK = "https://www.nseindia.com/";
	public String WIP_LINK = "http://www.wipro.com/";
	public String NER_LINK = "https://www.nerolac.com/";
	public String AMD_LINK = "http://www.amdocs.com/pages/homepage.aspx";
	public String SYN_LINK = "http://www.syntelinc.com/";
	public String HSBC_LINK = "https://www.hsbc.co.in/1/2/homepage";
	public String TM_LINK = "http://www.techmahindra.com/pages/default.aspx";
	public String HP_LINK = "http://www.hp.com/";
	public String MH_LINK = "http://www.mahindra.com/";
	public String FB_LINK = "http://www.federalbank.co.in/";
	public String CG_LINK = "https://www.capgemini.com/";
	public String PAT_LINK = "https://www.capgemini.com/";
	public String GIT_LINK = "http://www.godrejinfotech.com/";
	public String MAQ_LINK = "http://maqsoftware.com/";
	public String CSI_LINK = "http://www.csitech.com/";
	public String GOG_LINK = "https://www.google.co.in/";
	public String QUI_LINK = "http://www.quinnox.com/";
	public String GEN_LINK = "http://www.genesys.com/";
	public String IBM_LINK = "https://www.ibm.com/in-en/";
	public String WF_LINK = "http://www.weatherford.com/en";

	//NOTIFICATION CATEGORIES	
	public String JOB = "JOB";
	public String ELIGIBLE = "ELIGIBILITY";
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
	
	public String ROOM_M = "Venue has been posted for an event. Check the Venue list";
	
	public String EMAIL_M = "";
	
	public String ROLE_M = "";
	
	public String DOWNLOAD_M = "";
	
	public String APPLICANTS_MSG1 = "Congratulations! Your application for ";
	public String APPLICANTS_MSG2 = " has been approved by Placement Council";
	public String APPLICANTS_MSG3 = "Attention! Your name has been removed from the applicant list for ";
	public String APPLICANTS_MSG4 = ". For any discussion, please approach the Placement Council";
	
	public String SELECTED_MSG1 = "Congratulations! You have been recruited in ";
	public String SELECTED_MSG2 = " as an Employee";
	public String SELECTED_MSG3 = "Attention! Your name has been removed from the selected applicants list for ";
	public String SELECTED_MSG4 = ". For any discussion, please approach the Placement Council";
	
	
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
	public String NOT_PLACED = "Not Placed";
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
	public String APPLICANTS_URL1 = "viewApplicants?companyname=";
	public String APPLICANTS_URL2 = "&amp;year=";
	
}

