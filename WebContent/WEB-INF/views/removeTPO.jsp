
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- This JSP is a form to allow a person to input Username of the User to be removed as TPO

 @author Adarsh
 -->


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Remove TPO</title>
<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>

			<jsp:directive.include file="Header.jsp" />
			<div class="main-content">
				<div class="main-content-inner"><div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>
					<div class="page-content">
						<div class="page-header">
							<h2 class="widget-title grey lighter">
								&nbsp; &nbsp; &nbsp; &nbsp; 
									Remove TPO
							</h2>
						</div>
						<div class="center">
							<a href="AdminHome"><h3>Home</h3></a>
						</div>
						<div class="space"></div>
						<div class="center">
							<form:form method="POST" action="SubmitRemoveTPO">
							<table align="center">
							<tr>
								<td><form:label path="userName">
										<h3>User name:</h3>
									</form:label></td>
								<td><form:input path="userName" /></td>
								<td><form:errors path="userName" cssClass="error" /></td>
							</tr>
							<tr>
								<p>
									<font size="5" color="red" face="verdana">${erroMesg}</font>
								</p>
							</tr>
							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Submit"
									class="btn btn-info" /></td>
							</tr>
						</table>
					</form:form>
				</div>
				<jsp:directive.include file="Footer.jsp" />
	<jsp:directive.include file="scripts.jsp" />
			</div>
		</div>
	</div>
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
