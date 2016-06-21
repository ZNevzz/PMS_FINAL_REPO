/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.interns.service.impl;

import java.io.File;
import java.util.Calendar;

/**
 *
 * @author Leon
 * Task: Creates folders for users after users for their File operations
 * Dependency: DirectoryDAO.java, DirectoryPathBean.java
 */





import java.util.List;
import org.crce.interns.beans.DirectoryPathBean;
import org.crce.interns.dao.*;
import org.crce.interns.service.DirectoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("directoryService")
public class DirectoryServiceImpl implements DirectoryService {

    @Autowired
    private DirectoryDAO directoryDAO;
    
    
    DirectoryPathBean directoryPathBean = new DirectoryPathBean();
    String path = "C:\\PMS";
    int year = Calendar.getInstance().get(Calendar.YEAR);

    public void setLoginDAO(DirectoryDAO directoryDAO) {
        this.directoryDAO = directoryDAO;
    }
    
   /* public String checkLogin(String userName, String userPassword) {
        System.out.println("In Service class...Check Login");
        return loginDAO.checkLogin(userName, userPassword);
    }
*/
    
    
    
        
    @Override
    public void createStudentFolder() {
        System.out.println("Service");
        //return directoryDAO.createStudentFolder();
        List studentList = directoryDAO.createStudentFolder();
        boolean created = false;
        for (Object l1 : studentList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getStudentFolder()+"/" + (l1.toString()) + "/Resume");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        for (Object l1 : studentList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getStudentFolder()+"/" + (l1.toString()) + "/Offer Letters");//folder name changed @Crystal
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        for (Object l1 : studentList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getStudentFolder()+"/" + (l1.toString()) + "/Certificates");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
    }
    
    @Override
    public void createFacultyFolder()
    {
        System.out.println("fac Service");
        //return directoryDAO.createFacultyFolder();
        List facultyList = directoryDAO.createFacultyFolder();
        boolean created = false;
        for (Object l1 : facultyList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getFacultyFolder()+"/" + (l1.toString()) + "/Reference");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        for (Object l1 : facultyList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getFacultyFolder()+"/" + (l1.toString()) + "/Letters");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        
    }
    
    
    @Override
    public void createTpoFolder() {
        System.out.println(" tpo Service");
        //return directoryDAO.createTpoFolder();
        List tpoList = directoryDAO.createTpoFolder();
        boolean created = false;
        for (Object l1 : tpoList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getTpoFolder()+"/" + (l1.toString()) + "/References");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        for (Object l1 : tpoList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getTpoFolder()+"/" + (l1.toString()) + "/Letters");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
        for (Object l1 : tpoList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getTpoFolder()+"/" + (l1.toString()) + "/Reports");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
    }
    
    @Override
    public void createCompanyFolder()
    {
        System.out.println("Company Service");
        //return directoryDAO.createCompanyFolder();
        List companyList = directoryDAO.createCompanyFolder();
        boolean created=false;
        for (Object l1 : companyList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getCompanyFolder()+"/" + (l1.toString()));
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
    }
    
    @Override
    public void createAdminFolder(){
        System.out.println("createAdminService");
        List adminList = directoryDAO.createAdminFolder();
        boolean created = false;
        for (Object l1 : adminList) {
            System.out.println(l1);
            File files = new File(directoryPathBean.getAdminFolder() + "/" +(l1.toString()) + "/Archives");
            if (!files.exists()) {
                System.out.println("Something doesnt exist");
                if (files.mkdirs()) {
                    System.out.println("created");
                    created = true;
                } else {
                    created = false;
                }

            }

        }
    }
    
    @Override
    public void createSystemFolders(){
        File logFiles = new File(directoryPathBean.getLogFolder());
        logFiles.mkdirs();
        File csvFiles = new File(directoryPathBean.getCsvFolder());
        csvFiles.mkdirs();
        File emailFiles = new File(directoryPathBean.getEmailFolder());
        emailFiles.mkdirs();
        
        //code added @Crystal
        File roomAllotmentFiles = new File(directoryPathBean.getRoomAllotmentFolder());
        roomAllotmentFiles.mkdirs();
        
        File counselingReportStudentFiles = new File(directoryPathBean.getCounselingReportStudentFolder());
        counselingReportStudentFiles.mkdirs();
        
        File counselingReportFtpcFiles = new File(directoryPathBean.getCounselingReportFtpcFolder());
        counselingReportFtpcFiles.mkdirs();
        
      //File copyFiles = new File(directoryPathBean.getCopyFolder());
      //copyFiles.mkdirs();
    }
}
