<!-- author: Pankaj sankpal
description: contains fields to add a new event regarding placement drives ->
<!-- -------------------------------------------------------------------------------------------------------- -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%
	ResultSet resultset = null;
%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Event</title>
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
	<jsp:directive.include file="Header.jsp" />

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>

			<div class="page-content">


				<div class="page-header">
					<h1>Logged in as ${sessionScope.name}</h1>
				</div>
				<!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="clearfix">

							<div class="row">
								<div class="col-xs-12 col-lg-6 ">
									<div class="widget-box" align="center">
										<div class="widget-body">
											<div class="widget-main">
												<div align="center" >
													<form id="form" action="fill.html" method="post"
														novalidate="novalidate">
																												<p>
															Event type: <select id="category" name="event_type">
																<option value="none">------</option>
																<option value="pre_placement">pre_placement</option>
																<option value="aptitude">aptitude</option>
																<option value="interview">interview</option>
															</select>
														</p>

														<p>
															Company Name: <input path="company" name="company_name"
																id="dynamicsearchcompany" value="" />
														</p>

														<p>
															Approved: <select type="text" id="approved"
																name="approved">
																<option value="yes">yes</option>
																<option value="no">no</option>
															</select>
														</p>

														<p>
															Date: <input type="text" id="date" name="date"
																placeholder="dd/MM/yyyy" />
														</p>

														<p>
															Time: <input type="text" id="time" name="time"
																placeholder="HH:mm" />
														</p>

														<p>
															Venue: <input type="text" id="venue" name="venue" />
														</p>

														<!-- pre_placement -->

														<div class="pre_placement" hidden>
															<p>
																Conducted_by: <input type="text" id="test"
																	name="conducted_by">
															</p>

															<p>
																Agenda: <input type="text" id="test" name="agenda">
															</p>
														</div>

														<!-- aptitude -->
														<div class="aptitude" hidden>
															<p>
																Test Duration: <input type="text" id="test"
																	name="test_duration">
															</p>

															<p>
																Subjects To Be Prepared: <input type="text" id="test"
																	name="subjects_to_be_prepared">
															</p>

															<p>
																Test Section: <input type="text" id="test"
																	name="test_section">
															</p>
														</div>

														<!-- interview -->
														<div class="interview" hidden>
															<p>
																Interview Type: <input type="text" id="test"
																	name="interview_type">
															</p>
														</div>




														<button class="btn btn-md btn-success">Submit</button>
													</form>


													<br>
													<br>
												</div>
											</div>
										</div>
									</div>
									<br>
									<br>
								</div>


							</div>



						</div>
					</div>
				</div>
						
		<jsp:directive.include file="Footer.jsp" />
			<jsp:directive.include file="scripts.jsp" />
				
			</div>
		</div>





		<!-- ace scripts -->
		<!-- /.main-container -->

	</div>
	<script>
		$(document).ready(function() {
			$("#category").change(function() {

				var typ = $("#category").val();

				switch (typ) {
				case "training":

					$(".pre_placement").hide();
					$(".interview").hide();
					$(".aptitude").hide();
					$(".training").show();

					break;
				case "aptitude":

					$(".pre_placement").hide();
					$(".interview").hide();
					$(".aptitude").show();
					$(".training").hide();
					break;

				case "interview":

					$(".pre_placement").hide();
					$(".interview").show();
					$(".aptitude").hide();
					$(".training").hide();
					break;

				case "pre_placement":

					$(".pre_placement").show();
					$(".interview").hide();
					$(".aptitude").hide();
					$(".training").hide();

					break;
				}

			});

		});
	</script>


<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/jquery.validate.min.js"></script>

<script type="text/javascript">
	(function($, W, D) {
		var JQVAL = {};
		JQVAL.UTIL = {
			setupFormValidation : function() {
				$("#form").validate({
					rules : {
						event_type : "required",
						company_name : "required",
						date : {
							required : true,
						},
						time : "required",
						venue : "required"
					},
					messages : {
						event_type : "Please select an event type",
						company_name : "Please enter the name of the company",
						date : {
							required : "Please enter the required date",
						},
						time : "Please enter the event time",
						venue : "Please enter the venue",
					},
					submitHandler : function(form) {
						form.submit();
					}

				});

			}
		}
		$(D).ready(function($) {
			JQVAL.UTIL.setupFormValidation();
		});

	})(jQuery, window, document);
</script>


	<!-- inline scripts related to this page -->

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	


</body>
</html>





<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>

</head>
<body>
 
 <form action="fill.html" method="post">
 <p>event name: <input type="text" id="test" name="event_name"></p>
<p>event type: 
 <select id="category" name="event_type">
   <option value="none">------</option>
  <option value="pre_placement">pre_placement</option>
  <option value="aptitude">aptitude</option>
  <option value="interview">interview</option>
</select> 
</p>

<p>company name: <input type="text" id="test" name="company_name"></p>

<p>approved: <input type="text" id="test" name="approved"></p>

<p>date: <input type="text" id="test" name="date"></p>

<p>time: <input type="text" id="test" name="time"></p>

<p>venue: <input type="text" id="test" name="venue"></p>

<!-- pre_placement -->

<div class="pre_placement" hidden>
<p>conducted_by: <input type="text" id="test" name="conducted_by"></p>

<p>agenda: <input type="text" id="test" name="agenda"></p>
</div>

<!-- aptitude -->
<div class="aptitude" hidden>
<p>test_duration: <input type="text" id="test" name="test_duration"></p>

<p>subjects_to_be_prepared: <input type="text" id="test" name="subjects_to_be_prepared"></p>

<p>test_section: <input type="text" id="test" name="test_section"></p>
</div>

<!-- interview -->
<div class="interview" hidden>
<p>interview_type: <input type="text" id="test" name="interview_type"></p>
</div>




<button>Show Value</button>
</form>

<script>
$(document).ready(function(){
	$( "#category" ).change(function() {
				
				var typ=$( "#category").val();
				
				
				switch(typ){
					case "training":
						
						$(".pre_placement").hide();
						$(".interview").hide();
						$(".aptitude").hide();
						$(".training").show();
						
						break;
					case "aptitude":
						
						$(".pre_placement").hide();
						$(".interview").hide();
						$(".aptitude").show();
						$(".training").hide();
						break;
					
					case "interview":
						
						
						$(".pre_placement").hide();
						$(".interview").show();
						$(".aptitude").hide();
						$(".training").hide();
						break;
						
					case "pre_placement":
						
						$(".pre_placement").show();
						$(".interview").hide();
						$(".aptitude").hide();
						$(".training").hide();
							
						break;
				}
				
				
	});
	
	
});
</script>
</body>
</html>
 --%>