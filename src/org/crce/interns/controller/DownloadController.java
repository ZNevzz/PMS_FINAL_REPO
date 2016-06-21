package org.crce.interns.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import org.crce.interns.beans.DirectoryPathBean;
import org.crce.interns.service.CheckRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
*commented - melwyn95
*This class has 3 methods
*1>downloadResume
*2>viewFiles
*3>getRole
*/
@Controller
public class DownloadController extends HttpServlet {

	@Autowired
	private CheckRoleService crService;
	/*
	 * The base path would be the root directory of all the folders the year
	 * field will be added soon so final basePath would look like PMS/year
	 */
	DirectoryPathBean dpb = new DirectoryPathBean();
	private String basePath = dpb.getRootContext();

	private static final int BUFFER_SIZE = 4096;
        
        private static final Logger logger = Logger.getLogger(DownloadController.class.getName());

	/*
	 * This method constructs the path of the file the user wants to download
	 * download path = basePath/role/userName and downloads the file the code is
	 * pretty much standard not much of modification done to standard code
	 * availabe online
	 */
	@RequestMapping("/downloadResume")

	public void downloadResume(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") String fileName) {
		try {
			String userName = (String) request.getSession().getAttribute("userName");
			String role = getRole((String) request.getSession().getAttribute("roleId"));
			String folderName = (String) request.getSession().getAttribute("folderName");

			String fileToBeDownloaded = basePath + "/Users" + "/" + role + "/" + userName + "/" + folderName + "/"
					+ fileName;
			//System.out.println(fileToBeDownloaded);
                        logger.error(fileToBeDownloaded);
			ServletContext context = request.getServletContext();

			File downloadFile = new File(fileToBeDownloaded);
			FileInputStream inputStream = null;
			try {
				inputStream = new FileInputStream(downloadFile);
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
                                logger.error(e);
			}
			String mimeType = context.getMimeType(fileToBeDownloaded);
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}

			String downloadFileName = downloadFile.getName();

			String ext = downloadFileName.substring(downloadFileName.lastIndexOf("."));

			response.setContentType(mimeType);
			response.setContentLength((int) downloadFile.length());
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",
					downloadFileName.substring(0, downloadFileName.indexOf('-')) + ext);
			response.setHeader(headerKey, headerValue);

			OutputStream outStream = null;
			try {
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				outStream = response.getOutputStream();
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outStream.write(buffer, 0, bytesRead);
				}

