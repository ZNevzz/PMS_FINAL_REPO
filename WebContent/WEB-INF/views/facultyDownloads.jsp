<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<title>Downloads</title>



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
										<li><a href="viewprofile"> <i
												class="orange ace-icon fa fa-wrench bigger-120"></i> Activity
										</a></li>

										<li class="active"><a href="#uploads"> <i
												class="blue ace-icon fa fa-upload bigger-120"></i> Uploads
										</a></li>
										<li>
											<a href="fnotifications">
												<i class="pink ace-icon fa fa-check bigger-120"></i>
												Notification
											</a>
										</li>


									</ul>

									<div class="tab-content no-border padding-24">


										<div id="uploads" class="tab-pane in active">
											<div class="row">
												<div class="col-xs-12 ">
													<div class="widget-box">
														<div class="widget-body">
															<div class="widget-main" align="center">
																<div>
																	<h2>Get students Documents...!</h2>
																	

																		Student Rollno: <input id="userID" type="text"
																			name="userId" required><br>
																		<br> <button class="btn btn-sm btn-success"
																			onclick="dispFolder()"  >Submit</button>
																	


																	<%-- <c:if test="${not empty list}">
																					</br>pick a folder
																							<ul>
																								<c:forEach var="l" items="${list}">
																									
																									<li><a href="/${pageContext.request.contextPath}/displistoffiles?folder=${l }">${l}</a></li>
																								</c:forEach>
																							</ul>
																					
																						</c:if> --%>

																	<br> <br>
																</div>

																<div id="folders"></div>
																<div id="files"></div>
															</div>
														</div>
													</div>
													<br> <br>
												</div>


											</div>



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
																<%-- <c:forEach var="index" items="${indexList}"><li><a href="${pageContext.request.contextPath}/downloadCounsellingReport?fileName=${actualFileNames[index]}">${nameToDisplay[index]}</a></li></c:forEach> --%>
																<div id="DisplayTree"></div>
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
					
				</div>
				<!-- end of page-content -->

				<jsp:directive.include file="Footer.jsp" />
					<jsp:directive.include file="scripts.jsp" />


			</div>
			<!-- /.main-content-inner-->

		</div>
		<!-- main-content -->




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
		


		

		<!-- inline scripts related to this page -->
		<script type="text/javascript">

		 function x(subfolder){
			// alert("HI  "+ subfolder);
			//var idvalue= $('#userID').val();
			$.ajax({
				url: 'displistoffiles' ,
				data:'folder='+subfolder,
				dataType : 'json',
				success : function(data){
					console.log("inside subfolder...");
					console.log(data.length);
					for (i = 0; i < data.length; i++)
						console.log(data[i]);
					// times = data.length;
					// console.log("times: " + times);
					$('#files').text('');
					$.each(data, function() {
						console.log("print...");
						$('#files').append(
								' <hr> </hr><table><tr><li type="disk"><a href="${pageContext.request.contextPath}/downloadResume?fileName='
										+this.actualFileNames+' ">'+this.nameToDisplay+'</a></li></tr></table>'
								/* '<ol> <li><a href="${pageContext.request.contextPath}/downloadResume?fileName='
									+this.actualFileNames+' ">'+this.nameToDisplay+'</a></li></ol>' */
								);
					});
				}
				
			});
		} 
			
			
			function dispFolder(){
				var idvalue= $('#userID').val();
				$.ajax({
					url: 'dispAllfolder' ,
					data:'userId='+idvalue,
					dataType : 'json',
					success : function(data){
						
						console.log(data.length);
						for (i = 0; i < data.length; i++)
							console.log(data[i]);
						// times = data.length;
						// console.log("times: " + times);
						$('#folders').text('');
						$.each(data, function() {
							console.log("print..."+this.list);
							var folder = this.list;
							console.log('<li><a id ="folderName" onClick="x(\''+folder+'\')">'+ this.list+'</a></li>');
							$('#folders').append(
									'<table> <tr><td><li><a id ="folderName" onClick="x(\''+folder+'\')">'+ this.list+'</a></li></table>'
									);
						});
					}
					
				});
			} 

			

			function displayCRS() {

				$.ajax({
					url : 'dispCounselingReport',
					data : 'folder=Counseling Report-Student',
					dataType : 'json',
					success : function(data) {
						console.log(data.length);
						for (i = 0; i < data.length; i++)
							console.log(data[i]);
						//times = data.length;
						//console.log("times: " + times);
						$('#DisplayTree').text('');
						$.each(data, function() {
							$('#DisplayTree')
									.append(
											'<li><a href="${pageContext.request.contextPath}/downloadCounsellingReport?fileName='
													+ this.actualFileNames
													+ ' "> '
													+ this.nameToDisplay
													+ ' </a></li>');
						});
					}
				});

				//initiateDemoData();
			}

			function displayCRF() {

				$.ajax({
					url : 'dispCounselingReport',
					data : 'folder=Counseling Report-Ftpc',
					dataType : 'json',
					success : function(data) {
						console.log(data.length);
						for (i = 0; i < data.length; i++)
							console.log(data[i]);
						//times = data.length;
						//console.log("times: " + times);
						$('#DisplayTree').text('');
						$.each(data, function() {
							$('#DisplayTree')
									.append(
											'<li><a href="${pageContext.request.contextPath}/downloadCounsellingReport?fileName='
													+ this.actualFileNames
													+ ' "> '
													+ this.nameToDisplay
													+ ' </a></li>');
						});
					}
				});

				//initiateDemoData();
			}

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
					//console.log("inside other fnc: "+ times);
					var tree_data_2 = {

						'marksheets' : {
							text : '<button onClick="displayCRS()">Counseling Report-Student</button>',
							type : 'folder',
							'icon-class' : 'red'
						},

						'resume' : {
							text : '<button onClick="displayCRF()">Counseling Report-faculty</button>',
							type : 'folder',
							'icon-class' : 'orange'
						},

					}

					/*
					<a href="/PMS_v1/dispCounselingReport?folder=Counseling Report-Ftpc">Counseling Report-faculty</a>
					<a href="/PMS_v1/dispCounselingReport?folder=Counseling Report-Student">Counseling Report-Student</a>
					
					tree_data_2['resume']['additionalParameters'] = {
						'children' : [
							{text: '', type: 'item'},

								
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
					/* tree_data_2['marksheets']['additionalParameters'] = {
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
						} else if ("type" in options
								&& options.type == "folder") {
							if ("additionalParameters" in options
									&& "children" in options.additionalParameters)
								$data = options.additionalParameters.children
										|| {};
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

		<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

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

