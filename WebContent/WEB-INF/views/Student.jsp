<!-- author: Pankaj sankpal
description: contains tabs ->  profile,uploads ,notification for student -->
<!-- -------------------------------------------------------------------------------------------------------- -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student | HOME</title>

<!-- page specific plugin styles -->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
		
		
		<link rel="stylesheet" href="assets/css/bootstrap-editable.min.css" />
<!-- page specific plugin styles -->
		
		
		
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
								My Profile
								
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
											<ul class="nav nav-tabs padding-18">
												<ul class="nav nav-tabs padding-18">
												<li class="active">
													<a data-toggle="tab" href="#profile">
														<i class="green ace-icon fa fa-user bigger-120"></i>
														Profile
													</a>
												</li>

												<li>
													<a href="displist">
														<i class="orange ace-icon fa fa-upload bigger-120"></i>
														Uploads
													</a>
												</li>

												
												<li>
													<a  href="notifications">
														<i class="pink ace-icon fa fa-check bigger-120"></i>
														Notification
													</a>
												</li>

											</ul>
											</ul>

											<div class="tab-content no-border padding-24">
												<div id="profile" class="tab-pane in active">
													<div class="row">
														<div class="col-xs-12 col-sm-3 center">
															<span class="profile-picture">
																<img class="editable img-responsive" alt="Alex's Avatar" id="avatar2" src="assets/avatars/profile-pic.jpg" />
															</span>

															
															<div class="space space-4"></div>

																<a href="edit"><span class="btn btn-md btn-block btn-pink">Edit Profile</span></a>
															
														</div><!-- /.col -->

														<div class="col-xs-12 col-sm-9">
														
														
																		
															<h4 class="blue">
					
																<span class="label label-purple arrowed-in-right">
																	<i class="ace-icon fa fa-circle smaller-80 align-middle"></i>
																	${userDetails.currentState}
																</span>
																
															</h4>
					

															<div class="profile-user-info">
																<div class="profile-info-row">
																	<div class="profile-info-name"> Username </div>

																	<div class="profile-info-value">
																		<span><core:out value=" ${sessionScope.name}" /> </span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name">Gender: </div>

																	<div class="profile-info-value">
																		
																		<span><core:out value="${personalProfile.gender}" /> </span>
																		
																	</div>
																</div>
																<div class="profile-info-row">
																	<div class="profile-info-name">Year of Passing: </div>

																	<div class="profile-info-value">
																		
																		<span><core:out value="${professionalProfile.year}" /> </span>
																		
																	</div>
																</div>

																

																<div class="profile-info-row">
																	<div class="profile-info-name"> Branch:   </div>

																	<div class="profile-info-value">
																		<span><core:out value=" ${professionalProfile.branch}" /></span>
																	</div>
																</div>

																<div class="profile-info-row">
																	<div class="profile-info-name"> DOB:  </div>

																	<div class="profile-info-value">
																		<span><core:out value="${personalProfile.dob}" /></span>
																	</div>
																</div>
															</div>

															<div class="hr hr-8 dotted"></div>

															
														</div><!-- /.col -->
													</div><!-- /.row -->

													<div class="space-20"></div>

													<div class="row">
														<div class="col-xs-12 col-sm-6">
															<div class="widget-box transparent">
																<div class="widget-header widget-header-small">
																	<h4 class="widget-title smaller">
																		<i class="ace-icon fa fa-check-square-o bigger-110"></i>
																		Little About Me
																	</h4>
																</div>

																<div class="widget-body">
																	<div class="widget-main">
																		<p>
																			<b>Email id</b> :  ${personalProfile.emailId}
																		</p>
																		<p>
																			<b>Contact No. </b> : ${personalProfile.mobileNo}
																		</p>
																		<p>
																			<b>Correspondance Address</b>: ${personalProfile.correspondenceAddress}
																		</p>
																		<p>
																			<b>Permanent Address</b>: ${personalProfile.permanentAddress}
																		</p>
																		<p>
																			Thanks for visiting my profile.
																		</p>
																	</div>
																</div>
															</div>
														</div>

														<div class="col-xs-12 col-sm-6">
															<div class="widget-box transparent">
																<div class="widget-header widget-header-small header-color-blue2">
																	<h4 class="widget-title smaller">
																		<i class="ace-icon fa fa-lightbulb-o bigger-120"></i>
																		My Professional Details
																	</h4>
																</div>

																<div class="widget-body">
																	<div class="widget-main padding-10">
																		<div class="clearfix">
																			<p> My name is ${sessionScope.name} , I am a  ${sessionScope.roleName} from  ${sessionScope.branch} branch .
																			</p>
																			<div class="hr hr-16"></div>
																			<p>
																				Placement Status: ${professionalProfile.status}
																			</p>
																			<p>
																				FIELDS OF INTEREST:
																									${professionalProfile.fieldOfInterest}
																			</p>
																			<p> ACHIEVEMENTS: ${professionalProfile.achievements}</p>
	
																			<p> PROJECTS Undertaken :
																						${professionalProfile.projects}</p>
																			
																			<p> INTERNSHIPS:${professionalProfile.internships}</p>
																			<p>
																			Co-Curricular Activities :${professionalProfile.coCurricularActivities}
																			</p>	
																			<p>
																				Extar-Curricular Activities :${professionalProfile.extraCurricularActivities}
																			</p>		
																		</div>

																		
																		

																		<div class="profile-skills">
																			
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												
												</div><!-- /#home -->

												
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
			

		
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.gritter.min.js"></script>
		<script src="assets/js/moment.min.js"></script>
		
		
		<script src="assets/js/bootstrap-editable.min.js"></script>
		<script src="assets/js/ace-editable.min.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
				
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->
			
		
	
	<!--script for changing the profile image -->
	<script>
		//another option is using modals
				$('#avatar2').on('click', function(){
					var modal = 
					'<div class="modal fade">\
					  <div class="modal-dialog">\
					   <div class="modal-content">\
						<div class="modal-header">\
							<button type="button" class="close" data-dismiss="modal">&times;</button>\
							<h4 class="blue">Change Avatar</h4>\
						</div>\
						\
						<form class="no-margin">\
						 <div class="modal-body">\
							<div class="space-4"></div>\
							<div style="width:75%;margin-left:12%;"><input type="file" name="file-input" /></div>\
						 </div>\
						\
						 <div class="modal-footer center">\
							<button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> Submit</button>\
							<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> Cancel</button>\
						 </div>\
						</form>\
					  </div>\
					 </div>\
					</div>';
					
					
					var modal = $(modal);
					modal.modal("show").on("hidden", function(){
						modal.remove();
					});
			
					var working = false;
			
					var form = modal.find('form:eq(0)');
					var file = form.find('input[type=file]').eq(0);
					file.ace_file_input({
						style:'well',
						btn_choose:'Click to choose new avatar',
						btn_change:null,
						no_icon:'ace-icon fa fa-picture-o',
						thumbnail:'small',
						before_remove: function() {
							//don't remove/reset files while being uploaded
							return !working;
						},
						allowExt: ['jpg', 'jpeg', 'png', 'gif'],
						allowMime: ['image/jpg', 'image/jpeg', 'image/png', 'image/gif']
					});
			
					form.on('submit', function(){
						if(!file.data('ace_input_files')) return false;
						
						file.ace_file_input('disable');
						form.find('button').attr('disabled', 'disabled');
						form.find('.modal-body').append("<div class='center'><i class='ace-icon fa fa-spinner fa-spin bigger-150 orange'></i></div>");
						
						var deferred = new $.Deferred;
						working = true;
						deferred.done(function() {
							form.find('button').removeAttr('disabled');
							form.find('input[type=file]').ace_file_input('enable');
							form.find('.modal-body > :last-child').remove();
							
							modal.modal("hide");
			
							var thumb = file.next().find('img').data('thumb');
							if(thumb) $('#avatar2').get(0).src = thumb;
			
							working = false;
						});
						
						
						setTimeout(function(){
							deferred.resolve();
						} , parseInt(Math.random() * 800 + 800));
			
						return false;
					});
					
			});
	</script>