				inputStream.close();
				outStream.close();
			} catch (IOException e) {
				//e.printStackTrace();
                                logger.error(e);
			}
		} catch (Exception e) {
			//System.out.println();
                        logger.error(e);
		}
	}

	/*
	 * This method lists all the files in the folder selected by the user and
	 * puts them is a list and sends the list to be displayed on the UI
	 */
	@RequestMapping("/viewResumes")
	public ModelAndView viewFiles(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userName = (String) request.getSession().getAttribute("userName");
			String role = getRole((String) request.getSession().getAttribute("roleId"));
			String roleId = (String) request.getSession().getAttribute("roleId");
			if (!crService.checkRole("Download", roleId))
				return new ModelAndView("403");
			else {
				String directoryPath = basePath + "/" + role + "/" + userName;
				File directory = new File(directoryPath);
				File[] listOfFiles = directory.listFiles();

				//System.out.println(directoryPath);
                                logger.error(directoryPath);

				List<String> fileList = new ArrayList<String>();
				for (File file : listOfFiles) {
					if (file.isFile()) {
						System.out.println("FILE : " + file.getName());
						fileList.add(file.getName());
					} else
						System.out.println("DIRECTORY : " + file.getName());
				}
				Map<String, Object> modelMap = new HashMap<String, Object>();
				modelMap.put("fileList", fileList);
				return new ModelAndView("viewResumes", modelMap);
			}
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500");
		}
	}

	/*
	 * This method converts roleId into roleName This is used while accessing
	 * directory both while viewing and downloading
	 */
	public String getRole(String role) {
		if (role.equals("1"))
			return "Student";
		else if (role.equals("2"))
			return "Faculty";
		else if (role.equals("3"))
			return "StudentTPC";
		else if (role.equals("4"))
			return "FacultyTPC";
		else if (role.equals("5"))
			return "TPO";
		else if (role.equals("6"))
			return "Admin";
		return null;
	}

	@RequestMapping("/viewCSV")
	public ModelAndView viewCV(HttpServletRequest request, HttpServletResponse response) {
		try {
			String directoryPath = basePath + "/System/CSV";
			File directory = new File(directoryPath);
			File[] listOfFiles = directory.listFiles();

			System.out.println(directoryPath);
			System.out.println(listOfFiles);

			List<String> fileList = new ArrayList<String>();
			if (listOfFiles != null) {
				for (File file : listOfFiles) {
					if (file.isFile()) {
						//System.out.println("FILE : " + file.getName());
                                                logger.error("FILE : " + file.getName());
						fileList.add(file.getName());
					} else
						//System.out.println("DIRECTORY : " + file.getName());
                                                logger.error("DIRECTORY : " + file.getName());
				}
			}
			Map<String, Object> modelMap = new HashMap<String, Object>();
			modelMap.put("fileList", fileList);
			return new ModelAndView("viewCSV", modelMap);
		} catch (Exception e) {
                        logger.error(e);
			return new ModelAndView("500s");
		}
	}

	@RequestMapping("/downloadCSV")
	public void downloadCSV(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") String fileName) {
		String fileToBeDownloaded = basePath + "/System/CSV" + "/" + fileName;

		//System.out.println(fileToBeDownloaded);
                logger.error(fileToBeDownloaded);
                
		ServletContext context = request.getServletContext();

		File downloadFile = new File(fileToBeDownloaded);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
                        logger.error(e);
		}
		String mimeType = context.getMimeType(fileToBeDownloaded);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		String downloadFileName = downloadFile.getName();

		String ext = downloadFileName.substring(downloadFileName.lastIndexOf("."));

		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFileName.substring(0, downloadFileName.indexOf('-')) + ext);
		response.setHeader(headerKey, headerValue);

		OutputStream outStream = null;
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			outStream = response.getOutputStream();
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outStream.close();
		} catch (IOException e) {
			//e.printStackTrace();
                        logger.error(e);
		}
	}

	@RequestMapping("/downloadCounsellingReport")
	public void downloadCounsellingReport(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") String fileName) {
		String folderName = (String) request.getSession().getAttribute("folderName");
		String fileToBeDownloaded = basePath + "/System/" + folderName + "/" + fileName;
		//System.out.println(fileToBeDownloaded);
                logger.error(fileToBeDownloaded);

		ServletContext context = request.getServletContext();

		File downloadFile = new File(fileToBeDownloaded);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
                        logger.error(e);
		}
		String mimeType = context.getMimeType(fileToBeDownloaded);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		String downloadFileName = downloadFile.getName();

		String ext = downloadFileName.substring(downloadFileName.lastIndexOf("."));

		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFileName.substring(0, downloadFileName.indexOf('-')) + ext);
		response.setHeader(headerKey, headerValue);

		OutputStream outStream = null;
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			outStream = response.getOutputStream();
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outStream.close();
		} catch (IOException e) {
			//e.printStackTrace();
                        logger.error(e);
		}
	}

	@RequestMapping("/downloadOfferLetter")
	public void downloadOfferLetter(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") String fileName) {
		String userId = (String) request.getSession().getAttribute("userId");
		String fileToBeDownloaded = basePath + "/Users/Student/" + userId + "/Offer Letters/" + fileName;
		System.out.println(fileToBeDownloaded);

		ServletContext context = request.getServletContext();

		File downloadFile = new File(fileToBeDownloaded);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(downloadFile);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
                        logger.error(e);
		}
		String mimeType = context.getMimeType(fileToBeDownloaded);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		String downloadFileName = downloadFile.getName();

		String ext = downloadFileName.substring(downloadFileName.lastIndexOf("."));

		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFileName.substring(0, downloadFileName.indexOf('-')) + ext);
		response.setHeader(headerKey, headerValue);

		OutputStream outStream = null;
		try {
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead = -1;
			outStream = response.getOutputStream();
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/downloads")
	public String StudentNotification() {
		return "facultyDownloads";
	}
}
