/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.interns.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import org.crce.interns.service.FTPService;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leon
 */
@Service("ftpService")
public class FTPServiceImpl implements FTPService{

    //create FTP Client instance for connection
    FTPSClient ftpClient = null;
    /**
     * 
     * @param host
     * @param port
     * @param username
     * @param password
     * @throws Exception 
     */
    
    
  
    // Constructor! Class Declaration changes for this one!
    //public FTPServiceImpl(String host, int port, String username, String password) throws Exception {
        
    public FTPServiceImpl() throws Exception {    
        /*
    	ftpClient = new FTPSClient("SSL");
        ftpClient.setAuthValue("SSL");
        ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;
        //.connect + .login in java is equivalent to ftp_login in PHP
        //ftpClient.connect(host, port);
        ftpClient.connect("127.0.0.1", 21);
        //debug statement to check port 
        System.out.println("FTP URL is:" + ftpClient.getDefaultPort());
        reply = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftpClient.disconnect();
            throw new Exception("Exception in connecting to FTP Server");
        }
        ftpClient.login("PMS", "place");
        //allow files to be transferred only in Binary
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.enterLocalPassiveMode();
        */
    }
    
    /**
     * 
     * @param localFileFullName
     * @param fileName
     * @param hostDir
     * @throws Exception 
     */
    
    
    @Override
    public void uploadFTPFile(String localFileFullName, String fileName, String hostDir)
            throws Exception {
    	
    	/*
        try {
            InputStream input = new FileInputStream(new File(localFileFullName));

            this.ftpClient.storeFile(hostDir + fileName, input);
        } catch (Exception e) {

        }
        */
    }
    
    /**
     * 
     * @param source
     * @param destination 
     */
    
    
    
    @Override
    public void downloadFTPFile(String source, String destination) {
    	/*
        try (FileOutputStream fos = new FileOutputStream(destination)) {
            this.ftpClient.retrieveFile(source, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
    
    /**
     * 
     * @param directory
     * @param fileName
     * @return
     * @throws IOException 
     */
    
    
    //use this for debugging
    @Override
    public boolean listFTPFiles(String directory, String fileName) throws IOException {
        // lists files and directories in the current working directory
    	
    	/*
        boolean foundFilename = false;
        FTPFile[] files = ftpClient.listFiles(directory);
        for (FTPFile file : files) {
            String details = file.getName();
            System.out.println(details);
            if (details.equals(fileName)) {
                System.out.println("Correct Filename");
                foundFilename = details.equals(fileName);
                if (!details.equals(fileName)) {
                    System.out.println("FIle not updated yet!");
                }
            }
        }

        return foundFilename;
        
        */
    	return true;
    }
    

    @Override
    public void disconnect() {
    	
    	/*
        if (this.ftpClient.isConnected()) {
            try {
                this.ftpClient.logout();
                this.ftpClient.disconnect();
            } catch (IOException f) {
                // do nothing as file is already saved to server
            }
        }
        */
    }

}
