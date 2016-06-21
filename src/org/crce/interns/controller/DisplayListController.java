/**
 * Filename: DisplayListController.java	
 * Classes used by code: DisplayListService
* 
* Description: This controller is used to display a list of files inside a directory structure for student
* 
* Functions: displayCV(), displayCVpage()

 */

package org.crce.interns.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.crce.interns.service.impl.DisplayListService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

@Controller
public class DisplayListController {

	DisplayListService dsp = new DisplayListService();
	// this method is for displaying the list of cv
        
        private static final Logger logger = Logger.getLogger(DisplayListController.class.getName());
        
	/**
	 * method simply directs to listCV.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/displist")
	public ModelAndView displayCVpage() {
		return new ModelAndView("listCV");
	}

	@RequestMapping(value = "/disptemppage")
	public ModelAndView displaypage() {
		return new ModelAndView("Folders");
	}

	/**
	 * this method display a list of folders
	 * 
	 * @param request
	 * @param userId
	 * @return
	 */

	/*@RequestMapping(value = "/dispAllfolder")
	public ModelAndView displayfolder(HttpServletRequest request, @RequestParam(value = "userId") String userId) {
		try {
			request.getSession().setAttribute("userId", userId);
			List<String> list = dsp.displayFolderlist(userId);
			ModelAndView model = new ModelAndView("Folders");
			model.addObject("list", list);

			return model;
		} catch (Exception e) {
			return new ModelAndView("500");
		}
	}
*/

	/**
	 * this method displays list of files within a particular folder in
	 * ascending order
	 * 
	 * @param request
	 * @param folder
	 * @return
	 */

	/*@RequestMapping(value = "/dispCV--")
	public ModelAndView displayCV(HttpServletRequest request, @RequestParam(value = "folder") String folder) {
		try {
			String userName = (String) request.getSession().getAttribute("userName");
			String userRole = (String) request.getSession(true).getAttribute("roleName");
			List<String> listFullName = dsp.displayCVList(folder, userName, userRole);
			List<String> list = new ArrayList<String>();
			ModelAndView model = new ModelAndView("listCV");

			int z = 0;
			List<Integer> indexList = new ArrayList<>();
			if (listFullName.isEmpty())
				return model;
			for (String x : listFullName) {
				int pos = x.indexOf('-');
				list.add(x.substring(0, pos));
				indexList.add(z);
				z++;
			}

			request.getSession().setAttribute("folderName", folder);

			model.addObject("actualFileNames", listFullName);
			model.addObject("nameToDisplay", list);
			model.addObject("indexList", indexList);

			return model;
		} catch (Exception e) {
			return new ModelAndView("500");
		}

	}


	/**
	 * this method display the files to ftpc, tpo
	 * 
	 * @param request
	 * @param folder
	 * @return
	 */

	/*@RequestMapping(value = "/dispCounselingReport")
	public ModelAndView displayCounselReport(HttpServletRequest request,
			@RequestParam(value = "folder") String folder) {
		try {
			String userName = (String) request.getSession().getAttribute("userName");
			String userRole = (String) request.getSession(true).getAttribute("roleName");
			List<String> listFullName = dsp.displayCVList(folder, userName, userRole);
			List<String> list = new ArrayList<String>();

			int z = 0;
			List<Integer> indexList = new ArrayList<>();
			System.out.println(listFullName);
			for (String x : listFullName) {
				list.add(x);
				indexList.add(z);
				z++;
			}

			request.getSession().setAttribute("folderName", folder);
			ModelAndView model = new ModelAndView("facultyDownloads");

			model.addObject("actualFileNames", listFullName);
			model.addObject("nameToDisplay", list);
			model.addObject("indexList", indexList);


			return model;
		} catch (Exception e) {
			return new ModelAndView("500");
		}
	}*/

	
	/**
	 * this method displays the files within a selected student's folder to ftpc
	 * 
	 * @param request
	 * @param folder
	 * @return
	 */
	/*@RequestMapping(value = "/displistoffiles")
	public ModelAndView displayFilesToftpc(HttpServletRequest request, @RequestParam(value = "folder") String folder) {

		try {
			String userId = (String) request.getSession().getAttribute("userId");
			String userRole = "allowed";
			List<String> listFullName = dsp.displayCVList(folder, userId, userRole);
			List<String> list = new ArrayList<String>();
			ModelAndView model = new ModelAndView("dispfiles");

			int z = 0;
			List<Integer> indexList = new ArrayList<>();
			if (listFullName.isEmpty())
				return model;
			for (String x : listFullName) {
				int pos = x.indexOf('-');
				list.add(x.substring(0, pos));
				indexList.add(z);
				z++;
			}

			request.getSession().setAttribute("folderName", folder);
			model.addObject("actualFileNames", listFullName);
			model.addObject("nameToDisplay", list);
			model.addObject("indexList", indexList);


			return model;
		} catch (Exception e) {
			return new ModelAndView("500");
		}


		
	}*/

