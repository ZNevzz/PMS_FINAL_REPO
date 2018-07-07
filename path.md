##PATH PAGE

@backend developers
As we code in Windows OS & deploy in Ubuntu, it is difficult to change the OS dependent paths which are defined 

within the java code or jsp pages. 

For a solution, we will manage all path related information on this page to simplify the deployment & development phase.

Please copy paste & enter correct data in the below template 

### DEVELOPER NAME
## File Name - method name - path value

@Crystal21
1) AddUserServiceImpl.java- handleFileUpload()- 
	String saveDirectory = directoryPathBean.getCsvFolder() + "/"  + timeStamp + "/";
	AddUserDaoImpl.java
	copyFile = new File(directoryPathBean.getCsvFolder() + "/"  + timeStamp + "/" + fileName);
	
	DirectoryPathBean.java
	private final String rootContext="home/universe/PMS/"+year;
	private final String studentFolder=rootContext + "/Users/Student";
	private final String counselingReportStudentFolder = rootContext + "/System/Counseling Report-Student"; 
	private final String counselingReportFtpcFolder = rootContext + "/System/Counseling Report-Ftpc"; 
2)ResumeUploadServiceImpl.java- handleFileUpload()
	String saveDirectory = directoryPathBean.getStudentFolder() + "/" + username + "/Resume/";	
	
3) 	ManageAllotmentServiceImpl.java- not in any method-
	String saveDirectory = directoryPathBean.getRoomAllotmentFolder()+ "/";
	
4)	CertificateUploadServiceImpl.java- handleFileUpload()
	String saveDirectory = directoryPathBean.getStudentFolder() + "/" + username + "/Certificates/";
	
5) CounselingReportUploadServiceImpl.java- handleFileUpload()
	saveDirectory = directoryPathBean.getCounselingReportStudentFolder() + "/";
	saveDirectory = directoryPathBean.getCounselingReportFtpcFolder()+ "/";
	
6)OfferLetterUploadServiceImpl.java- handleFileUpload()
	String saveDirectory = directoryPathBean.getStudentFolder() + "/" + username + "/Offer Letters/";
	
	
	
Example

### ZNevzz
## dispatcher-servlet.xml - FileReader - /WEB-INF/database.xml

### ZNevzz
## dispatcher-servlet.xml - CSVReader - /WEB-INF/applicant.csv

### ZNevzz
## dispatcher-servlet.xml - SCSVReader - /WEB-INF/applicant.scsv

