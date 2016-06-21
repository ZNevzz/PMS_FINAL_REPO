/**
 * Author Name: Andrea Furtado
 * Filename: DisplayListService.java	
* 
* Description: This service is used to return a list of files sorted according to date of creation
* 
* Functions: displayCVList()

 */

package org.crce.interns.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.crce.interns.beans.DirectoryPathBean;
import org.crce.interns.service.ConstantValues;

public class DisplayListService {

	
	/**
	 * method returns a sorted list of files belonging to the folder
	 * @param folder
	 * @param userName
	 * @return
	 */
		public List<String> displayCVList(String folder,String userName,String userRole){
			DirectoryPathBean dpb=new DirectoryPathBean();
			 List<String> results = new ArrayList<String>();
			 String pathname = null;
			 System.out.println("Role : " + userRole);
			if(userRole.equals(ConstantValues.StudentName) || userRole.equals("allowed") || userRole.equals(ConstantValues.StudentTPCName))
				pathname=dpb.getStudentFolder()+"/"+userName+"/"+folder;
			else
				pathname=dpb.getSystemFolder()+"/"+folder;
			 System.out.println(pathname);
			 File[] files= new File(pathname).listFiles();
			 
			 //logic for sorting the files w.r.t to date of creation
			 if(files!= null)
			 {Arrays.sort( files, new Comparator<Object>()
		        {
		        public int compare(Object o1, Object o2) {
		        return -1 *new Long(((File)o1).lastModified()).compareTo(new Long(((File) o2).lastModified()));
		        }

		        });
			 
			 //getting the file names
			 for (File file : files) 
				  results.add(file.getName());
			 }
			         return results;
		}
		
		
		/**
		 * this method displays the folders within a folder
		 * @param id
		 * @return
		 */
		public List<String > displayFolderlist(String id){
			DirectoryPathBean dpb=new DirectoryPathBean();
			 List<String> results = new ArrayList<String>();
			 String path=dpb.getStudentFolder()+"/" +id;
			 File[] files= new File(path).listFiles();
			 System.out.println(path);
			 for (File file : files)
				 if(file.isDirectory())
				   results.add(file.getName());
				  
			 return results;
			
		}
		
		
		
}