	//------------------------------------------------------------------------------------------------------------
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Modified by Pankaj & Melwyn
	@RequestMapping(value = "/dispCV")
	public @ResponseBody String d(HttpServletRequest request, @RequestParam(value = "folder") String folder) {
		String userName = (String) request.getSession().getAttribute("userName");
		String userRole = (String) request.getSession(true).getAttribute("roleName");
		List<String> listFullName = dsp.displayCVList(folder, userName,userRole);
		List<String> list = new ArrayList<String>();
		int z = 0;
		List<Integer> indexList = new ArrayList<>();
		if(listFullName.isEmpty())
			return "[]";
		for (String x : listFullName) {
			int pos = x.indexOf('-');
			list.add(x.substring(0, pos));
			indexList.add(z);
			z++;
		}
		request.getSession().setAttribute("folderName", folder);
		JsonArray jarray = new JsonArray();
		for (int i=0;i<z;i++) {
			JsonObject jobj = new JsonObject();
			jobj.addProperty("actualName", listFullName.get(i));
			jobj.addProperty("displayName", list.get(i));
			System.out.println("displayName : " + list.get(i));
			jarray.add(jobj);
		}
		//System.out.println(jarray.toString());
                logger.error(jarray.toString());
		return jarray.toString();


	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	/// Pankaj Modified below
	
	/**
	 * this method display the files to ftpc, tpo
	 * @param request
	 * @param folder
	 * @return 
	 * @return
	 */
	@RequestMapping(value = "/dispCounselingReport")
	public @ResponseBody String displayCounselingReport(HttpServletRequest request, @RequestParam(value = "folder") String folder) {
		String userName = (String) request.getSession().getAttribute("userName");
		String userRole = (String) request.getSession(true).getAttribute("roleName");
		List<String> listFullName = dsp.displayCVList(folder, userName,userRole);
		List<String> list = new ArrayList<String>();


		int z = 0;
		List<Integer> indexList = new ArrayList<>();
		System.out.println(listFullName);
		for (String x : listFullName) {
			list.add(x);
			indexList.add(z);
			z++;
		}
		//System.out.println("checking..");
                logger.error("checking..");
		request.getSession().setAttribute("folderName", folder);
		
		JsonArray jarray = new JsonArray();
		for(int i=0;i<z;i++){
			
			JsonObject jobj=new JsonObject();
			jobj.addProperty("actualFileNames", listFullName.get(i));
			jobj.addProperty("nameToDisplay", list.get(i));
			jarray.add(jobj);
		}
		
		/*ModelAndView model = new ModelAndView("facultyDownloads");*/

		/*model.addObject("actualFileNames", listFullName);
		model.addObject("nameToDisplay", list);
		model.addObject("indexList", indexList);

		return model;*/
		//System.out.println("checking..");
                logger.error("checking..");
		return jarray.toString();
		
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/// Modified by Pankaj ...
	
	@RequestMapping(value = "/dispAllfolder")
	public @ResponseBody  String displayfolder(HttpServletRequest request,@RequestParam(value = "userId") String userId) {
		request.getSession().setAttribute("userId", userId);
		List<String> list = dsp.displayFolderlist(userId);
		
		/*ModelAndView model = new ModelAndView("Folders");
		model.addObject("list", list);*/

		JsonArray jarray= new JsonArray();
		for(int i=0;i<list.size();i++){
			
			JsonObject jobj =new JsonObject();
			jobj.addProperty("list", list.get(i));
			jarray.add(jobj);
			
		}
		//System.out.println("list: "+ list.size());
		logger.error("list: "+ list.size());
		//System.out.println("checking folders..");
                
                logger.error("checking folders..");
		return jarray.toString();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	///// Pankaj Modified following for displaying files in the folders..
	
	@RequestMapping(value = "/displistoffiles")
	public @ResponseBody String displayFilesToftpc(HttpServletRequest request, @RequestParam(value = "folder") String folder) {
		String userId = (String) request.getSession().getAttribute("userId");
		String userRole = "allowed";
		List<String> listFullName = dsp.displayCVList(folder, userId,userRole);
		List<String> list = new ArrayList<String>();
		//ModelAndView model = new ModelAndView("dispfiles");

		//System.out.println("inside files... ");
		logger.error("inside files... ");
		int z = 0;
		List<Integer> indexList = new ArrayList<>();
		if(listFullName.isEmpty())
			return "[]";
		for (String x : listFullName) {
			int pos = x.indexOf('-');
			list.add(x.substring(0, pos));
			indexList.add(z);
			z++;
		}

		request.getSession().setAttribute("folderName", folder);
		
		JsonArray jarry= new JsonArray();
		for(int i=0;i<z;i++){
			
			JsonObject jobj= new JsonObject();
			jobj.addProperty("actualFileNames", listFullName.get(i));
			jobj.addProperty("nameToDisplay", list.get(i));
			
			jarry.add(jobj);
		}
		
		
		/*model.addObject("actualFileNames", listFullName);
		model.addObject("nameToDisplay", list);
		model.addObject("indexList", indexList);*/
		
		//System.out.println("files: " + listFullName);
                logger.error("files: " + listFullName);
		//System.out.println("files: " + list);
                logger.error("files: " + list);

		//return mode;
		return jarry.toString();
	}
	

}
