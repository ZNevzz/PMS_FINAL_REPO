<!-- author: Pankaj sankpal
description: contains fields to add a student or a faculty TPC into the System->
<!-- -------------------------------------------------------------------------------------------------------- -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Add Faculty or Student TPC  Members Manually </title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>

</head>
<body >
	<jsp:directive.include file="Header.jsp" />

	<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>

					<div class="page-content">
						

						<div class="page-header">
							<h1>
								Logged in as
								<core:out value="${loginForm.userName}" />
							</h1>
						</div><!-- /.page-header -->
						
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="clearfix">
								
										<div class="row">
										<div class="col-xs-12 ">
										<div class="widget-box">
										<div class="widget-body">
										 <div class="widget-main">
											<div align="center">
													<h2>Assign TPC</h2>
													<br>
													<form:form method="POST" action="SubmitAssignTPC">
														
														<table>
															<tr>
																<td><form:label path="userName">User name:</form:label></td>
																<td><form:input path="userName" /></td>
																<td><form:errors path="userName" cssClass="error" /></td>
															</tr>
															<tr>
																<td style="padding-top: 10px"><form:label path="roleId">User Role:</form:label></td>
																<td style="padding-top: 10px"><form:radiobutton path="roleId" value="1" /> Student-TPC <form:radiobutton
																		path="roleId" value="2" /> Faculty-TPC</td>
												
																<td><form:errors path="roleId" cssClass="error" /></td>
															</tr>
															<tr>
																<p >
																	<font size="5" color="red" face="verdana">${erroMesg}</font>
																</p>
															</tr>
															<tr>
																<td colspan="2" style="padding-top: 10px"><input class="btn btn-md btn-success" type="submit" value="Submit" /></td>
															</tr>
														</table>
													</form:form>
												<br><br>
											</div>
											</div>
											</div>
											</div>
											<br><br>
										</div>

										
									</div>
										
								
								
								</div>
							</div>
						</div>
						<jsp:directive.include file="scripts.jsp" />
		<jsp:directive.include file="Footer.jsp" />
	
					</div>
				</div>
												


	
		
	
		<!-- /.main-container -->

</div>
		<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	
	


</body>
</html>



<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- This JSP is a form to allow a person to input Username and Select RoleID of the User to be assigned as TPC(STPC or FTPC)

 @author Adarsh
 -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign TPC</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<h2>Assign TPC</h2>
	<form:form method="POST" action="SubmitAssignTPC">
		modelAttribute="userBean"
		<table>
			<tr>
				<td><form:label path="userName">User name:</form:label></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="roleId">User Role:</form:label></td>
				<td><form:radiobutton path="roleId" value="1" /> Student-TPC <form:radiobutton
						path="roleId" value="2" /> Faculty-TPC</td>

				<td><form:errors path="roleId" cssClass="error" /></td>
			</tr>
			<tr>
				<p>
					<font size="5" color="red" face="verdana">${erroMesg}</font>
				</p>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<tr>
		<td><a href="TPOHome">Home</a></td>
	</tr>
</body>
</html>

 --%>