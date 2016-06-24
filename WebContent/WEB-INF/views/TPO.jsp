

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TPO | HOME</title>



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

					<h1>Welcome ${sessionScope.name} to the profile page</h1>

					<%-- <h2>My name is ${sessionScope.name} , I am a
						${sessionScope.roleName} from ${sessionScope.branch} branch with
						username ${sessionScope.userName}</h2>
					<br />
 --%>

				</div>
				<!-- /.page-header -->

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div class="clearfix"></div>

						<!-- <div class="hr dotted"></div> -->

						<div class="show">
							<div id="user-profile-2" class="user-profile">
								<div class="tabbable">
									<ul class="nav nav-tabs padding-18">
										<li class="active"><a data-toggle="tab" href="#activity">
												<i class="orange ace-icon fa fa-rss bigger-120"></i>
												Activity
										</a></li>	

										<li><a href="downloads"> <i
												class="blue ace-icon fa fa-users bigger-120"></i> Uploads
										</a></li>


									</ul>

									<div class="tab-content no-border padding-24">


										<div id="uploads" class="tab-pane">
											<div class="row">
												<div class="col-xs-12">
													<!-- PAGE CONTENT BEGINS -->

													<div class="widget-box widget-color-green2">
														<div class="widget-header">
															<h4 class="widget-title lighter smaller">Browse
																Files to Download</h4>
														</div>

														<div class="widget-body">
															<div class="widget-main padding-8">
																<ul id="tree2"></ul>
																<c:forEach var="index" items="${indexList}">
																	<li><a
																		href="${pageContext.request.contextPath}/downloadResume?fileName=${actualFileNames[index]}">${nameToDisplay[index]}</a></li>
																</c:forEach>
															</div>

															<!-- <button class="btn btn-md btn-block btn-primary pull-right">
																			<span class="bigger-110">Upload</span>
		
																			<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
																		</button> -->
														</div>

													</div>


												</div>
												<!-- /.col -->
											</div>
											<!-- /.row -->


											<div class="space-12"></div>

										</div>
										<!-- #end of uploads -->



										<div id="activity" class="tab-pane in active">
											<div class="row ">


												<br>

												<div class="col-xs-12 col-sm-4 left">

													<a href="addProfile"
														class="btn btn-purple btn-lg btn-block">Add job
														Profile </a> <br>
													<br> <a href="getEventForm.html"
														class="btn btn-inverse btn-lg btn-block">Add Event </a> <br>
													<br> <a href="addUser"
														class="btn btn-warning btn-lg btn-block">Manage
														Users</a>

												</div>


												&nbsp;&nbsp;
												<div class="col-xs-12 col-sm-4 right">

													<a href="manage.html"
														class="btn btn-purple btn-lg btn-block">Add candidate
													</a> <br>
													<br> <a href="GroupSendMail"
														class="btn btn-inverse btn-lg btn-block">Send Group
														Email </a><br>
													<br> <a href="personalMail"
														class="btn btn-warning btn-lg btn-block">Send Personal
														Email </a><br>
													<br>
												</div>

												<!-- <div class="col-xs-12 col-sm-8 left">
														<a href="addUser"  class="btn btn-warning btn-lg btn-block">Manage different users of System</a> <br><br>	
												</div> -->
											</div>
										</div>
										<!-- /#pictures -->
									</div>




				<!-- page specific plugin scripts -->
		<!-- <script src="assets/js/fuelux.tree.min.js"></script>
		
		<script src="assets/js/dropzone.min.js"></script>
		<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
		<!--<script src="assets/js/jquery-ui.custom.min.js"></script>
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
		<script src="assets/js/jquery.maskedinput.min.js"></script> -->
				
		<!-- ace scripts -->
		<!--<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script> -->


		<!-- page specific plugin scripts -->
		

								</div>
								<!-- end of tabbable -->
							</div>
							<!-- end of user-profile-2 -->
						</div>
						<!-- end of show -->
					</div>
					<!-- /.col -->

				</div>
				<!-- /.row -->

				<jsp:directive.include file="Footer.jsp" />
				<jsp:directive.include file="scripts.jsp" />



			</div>
			<!-- end of page-content -->




		</div>
		<!-- /.main-content-inner-->

	</div>
	<!-- main-content -->


	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>


	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {

			var sampleData = initiateDemoData();//see below

			$('#tree2')
					.ace_tree(
							{
								dataSource : sampleData['dataSource2'],
								loadingHTML : '<div class="tree-loading"><i class="ace-icon fa fa-refresh fa-spin blue"></i></div>',
								'open-icon' : 'ace-icon fa fa-folder-open',
								'close-icon' : 'ace-icon fa fa-folder',
								'selectable' : false,
								multiSelect : false,
								'selected-icon' : null,
								'unselected-icon' : null
							});

			function initiateDemoData() {

				var tree_data_2 = {
					'marksheets' : {
						text : '<a href="${pageContext.request.contextPath}/dispCounselingReport?folder=Counseling Report-Student">Counseling Report-Student</a>',
						type : 'folder',
						'icon-class' : 'red'
					},
					'resume' : {
						text : '<a href="${pageContext.request.contextPath}/dispCounselingReport?folder=Counseling Report-Ftpc">Counseling Report-faculty</a>',
						type : 'folder',
						'icon-class' : 'orange'
					},

				}
				/* tree_data_2['resume']['additionalParameters'] = {
					'children' : [ {
						text : '',
						type : 'item'
					},

					 {text: '<i class="ace-icon fa fa-file-text blue"></i> TCS resume.doc', type: 'item'}, 

					]
				} */
				/* tree_data_2['video']['additionalParameters'] = {
					'children' : [
						{text: '<i class="ace-icon fa fa-film blue"></i> movie1.avi', type: 'item'},
						{text: '<i class="ace-icon fa fa-film blue"></i> movie2.avi', type: 'item'},
						{text: '<i class="ace-icon fa fa-film blue"></i> movie3.avi', type: 'item'},
						{text: '<i class="ace-icon fa fa-film blue"></i> movie4.avi', type: 'item'},
						{text: '<i class="ace-icon fa fa-film blue"></i> movie5.avi', type: 'item'}
					]
				} */
			/*  */
					/* tree_data_2['marksheets']['additionalParameters'] = {
					'children' : {
						'ssc' : {
							text : 'SSC',
							type : 'folder',
							'icon-class' : 'pink'
						},
						'hsc' : {
							text : 'HSC',
							type : 'folder',
							'icon-class' : 'pink'
						},
						'sem1' : {
							text : 'sem_1',
							type : 'folder',
							'icon-class' : 'pink'
						},
						'sem3' : {
							text : 'sem_3',
							type : 'folder',
							'icon-class' : 'pink'
						},
						'sem6' : {
							text : 'sem_6',
							type : 'folder',
							'icon-class' : 'pink'
						}
					}
				}
				tree_data_2['marksheets']['additionalParameters']['children']['ssc']['additionalParameters'] = {
					'children' : [
							{
								text : '<i class="ace-icon fa fa-file-text green"></i> sample1.pdf <a href="#">download</a>',
								type : 'item'
							},
							{
								text : '<i class="ace-icon fa fa-file-text green"></i>sample2.pdf',
								type : 'item'
							},

					]
				}tree_data_2['marksheets']['additionalParameters']['children']['hsc']['additionalParameters'] = {
					'children' : [
							{
								text : '<i class="ace-icon fa  fa-file-text red"></i> doc1',
								type : 'item'
							},
							{
								text : '<i class="ace-icon fa fa-file-text grey"></i> doc2',
								type : 'item'
							},

					]
				} */

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

				var dataSource2 = function(options, callback) {
					var $data = null
					if (!("text" in options) && !("type" in options)) {
						$data = tree_data_2;//the root tree
						callback({
							data : $data
						});
						return;
					} else if ("type" in options && options.type == "folder") {
						if ("additionalParameters" in options
								&& "children" in options.additionalParameters)
							$data = options.additionalParameters.children || {};
						else
							$data = {}//no data
					}

					if ($data != null)//this setTimeout is only for mimicking some random delay
						setTimeout(function() {
							callback({
								data : $data
							});
						}, parseInt(Math.random() * 500) + 200);

					//we have used static data here
					//but you can retrieve your data dynamically from a server using ajax call
					//checkout examples/treeview.html and examples/treeview.js for more info
				}

				return {
					'dataSource2' : dataSource2
				}

			}

		})
	</script>



	<!--script for changing the profile image and model for buttons -->

