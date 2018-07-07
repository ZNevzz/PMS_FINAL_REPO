<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add/Delete Candidate</title>


<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />





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



				

				<%-- <form action="managelist.html" method=POST>
					Edit User List:<select name="option">
						<option value="Add">Add</option>
						<option value="Delete">Delete</option>
					</select> <input type=submit value=submit /><br />
				</form>
				<a href="view.html">View Applicants' List</a>
				 --%>


				<div class="clearfix">

					<div class="row">
						<div class="col-xs-12 ">
							<div class="widget-box">
								<div class="widget-body">
									<div class="widget-main">
										<div align="center">
											<h2>Add/Delete Selected Candidate</h2>
											<br><form action="manageslist.html" method=POST>
													<div class="row">
														<div class="col-sm-6 ">
														<label>Edit User List</label> <select
															name="option" class="chosen-select">
																<option value="Add">Add A Candidate</option>
																<option value="Delete">Delete A Candidate</</option>
														</select>
														
															<button class="btn btn-xs  btn-primary" type="submit">
																<i class="ace-icon fa fa-check bigger-110"></i> Submit

															</button></td>

													</tr>
													</table>
												<table>
							 						<tr>

														<td>
															
													<!-- 			<a href="views.html">View The
																	List Of Applied Candidates</a>   -->
															
														</td>

													</tr> 
													</table>
									</form>
												

											<br> <br> <br> <br> <br> <br>
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
				<jsp:directive.include file="scripts.jsp" />

			</div>
		</div>
	</div>

	<!-- /.main-container -->



	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

</body>
</html>