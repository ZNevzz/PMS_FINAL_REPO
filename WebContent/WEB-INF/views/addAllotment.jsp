<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Room Allotment</title>
		<style>
		.error {
					color: #ff0000;
					font-style: italic;
					font-weight: bold;
				}
		</style>
		<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  			<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  			<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  			<link rel="stylesheet" href="/resources/demos/style.css">
 		 <script>
		  $(function() {
    $( "#datepicker" ).datepicker();
  });
  </script>
		<meta name="description" content="Common form elements and layouts" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<!-- 		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.2.0/css/font-awesome.min.css" />
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/chosen.min.css" />
		<link rel="stylesheet" href="assets/css/datepicker.min.css" />
		<link rel="stylesheet" href="assets/fonts/fonts.googleapis.com.css" />
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
		<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<script src="assets/js/ace-extra.min.js"></script>		
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<script src="assets/js/jquery.js"></script> -->
		<!-- <script type="text/javascript">
		$(document).ready(function() { 
		$("#validation-form").validate({
		    rules: {
    				round: "required",
				description: {
					required: true,
				},
				date: {
					required: true,
				},
				file: {
					required: true,
				},
				room: {
					required: true,
				},
			   },
		messages: {
    				round: "Please enter your round",
				description: {
					required: "Please enter a description",
				},
				date: {
					required: "Please provide a date",
				},
				file: {
					required: "Please provide a date",
				},
				room: "Please enter a valid email address",
			 }
		});		
		});		
		</script> 
		<script type="text/javascript" src="assets/js/jquery.validate.min.js"></script> -->
</head>
<body>
	<jsp:directive.include file="Header.jsp" />
	
	<div class="main-content">
		<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>
			<div class="page-content">
				<form:form method="POST" id="validation-form" enctype="multipart/form-data" modelAttribute="allotmentBean" action="saveAllotment">
					<h2 align="center"><u>Room Allotment Details</u></h2>
					
					<c:if test="${success==1}">
						<center><p style="color:green;">Room Allotment details added successfully!</p></center>
					</c:if>
					<c:if test="${error==1}">
						<center><p style="color:red;">Failed to upload...File format can be .doc/.docx/.odt/.pdf/.png/.jpg/.jpeg only!</p></center>
					</c:if>
					<c:if test="${error1==1}">
						<center><p style="color:red;">Failed to upload...File size can be only upto 2MB!</p></center>>
					</c:if>
						<table align="center" cellspacing="20" cellpadding="20">
			 				<tr><td><form:input path="allotment_id" type="hidden" /></td></tr> 
							<tr><td><br/></td><td><br/></td>
							<td><br/></td></tr>
							<tr>
						<td><label>Company Name&nbsp&nbsp&nbsp</label></td>
				<td><form:select name="company" id="company" path="company_name">
				
				<c:forEach items="${companies}" var="companies">
                        <form:option value="${companies.key}">${companies.value}</form:option>
                </c:forEach>
				
				 <%-- <%
    				try{
							Class.forName("org.postgresql.Driver").newInstance();
							Connection connection = DriverManager.getConnection
            				("jdbc:postgresql://localhost:5432/placementdb?user=postgres&password=root");
       						Statement statement = connection.createStatement() ;
       						resultset =statement.executeQuery("select company_name from job_schema.company") ;
				%>
				<%  while(resultset.next()){ %>
            		<option><%= resultset.getString(1)%></option>
        		<% } %>
        		<%
        		}
        		catch(Exception e)
        		{
             			out.println("wrong entry"+e);
        		}
				%>  --%>
					</form:select></td>
					<td><form:errors path="company_name" cssClass="error" /></td>
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>		
			
			<tr>
				<td><label>Round Name</label></td>
				<td><form:input name="round" id="round" path="round_no" /></td>
				<td><form:errors path="round_no" cssClass="error" /></td>
				
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr>
				<td><label>Room number</label></td>
				<td><form:input name="room" id="room" path="room_no" /></td>
				<td><form:errors path="room_no" cssClass="error" /></td>
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr>
				<td><label>Description</label></td>
				<td><form:textarea name="description" id="description" path="job_description" /></td>
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr>
				<td><label>Date</label></td>
				<td><form:input path="drive_date" name="date" id="datepicker" class="form-control date-picker" data-date-format="yyyy/mm/dd"/></td>
				<td><form:errors path="drive_date" cssClass="error" /></td>
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr>
				<td><label>Add an attachment&nbsp;&nbsp;</label></td>
				<td><form:input type="file" name="file" id="file" path="fileUpload"/></td> 
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr>
			<td><br/></td>
			<td><br/></td>
			<td><br/></td>
			</tr>
			<tr></tr><tr></tr>
			
			<tr>
				<td><h1 align ="center"></h1></td>
				<td colspan="0"><input value="Submit" type="submit" class="btn btn-info"/></td>
				<!-- <td ><input type="reset" value="Reset" class="btn btn-info"/></td> -->
			</tr>
		</table>
	</form:form>
				<jsp:directive.include file="Footer.jsp" />
</div>
</div>
</div>

<!-- 	<script src="assets/js/jquery.2.1.1.min.js"></script>
	<script src="assets/js/jquery.1.11.1.min.js"></script>
	<script src="assets/js/jquery.validate.js"></script>
	<script src="assets/js/jquery.validate.min.js"></script>
	<script src="assets/js/jquery.js"></script> -->
	<script src="assets/js/bootstrap.min.js"></script> 
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/bootstrap-datepicker.min.js"></script>
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	<script>
	<!-- date picker-->
			jQuery(function($) {		
				$('.date-picker').datepicker({
					autoclose: true,
					todayHighlight: true
				})
				.next().on(ace.click_event, function(){
					$(this).prev().focus();
				});
				$('#file').ace_file_input({		//file upload
					no_file:'No File ...',
					btn_choose:'Choose',
					btn_change:'Change',
					droppable:false,
					onchange:null,
					thumbnail:false //| true | large
				});				
			});	
		</script>
		
				
</body>
</html>