</body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Student Profile</title>
</head>

<body>	
	
	<h3>Welcome  ${sessionScope.name} to the profile page </h3>
	
	<h2>
		My name is ${sessionScope.name} , I am a  ${sessionScope.roleName} from  ${sessionScope.branch} branch with username  ${sessionScope.userName}
	</h2>
	<br />
	<p>
	BRANCH:${professionalProfile.branch}
	<br><BR>
	
	GENDER:<BR>
	${personalProfile.gender}<BR><BR>
	
	DATE OF BIRTH:<BR>
	${personalProfile.dob}<BR>
	
	<BR><BR>
	EMAIL : ${personalProfile.emailId}			
	<br><BR>
	
	MOBILE CONTACT:<BR>
	${personalProfile.mobileNo}<BR><BR>
	
	CORRESPONDENCE ADDRESS:<BR>
	${personalProfile.correspondenceAddress}<br><BR>
	
	PERMANENT ADDRESS:<BR>
	${personalProfile.permanentAddress}<br><BR>
	

	YEAR OF PASSING: ${professionalProfile.year}
	<BR><BR>
	
	PLACEMENT STATUS:<BR>
	${professionalProfile.status}<BR><BR>
	
	FIELDS OF INTEREST:<br>
	${professionalProfile.fieldOfInterest}<br><BR>
	
	ACHIEVEMENTS:<br>
	${professionalProfile.achievements}<br><BR>
	
	PROJECTS:<br>
	${professionalProfile.projects}<br><BR>
	
	INTERNSHIPS:<br>
	${professionalProfile.internships}<br><BR>
	
	CO-CURRICULAR ACTIVITIES:<br>
	${professionalProfile.coCurricularActivities}<br><BR>
		
	EXTRA CURRICULAR ACTIVITIES:<br>
	${professionalProfile.extraCurricularActivities}<br><BR>
	
	</p>
	<br>
	<c:if test="${b==true }">
		<p>You have been selected for conselling round</p>
	</c:if>
	<br />
	<table>
		<tr>
			<td><a href="edit">Click here to edit your profile</a></td>
		</tr>
		<tr>
			<td><a href="resumeUpload">Click here to upload Resume</a></td>
		</tr>
		<tr>
			<td><a href="viewResumes">Click here to view/download Resume</a></td>
		</tr>
		
		<tr>
			<td><a href="certificateUpload">Click here to upload certificates!</a></td>
		</tr>
		
		<tr>
			<td><a href="offerLetterUpload">Click here to upload Offer Letter</a></td>
		</tr>
		
		<tr>
			<td><a href="counselingReportUpload">Click here to upload Counseling Report</a></td>
		</tr>
		<tr>
			<td><a href="addFeedback">Click here to give your feedback</a></td>
		</tr>
		<tr>
			<td><a href="searchHome">Click here to search for something</a></td>
		</tr>
		<tr>
			<td><a href="InsertMonth.html">Insert Month to view Events
					Users</a><br /></td>
		</tr>
		<tr>
			<td><a href="getjob">click here to check eligibility</a><br /></td>
		</tr>
                
		<tr>
 			<td><a href="displist">display list</a><br /></td>
 		</tr>
			<tr>
			<td><a href="logged-out">Logout</a></td>
		</tr>

	</table>
</body>
</html>
 --%>
