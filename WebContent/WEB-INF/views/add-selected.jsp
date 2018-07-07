 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Add Selected Candidates</title>

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
											<h2>Add Selected Candidate</h2>
											<br>
<form:form action="addselected.html" modelAttribute="userBean" method="post">
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
																<form:input name="company_name" id="company_id"
																	path="company_name" />
																<form:errors path="company_name" cssClass="error" />
																<br> ${msg}<br></td>
													</tr>
													<tr>
														<td><div class="" center>
																<button class="btn  btn-primary" type="submit">
																	<i class="ace-icon fa fa-check bigger-110"></i> Add
																</button>
															</div></td>
													</tr>
		<!-- 											<tr>
														<td><a href="views.html">View The List Of Applied
																Candidates</a></td>
													</tr> -->



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