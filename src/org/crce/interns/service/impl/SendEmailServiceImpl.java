/*
* @author Leon
* Task: Sends Email To group values retrieved from Database 
* Dependency: SendEmailDAOImpl.java, javaMailSender, DirectoryPathBean.java
*/

package org.crce.interns.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.crce.interns.beans.DirectoryPathBean;
import org.crce.interns.dao.SendEmailDAO;
import org.crce.interns.service.ConstantValues;

import org.crce.interns.service.SendEmailService;
import org.crce.interns.validators.PersonalEmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Service("sendEmailServiceImpl")
public class SendEmailServiceImpl implements SendEmailService,ConstantValues {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private SendEmailDAO sendEmailDAO;
    
    DirectoryPathBean directoryPathBean = new DirectoryPathBean();
    
    /**
     * 
     * @param request
     * @param file
     * @return ModelAndView 
     */
    
    
    @Override
    public ModelAndView sendMail(HttpServletRequest request,
            @RequestParam(value = "fileUpload") CommonsMultipartFile[] file) {
        System.out.println(request.getParameter("message"));
        System.out.println(request.getParameter("subject"));
        System.out.println(request.getParameter("receiver"));
        DirectoryPathBean directoryPathBean = new DirectoryPathBean();
        String path = directoryPathBean.getEmailFolder()+"/";
        if (file.length > 0 && file != null) {
            System.out.println("Inside If");
            for (CommonsMultipartFile f : file) {
                if (!f.getOriginalFilename().equals("")) {
                    System.out.println(path + f.getOriginalFilename());
                    try {
                        f.transferTo(new File(path + f.getOriginalFilename()));
                    } catch (IllegalStateException | IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        //String compsClass = "leonsurajd69@gmail.com", itClass = "dsouza.nevil45@gmail.com", prodClass = "cuthinho.crystal95@gmail.com", elexClass = "melwyn95@gmail.com";
        //String allClass = compsClass + " " + itClass + " " + prodClass + " " + elexClass;

       // String [] keywordReceivers = request.getParameterValues("receiver");

        //String[] keywordReceiversSplit = keywordReceivers.split(" ");
        String[] keywordReceiversSplit = request.getParameterValues("receiver");
        List<String> list = new ArrayList<String>();
        List<String> loweredList = new ArrayList<String>();
        list.addAll(Arrays.asList(keywordReceiversSplit));
        System.out.println(list);
        list.stream().forEach((st) -> {
            loweredList.add(st.toLowerCase());
        });
        System.out.println(loweredList);

        //boolean t=loweredList.contains("itstpc");
        //System.out.println(t);
        loweredList.indexOf(",");
        //System.out.println(loweredList);
        if (loweredList.contains("compsstpc,")) {
            //System.out.println("compsstpc,");
            int pos = loweredList.indexOf("compsstpc,");
            //System.out.println(pos);
            String CompsSTPC = sendEmailDAO.fetchCompsSTPC();
            loweredList.remove("compsstpc,");
            loweredList.add(pos, CompsSTPC);
            //System.out.println(loweredList);
        } else if (loweredList.contains("compsstpc")) {
            // System.out.println("compsstpc");
            int pos = loweredList.indexOf("compsstpc");
            // System.out.println(pos);
            String CompsSTPC = sendEmailDAO.fetchCompsSTPC();
            loweredList.remove("compsstpc");
            loweredList.add(pos, CompsSTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("itstpc,")) {
            //System.out.println("itstpcstpc,");
            int pos = loweredList.indexOf("itstpc,");
            //System.out.println(pos);
            String ITSTPC = sendEmailDAO.fetchITSTPC();
            loweredList.remove("itstpc,");
            loweredList.add(pos, ITSTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("itstpc")) {
            // System.out.println("itstpc");
            int pos = loweredList.indexOf("itstpc");
            String ITSTPC = sendEmailDAO.fetchITSTPC();
            // System.out.println(pos);
            loweredList.remove("itstpc");
            loweredList.add(pos, ITSTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("prodstpc,")) {
            // System.out.println("prodstpc,");
            int pos = loweredList.indexOf("prodstpc,");
            // System.out.println(pos);
            String ProdSTPC = sendEmailDAO.fetchProdSTPC();
            loweredList.remove("prodstpc,");
            loweredList.add(pos, ProdSTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("prodstpc")) {
            // System.out.println("prodstpc");
            int pos = loweredList.indexOf("prodstpc");
            //System.out.println(pos);
            String ProdSTPC = sendEmailDAO.fetchProdSTPC();
            loweredList.remove("prodstpc");
            loweredList.add(pos, ProdSTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("elexstpc,")) {
            // System.out.println("elexstpc,");
            int pos = loweredList.indexOf("elexstpc,");
            // System.out.println(pos);
            String ElexSTPC = sendEmailDAO.fetchElexSTPC();
            loweredList.remove("elexstpc,");
            loweredList.add(pos, ElexSTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("elexstpc")) {
            // System.out.println("elexstpc");
            int pos = loweredList.indexOf("elexstpc");
            // System.out.println(pos);
            loweredList.remove("elexstpc");
            String ElexSTPC = sendEmailDAO.fetchElexSTPC();
            loweredList.add(pos, ElexSTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("compsftpc,")) {
            //  System.out.println("compsftpc,");
            int pos = loweredList.indexOf("compsftpc,");
            // System.out.println(pos);
            String CompsFTPC = sendEmailDAO.fetchCompsFTPC();
            loweredList.remove("compsftpc,");
            loweredList.add(pos, CompsFTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("compsftpc")) {
            // System.out.println("compsftpc");
            int pos = loweredList.indexOf("compsftpc");
            // System.out.println(pos);
            String CompsFTPC = sendEmailDAO.fetchCompsFTPC();
            loweredList.remove("compsftpc");
            loweredList.add(pos, CompsFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("prodftpc,")) {
            // System.out.println("prodftpc,");
            int pos = loweredList.indexOf("prodftpc,");
            // System.out.println(pos);
            loweredList.remove("prodftpc,");
            String ProdFTPC = sendEmailDAO.fetchProdFTPC();
            loweredList.add(pos, ProdFTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("prodftpc")) {
            // System.out.println("compsstpc");
            int pos = loweredList.indexOf("prodftpc");
            String ProdFTPC = sendEmailDAO.fetchProdFTPC();
            // System.out.println(pos);
            loweredList.remove("prodftpc");
            loweredList.add(pos, ProdFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("elexftpc,")) {
            // System.out.println("elexftpc,");
            int pos = loweredList.indexOf("elexftpc,");
            // System.out.println(pos);
            String ElexFTPC = sendEmailDAO.fetchElexFTPC();
            loweredList.remove("elexftpc,");
            loweredList.add(pos, ElexFTPC);

            // System.out.println(loweredList);
        } else if (loweredList.contains("elexftpc")) {
            // System.out.println("elexftpc");
            int pos = loweredList.indexOf("elexftpc");
            //  System.out.println(pos);
            loweredList.remove("elexftpc");
            String ElexFTPC = sendEmailDAO.fetchElexFTPC();
            loweredList.add(pos, ElexFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("itftpc,")) {
            //  System.out.println("itftpc,");
            int pos = loweredList.indexOf("itftpc,");
            //  System.out.println(pos);
            String ITFTPC = sendEmailDAO.fetchITFTPC();
            loweredList.remove("itftpc,");
            loweredList.add(pos, ITFTPC);
            // System.out.println(loweredList);
        } else if (loweredList.contains("itftpc")) {
            // System.out.println("itftpc");
            int pos = loweredList.indexOf("itftpc");
            // System.out.println(pos);
            String ITFTPC = sendEmailDAO.fetchITFTPC();
            loweredList.remove("itftpc");
            loweredList.add(pos, ITFTPC);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("stpc,")) {
            System.out.println("stpc,");
            int pos = loweredList.indexOf("stpc,");
            System.out.println(pos);
            loweredList.remove("stpc,");
            String allSTPC = sendEmailDAO.fetchCompsSTPC() + " " + sendEmailDAO.fetchElexSTPC() + " " + sendEmailDAO.fetchITSTPC() + " " + sendEmailDAO.fetchProdSTPC();
            loweredList.add(pos, allSTPC);
            System.out.println(loweredList);
        } else if (loweredList.contains("stpc")) {
            System.out.println("stpc");
            int pos = loweredList.indexOf("stpc");
            System.out.println(pos);
            loweredList.remove("stpc");
            String allSTPC = sendEmailDAO.fetchCompsSTPC() + " " + sendEmailDAO.fetchElexSTPC() + " " + sendEmailDAO.fetchITSTPC() + " " + sendEmailDAO.fetchProdSTPC();
            loweredList.add(pos, allSTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("ftpc,")) {
            System.out.println("ftpc,");
            int pos = loweredList.indexOf("ftpc,");
            System.out.println(pos);
            loweredList.remove("ftpc,");
            String allFTPC = sendEmailDAO.fetchCompsFTPC() + " " + sendEmailDAO.fetchElexFTPC() + " " + sendEmailDAO.fetchITFTPC() + " " + sendEmailDAO.fetchProdFTPC();
            loweredList.add(pos, allFTPC);
            System.out.println(loweredList);
        } else if (loweredList.contains("ftpc")) {
            System.out.println("ftpc");
            int pos = loweredList.indexOf("ftpc");
            System.out.println(pos);
            loweredList.remove("ftpc");
            String allFTPC = sendEmailDAO.fetchCompsFTPC() + " " + sendEmailDAO.fetchElexFTPC() + " " + sendEmailDAO.fetchITFTPC() + " " + sendEmailDAO.fetchProdFTPC();
            loweredList.add(pos, allFTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("tpc,")) {
            System.out.println("tpc,");
            int pos = loweredList.indexOf("tpc,");
            System.out.println(pos);
            loweredList.remove("tpc,");
            //loweredList.add(pos, allTPC);
            String allTPC = sendEmailDAO.fetchCompsSTPC() + " " + sendEmailDAO.fetchElexSTPC() + " " + sendEmailDAO.fetchITSTPC() + " " + sendEmailDAO.fetchProdSTPC() + " " + sendEmailDAO.fetchCompsFTPC() + " " + sendEmailDAO.fetchElexFTPC() + " " + sendEmailDAO.fetchITFTPC() + " " + sendEmailDAO.fetchProdFTPC();
            loweredList.add(pos, allTPC);
            System.out.println(loweredList);
        } else if (loweredList.contains("tpc")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("tpc");
            System.out.println(pos);
            loweredList.remove("tpc");
            String allTPC = sendEmailDAO.fetchCompsSTPC() + " " + sendEmailDAO.fetchElexSTPC() + " " + sendEmailDAO.fetchITSTPC() + " " + sendEmailDAO.fetchProdSTPC() + " " + sendEmailDAO.fetchCompsFTPC() + " " + sendEmailDAO.fetchElexFTPC() + " " + sendEmailDAO.fetchITFTPC() + " " + sendEmailDAO.fetchProdFTPC();
            loweredList.add(pos, allTPC);
            System.out.println(loweredList);
        }
        if (loweredList.contains("prodclass,")) {
            // System.out.println("tpc,");
            int pos = loweredList.indexOf("prodclass,");
            
            loweredList.remove("prodclass,");
            String prodClass = sendEmailDAO.fetchStreamStudents(PROD);
            loweredList.add(pos, prodClass);
            // System.out.println(loweredList);
        } else if (loweredList.contains("prodclass")) {
            // System.out.println("tpc");
            int pos = loweredList.indexOf("prodclass");
            //System.out.println(pos);
            loweredList.remove("prodclass");
            String prodClass = sendEmailDAO.fetchStreamStudents(PROD);
            loweredList.add(pos, prodClass);
            // System.out.println(loweredList);
        }
        if (loweredList.contains("itclass,")) {
            System.out.println("tpc,");
            int pos = loweredList.indexOf("itclass,");
            System.out.println(pos);
            loweredList.remove("itclass,");
            String itClass = sendEmailDAO.fetchStreamStudents(IT);
            loweredList.add(pos, itClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("itclass")) {
            //System.out.println("tpc");
            int pos = loweredList.indexOf("itclass");
            System.out.println(pos);
            loweredList.remove("itclass");
            String itClass = sendEmailDAO.fetchStreamStudents(IT);
            loweredList.add(pos, itClass);
            System.out.println(loweredList);
        }
        if (loweredList.contains("compsclass,")) {
            System.out.println("tpc,");
            int pos = loweredList.indexOf("compsclass,");
            System.out.println(pos);
            loweredList.remove("compsclass,");
            String compsClass = sendEmailDAO.fetchStreamStudents(COMPS);
            loweredList.add(pos, compsClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("compsclass")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("compsclass");
            System.out.println(pos);
            loweredList.remove("compsclass");
            String compsClass = sendEmailDAO.fetchStreamStudents(COMPS);
            loweredList.add(pos, compsClass);
            System.out.println(loweredList);
        }
        if (loweredList.contains("elexclass,")) {
            System.out.println("elexclass,");
            int pos = loweredList.indexOf("elexclass,");
            System.out.println(pos);
            loweredList.remove("elexclass,");
            String elexClass = sendEmailDAO.fetchStreamStudents(ELEX);
            loweredList.add(pos, elexClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("elexclass")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("elexclass");
            System.out.println(pos);
            loweredList.remove("elexclass");
            String elexClass = sendEmailDAO.fetchStreamStudents(ELEX);
            loweredList.add(pos, elexClass);
            System.out.println(loweredList);
        }
        if (loweredList.contains("allclasses,")) {
            System.out.println("allclasses,");
            int pos = loweredList.indexOf("allclasses,");
            System.out.println(pos);
            loweredList.remove("allclasses,");
            String allClass = sendEmailDAO.fetchStreamStudents(ELEX) + " " + sendEmailDAO.fetchStreamStudents(COMPS) + " " + sendEmailDAO.fetchStreamStudents(PROD) + " " + sendEmailDAO.fetchStreamStudents(IT);
            loweredList.add(pos, allClass);
            System.out.println(loweredList);
        } else if (loweredList.contains("allclasses")) {
            System.out.println("tpc");
            int pos = loweredList.indexOf("allclasses");
            System.out.println(pos);
            loweredList.remove("allclasses");
            String allClass = sendEmailDAO.fetchStreamStudents(ELEX) + " " + sendEmailDAO.fetchStreamStudents(COMPS) + " " + sendEmailDAO.fetchStreamStudents(PROD) + " " + sendEmailDAO.fetchStreamStudents(IT);
            loweredList.add(pos, allClass);
            System.out.println(loweredList);
        }
            PersonalEmailValidator personalEmailValidator = new PersonalEmailValidator();
            List copyList = loweredList;
            Iterator iter = copyList.iterator();
            try{
            copyList.stream().map((o) -> {
                System.out.println(o.toString());
            return o;
        }).filter((o) -> (!personalEmailValidator.validateEmail(o.toString().replace("[","").replace("]", "")))).map((o) -> {
            System.out.println("Entered in for "+ o.toString());
            return o;
        }).map((o) -> {
            int pos = loweredList.indexOf(o.toString());
            System.out.println(pos);
            String companyStudents = sendEmailDAO.fetchCompanyStudents(o.toString());
            System.out.println("fetched DAO");
            loweredList.remove(o.toString());
            System.out.println("removed ");
            loweredList.add(pos, companyStudents);
            return o;
        }).forEach((_item) -> {
            System.out.println("LoweredList");
            System.out.println(loweredList);
        });//   
            }
            finally{
//                  while(iter.hasNext()){
//                    System.out.println(iter.next().toString());
//                    if(!personalEmailValidator.validateEmail(iter.next().toString().replace("[","").replace("]",""))){
//                        System.out.println("Entered in for " + iter.next().toString());
//                        int pos = loweredList.indexOf(iter.next().toString());
//                    System.out.println(pos);
//                    loweredList.remove(iter.next().toString());
//                    System.out.println("removed ");
//                    String companyStudents = sendEmailDAO.fetchCompanyStudents(iter.next().toString());
//                    System.out.println("fetched DAO");
//                    loweredList.add(pos, companyStudents);
//                    System.out.println(loweredList);
//                    }
//                }
        
//        if (keywordReceivers.equalsIgnoreCase("CompsSTPC")) {
//            input = CompsFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ProdSTPC")) {
//            input = ProdSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ElexSTPC")) {
//            input = ElexSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ITSTPC")) {
//            input = ITSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ITFTPC")) {
//            input = ITFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("CompsFTPC")) {
//            input = CompsFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ProdFTPC")) {
//            input = ProdFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("ElexFTPC")) {
//            input = ElexFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("STPC")) {
//            input = allSTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("FTPC")) {
//            input = allFTPC;
//        } else if (keywordReceivers.equalsIgnoreCase("TPC")) {
//            input = allTPC;
//        }

        String input[] = new String[loweredList.size()];
        // System.out.println("input array");
        input = loweredList.toArray(input);
        String finalList = Arrays.toString(input).replace("[", "").replace("]", "");
        finalList = finalList.replace(",", " ");
        System.out.println("Final List");
        System.out.println(finalList);
        String stream = Arrays.toString(input);
        System.out.println("Stream");
        System.out.println(stream);

        String[] emailIds = finalList.split("\\s+");

        javaMailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage)
                    throws javax.mail.MessagingException, IllegalStateException, IOException {
                System.out.println("Throws Exception");
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                //mimeMessageHelper.setTo(request.getParameter("receiver"));
                mimeMessageHelper.setTo(emailIds);

                mimeMessageHelper.setSubject(request.getParameter("subject"));

                mimeMessageHelper.setText(request.getParameter("message"));

                for (CommonsMultipartFile f : file) {
                    if (checkFile(f.getOriginalFilename())) {
                        mimeMessageHelper.addAttachment(f.getOriginalFilename(), new File(path + f.getOriginalFilename()));
                    }
                }
            }
        });

        deleteFiles();
        return new ModelAndView("Email");
            }
    }

    /*
     Return Type: Boolean-True/False
     Function: Checks for Files
     */
    /**
     * 
     * @param name
     * @return boolean
     */
    
    @Override
    public boolean checkFile(String name) {
        String path = directoryPathBean.getEmailFolder()+"/";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println(listOfFiles[i].getName());
            if (listOfFiles[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /*
     Return Type: Void
     Function: Deletes the copy of the file made for uploading in Email_Temp directory
     */
    
    
    @Override
    public void deleteFiles() {
        String path = directoryPathBean.getEmailFolder()+"/";
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File f : files) {
            f.delete();
        }
    }
    
    /**
     * 
     * @param request
     * @param file
     * @return ModelAndView
     */
    
    @Override
    public ModelAndView sendPersonalMail(HttpServletRequest request,
            @RequestParam(value = "fileUpload") CommonsMultipartFile[] file){
        //DirectoryPathBean directoryPathBean = new DirectoryPathBean();
        String path = directoryPathBean.getEmailFolder()+"\\";
        String [] emailIds = request.getParameter("receiver").split(" ");
        
        javaMailSender.send(new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage)
                    throws javax.mail.MessagingException, IllegalStateException, IOException {
                System.out.println("Throws Exception");
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

                //mimeMessageHelper.setTo(request.getParameter("receiver"));
                mimeMessageHelper.setTo(emailIds);

                mimeMessageHelper.setSubject(request.getParameter("subject"));

                mimeMessageHelper.setText(request.getParameter("message"));

                for (CommonsMultipartFile f : file) {
                    if (checkFile(f.getOriginalFilename())) {
                        mimeMessageHelper.addAttachment(f.getOriginalFilename(), new File(path + f.getOriginalFilename()));
                    }
                }
            }
        });
        return new ModelAndView("EmailForm");
    }
    
}
