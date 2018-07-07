
<!-- author: Pankaj sankpal
description: contains tabs ->  activity ,uploads ,notification -->
<!-- -------------------------------------------------------------------------------------------------------- -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Faculty Tpc | HOME</title>
<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- page specific plugin styles -->
		<!-- <link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
		<link rel="stylesheet" href="assets/css/select2.min.css" />
		<link rel="stylesheet" href="assets/css/datepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-editable.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-multiselect.min.css" />
		<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
 -->


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

							<h3>Profile </h3>

	
							<%-- <h2>
								My name is ${sessionScope.name} , I am a  ${sessionScope.roleName} from  ${sessionScope.branch} branch with username  ${sessionScope.userName}
							</h2> --%>
							
							
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="clearfix">
									
							<div class="show">
									<div id="user-profile-2" class="user-profile">
										<div class="tabbable">
											<ul class="nav nav-tabs padding-18">
												
												<li class="active">
													<a href="#activity">
														<i class="orange ace-icon fa fa-wrench bigger-120"></i>
														Activity
													</a>
												</li>

												<li>
													<a href="downloads">
														<i class="blue ace-icon fa fa-upload bigger-120"></i>
														Uploads
													</a>
												</li>
												<li>
													<a href="fnotifications">
														<i class="pink ace-icon fa fa-check bigger-120"></i>
														Notification
													</a>
												</li>
												

											</ul>

											<div class="tab-content no-border padding-24">
												

											
												<div id="activity" class="tab-pane in active">
													
												
													
															<!-- PAGE CONTENT BEGINS -->
													<div class="row ">
														<div class="col-xs-12 col-sm-4 left">
																	
														  	<a href="AssignTPCF.html"  class="btn btn-primary btn-lg btn-block">Assign Student TPC</a> <br> <br>
															<a href="searchHome"   class="btn btn-purple btn-lg btn-block">Search for Students/Company </a> <br><br>															
															<a href="SearchApplicant"  class="btn btn-inverse btn-lg btn-block">Search Applicants </a><br><br>
															
													
															<button data-toggle="dropdown" class="btn btn-pink btn-lg  dropdown-toggle btn-block">
																								Send E-mail
																<i class="ace-icon fa fa-angle-down icon-on-right"></i>
															</button> <br><br>
															<ul class="dropdown-menu dropdown-pink dropdown-menu-right">
																<li>
																	<a href="GroupSendMail">send to Group</a>
																</li>
			
																<li>
																	<a href="personalMail">send to individual</a>
																</li>
															
															</ul>
														</div>
														
														<div class="col-xs-12 col-sm-4 right">
																	
														  	<a href="RemoveTPCF.html"  class="btn btn-primary btn-lg btn-block">Remove Student Tpc </a> <br> <br>

															<!-- <a href="InsertMonth.html"  class="btn btn-purple btn-lg btn-block">View Events in a month </a> <br><br>
															<a href="counselingReportUpload"  class="btn btn-pink btn-lg btn-block">Counseling Report Upload</a><br><br>
															<a href="viewAllotment"  class="btn btn-inverse btn-lg btn-block">View Allotment</a>
															<a href="ViewEvents"  class="btn btn-purple btn-lg btn-block">View Events in a month </a> <br><br> -->
			
															<a href="counselingReportUpload"  class="btn btn-pink btn-lg btn-block">Counseling Report Upload</a> <br><br>
															<a href="addAllotment"  class="btn btn-inverse btn-lg btn-block">Room Allotment</a><br><br>
                                                            <a href="addH"   class="btn btn-purple btn-lg btn-block">Details of Students for Placement Statistics </a> <br><br>															
                                                            
														</div>
														
														<!-- <div class="col-xs-12 col-sm-8">
														</div> -->
														
														
													</div>
													
													
															

												</div><!-- /#activity -->

												<div id="notification" class="tab-pane">
													
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

												</div>
												
											</div><!-- /#notification -->
											</div>
										</div>
									</div>
								</div>

						
								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
						
