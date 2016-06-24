
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- This JSP displays the List of the Users from UserDetails Table (For Admin)

 @author Adarsh
 -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>View Users</title>
<link rel="stylesheet" href="assets/css/table.css">
<meta name="viewport"
	content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
</head>
<body class="no-skin">
	<jsp:directive.include file="Header.jsp" />
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>
			<div class="page-content">
				<div class="page-header">
					<h2 class="widget-title grey lighter">&nbsp; &nbsp; &nbsp;
						&nbsp; View Users</h2>
				</div>
				<div class="space"></div>
				<div class="center">
					<c:if test="${!empty users}">
						<table align="center" border="2" width="500" class="table-fill">
							<thead>
								<tr>
									<th class="text-center"><h3 align="center">
											<b>User Name</b>
										</h3></th>
									<th class="text-center"><h3 align="center">
											<b>User Role</b>
										</h3></th>
								</tr>
							</thead>
							<tbody class="table-hover">
								<c:forEach items="${users}" var="user">
									<tr>
										<td class="text-center"><h4>
												<c:out value="${user.userName}" />
											</h4></td>
										<td class="text-center"><c:choose>
												<c:when test="${user.roleId=='1'}">
													<h4>
														<c:out value="Student" />
													</h4>
												</c:when>
												<c:when test="${user.roleId=='2'}">
													<h4>
														<c:out value="Faculty" />
													</h4>
												</c:when>
												<c:when test="${user.roleId=='3'}">
													<h4>
														<c:out value="Student-TPC" />
													</h4>
												</c:when>
												<c:when test="${user.roleId=='4'}">
													<h4>
														<c:out value="Faculty-TPC" />
													</h4>
												</c:when>
												<c:when test="${user.roleId=='5'}">
													<h4>
														<c:out value="TPO" />
													</h4>
												</c:when>
												<c:otherwise>
													<h4>
														<c:out value="Admin" />
													</h4>
												</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
				<!-- /.page-header -->

				<jsp:directive.include file="Footer.jsp" />
				<jsp:directive.include file="scripts.jsp" />
			</div>
			<!-- /.page-content -->
		</div>
	</div>
<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>



</body>
</html>
