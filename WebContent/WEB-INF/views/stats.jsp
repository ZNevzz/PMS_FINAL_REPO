
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Statistics</title>
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
				<div class="page-header center">
					<b><h2 class="widget-title grey lighter">&nbsp; &nbsp;
							&nbsp; &nbsp; Statistics of the year</h2></b>
				</div>
				<!-- /.page-header -->
				<div class="space-4"></div>
				<div class="center">
					<table border="3" class="table-fill">
						<thead>
							<tr>
								<th class="text-center"><h3 align="center">
										<b><u>S.No.</u></b>
									</h3>
								</td>
								<th class="text-center"><h3 align="center">
										<b><u>Company</u></b>
									</h3>
								</td>
								<th class="text-center"><h3 align="center">
										<b><u>Production</u></b>
									</h3>
								</td>
								<th class="text-center"><h3 align="center">
										<b><u>Electronic</u></b>
									</h3>
								</td>
								<th class="text-center"><h3 align="center">
										<b><u>Computer</u></b>
									</h3>
								</td>
								<th class="text-center"><h3 align="center">
										<b><u>I.T.</u></b>
									</h3>
								</td>
							</tr>
						</thead>
						<tbody class="table-hover">
							<tr>
								<td class="text-center">1</td>
								<td class="text-center">TCS</td>
								<td class="text-center">10</td>
								<td class="text-center">21</td>
								<td class="text-center">12</td>
								<td class="text-center">10</td>
							</tr>
							<tr>
								<td class="text-center">2</td>
								<td class="text-center">Accenture</td>
								<td class="text-center">11</td>
								<td class="text-center">12</td>
								<td class="text-center">13</td>
								<td class="text-center">14</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">Total Placed</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">Total No. of Students</td>
								<td class="text-center">${totalStudents.prod}</td>
								<td class="text-center">${totalStudents.elex}</td>
								<td class="text-center">${totalStudents.comps}</td>
								<td class="text-center">${totalStudents.it}</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">Eligible Students</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">Interested in Higher
									Studies</td>
								<td class="text-center">${hs.prod}</td>
								<td class="text-center">${hs.elex}</td>
								<td class="text-center">${hs.comps}</td>
								<td class="text-center">${hs.it}</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">% Placement</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
								<td class="text-center">2</td>
							</tr>
							<tr>
								<td colspan="2" class="text-center">Internship Placed</td>
								<td class="text-center">${ip.prod}</td>
								<td class="text-center">${ip.elex}</td>
								<td class="text-center">${ip.comps}</td>
								<td class="text-center">${ip.it}</td>
													</tr>
						</tbody>
					</table>
				</div>
				<jsp:directive.include file="Footer.jsp" />
				<jsp:directive.include file="scripts.jsp" />
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
	<!-- inline scripts related to this page -->

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>


</body>
</html>