</body>
</html>





<%--		backend jsp page
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT> -->
<title>TPO</title>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	
	<h3>Welcome  ${sessionScope.name} to the profile page </h3>
	
	<h2>
		My name is ${sessionScope.name} , I am a  ${sessionScope.roleName} from  ${sessionScope.branch} branch with username  ${sessionScope.userName}
	</h2>
	<br />
	
	<table>
		<tr>
			<td><a href="addUser">Click here to Add users via csv file</a></td>
		</tr>
		<tr>
			<td>1. <a href="addstudent.html">Add Student</a></td>
		</tr>
		<tr>
			<td>2. <a href="addfaculty.html">Add Faculty</a></td>
		</tr>
		<tr>
			<td>3. <a href="removeuser.html">Remove User</a></td>
		</tr>
		<tr>
			<td>4. <a href="AssignTPC.html">Assign TPC</a></td>
		</tr>
		<tr>
			<td>5. <a href="RemoveTPC.html">Remove TPC</a></td>
		</tr>
		<tr>
			<td>6. <a href="InsertWork.html">Assign Task</a></td>
		</tr>
		<tr>
			<td>7. <a href="ViewUsersT.html">View Users</a></td>
		</tr>
		<tr>
			<td>8. <a href="ViewFacultyTasks.html">View Faculty Tasks</a></td>
		</tr>
		<tr>
			<td>9.<a href="InsertMonth.html">Insert Month to view Events
					Users</a><br /></td>
		</tr>
		<tr>
			<td>10.<a href="manage.html">Manage List of Applicants of all Companies</a><br /></td>
			<td>10.<a href="view-candidate.html">Manage List of Applicants of all Companies</a><br /></td>
		</tr>
		<tr>
			<td>11.<a href="getEventForm.html">Add Events</a><br /></td>
		</tr>
		
	</table>
	<br />
	<br />
	<table>
		<tr>
			<td><a href="searchHome">Click here to search for something</a></td>
		</tr>
		<tr>
			<td><a href="addProfile">Add JOB POST</a></td>
		</tr>
		<tr>
			<td><a href="viewProfile">View JOB POSTS</a></td>
		</tr>
		
		<tr>
			<td><a href="sendMail">Click here to send an email</a></td>
		</tr>
		<tr>
			<td><a href="logged-out">Logout</a></td>
		</tr>
	</table>
</body>
</html>
 
   --%>

