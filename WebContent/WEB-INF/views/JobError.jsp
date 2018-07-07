
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Job Errors Page </title>

<meta name="description" content="404 Error Page" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="assets/fonts/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
</head>
<body>
	<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container " id="navbar-container">
				<!-- <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button> -->

				<div class="navbar-header navbar-green pull-left">
					<a href="viewprofile" class="navbar-brand">
						<small>
							<i class="fa fa-graduation-cap"></i>
							C R C E &nbsp;&nbsp;&nbsp;P l a c e m e n t s
							
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						
						<!-- <li class="blue">
							<a datatoggle="dropdown" href="notifications">

								<i class="ace-icon fa fa-bell icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>
						</li> -->

						

						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<!--  <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo" />   -->
								<span class="user-info">


									<small>Welcome</small>
									${sessionScope.name}


								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="viewprofile">
										<i class="ace-icon fa fa-user"></i>
										Profile
									</a>
								</li>
								
								<li>
									<a href="logged-out">
										<i class="ace-icon fa fa-power-off"></i>
										Sign out
									</a>
								</li>

							</ul>
						</li>
					</ul>
				</div>
			</div><!-- /.navbar-container -->
		</div>
	<div class="main-content">
		<div class="main-content-inner">
			
			<div class="page-content">
				<div class="ace-settings-container" id="ace-settings-container">
					
					<div class="ace-settings-box clearfix" id="ace-settings-box">
						<div class="pull-left width-50">
							
							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-navbar" /> <label class="lbl"
									for="ace-settings-navbar"> Fixed Navbar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-sidebar" /> <label class="lbl"
									for="ace-settings-sidebar"> Fixed Sidebar</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-breadcrumbs" /> <label class="lbl"
									for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-rtl" /> <label class="lbl"
									for="ace-settings-rtl"> Right To Left (rtl)</label>
							</div>

							<div class="ace-settings-item">
								<input type="checkbox" class="ace ace-checkbox-2"
									id="ace-settings-add-container" /> <label class="lbl"
									for="ace-settings-add-container"> Inside <b>.container</b>
								</label>
							</div>
						</div>
						<!-- /.pull-left -->

					</div>
					<!-- /.ace-settings-box -->
				</div>
				<!-- /.ace-settings-container -->

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->

						<div class="error-container">
							<div class="well">
								<h2 class="red lighter smaller">
									<span class="blue bigger-125"> <i
										class="ace-icon fa fa-random"></i> DETAILS ERROR

									</span><strong> Some Input Details Are Incorrect  </strong>

									
								</h2>

								<hr />
								<h3 class=" green lighter smaller">

								<strong>
									Please fill in the following details correctly.<br/>
									 (click the Correct Details button below)
									 <br /> 
								</strong>	 
									  
									<!--wasn't sure which one to keep @Crystal  -->
									<%-- Sorry,an unwanted error occured while displaying the
									URL:"${exception} <br /> ${message} 

									<a href="${url}">Let's take you back</a> --%>
								</h3>

								<div class="space"></div>

								<div>
									<!-- <h4 class="lighter smaller">Meanwhile, try one of the
										following:</h4> -->

									<ul class="list-unstyled spaced inline bigger-110 margin-15">

										<c:if test="${driveDateError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Drive Date cannot be blank or before current date</font>
										</li>
										</c:if>
								
										<c:if test="${ctcError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the CTC</font>
										</li>
										</c:if>
										
										<c:if test="${categoryError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the Job Category</font>
										</li>
										</c:if>
										
										<c:if test="${docsError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the Documents Required</font>
										</li>
										</c:if>
										
										<c:if test="${skillsError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the Skills Required</font>
										</li>
										</c:if>
										
										<!--  Validation Messages For Criteria -->
										
										<c:if test="${branchError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the Eligible Branches</font>
										</li>
										</c:if>
										
										<c:if test="${passError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the Year Of Passing</font>
										</li>
										</c:if>
										
										<c:if test="${cgpaError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the CGPA</font>
										</li>
										</c:if>
										
										<c:if test="${hscError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the HSC Percentage</font>
										</li>
										</c:if>
										
										<c:if test="${sscError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the SSC percentage</font>
										</li>
										</c:if>
										
										<c:if test="${percentageError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Please mention the Percentage</font>
										</li>
										</c:if>
										
										<c:if test="${lastDateError==1}">
										<li><i class="ace-icon fa fa-hand-o-right blue"></i>
										<font color="red" size="4">Last Date To Apply cannot be blank or after Drive Date</font>
										</li>
										</c:if>

									<!--wasn't sure which one to keep @Crystal  -->
										<!-- <li><i class="ace-icon fa fa-hand-o-right blue"></i> Read
											the faq</li>

										<li><i class="ace-icon fa fa-hand-o-right blue"></i> Give
											us more info on how this specific error occurred!</li> -->

									</ul>
								</div>

								<hr />
								<div class="space"></div>

								<div class="center">
								
									<a href="javascript:history.back()" class="btn btn-pink"> <i
										class="ace-icon fa fa-arrow-left"></i>
										<font size="4">  Correct Details </font>
									</a>
								
								</div>
							</div>
						</div>

						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->


	<jsp:directive.include file="Footer.jsp" />


	</div>
	</div>
	</div>

	<!-- /.main-container -->

	<!--[if !IE]> -->

	<script src="assets/js/jquery.2.1.1.min.js"></script>



	<!-- inline scripts related to this page -->

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
</body>
</html>
