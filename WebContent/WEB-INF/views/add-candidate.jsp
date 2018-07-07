<%-- 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Add Candidate</title>

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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.1/angular.min.js"></script>

<!-- for autocomplete -->
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="assets/autocomplete/jquery.autocomplete.min.js"></script>
<link href="assets/autocomplete/main.css" rel="stylesheet">

<script>
	$(document)
			.ready(
					function() {

						$('#dynamicsearchcompany')
								.autocomplete(
										{
											serviceUrl : 'looseSearch2',
											paramName : "CHARS",
											delimiter : ",",
											transformResult : function(response) {

												return {
													//must convert json to javascript object before process
													suggestions : $
															.map(
																	$
																			.parseJSON(response),
																	function(
																			company) {

																		return {
																			value : company.company_name,
																			data : company.company_id
																		};
																	})

												};

											}

										});

					});
</script>
</head>
<body>
<jsp:directive.include file="scripts.jsp" />
<form:form action="addcandidate.html" modelAttribute="userBean" method="post">
Name:<form:input name="name" type="text" path="username" /> 
<form:errors path="username" cssClass="error"/><br/>
Company:<form:input path="company"  id="dynamicsearchcompany" value=""/>
<br>
${msg}
<form:errors path="company" cssClass="error"/><br/>
<input type="submit" value="Add"/><br />
</form:form>

				<div class="clearfix">

					<div class="row">
						<div class="col-xs-12 ">
							<div class="widget-box">
								<div class="widget-body">
									<div class="widget-main">
										<div align="center">
											<h2>Add Candidate</h2>
											<br>
											<form:form action="addcandidate.html"
												modelAttribute="userBean">

												<table>
													<tr>
														<td>Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input
																name="name" type="text" path="username" /> <form:errors
																path="username" cssClass="error" />
														</td>

													</tr>
													<tr>
														<td><div class="col-sm-16">
																<br>Company:
																<form:input name="company" id="company_id"
																	path="company" />
																<br> ${msg}
																<form:errors path="company" cssClass="error" />
																</br> <br></td>
													</tr>
													<tr>
														<td><div class="" center>
																<button class="btn  btn-primary" type="submit">
																	<i class="ace-icon fa fa-check bigger-110"></i> Add
																</button>
															</div></td>
													</tr>
													<tr>
														<td><a href="view.html">View The List Of Applied
																Candidates</a></td>
													</tr>



												</table>
											</form:form>
											<br> <br>
										</div>
									</div>
								</div>
							</div>
							<br> <br>
						</div>


					</div>

					<!-- /#home -->
				</div>






				<form:form action="addcandidate.html" modelAttribute="userBean"
					method="post">
Name:<form:input name="name" type="text" path="username" />
					<form:errors path="username" cssClass="error" />
					<br />
Company:<form:input name="company" id="company_id" path="company" />
					<br>
${msg}
<form:errors path="company" cssClass="error" />
					<br />
					<input type="submit" value="Add" />
					<br />
				</form:form>
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
 --%>






































<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Add Candidate</title>

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style><meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />


<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<!-- for autocomplete -->

<jsp:directive.include file="scripts.jsp" />
<!-- <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script> -->
<script src="assets/autocomplete/jquery.autocomplete.min.js"></script>
<link href="assets/autocomplete/main.css" rel="stylesheet">
<script>
/* 	$(document)
			.ready(
					function() { */
				jQuery(function($){

						$('#company_id')
								.autocomplete(
										{
											serviceUrl : 'looseSearch2',
											paramName : "CHARS",
											delimiter : ",",
											transformResult : function(response) {

												return {
													//must convert json to javascript object before process
													suggestions : $
															.map(
																	$
																			.parseJSON(response),
																	function(
																			company) {

																		return {
																			value : company.company_name,
																			data : company.company_id
																		};
																	})

												};

											}

										});

					});
</script>



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

					<h1>Welcome ${sessionScope.name} to the profile page</h1>

					<%-- <h2>My name is ${sessionScope.name} , I am a
						${sessionScope.roleName} from ${sessionScope.branch} branch with
						username ${sessionScope.userName}</h2>
					<br />
 --%>

				</div>
			


				<div class="clearfix">

					<div class="row">
						<div class="col-xs-12 ">
							<div class="widget-box">
								<div class="widget-body">
									<div class="widget-main">
										<div align="center">
											<h2>Add Candidate</h2>
											<br>
											<form:form action="addcandidate.html"
												modelAttribute="userBean">

												<table>
													<tr>
														<td>Name: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form:input
																name="name" type="text" path="username" /> <form:errors
																path="username" cssClass="error" />
														</td>

													</tr>
													<tr>
														<td><div class="col-sm-16">
																<br>Company:
																<form:input name="company" id="company_id"
																	path="company" />
																<form:errors path="company" cssClass="error" />
																<br> ${msg}<br></td>
													</tr>
													<tr>
														<td><div class="" align="center">
																<button class="btn  btn-primary" type="submit">
																	 Add
																</button>
															</div></td>
													</tr><tr></tr>
													<tr>
														<td><a href="view.html">View The List Of Applied
																Candidates</a></td>
													</tr>



												</table>
											</form:form>
											<br> <br>
										</div>
									</div>
								</div>
							</div>
							<br> <br>
						</div>


					</div>

					<!-- /#home -->
				</div>






				<%-- <form:form action="addcandidate.html" modelAttribute="userBean"
					method="post">
Name:<form:input name="name" type="text" path="username" />
					<form:errors path="username" cssClass="error" />
					<br />
Company:<form:input name="company" id="company_id" path="company" />
					<br>
${msg}
<form:errors path="company" cssClass="error" />
					<br />
					<input type="submit" value="Add" />
					<br />
				</form:form> --%>
				<jsp:directive.include file="Footer.jsp" />
				<jsp:directive.include file="scripts.jsp" />

			</div>
		</div>
	</div>


	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
