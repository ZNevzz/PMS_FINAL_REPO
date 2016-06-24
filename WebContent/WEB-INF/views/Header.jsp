
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>  -->



</head>

<body onload="" class="skin-3 no-skin">
	<jsp:directive.include file="scripts.jsp" />
	
	<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container " id="navbar-container">
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<div class="navbar-header navbar-green pull-left">
					<a href="#" class="navbar-brand">
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
		
		<!-- basic scripts -->
		<jsp:directive.include file="sidebar.jsp" />
		
		
</body>

</html>

