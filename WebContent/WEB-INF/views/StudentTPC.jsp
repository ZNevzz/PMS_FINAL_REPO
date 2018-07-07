<!-- author: Pankaj sankpal
description: contain ALL professional and personal details of STUDENT tpc -->
<!-- -------------------------------------------------------------------------------------------------------- -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student TPC| HOME</title>

<!-- page specific plugin styles -->

		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
		
		<link rel="stylesheet" href="assets/css/bootstrap-editable.min.css" />
<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/dropzone.min.css" />
		<!-- page specific plugin styles -->
		
		<link rel="stylesheet" href="assets/css/fullcalendar.min.css" />
		
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
							<h1>
								Welcome , ${sessionScope.name} !
								
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
													<a data-toggle="tab" href="viewprofile">
														<i class="green ace-icon fa fa-user bigger-120"></i>
														Profile
													</a>
												</li>
												

												<li>
													<a  href="displist">
														<i class="orange ace-icon fa fa-upload bigger-120"></i>
														Uploads
													</a>
												</li>

												
												<li>
													<a href="StuNoti">
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

																<a href="edit"><span class="btn btn-md btn-block btn-pink">click here to edit your profile </span></a>
															
														</div><!-- /.col -->

														<div class="col-xs-12 col-sm-9">
															<h4 class="blue">
																

																<span class="label label-purple arrowed-in-right">
																	<i class="ace-icon fa fa-circle smaller-80 align-middle"></i>
																	online
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
												
												<!-- <div id="activity" class="tab-pane">
												
													<div class="row">
														<div class="col-xs-12">
															PAGE CONTENT BEGINS
															<div class="clearfix">
															
																	<div class="row">
																	<div class="col-xs-12 ">
																	<div class="widget-box">
																	<div class="widget-body">
																	 <div class="widget-main" align="center">
																		<div>
																				<div class="profile-feed row">
																					<button type="button" class="btn btn-md btn-primary" data-toggle="model" dats-target="myModel"><i class="ace-icon fa fa-group-o"></i> Apply on behalf of student..</button>
																				</div>
																				<br>
																				<table>
																			
																				
																				<tr>
																					<td>Links for Quick Access</td>
																				</tr>
																				<tr>
																					<td>1. <a href="resumeUpload">Upload Resume</a></td></tr>
																			    <tr>
																					<td>2. <a href="viewResumes">Click to View/Download Resume</a></td>	</tr>
																				<tr>
																					<td>3.<a  href="certificateUpload">Click to upload Certificates </a></td>
																				</tr>
																				
																				<tr>
																					<td>4.<a href="addFeedback">Give a Feedback</a><br/></td>
																				</tr>
																				<tr>
																					<td>5. <a href="InsertMonth.html"> Click to View Events in that month </a></td>
																				</tr>
																				
																				<tr>
																					<td>6. <a href="offerLetterUpload">Click to Upload Offer Letter </a></td>
																				</tr>
																				
																				<tr>
																					<td>7. <a href="counselingReportUpload">Click here to upload Counseling Report</a></td>
																				</tr>
																				<tr>
			<td><a href="getjob">click here to apply for job</a><br /></td>
		</tr>
																				</table>
																				
																			
																			<br><br>
																		</div>
																		</div>
																		</div>
																		</div>
																		<br><br>
																	</div>
							
																	
																</div>
																	
															
															
															</div>
														</div>
													</div>
													
												</div>	
												 -->
												 
												 
												<!-- <div id="uploads" class="tab-pane">
													<div class="profile-feed row">
														<div class="row">
															<div class="col-xs-12">
																PAGE CONTENT BEGINS
																
																	<div class="widget-box widget-color-green2">
																		<div class="widget-header">
																			<h4 class="widget-title lighter smaller">Browse Files</h4>
																		</div>
							
																		<div class="widget-body">
																			<div class="widget-main padding-8">
																				<ul id="tree2"></ul>
																			</div>
																			
																			<button class="btn btn-md btn-block btn-primary pull-right">
																			<span class="bigger-110">Upload</span>
		
																			<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
																		</button>
																		</div>
																		
																	</div>
																	
																
															</div>/.col
														</div>/.row
					
													
													</div>/.row

													<div class="space-12"></div>

												</div>/#feed
 -->
 
 
												<!-- <div id="notificatn" class="tab-pane">
													
													<div class="col-xs-10 widget-container-col">
														
															<div class="widget-box">
															<div class="widget-header widget-header-large">
																<h4 class="widget-title">Job News</h4>

																<div class="widget-toolbar">
																	<a href="#" data-action="settings">
																		<i class="ace-icon fa fa-cog"></i>
																	</a>

																	<a href="#" data-action="reload">
																		<i class="ace-icon fa fa-refresh"></i>
																	</a>

																	<a href="#" data-action="collapse">
																		<i class="ace-icon fa fa-chevron-up"></i>
																	</a>

																	<a href="#" data-action="close">
																		<i class="ace-icon fa fa-times"></i>
																	</a>
																</div>
															</div>

															<div class="widget-body">
																<div class="widget-main padding-4 scrollable" data-size="200">
																	
																	<p class="alert alert-info">
																		TCS Mock Interviews..
																	</p>
																	<p class="alert alert-danger">
																		TCS Pre-placement talk..
																	</p>
																	<p class="alert alert-success">
																		Jp Morgan CODE FOR GOOD Registration.<t>25th march 2016</t>
																	</p>
																	<p class="alert alert-primary">
																		Aptitude test for all BE student.<t></t>22nd may 2016
																	</p>
																
																
															</div>
															
															</div>
															
														</div>
												</div>
													PAGE CONTENT ENDS
														

												</div>/#friends

 -->
							
											</div><!-- /#pictures -->
											</div>
										</div>
									</div>
								</div>

						
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			
<jsp:directive.include file="Footer.jsp" />
<jsp:directive.include file="scripts.jsp" />
	

		<!-- page specific plugin scripts -->
		<script src="assets/js/fuelux.tree.min.js"></script>
		
		<script src="assets/js/dropzone.min.js"></script>
		<!--[if lte IE 8]>
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
		
		<script type="text/javascript">
			jQuery(function($) {

				var sampleData = initiateDemoData();//see below
				
				
				$('#tree2').ace_tree({
					dataSource: sampleData['dataSource2'] ,
					loadingHTML:'<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
					'open-icon' : 'ace-icon fa fa-folder-open',
					'close-icon' : 'ace-icon fa fa-folder',
					'selectable' : false,
					multiSelect: false,
					'selected-icon' : null,
					'unselected-icon' : null
				});

				function initiateDemoData(){
					
					var tree_data_2 = {
							'marksheets' : {text: 'Marksheets', type: 'folder', 'icon-class':'red'}	,
							'resume' : {text: 'Resumes', type: 'folder', 'icon-class':'orange'}	,
							
						}
						tree_data_2['resume']['additionalParameters'] = {
							'children' : [
								{text: '<i class="ace-icon fa fa-file-text blue"></i> resume1.doc', type: 'item'},
								{text: '<i class="ace-icon fa fa-file-text blue"></i> TCS resume.doc', type: 'item'},
								
							]
						}
						/* tree_data_2['video']['additionalParameters'] = {
							'children' : [
								{text: '<i class="ace-icon fa fa-film blue"></i> movie1.avi', type: 'item'},
								{text: '<i class="ace-icon fa fa-film blue"></i> movie2.avi', type: 'item'},
								{text: '<i class="ace-icon fa fa-film blue"></i> movie3.avi', type: 'item'},
								{text: '<i class="ace-icon fa fa-film blue"></i> movie4.avi', type: 'item'},
								{text: '<i class="ace-icon fa fa-film blue"></i> movie5.avi', type: 'item'}
							]
						} */
						tree_data_2['marksheets']['additionalParameters'] = {
							'children' : {
								'ssc' : {text: 'SSC', type: 'folder', 'icon-class':'pink'} , 
								'hsc' : {text: 'HSC', type: 'folder', 'icon-class':'pink'}, 
								'sem1' : {text: 'sem_1', type: 'folder', 'icon-class':'pink'},
								'sem3' : {text: 'sem_3', type: 'folder', 'icon-class':'pink'},
								'sem6' : {text: 'sem_6', type: 'folder', 'icon-class':'pink'}
							}
						}
						tree_data_2['marksheets']['additionalParameters']['children']['ssc']['additionalParameters'] = {
							'children' : [
								{text: '<i class="ace-icon fa fa-file-text green"></i> sample1.pdf <a href="#">download</a>', type: 'item'},
								{text: '<i class="ace-icon fa fa-file-text green"></i>sample2.pdf', type: 'item'},
								
							]
						}
						tree_data_2['marksheets']['additionalParameters']['children']['hsc']['additionalParameters'] = {
							'children' : [
								{text: '<i class="ace-icon fa  fa-file-text red"></i> doc1', type: 'item'},
								{text: '<i class="ace-icon fa fa-file-text grey"></i> doc2', type: 'item'},
								
							]
						}

/* 
						tree_data_2['documents']['additionalParameters'] = {
							'children' : [
								{text: '<i class="ace-icon fa fa-file-text red"></i> document1.pdf', type: 'item'},
								{text: '<i class="ace-icon fa fa-file-text grey"></i> document2.doc', type: 'item'},
								{text: '<i class="ace-icon fa fa-file-text grey"></i> document3.doc', type: 'item'},
								{text: '<i class="ace-icon fa fa-file-text red"></i> document4.pdf', type: 'item'},
								{text: '<i class="ace-icon fa fa-file-text grey"></i> document5.doc', type: 'item'}
							]
						}

						tree_data_2['backup']['additionalParameters'] = {
							'children' : [
								{text: '<i class="ace-icon fa fa-archive brown"></i> backup1.zip', type: 'item'},
								{text: '<i class="ace-icon fa fa-archive brown"></i> backup2.zip', type: 'item'},
								{text: '<i class="ace-icon fa fa-archive brown"></i> backup3.zip', type: 'item'},
								{text: '<i class="ace-icon fa fa-archive brown"></i> backup4.zip', type: 'item'}
							]
						} */
						var dataSource2 = function(options, callback){
							var $data = null
							if(!("text" in options) && !("type" in options)){
								$data = tree_data_2;//the root tree
								callback({ data: $data });
								return;
							}
							else if("type" in options && options.type == "folder") {
								if("additionalParameters" in options && "children" in options.additionalParameters)
									$data = options.additionalParameters.children || {};
								else $data = {}//no data
							}
							
							if($data != null)//this setTimeout is only for mimicking some random delay
								setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

							//we have used static data here
							//but you can retrieve your data dynamically from a server using ajax call
							//checkout examples/treeview.html and examples/treeview.js for more info
						}

						
						return { 'dataSource2' : dataSource2}

				}




})
		</script>
	
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


<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>StudentTPC</title>
</head>

<body>	
	
	<h3>Welcome  ${sessionScope.name}To the profile page </h3>
	
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
			<td><a href="getjob">click here to apply for job</a><br /></td>
		</tr>
		
		<tr>
			<td><a href="logged-out">Logout</a></td>
		</tr>
		<tr>
			<td><a href="ftpcapplies">apply on behalf of student</a></td>
		</tr>
	</table>

</body>
</html>  --%>