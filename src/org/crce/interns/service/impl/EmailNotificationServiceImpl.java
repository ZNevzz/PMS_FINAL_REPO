/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crce.interns.service.impl;

import java.io.IOException;
import javax.mail.internet.MimeMessage;
import org.crce.interns.dao.SendEmailDAO;
import org.crce.interns.service.ConstantValues;
import org.crce.interns.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 *
 * @author Leon
 */
@Service("emailNotificationService")
public class EmailNotificationServiceImpl implements EmailNotificationService,ConstantValues{

    @Autowired
    private SendEmailDAO sendEmailDAO;
    
     @Autowired
    private JavaMailSender javaMailSender;
    
    private String intendedReceivers;
    
    /**
     * 
     * @param receivers
     * @param category
     * @param message 
     */
    public void sendEmailNotification(String receivers, String category, String message) {

        if (receivers.equalsIgnoreCase(COMPS) || receivers.equalsIgnoreCase(IT) || receivers.equalsIgnoreCase(PROD) || receivers.equalsIgnoreCase(ELEX)){
            String list = sendEmailDAO.fetchStreamStudents(receivers);
        }
        else{
            
        //indiwala
            intendedReceivers = intendedReceivers.concat(sendEmailDAO.fetchStudentEmailId(receivers));
        }
        
        String[] emailIds = intendedReceivers.split("\\s");
        
        
        javaMailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage)
                    throws javax.mail.MessagingException, IllegalStateException, IOException {
                System.out.println("Throws Exception");
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                //mimeMessageHelper.setTo(request.getParameter("receiver"));
                mimeMessageHelper.setTo(emailIds);

                mimeMessageHelper.setSubject(category + "-Unread Notification-Placement Management System-CRCE" );

                mimeMessageHelper.setText(message);

            }
        });
        
    }

}