<jsp:directive.include file="Footer.jsp" />
<jsp:directive.include file="scripts.jsp" />
					</div><!-- /.page-content -->
				</div>
			
</div>
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>
	
	
	<!-- 	<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.gritter.min.js"></script>
		<script src="assets/js/moment.min.js"></script>
		
		<script src="assets/js/bootbox.min.js"></script>
		<script src="assets/js/jquery.easypiechart.min.js"></script>
		
		<script src="assets/js/jquery.hotkeys.min.js"></script>
		<script src="assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="assets/js/select2.min.js"></script>
		<script src="assets/js/fuelux.spinner.min.js"></script>
		<script src="assets/js/bootstrap-editable.min.js"></script>
		<script src="assets/js/ace-editable.min.js"></script>
		<script src="assets/js/jquery.maskedinput.min.js"></script>
		<script src="assets/js/jquery.autosize.min.js"></script>
		<script src="assets/js/bootstrap-multiselect.min.js"></script>
		<script src="assets/js/jquery-ui.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>

		page specific plugin scripts
		
		
		ace scripts
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
 -->

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
		
		<script type="text/css">
		.box{
				display: none;
			}
		</script>
		<script type="text/javascript">
		
	/*** script for show /hide of addtpc section*/
		 $(document).ready(function(){
			$('input[type="radio"]').click(function(){
				if($(this).attr("value")=="faculty"){
					$(".box").not(".faculty").hide('fast');
					$(".faculty").show('slow');
				}
				if($(this).attr("value")=="student"){
					$(".box").not(".student").hide('fast');
					$(".student").show('slow');
				}
			});
		}); 
		
			jQuery(function($) {

/* initialize the external events
	-----------------------------------------------------------------*/

	$('#external-events div.external-event').each(function() {

		// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
		// it doesn't need to have a start or end
		var eventObject = {
			title: $.trim($(this).text()) // use the element's text as the event title
		};

		// store the Event Object in the DOM element so we can get to it later
		$(this).data('eventObject', eventObject);

		// make the event draggable using jQuery UI
		$(this).draggable({
			zIndex: 999,
			revert: true,      // will cause the event to go back to its
			revertDuration: 0  //  original position after the drag
		});
		
	});
	
	/*** FOR DRAG AND DROP functionality *********************/
	$('#id-input-file-3').ace_file_input({
					style:'well',
					btn_choose:'Drop Reference material if any or click to choose',
					btn_change:null,
					no_icon:'ace-icon fa fa-cloud-upload',
					droppable:true,
					thumbnail:'small'//large | fit
					//,icon_remove:null//set null, to hide remove/reset button
					/**,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					}*/
					/**,before_remove : function() {
						return true;
					}*/
					,
					preview_error : function(filename, error_code) {
						//name of the file that failed
						//error_code values
						//1 = 'FILE_LOAD_FAILED',
						//2 = 'IMAGE_LOAD_FAILED',
						//3 = 'THUMBNAIL_FAILED'
						//alert(error_code);
					}
			
				}).on('change', function(){
					//console.log($(this).data('ace_input_files'));
					//console.log($(this).data('ace_input_method'));
				});


/**  for increasing the size of text area automatically************/
		$('textarea[class*=autosize]').autosize({append: "\n"});

/*  use for Multiselecting the inputs*/
		$('.multiselect').multiselect({
						 enableFiltering: true,
						 buttonClass: 'btn btn-white btn-primary',
						 templates: {
							button: '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"></button>',
							ul: '<ul class="multiselect-container dropdown-menu"></ul>',
							filter: '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
							filterClearBtn: '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
							li: '<li><a href="javascript:void(0);"><label></label></a></li>',
							divider: '<li class="multiselect-item divider"></li>',
							liGroup: '<li class="multiselect-item group"><label class="multiselect-group"></label></li>'
						 }
							});

		
	/* initialize the calendar
	-----------------------------------------------------------------*/

	var date = new Date();
	var d = date.getDate();
	var m = date.getMonth();
	var y = date.getFullYear();


	var calendar = $('#calendar').fullCalendar({
		//isRTL: true,
		 buttonHtml: {
			prev: '<i class="ace-icon fa fa-chevron-left"></i>',
			next: '<i class="ace-icon fa fa-chevron-right"></i>'
		},
	
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay'
		},
		events: [
		  {
			title: 'All Day Event',
			start: new Date(y, m, 1),
			className: 'label-important'
		  },
		  {
			title: 'Long Event',
			start: moment().subtract(5, 'days').format('YYYY-MM-DD'),
			end: moment().subtract(1, 'days').format('YYYY-MM-DD'),
			className: 'label-success'
		  },
		  {
			title: 'Some Event',
			start: new Date(y, m, d-3, 16, 0),
			allDay: false,
			className: 'label-info'
		  }
		]
		,
		editable: true,
		droppable: true, // this allows things to be dropped onto the calendar !!!
		drop: function(date, allDay) { // this function is called when something is dropped
		
			// retrieve the dropped element's stored Event Object
			var originalEventObject = $(this).data('eventObject');
			var $extraEventClass = $(this).attr('data-class');
			
			
			// we need to copy it, so that multiple events don't have a reference to the same object
			var copiedEventObject = $.extend({}, originalEventObject);
			
			// assign it the date that was reported
			copiedEventObject.start = date;
			copiedEventObject.allDay = allDay;
			if($extraEventClass) copiedEventObject['className'] = [$extraEventClass];
			
			// render the event on the calendar
			// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
			$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
			
			// is the "remove after drop" checkbox checked?
			if ($('#drop-remove').is(':checked')) {
				// if so, remove the element from the "Draggable Events" list
				$(this).remove();
			}
			
		}
		,
		selectable: true,
		selectHelper: true,
		select: function(start, end, allDay) {
			
			bootbox.prompt("New Event Title:", function(title) {
				if (title !== null) {
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							start: start,
							end: end,
							allDay: allDay,
							className: 'label-info'
						},
						true // make the event "stick"
					);
				}
			});
			

			calendar.fullCalendar('unselect');
		}
		,
		eventClick: function(calEvent, jsEvent, view) {

			//display a modal
			var modal = 
			'<div class="modal fade">\
			  <div class="modal-dialog">\
			   <div class="modal-content">\
				 <div class="modal-body">\
				   <button type="button" class="close" data-dismiss="modal" style="margin-top:-10px;">&times;</button>\
				   <form class="no-margin">\
					  <label>Change event name &nbsp;</label>\
					  <input class="middle" autocomplete="off" type="text" value="' + calEvent.title + '" />\
					 <button type="submit" class="btn btn-sm btn-success"><i class="ace-icon fa fa-check"></i> Save</button>\
				   </form>\
				 </div>\
				 <div class="modal-footer">\
					<button type="button" class="btn btn-sm btn-danger" data-action="delete"><i class="ace-icon fa fa-trash-o"></i> Delete Event</button>\
					<button type="button" class="btn btn-sm" data-dismiss="modal"><i class="ace-icon fa fa-times"></i> Cancel</button>\
				 </div>\
			  </div>\
			 </div>\
			</div>';
		
		
			var modal = $(modal).appendTo('body');
			modal.find('form').on('submit', function(ev){
				ev.preventDefault();

				calEvent.title = $(this).find("input[type=text]").val();
				calendar.fullCalendar('updateEvent', calEvent);
				modal.modal("hide");
			});
			modal.find('button[data-action=delete]').on('click', function() {
				calendar.fullCalendar('removeEvents' , function(ev){
					return (ev._id == calEvent._id);
				})
				modal.modal("hide");
			});
			
			modal.modal('show').on('hidden', function(){
				modal.remove();
			});


			//console.log(calEvent.id);
			//console.log(jsEvent);
			//console.log(view);

			// change the border color just for fun
			//$(this).css('border-color', 'red');

		}
		
	});


})
		</script>
	
	
	<!--script for changing the profile image and model for buttons -->
	<script>
		
		$('#id-input-file-1 , #id-input-file-2').ace_file_input({
					no_file:'Upload Correspondance file ...',
					btn_choose:'Choose',
					btn_change:'Change',
					droppable:false,
					onchange:null,
					thumbnail:false //| true | large
					//whitelist:'gif|png|jpg|jpeg'
					//blacklist:'exe|php'
					//onchange:''
					//
				});

		
		//override dialog's title function to allow for HTML titles
				$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
					_title: function(title) {
						var $title = this.options.title || '&nbsp;'
						if( ("title_html" in this.options) && this.options.title_html == true )
							title.html($title);
						else title.text($title);
					}
				}));

				$( "#id-btn-dialog1" ).on('click', function(e) {
							e.preventDefault();
					
							var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
								modal: true,
								title: "<div class='widget-header widget-header-large'><h4 class='smaller'><i class='ace-icon fa fa-check'></i> Details of Candidates applied for Placement.</h4></div>",
								title_html: true,
								buttons: [ 
									{
										text: "Cancel",
										"class" : "btn btn-minier",
										click: function() {
											$( this ).dialog( "close" ); 
										} 
									},
									{
										text: "OK",
										"class" : "btn btn-primary btn-minier",
										click: function() {
											$( this ).dialog( "close" ); 
										} 
									}
								]
							});
					
							/**
							dialog.data( "uiDialog" )._title = function(title) {
								title.html( this.options.title );
							};
							**/
						});

		
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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT> -->

