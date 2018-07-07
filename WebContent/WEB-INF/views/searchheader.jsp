<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.1/angular.min.js"></script>

<!-- for autocomplete -->
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="assets/autocomplete/jquery.autocomplete.min.js"></script>
<link href="assets/autocomplete/main.css" rel="stylesheet">

<!-- for searching -->
<script>
	var x = [];
	$(document)
			.ready(
					function() {

						$('#dynamicsearchall').autocomplete(
								{
									serviceUrl : 'Search',
									paramName : "CHARS",
									delimiter : ",",
									transformResult : function(response) {

										return {
											suggestions : $.map($
													.parseJSON(response),
													function(user) {
														x.push(user);
														console.log(x);
														$('#notfound').text("");
														return {
															value : user.name,
															data : user.id
														};

													})

										};

									}

								});

						/* $('#dynamicsearchall').on('change',function(){
							  //alert(x.name);
							  alert($(this).val());
							  
							  
							  //window.location.replace("");
							  
						  }); */
						$('#searchbutton')
								.click(
										function() {
											var userSelect = $(
													'#dynamicsearchall').val();
											console.log(userSelect);
											var userSelectId = -1;
											var companyName = "xyz"
											var type = "xyz"
											console.log(x);
											for (var i = 0; i < x.length; i++) {
												console.log(x[i].name);
												if (x[i].name == userSelect) {
													userSelectId = x[i].id;
													type = x[i].type;
													companyName = x[i].name;
													break;
												}
											}
											console.log(userSelectId);
											if (userSelectId !== -1) {
												if (type === 'user') {
													window.location
															.replace("${pageContext.request.contextPath}/searchProfile?userName="
																	+ userSelectId);// ill tak to nevil tom abt ths url
												} else {
													if (companyName !== 'xyz')
														window.location
																.replace("Company?companyname="
																		+ companyName);
													else
														$('#notfound')
																.text(
																		"No results found.");// not found
												}
											} else {
												$('#notfound').text(
														"No results found.");
												//window.location.replace("wtf.com");//not found 
											}
										});

					});
</script>
</head>
<body>
	<div class="nav-search" id="nav-search">
		<form class="form-search">
			<span class="input-icon"> <input type="text" style="height:30px; "
				placeholder="Search ..." class=""
				id="dynamicsearchall" /> <i
				class="ace-icon fa fa-search "></i> 
				<input
				class="btn btn-sm btn-primary" type="button" value="Search"  
				id="searchbutton"/> 
				<span id="notfound" style="color:red"></span>
				<!-- <div id="notfound" style="color: red"></div> -->
			</span>
		</form>
	</div>
	

</body>
</html>