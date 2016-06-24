
<!-- auther: @pankaj
description: contains various functions for admin -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title> Admin | HOME</title>

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
		<link rel="stylesheet" href="assets/css/select2.min.css" />
	
		<link rel="stylesheet" href="assets/css/bootstrap-editable.min.css" />
		
		<link rel="stylesheet" href="assets/css/select2.min.css" />
		
		
		<!-- <link rel="stylesheet" href="assets/css/bootstrap-multiselect.min.css" /> -->
		<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
			
		<script src="assets/js/ace-extra.min.js"></script>
		
		
</head>
<body>

<jsp:directive.include file="Header.jsp" />

	<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
				</div>
					<div class="page-content">
							<div class="page-header">
							
									<h1>Welcome , ${sessionScope.name}! </h1>

							</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="clearfix">
									
								</div>

								<!-- <div class="hr dotted"></div> -->

							<div class="show">
									<div id="user-profile-2" class="user-profile">
										<div class="tabbable">
											<ul class="nav nav-tabs padding-18">
												<li class="active">
													<a data-toggle="tab" href="#activity">
														<i class="orange ace-icon fa fa-rss bigger-120"></i>
														Activities
													</a>
												</li>

												<!-- <li>
													<a data-toggle="tab" href="#uploads">
														<i class="blue ace-icon fa fa-users bigger-120"></i>
														Uploads
													</a>
												</li> -->
												

											</ul>

											<div class="tab-content no-border padding-24">
												

												<div id="activity" class="tab-pane in active">
													 <div class="row ">
														
														 <br>
													 
														<div class="col-xs-12 col-sm-4 left">
															
															  <a href="AssignTPO.html"  class="btn btn-pink btn-lg btn-block">Assign TPO </a> <br><br>

															<button data-toggle="dropdown" class="btn btn-success btn-lg  dropdown-toggle btn-block">
																								Send E-mail
																<i class="ace-icon fa fa-angle-down icon-on-right"></i>
															</button>
															<ul class="dropdown-menu dropdown-success dropdown-menu-right">
																<li>
																	<a href="GroupSendMail">send to Group</a>
																</li>
			
																<li>
																	<a href="personalMail">send to individual</a>
																</li>
															
															</ul>
														</div>
										
														
														&nbsp;&nbsp;<div class="col-xs-12 col-sm-4" >
														  
														  <a href="RemoveTPO.html" class="btn btn-pink btn-lg btn-block">Remove TPO </a> <br><br>
														  <a href=AssignRole  class="btn btn-success btn-lg btn-block">Authorization Controls</a><br><br>
														
														</div>
														
														<div class="col-xs-12 col-sm-8" >
														  
														  <a href="addUser" class="btn btn-inverse btn-lg btn-block">Manage Users</a> <br><br>
														  
														</div>
														
												<!-- <div class="col-xs-12 col-sm-8 left">
														<a href="addUser"  class="btn btn-warning btn-lg btn-block">Manage different users of System</a> <br><br>	
												</div> -->
												</div>
											</div><!-- /#pictures -->
										</div>
								
							
										
										</div><!-- end of tabbable -->
									</div><!-- end of user-profile-2 -->
								</div><!-- end of show -->
							</div><!-- /.col -->

						
								
							</div><!-- /.row -->
<jsp:directive.include file="Footer.jsp" />
<jsp:directive.include file="scripts.jsp" />

						</div><!-- end of page-content -->
					

				
			
			</div><!-- /.main-content-inner-->
		
</div><!-- main-content -->
			



				<!-- page specific plugin scripts -->
		<script src="assets/js/fuelux.tree.min.js"></script>
		
		<script src="assets/js/dropzone.min.js"></script>
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.gritter.min.js"></script>
		<script src="assets/js/moment.min.js"></script>
		<script src="assets/js/jquery.hotkeys.min.js"></script>
		<script src="assets/js/bootstrap-wysiwyg.min.js"></script>
		
		<script src="assets/js/bootstrap-editable.min.js"></script>
		<script src="assets/js/ace-editable.min.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
				
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>


		<!-- page specific plugin scripts -->
		
		
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
	
		
</body>
</html>

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT> -->
<title>Admin</title>
</head>
<body>
	
	<h3>Welcome  ${sessionScope.name} to the profile page </h3>
	
	
	<br />
	<table>

		<tr>
			<td><a href="addUser">Click here to Add students via csv
					file</a></td>
		</tr>
		<tr>
			<td><br />To add users manually</td>
		</tr>
		<tr>
			<td>1. <a href="addstudent.html">Add Student</a></td>
		</tr>
		<tr>
			<td>2. <a href="addfaculty.html">Add Faculty</a></td>
		</tr>
		<tr>
			<td>3. <a href="removeuser.html">Remove User</a><br /></td>
		</tr>
		<tr>
			<td>4. <a href="AssignTPO.html">Assign TPO</a><br /></td>
		</tr>
		<tr>
			<td>4. <a href="RemoveTPO.html">Remove TPO</a><br /></td>
		</tr>
	<tr>
			<td>5. <a href="InsertWork.html">Assign Task</a></td>
		</tr>
		<tr>
			<td>6. <a href="ViewFacultyTasks.html">View Faculty Tasks</a></td>
		</tr>
		<tr>
			<td>7. <a href="ViewUsersA.html">View Users</a><br /></td>
		</tr>
		<tr>
			<td>8. <a href="InsertMonth.html">Insert Month to view
					Events Users</a><br /></td>
		</tr>
		<tr>
			<td>7. <a href="AssignRole">Assign functions to various roles</a><br /></td>
		</tr>

	</table>

	<br /></br>
	<table>
		<tr>
			<td><a href="searchHome">Click here to search for something</a></td>
		</tr>
		<tr>
			<td><a href="GroupSendMail">Click here to send an group email</a></td>
		</tr>
		<tr>
			<td><a href="personalMail">Click here to send personal email</a></td>
		</tr>
		<tr>
			<td><a href="logged-out">Logout</a></td>
		</tr>
	</table>
</body>
</html>

 --%>