<!-- author: Pankaj sankpal
description: contain notification received by student and student tpc -->
<!-- -------------------------------------------------------------------------------------------------------- -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Faculty Notification</title>

<!-- page specific plugin styles -->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
		
		<link rel="stylesheet" href="assets/css/bootstrap-editable.min.css" />

		
</head>
<body onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">

<jsp:directive.include file="Header.jsp" />

<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />
			</div>

					<div class="page-content">
						
						<div class="page-header">
							<h1>

								Welcome , ${sessionScope.name} !

							</h1>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="clearfix">
									
								</div>

								<!-- <div class="hr dotted"></div> -->

							<div class="show">
									<div id="user-profile-2" class="user-profile">
										<div class="tabbable">
										<c:if test="${sessionScope.roleName=='FacultyTPC'}">
											<ul class="nav nav-tabs padding-18">
												<ul class="nav nav-tabs padding-18">
												<li>
													<a  href="viewprofile">
														<i class="orange ace-icon fa fa-wrench bigger-120"></i>
														Activity
													</a>
												</li>
												
												<li>
													<a  href="downloads">
														<i class="blue ace-icon fa fa-upload bigger-120"></i>
														Uploads
													</a>
												</li>

												
												<li  class="active">
													<a data-toggle="tab" href="#notificatn">
														<i class="pink ace-icon fa fa-check bigger-120"></i>
														Notification
													</a>
												</li>

											</ul>
											</ul>
										</c:if>
											<div class="tab-content no-border padding-24" >
												
												<div id="notificatn" class="tab-pane in active">
													
													<div class="col-xs-15 widget-container-col">
														
															<div class="widget-box">
															<div class="widget-header widget-header-large">
																<h4 class="widget-title">Latest notifications</h4>
						
															</div>
													<div class="widget-body">
																<div class="widget-main padding-4 scrollable" data-size="400">		
													
													
													
															
															<c:if test="${!empty nf}"><c:forEach items="${nf}" var="a">
															
															
																<div class="message-item message-unread">
																	<i class="ace-icon fa fa-bell-o"></i>
																	<p class="sender">${a.category}</p>
																	<br/>
																	
																																		
																	<p class="">
																	<i class="ace-icon glyphicon glyphicon-time"></i>
																	${a.dateTime}
																	</p>
																																	
																	<a href="${a.url}">																	
																	<i class="ace-icon fa fa-envelope-o"></i>
																		<span class="text">
																		
																			${a.message}
																		</span>
																	
																	</a>
																</div>
																
															</c:forEach></c:if>
																
															

												</div>
										</div>
										</div>
										</div>
													
													
													
													<%--
															<div class="widget-body">
																<div class="widget-main padding-4 scrollable" data-size="400">
																	
																	<c:if test="${!empty nf}">

 
 																		<c:forEach items="${nf}" var="a">
 																		<p class="alert alert-info">
 																		      
 																		<a href="${a.url}" style="text-decoration: none;">
 																		<strong>
 																		${a.dateTime}
 																		</strong>																	      
 																<%-- 		${a.type} Notification for ${a.userOrGroupId}:--%><br/><%--
 																		${a.message}<br/>
 																		</a><br/><br/>
 																		</c:forEach>
 																		</p>
 																	</c:if>
															
																</div>
															</div>
															
														</div>
													</div>
													
													 --%>
													
													
													
													
													
													
											
															<!-- PAGE CONTENT BEGINS -->
															<!-- <div class="row">
																<div class="col-sm-9">
																	<div class="space"></div>

																	<div id="calendar"></div>
																</div>

															</div> -->  <!-- end of calander -->

															<!-- PAGE CONTENT ENDS -->
														

												</div><!-- /#friends -->


							
											</div><!-- /#pictures -->
											</div>
										</div>
									</div>
								</div>

						
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
							<jsp:directive.include file="Footer.jsp" />
<jsp:directive.include file="scripts.jsp" />
	
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			


		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.gritter.min.js"></script>
		<script src="assets/js/moment.min.js"></script>
		<script src="assets/js/fullcalendar.min.js"></script>
		<script src="assets/js/bootbox.min.js"></script>
		<script src="assets/js/jquery.easypiechart.min.js"></script>
		<script src="assets/js/bootstrap-datepicker.min.js"></script>
		<script src="assets/js/jquery.hotkeys.min.js"></script>
		<script src="assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="assets/js/select2.min.js"></script>
		<script src="assets/js/fuelux.spinner.min.js"></script>
		<script src="assets/js/bootstrap-editable.min.js"></script>
		<script src="assets/js/ace-editable.min.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
				
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
			<script type="text/javascript">
			jQuery(function($) {
			
			
			
			
				// scrollables
				$('.scrollable').each(function () {
					var $this = $(this);
					$(this).ace_scroll({
						size: $this.attr('data-size') || 150,
						//styleClass: 'scroll-left scroll-margin scroll-thin scroll-dark scroll-light no-track scroll-visible'
					});
				});
				
			
			
			});
		</script>
		
		
</body>
</html>


