<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Applied List</title>

<jsp:directive.include file="scripts.jsp" />

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
 
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.1/angular.min.js"></script>
<script  type="text/javascript">
function doSearch(){
		$.getJSON("looseSearch2",
				
				{CHARS:''},
				
				function(data){
					console.log(data);
					$('#searchresult').text('');
					for(var index in data){
						$('#searchresult').append('<option name="'+data[index].company_id+'">'+data[index].company_name+'</option>');
					}
				});
	}

</script>

</head>
<body onLoad="doSearch();">
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
											<h2>Select The Company You Want To View</h2>
											<br>
											<form action="viewclist.html" method="get">

												<table>
													<tr>
														<td><label class="col-sm-0">Company</label><select name="company" id="searchresult"></select>
															<button class="btn btn-xs btn-primary" type="submit">
																<i class="ace-icon fa fa-check bigger-110"></i> Submit
															</button></td>

													</tr>
												</table>
												
												<input type="text" name="year" hidden/>
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

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>