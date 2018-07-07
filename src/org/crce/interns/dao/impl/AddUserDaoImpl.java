/*
*
*
* Author Name: Crystal Cuthinho	
* 
* Filename: AddUserDaoImpl.java	
* 	
* Classes used by code:  AddUserDao,DirectoryPathBean
* 
* Tabes used: Loader_schema.loader (temporary table),User_schema.userdetails,User_schema.personal_profile,User_schema.professional_profile,User_schema.qualification
* 
* Description: This dao implementation is used to implement the methods in AddUserDao.java.
* 				It uses JDBC connection.
* 
* Functions: loadCopyFile()	
*
*/


package org.crce.interns.dao.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.crce.interns.beans.DirectoryPathBean;
import org.crce.interns.beans.UserDetailsBean;
import org.crce.interns.dao.AddUserDao;
import org.crce.interns.exception.IncorrectEncodingTypeException;
import org.crce.interns.service.ProfileService;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository("addUserDao")
public class AddUserDaoImpl implements AddUserDao {
	
	
	public void loadCopyFile(String tableName,String timeStamp,String userName, String fileName) throws SQLException, IOException, ParseException, IncorrectEncodingTypeException {
		
		IncorrectEncodingTypeException x = new IncorrectEncodingTypeException();
		CopyManager copyManager;
		InputStream inStream = null;
		File copyFile;
		int encoding;
			
		Date dNow = new Date( );
		SimpleDateFormat ft = 
			      new SimpleDateFormat ("yyyy-MM-dd");
		String temp = ft.format(dNow);
		//Date parsed = ft.parse(temp);
		System.out.println(temp);
		 
		 //java.sql.Date sql = new java.sql.Date(parsed.getTime());
        
		
		
		String year =  Integer.toString(Calendar.getInstance().get(Calendar.YEAR)+1);
		Connection c = null;
		
		try {
			
			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/placementdb", "postgres", "root");

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		
		System.out.println("Opened database successfully");

		//to get path where the csv file is stored
        DirectoryPathBean directoryPathBean = new DirectoryPathBean();
        copyFile = new File(directoryPathBean.getCsvFolder() + "/"  + timeStamp + "/" + fileName);
		//copyFile = new File(directoryPathBean.getCsvFolder() + "\\"  + timeStamp + "\\" + fileName);	//for windows

		// tableName = "loader_schema.loader";
	
		InputStream bufferedInStream;

		inStream = new FileInputStream(copyFile);
		bufferedInStream = new BufferedInputStream(inStream, 65536);

		copyManager = new CopyManager((BaseConnection) c);

		try{
		//copies contents of csv file into loader_schema.loader table
		copyManager.copyIn("COPY " + tableName + " FROM STDIN DELIMITER ',' CSV", bufferedInStream);

		}
		catch(org.postgresql.util.PSQLException e){
			throw x;
			
		}
		Statement st = c.createStatement();
		Statement st1 = c.createStatement();
		//ResultSet rs = st.executeQuery("SELECT * FROM users");
		System.out.println(year);
		
		
		
		
		try{
		//deletes unnecessary row
		st1.executeUpdate("delete from loader_schema.loader where name='Name'");
		//inserts appropriate data from loader table
		st1.executeUpdate("insert into user_schema.userdetails(username) select roll_no from loader_schema.loader");	
		st1.executeUpdate("update user_schema.userdetails set created_date='"+ temp +"' where created_date is NULL");
		st1.executeUpdate("update user_schema.userdetails set created_by='"+ userName +"' where created_by is NULL");
		st1.executeUpdate("update user_schema.userdetails set role_id='1' where role_id is NULL");
		
		st1.executeUpdate("insert into user_schema.personal_profile(username,name,gender,dob,mobile_no,email_id) select roll_no,name,gender,dob,mobile,email from loader_schema.loader");
		st1.executeUpdate("update user_schema.personal_profile set created_date='"+ temp +"' where created_date is NULL");
		st1.executeUpdate("update user_schema.personal_profile set created_by='"+ userName +"' where created_by is NULL");
		
		st1.executeUpdate("insert into user_schema.professional_profile(username,branch) select roll_no,branch from loader_schema.loader");
		st1.executeUpdate("update user_schema.professional_profile set year='" + year +"' where year is NULL");
		st1.executeUpdate("update user_schema.professional_profile set created_date='"+ temp +"' where created_date is NULL");
		st1.executeUpdate("update user_schema.professional_profile set created_by='"+ userName +"' where created_by is NULL");
		
		st1.executeUpdate("insert into user_schema.qualification(username,ssc_per,hsc_or_dip,hsc_or_dip_per,s1_mark,s1_max,s1_per,s1_res,s1_kt,s2_mark,s2_max,s2_per,s2_res,s2_kt,s3_mark,s3_max,s3_per,s3_res,s3_kt,s4_mark,s4_max,s4_per,s4_res,s4_kt,s5_mark,s5_max,s5_per,s5_res,s5_kt,s6_mark,s6_max,s6_per,s6_res,s6_kt,s7_mark,s7_max,s7_per,s7_res,s7_kt,s8_mark,s8_max,s8_per,s8_res,s8_kt,deg_per,deg_kt,drops) select roll_no,ssc_per,hsc_or_dip,hsc_or_dip_per,s1_mark,s1_max,s1_per,s1_res,s1_kt,s2_mark,s2_max,s2_per,s2_res,s2_kt,s3_mark,s3_max,s3_per,s3_res,s3_kt,s4_mark,s4_max,s4_per,s4_res,s4_kt,s5_mark,s5_max,s5_per,s5_res,s5_kt,s6_mark,s6_max,s6_per,s6_res,s6_kt,s7_mark,s7_max,s7_per,s7_res,s7_kt,s8_mark,s8_max,s8_per,s8_res,s8_kt,deg_per,deg_kt,drops from loader_schema.loader");
		st1.executeUpdate("update user_schema.qualification set created_date='"+ temp +"' where created_date is NULL");
		st1.executeUpdate("update user_schema.qualification set created_by='"+ userName +"' where created_by is NULL");
		}
		catch (org.postgresql.util.PSQLException e) {
			
			System.out.println(e.toString());
			//st1.executeUpdate("update user_schema.qualification set s6_res= s6_res in (select s6_res from loader_schema.loader)");
			st1.executeUpdate("update user_schema.qualification set s6_res = (select s6_res from loader_schema.loader where user_schema.qualification.username = loader_schema.loader.roll_no)");
			
		}
		
		//truncates the temporary loader table
		st1.executeUpdate("delete from loader_schema.loader");
		
		
		st.close();
		st1.close();
		inStream.close();
		inStream = null;

		
	}
}
