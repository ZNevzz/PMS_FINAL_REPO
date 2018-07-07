<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Add Feedback</title>


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
			<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>
			<div class="page-content">
				<div class="page-header"></div>
				<!-- /.page-header -->



				<script type="text/javascript">
					try {
						ace.settings.check('main-container', 'fixed')
					} catch (e) {
					}
				</script>
				<jsp:directive.include file="scripts.jsp" />


				<div class="clearfix">

					<div class="row">
						<div class="col-xs-12 ">
							<div class="widget-box">
								<div class="widget-body">
									<div class="widget-main">
										<div align="center">
											<h2>Add Feedback Data</h2>
											
											<c:if test="${not empty msg}">
			    <font size="5" color="red" face="verdana">${msg}</font>
		         </c:if>
		         <br>
											<form:form method="POST" action="save.html">

												<table>
													<tr hidden>
														<td><form:label path="username">User name:</form:label></td>
														<td><form:input path="username"
																value="${sessionScope.userName}" /></td>
														<td><form:errors path="username" cssClass="error" /></td>
													</tr>

													<tr>

														<td><form:label path="feeback">Feedback:</form:label></td>
														<td><form:input path="feeback" /></td>
														<td><form:errors path="feeback" cssClass="error" /></td>
													</tr>
													<tr>
														<td><br/></td>
													</tr>
													
													<tr>

														<td><form:label path="company">Company:</form:label></td>
														<td><form:input path="company"
																id="dynamicsearchcompany" value="" /></td>
														<td><form:errors path="company" cssClass="error" /></td>
													</tr>
												</table>
												<br>
												<button class="btn  btn-primary" type="submit">
													<i class="ace-icon fa fa-check bigger-110"></i> Submit
													Feedback
												</button>

											</form:form>
											
										</div>
									</div>
								</div>
							</div>
							<br> <br><br> <br>
											<br> <br>
											<br> <br>
											<br> <br> <br>
											<br> <br>
											<br> <br>
						</div>


					</div>

					<!-- /#home -->
				</div>
				<jsp:directive.include file="Footer.jsp" />
				<jsp:directive.include file="scripts.jsp" />

			</div>
		</div>
	</div>

	<!-- ace scripts -->
	
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
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
