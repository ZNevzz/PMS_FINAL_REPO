<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
</head>
<body><jsp:directive.include file="Header.jsp" />
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
											
<form action="saveH" method="post">
<c:if test="${not empty msg}">
			    <font size="5" color="red" face="verdana">${msg}</font>
           </c:if>

<table>
<tr>		         
<td><h1>Number of students interested in Higher Studies: </h1></td>
</tr>

<tr>
<td>Year:</td>
<td>
<input type="text" name="year" value="${ihs.year}"></td></tr>

<tr>
<td><br/></td>
</tr>

<tr>
<td>Computers:</td>
<td>
<input type="text" name="comps" value="${ihs.comps}">
</td></tr>

<tr>
														<td><br/></td>
													</tr>
													
<tr>
<td>
Electronics:</td>
<td><input type="text" name="elex" value="${ihs.elex}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr>
<td>
Production:</td>
<td>
<input type="text" name="prod" value="${ihs.prod}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr>
<td>
Information Technology:</td>
<td><input type="text" name="it" value="${ihs.year}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr>
<td>
<h1>Number of Internship Placed students:</h1><br></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr>
<td>
Year:</td>
<td><input type="text" name="years" value="${ips.year}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr><td>
Computers:</td>
<td>
<input type="text" name="compss" value="${ips.comps}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr><td>
Electronics:</td>
<td>
<input type="text" name="elexs" value="${ips.elex}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr>
<td>
Production:</td>
<td><input type="text" name="prods" value="${ips.prod}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr><td>
Information Technology:</td>
<td>
<input type="text" name="its" value="${ips.it}"></td>
</tr>
<tr>
														<td><br/></td>
													</tr>
													
<tr>
<td>
<button class="btn  btn-primary" type="submit">
													<i class="ace-icon fa fa-check bigger-110"></i> Submit
													</button></td></tr>
													
</table>												
</form>
</div>
									</div>
								</div>
							</div>
							<br> <br><br> <br>
											<br> <br>
											<br> <br>
											</div>

							</div>
				<jsp:directive.include file="Footer.jsp" />
<jsp:directive.include file="scripts.jsp" />

			</div>
		</div>
	</div>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
							
</body>


</html>
