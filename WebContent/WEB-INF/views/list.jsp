<%-- 
 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#yb").change(function(){
    	var x = $('#yb').val();
    	
    	window.location.replace("highlight?year="+x);
    });
});
</script>
 
 <script  type="text/javascript">
 function fillsel(){
  							var myDate = new Date();
  							var year = myDate.getFullYear();
  							for(var i = 2000; i < year+1; i++){
					 						 	$('#yb').append('<option value="'+i+'">'+i+'</option>');

  							}
  							
 }
 </script>
<title>Highlights</title>
</head>
<body class="no-skin" onLoad="fillsel()">

			<jsp:directive.include file="Header.jsp" />
			<div class="main-content">
				<div class="main-content-inner">
				<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>					
					<div class="page-content">
						<div class="page-header center">
							<b><h2 class="widget-title grey lighter">
								&nbsp; &nbsp; &nbsp; &nbsp; 					
									Hightlights of the year
							</h2></b>
						</div>
						<!-- /.page-header -->
						<div class="space-4"></div>
						
						<div class="center">
							<form action = "">
							<select id="yb" name="yb" >
  							</select>
  							</form>
						</div>
						<div class="space-4"></div>
						<div class="center">
						<table align="center">
						<tr>	
							<td><a href="tpclist">
								<img src="assets/images/placement.jpg" alt="TPC list" width="300" height="300" border="0">
							</a><h4>TPC list</h4>
							</td>
							<td>
							<a href="studentlist">
								<img src="assets/images/student.jpg" alt="Students" width="300" height="300" border="0">
							</a><h4>Students</h4>
							</td>
						</tr>	
						<tr>
							<td><a href="stats">
								<img src="assets/images/statistics.jpg" alt="Statistics" width="300" height="300" border="0">
							</a><h4>Statistics</h4>
							</td>
							<td><a href="company">
								<img src="assets/images/company.png" alt="Company" width="300" height="300" border="0">
							</a><h4>Company</h4>
							</td>
						</tr>
						</table>
						</div>	
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->

	</body>

</html> --%>




<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Statistics</title>


<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<jsp:directive.include file="scripts.jsp" />
<script>
	$(document).ready(function() {
		var x = new Date().getFullYear();
		$("#tpclist").attr("href", "tpclist?year=" + x);
		$("#studentlist").attr("href", "studentlist?year=" + x);
		$("#stats").attr("href", "stats?year=" + x);
		$("#company").attr("href", "company?year=" + x);
		$("#yb").change(function() {
			var x = $('#yb').val();
			$("#tpclist").attr("href", "tpclist?year=" + x);
			$("#studentlist").attr("href", "studentlist?year=" + x);
			$("#stats").attr("href", "stats?year=" + x);
			$("#company").attr("href", "company?year=" + x);
			//window.location.replace("highlight?year="+x);
		});
	});
</script>

<script type="text/javascript">
	function fillsel() {
		var myDate = new Date();
		var year = myDate.getFullYear();
		$('#yb').append('<option value=" ">--select--</option>');
		for (var i = 2000; i < year + 1; i++) {
			$('#yb').append('<option value="'+i+'">' + i + '</option>');
		}
	}
</script>
<style>
.fa fa-graduation-ca {
	font-size: 75px;
}
</style>
</head>
<body class="no-skin" onLoad="fillsel()">

	<jsp:directive.include file="Header.jsp" />
	<div class="main-content">
		<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>
			<div class="page-content">
				<div class="center">
					<b><h4 class="widget-title grey lighter">Select your year
							:</h4></b>
							<form action="">
					<select id="yb" name="yb">
					</select>
				</form>
				</div>
				
				<!-- /.page-header -->
				<div class="space-20"></div>
				<div class="space-20"></div>
				<div class="space-20"></div>
				<div class="space-20"></div>
				<div class="space-20"></div>


				<div class="space-4"></div>
				<div class="center">
					<div class="row">

						<div class="col-xs-6">
							<a id="tpclist" href="tpclist"> <!-- <img src="assets/images/placement.jpg" alt="TPC list" width="300" height="300" border="0">
							 --> <i class="fa fa-group fa-5x" aria-hidden="true"></i>

							</a>
							<h4>TPC list</h4>
						</div>
						<div class="col-xs-3">
							<a id="studentlist" href="studentlist"> <!-- <img
									src="assets/images/student.png" alt="Students" width="300"
									height="300" border="0"> --> <i
								class="fa fa-graduation-cap fa-5x" aria-hidden="true"></i>

							</a>
							<h4>Students</h4>
						</div>

					</div>


					<br /> <br />

					<div class="row">
						<div class="col-xs-6">
							<a id="stats" href="stats"> <!-- <img
									src="assets/images/statistics.jpg" alt="Statistics" width="300"
									height="300" border="0"> --> <i class="fa fa-area-chart fa-5x"
								aria-hidden="true"></i>
							</a>
							<h4>Statistics</h4>
							</td>
						</div>

						<div class="col-xs-3">
							<a id="company" href="company"> <!--  <img
									src="assets/images/company.png" alt="Company" width="300"
									height="300" border="0"> --> <i class="fa fa-building-o fa-5x"
								aria-hidden="true"></i>
							</a>
							<h4>Company</h4>
							</td>
						</div>
					</div>





				</div>
				<br><br><br><br>
			<jsp:directive.include file="Footer.jsp" />
			<jsp:directive.include file="scripts.jsp" />

				
			</div>
		</div>
	</div>

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>


</body>
</html>