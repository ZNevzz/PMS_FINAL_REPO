/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.interns.beans;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Leon
 * Task: Makes it easier for people dealing with file handling operations to get paths
 * Dependency: -
 */
public class DirectoryPathBean {
	
	
	

    String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR))+"-"+ Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+1);

    //private final String rootContext="C:\\PMS\\"+year;
    private final String rootContext="/home/universe/PMS/"+year;

    private final String studentFolder=rootContext + "/Users/Student";
    //private final String studentFolder=rootContext + "\\Users\\Student";	//for windows
    private final String facultyFolder=rootContext + "/Users/Faculty";
    private final String tpoFolder = rootContext + "/Users/TPO";
    private final String adminFolder = rootContext + "/Users/Admin";
    private final String companyFolder = rootContext + "/Users/Company";
    private final String csvFolder = rootContext + "/System/CSV";
    private final String logFolder = rootContext + "/System/Logs";
    private final String emailFolder= rootContext + "/System/Email_Temp";
    private final String roomAllotmentFolder = rootContext + "/System/Room Allotment"; //code added @Crystal
    private final String counselingReportStudentFolder = rootContext + "/System/Counseling Report-Student"; //code added @Crystal
    //private final String counselingReportStudentFolder = rootContext + "\\System\\Counseling Report-Student"; //for windows
    private final String counselingReportFtpcFolder = rootContext + "/System/Counseling Report-Ftpc"; //code added @Crystal
    //private final String counselingReportFtpcFolder = rootContext + "\\System\\Counseling Report-Ftpc"; //for windows
	private final String systemFolder = rootContext + "/System";  //code added @Leon

/*	private final String copyFolder = "C:\\Users\\Crystal\\Desktop"; //code added @Crystal
	    
			public String getCopyFolder() {
				return copyFolder;
			}    */
	
	public String getCounselingReportStudentFolder() {
		return counselingReportStudentFolder;
	}

	public String getCounselingReportFtpcFolder() {
		return counselingReportFtpcFolder;
	}
	
    public String getSystemFolder(){
    	return systemFolder;
    }
    
    public String getRoomAllotmentFolder() {
		return roomAllotmentFolder;
	}

	public String getRootContext(){
        return rootContext;
    }
    
    public String getStudentFolder(){
        return studentFolder;
    }

    public String getFacultyFolder() {
        return facultyFolder;
    }

    public String getTpoFolder() {
        return tpoFolder;
    }

    public String getAdminFolder() {
        return adminFolder;
    }

    public String getCompanyFolder() {
        return companyFolder;
    }

    public String getCsvFolder() {
        return csvFolder;
    }

    public String getLogFolder() {
        return logFolder;
    }

    public String getEmailFolder() {
        return emailFolder;
    }
    
    
}