<title>Faculty TPC</title>

</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<h3>
		Welcome To the FacultyTPC page !!!!!



<!-- page specific plugin styles -->
		<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
		<link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
		<link rel="stylesheet" href="assets/css/select2.min.css" />
		<link rel="stylesheet" href="assets/css/datepicker.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-editable.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-multiselect.min.css" />
		<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
</head>


<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	
<jsp:directive.include file="Header.jsp" />
	<h3>
		Welcome To the FacultyTPC page !!!!!
		<core:out value="${loginForm.userName}" />
>>>>>>> b7b36101e47e911950c6d7a25fec6a70290a825f
	</h3>

	<h2>
		Logged in as
		<core:out value="${loginForm.userName}" />
	</h2>
	<br />
	<br />

	
	<!-- commented by @Crystal -->
	<%-- <form:form action="notify" commandName="notify">	

	<form:form action="notify" commandName="notify">

		<table>
			<tr>
				<td>Roll No:<FONT color="red"> <form:errors
							path="userName" /></FONT></td>
			</tr>
			<tr>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Notify" /></td>
			</tr>
		</table>

	</form:form> --%>
	<%--

	</form:form>


	<br />
	<br />
	<!-- <a href="StudentTPC.jsp">Student</a> -->

	<!-- <h2><a href="addAllotment">
	<button>Allot New Room </button>
	</a></h2>
	
	<h2><a href="viewAllotment">
	<button>View Allotment List </button>
	</a></h2> -->
	<table>
		<tr>
			<td><a href="AssignTPCF.html">Assign Student TPC</a></td>
		</tr>
		<tr>
			<td><a href="RemoveTPCF.html">Remove Student TPC</a></td>
		</tr>
		<tr>
			<td><a href="ViewUsersF.html">View Users</a></td>
		</tr>
		<tr>
			<td><a href="InsertMonth.html">Insert Month to view
					Events Users</a><br /></td>
		</tr>
		<tr>
			<td><a href="searchHome">Click here to search for something</a></td>
		</tr>
		<tr>
			<td><a href="sendMail">Click here to send an email</a></td>
		</tr>
		<tr>
			<td><a href="addAllotment">Add Room Allotment</a></td>
		</tr>
		<tr>
			<td><a href="viewAllotment">View Room Allotment</a></td>
		</tr>
		<tr>
			<td><a href="form">Logout</a></td>
		</tr>
	</table>
</body>
</html>


 --%>
