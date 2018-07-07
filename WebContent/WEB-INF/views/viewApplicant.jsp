
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>List Of Applicants</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />





<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

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
		<div class="main-content-inner">

			<div class="page-content">
				<div class="page-header"></div>
				<!-- /.page-header -->



				<script type="text/javascript">
					try {
						ace.settings.check('main-container', 'fixed')
					} catch (e) {
					}
				</script>


				<%-- <c:if test="${!empty users}">
		<table border="1">
			<tr>
				<th>User Roll No.</th>
				
			</tr>
			<c:forEach items="${users}" var="ud">
				<tr>
					<td><c:out value="${ud.username}" /></td>
					
				</tr>
			</c:forEach>
		</table>
	</c:if> --%>


				<div class="row">
					<center>
						<div class="col-xs-3">
							<div class="table-header">The List Of Applicants So Far</div>
							<c:if test="${!empty users}">
								<table id="simple-table"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th><center>Name</center></th>
										</tr>
									</thead>

									<tbody>
										<c:forEach items="${users}" var="ud">
											<tr>

												<td><font color="blue"><center>
															<c:out value="${ud.username}" />
														</center></font></td>
											</tr>

										</c:forEach>

									</tbody>
								</table>
							</c:if>
						</div>
					</center>

					<!-- /.col -->
					<div class="col-xs-9">

						<center>
							<h3>Input Student To Be Notified</h3>
							<center>

								<form:form method="POST" action="NotifyStudent">

									<table>

										<tr>
											<!-- 
					<td>UserName/Roll No. :</td>
					<td> <input name="userName" /> </td> -->
											<td><form:label path="userName">User name:</form:label></td>
									<%-- 	<td><form:input path="userName" /></td> 	--%>
											<td><form:errors path="userName" cssClass="error" /></td>
											<td><form:select name="userName" id="userName"
									path="userName">

									<c:forEach items="${users}" var="user">
										<form:option value="${user.username}">${user.username}</form:option>
									</c:forEach>
											</form:select></td>
										</tr>

										<tr>
											<p>
												<font size="5" color="red" face="verdana">${errorMsg}</font>
											</p>
										</tr>

										<tr>

											<td><br>
											<div class="" center>
													<button class="btn btn-primary btn-block" type="submit">
														<i class="ace-icon fa fa-check bigger-110"></i> Notify
													</button>
												</div>
												<td>
								
										</tr>

							</table>

						</form:form>
						
						<c:if test="${success==1}">
								<p color="green">
								
									<h2>Notification status changed successfully!!</h2>
								</p>
							</c:if>
					
					</div>
				<br /> <br />

					<!-- /.col --></div>
											



				<jsp:directive.include file="Footer.jsp" />


			</div>
		</div>
	</div>

	<!-- /.main-container -->

	<!--[if !IE]> -->
	<script src="assets/js/jquery.2.1.1.min.js"></script>


	<!-- inline scripts related to this page -->

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
