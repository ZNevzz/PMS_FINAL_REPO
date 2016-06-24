<!-- author: Lenherd Olivera
description: contains all the validations required for every field -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Profile</title>
<!-- page specific plugin styles -->
<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet" href="assets/css/chosen.min.css" />

<link rel="stylesheet" href="assets/css/jquery.gritter.min.css" />
<link rel="stylesheet" href="assets/css/select2.min.css" />
<link rel="stylesheet" href="assets/css/datepicker.min.css" />
<link rel="stylesheet" href="assets/css/bootstrap-editable.min.css" />
<!-- page specific plugin styles -->

<!-- page specific plugin styles -->
<link rel="stylesheet" href="assets/css/jquery-ui.custom.min.css" />
<link rel="stylesheet" href="assets/css/fullcalendar.min.css" />

</head>
<body 	onload="noBack();"
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
						Job Details
					</h1>
					
					<c:if test="${success==1}">
						<p color="blue"><h2>Profile added successfully!!</h2></p>
					</c:if>
					
					<br/>
					<c:if test="${job==1}">
						<p color="green"><h2>Job Details not filled</h2></p>
					</c:if>


				</div>
				<!-- /.page-header -->
				<div class="alert alert-danger">
					<i class="ace-icon fa fa-hand-o-right"></i> Please note: In
					some cases if the values aren't filled or changed, the default values in the
					field will be considered.
					
					<button class="close" data-dismiss="alert">
						<i class="ace-icon fa fa-times"></i>
					</button>
				</div>
				
						<font size="5" color="red" face="verdana">${errorMesg}</font>
				
				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->

						<div>
							<div>
								<div class="tabbable">


									<div class="tab-content no-border padding-24">
										<div id="home" class="tab-pane in active">
										<div  role="form" id="validation-form"  >
											<form  method="post" action="saveProfile">
										
												<div class="col-xs-12">

													<div class="row">
														
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="name">Company Name</label>

															<div class="col-sm-3">
																<div class="clearfix">
																	<select name="company_id" class="chosen-select">
																	<!-- <option ></option>
																		<option value="2">Jp Morgan</option>
																		<option value="4">Direct-I</option>
																		<option value="6">Morgan Stanley</option>
																		<option value="5">Godrej</option>
																		<option value="3">TCS</option>
																		<option value="8">Accenture</option>
																		<option value="7">L&T Infotech</option>
																		<option value="1">ZS</option> -->
																		<c:forEach items="${companies}" var="companies">
                        												<option value="${companies.key}">${companies.value}</option>
                  													</c:forEach>

																	</select>
																</div>

															</div>
														</div>
														
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="documents">Documents Required</label>

															<div class="col-sm-3">
																<div class="inline">
																	<input type="text" name="docs_required" id="form-field-tags2"
																		placeholder="Enter the documents" />
																</div>
															</div>
														</div>
														<div class="form-group">


															<label class="col-sm-1 control-label no-padding-right"
																for="comment1">Job Description</label>
															<div class="col-sm-3">
																<div class="clearfix">
																	<textarea class="autosize-transition form-control"
																		name="job_description" id="comment1"></textarea>
																</div>
															</div>

														</div>

													</div>
													<!-- /.row -->
												</div>
												<div class="col-xs-12">

													<div class="row">
														
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="ctc">C.T.C</label>
															<div class="col-sm-3">
																<div>
																	<input type="text" id="spinner1" name="ctc"/>
																	<div class="space-6"></div>

																</div>
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="skills">Skills Required</label>

															<div class="col-sm-3">
																<div class="inline">
																	<input type="text" name="skills_required" id="form-field-tags"
																		placeholder="Enter the skills" />
																</div>
															</div>
														</div>
														<div class="form-group">


															
															
															
															<label class="col-sm-1 control-label no-padding-right"
																for="jobcategory">Job Category</label>
															<div class="col-sm-2">

																<div>

																	<select name="job_category" class="chosen-select">
																	<option ></option>
																		<option value="Non Dream">NonDream</option>
																		<option value="Dream">Dream</option>
																		<option value="SD">SuperDream</option>

																	</select>
																</div>

															</div>

														</div>



													</div>
													<!-- /.row -->
												</div>

												<div class="col-xs-12">

													<div class="row">
													<div class="form-group">



														</div>
												
														<div class="form-group">

	
														<div class="form-group">


															<label class="col-sm-1 control-label no-padding-right"
																for="drivedate">Drive Date</label>
															<div class="col-sm-3">
																<div class="input-group input-group-sm">
																	<input name="drive_date" type="text" id="datepicker2"
																		class="form-control" /> <span
																		class="input-group-addon"> <i
																		class="ace-icon fa fa-calendar"></i>
																	</span>
													
																</div>

															</div>

														</div>
													</div>
													<!-- /.row -->
												</div>
												<div class="col-xs-12">

													
												<div class="hr hr-8 dotted"></div>
												<div class="page-header">

													<h1>
														Job Criteria
													</h1>

												</div>
												<!-- /.page-header -->
												<div class="col-xs-12">

													<div class="row">
														 <div class="form-group">
														
														</div> 
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="eligiblebranches">Eligible Branches</label>
															<div class="col-sm-4">
																<div>
																	<select name="eligible_branches" class="chosen-select form-control"
																		multiple="Eligible Branches">
																		<option value="CS">Computers</option>
																		<option value="IT">Info.Tech</option>
																		<option value="EX">Electronics</option>
																		<option value="PD">Production</option>

																	</select>
																</div>
															</div>
														</div>
														<div class="form-group">


															<label class="col-sm-1 control-label no-padding-right"
																for="yop">Year of Passing</label>
															<div class="col-sm-4">
																<div>
																	<select class="form-control" id="yop" name="year_of_passing">
																		<option value=""></option>
																		<option value="2017">2017</option>
																		<option value="2018">2018</option>
																		<option value="2019">2019</option>
																		<option value="2020">2020</option>
																		<option value="2021">2021</option>
																		<option value="2022">2022</option>
																		<option value="2023">2023</option>
																		<option value="2024">2024</option>
																	</select>
																</div>
															</div>
														</div>
													</div>
													<!-- /.row_1 -->
												</div>
												<div class="col-xs-12">

													<div class="row">
														<div class="form-group">




															<div class="widget-body">



																<label class="col-sm-1 control-label no-padding-right">HSC
																	Percentage</label>
																<div class="col-sm-2">
																	<div class="knob-container inline">
																		<input type="text" class="input-small knob" value="40"
																			data-min="0" data-max="100" data-step="0.01"
																			data-width="120" data-height="120"
																			data-thickness="0.3" data-fgcolor="#b723df" name="hsc_or_dip_percentage" />
																	</div>

																</div>
																<label class="col-sm-1 control-label no-padding-center">SSC
																	Percentage</label>
																<div class="col-sm-2">

																	<div class="knob-container inline">
																		<input type="text" class="input-small knob" value="40"
																			data-min="0" data-max="100" data-step="0.01"
																			data-width="120" data-height="120"
																			data-thickness=".3" data-fgcolor="#f42458" name="ssc_percentage" />
																	</div>

																</div>

																<label class="col-sm-1 control-label no-padding-right">Percentage</label>
																<div class="col-sm-2">
																	<div class="knob-container inline">
																		<input type="text" class="input-small knob" value="40"
																			data-min="0" data-max="100" data-step="0.01"
																			data-width="120" data-height="120"
																			data-thickness="0.3" data-fgcolor="#2466f4" name="percentage"/>
																	</div>

																</div>
																<label class="col-sm-1 control-label no-padding-center">CGPA</label>
																<div class="col-sm-1">

																	<div class="knob-container inline">
																		<input type="text" class="input-small knob"
																			value="5.0" data-min="0" data-max="10"
																			data-step="0.01" data-width="120" data-height="120"
																			data-thickness=".3" data-fgcolor="#47d05e" name="cgpa"/>
																	</div>

																</div>

															</div>

														</div>

													</div>
													<!-- /.row_1 -->
												</div>

												<div class="col-xs-12">

													<div class="row">
														<div class="form-group">
															<label class="col-sm-1  control-label no-padding-right"
																for="form-field-18">No. Of Year Gaps</label>
															
															<div class="col-sm-3">
																<div>
																	<input name="year_gap_allowed" type="text" id="spinner11" />
																	<div class="space-6"></div>
																</div>
															</div>
															

														</div>
														<div class="form-group">


															<label class="col-sm-1 control-label no-padding-right"
																for="lastdatetoapply">Last Date to Apply</label>
															<div class="col-sm-3">
																<div class="input-group input-group-sm">
																	<input name="last_date_to_apply" type="text" id="datepicker3"
																		class="form-control" /> <span
																		class="input-group-addon"> <i
																		class="ace-icon fa fa-calendar"></i>
																	</span>															
																
																</div>
															</div>

														</div>

													</div>
													<!-- /.row_1 -->
												</div>	
												<div class="col-xs-12">

													<div class="row">
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="form-field-18">Allow already Placed </label>
															<div class="col-sm-3">
																<div>

																<!-- don't add value attribute!  -->
																	<label> <input name="placed_students_allowed"
																		class="ace ace-switch ace-switch-6" type="checkbox"/>

																		<span class="lbl"></span>
																	</label>
																</div>
															</div>

														</div>
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="live">No of live KT's allowed </label>
															<div class="col-sm-3">
																<div>
																	<input name="no_of_live_kts_allowed" type="text" id="spinner11" />
																	<div class="space-6"></div>
																</div>
															</div>

														</div>
														<div class="form-group">
															<label class="col-sm-1 control-label no-padding-right"
																for="dead">No of dead KT's allowed </label>
															<div class="col-sm-3">
																<div>
																	<input name="no_of_dead_kts_allowed" type="text" id="spinner22" />
																	<div class="space-6"></div>
																</div>
															</div>

														</div>

														<div class="clearfix actions">
															
															<div class="col-md-offset-4 col-md-9">
																<button class="btn btn-info btn-next"
																	 type="submit">
																	<i class="ace-icon fa fa-check bigger-110"></i>
																	Submit 
																</button>
																<!-- <input type="submit" value="Submit"> -->

															</div>
														</div>

														<div class="hr hr-8 dotted"></div>
														</div>
											</form>
											</div>

										<!-- /.row_1 -->
									</div>

									<div class="hr hr-8 dotted"></div>

									<div class="space-20"></div>

								</div>
								<!-- /#home -->

							</div>
						</div>
					</div>
				</div>

						
						
						
						
					</div>
				</div>
												


	
		<jsp:directive.include file="scripts.jsp" />
		
	
	
		<!-- /.main-container -->


	<!--[if !IE]> -->
	<script src="assets/js/jquery.2.1.1.min.js"></script>




	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="assets/js/jquery.2.1.1.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery.1.11.1.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->
	<script type="text/javascript">
		window.jQuery
				|| document.write("<script src='assets/js/jquery.min.js'>"
						+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/chosen.jquery.min.js"></script>
	<script src="assets/js/fuelux.spinner.min.js"></script>
	<script src="assets/js/bootstrap-datepicker.min.js"></script>
	<script src="assets/js/bootstrap-timepicker.min.js"></script>
	<script src="assets/js/moment.min.js"></script>
	<script src="assets/js/daterangepicker.min.js"></script>
	<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
	<script src="assets/js/jquery.validate.min.js"></script>

	<script src="assets/js/bootstrap-colorpicker.min.js"></script>
	<script src="assets/js/jquery.knob.min.js"></script>
	<script src="assets/js/jquery.autosize.min.js"></script>
	<script src="assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
	<script src="assets/js/jquery.maskedinput.min.js"></script>
	<script src="assets/js/bootstrap-tag.min.js"></script>

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			$('#id-disable-check').on('click', function() {
				var inp = $('#form-input-readonly').get(0);
				if (inp.hasAttribute('disabled')) {
					inp.setAttribute('readonly', 'true');
					inp.removeAttribute('disabled');
					inp.value = "This text field is readonly!";
				} else {
					inp.setAttribute('disabled', 'disabled');
					inp.removeAttribute('readonly');
					inp.value = "This text field is disabled!";
				}
			});

			if (!ace.vars['touch']) {
				$('.chosen-select').chosen({
					allow_single_deselect : true
				});
				//resize the chosen on window resize

				$(window).off('resize.chosen').on('resize.chosen', function() {
					$('.chosen-select').each(function() {
						var $this = $(this);
						$this.next().css({
							'width' : $this.parent().width()
						});
					})
				}).trigger('resize.chosen');
				//resize chosen on sidebar collapse/expand
				$(document).on('settings.ace.chosen',
						function(e, event_name, event_val) {
							if (event_name != 'sidebar_collapsed')
								return;
							$('.chosen-select').each(function() {
								var $this = $(this);
								$this.next().css({
									'width' : $this.parent().width()
								});
							})
						});

				$('#chosen-multiple-style .btn').on(
						'click',
						function(e) {
							var target = $(this).find('input[type=radio]');
							var which = parseInt(target.val());
							if (which == 2)
								$('#form-field-select-4').addClass(
										'tag-input-style');
							else
								$('#form-field-select-4').removeClass(
										'tag-input-style');
						});
			}

			$('[data-rel=tooltip]').tooltip({
				container : 'body'
			});
			$('[data-rel=popover]').popover({
				container : 'body'
			});

			$('textarea[class*=autosize]').autosize({
				append : "\n"
			});
			$('textarea.limited').inputlimiter({
				remText : '%n character%s remaining...',
				limitText : 'max allowed : %n.'
			});

			$.mask.definitions['~'] = '[+-]';
			$('.input-mask-date').mask('99/99/9999');
			$('.input-mask-phone').mask('(999) 999-9999');
			$('.input-mask-eyescript').mask('~9.99 ~9.99 999');
			$(".input-mask-product").mask("a*-999-a999", {
				placeholder : " ",
				completed : function() {
					alert("You typed the following: " + this.val());
				}
			});

			$("#input-size-slider").css('width', '200px').slider(
					{
						value : 1,
						range : "min",
						min : 1,
						max : 8,
						step : 1,
						slide : function(event, ui) {
							var sizing = [ '', 'input-sm', 'input-lg',
									'input-mini', 'input-small',
									'input-medium', 'input-large',
									'input-xlarge', 'input-xxlarge' ];
							var val = parseInt(ui.value);
							$('#form-field-4').attr('class', sizing[val]).val(
									'.' + sizing[val]);
						}
					});

			$("#input-span-slider").slider(
					{
						value : 1,
						range : "min",
						min : 1,
						max : 12,
						step : 1,
						slide : function(event, ui) {
							var val = parseInt(ui.value);
							$('#form-field-5').attr('class', 'col-xs-' + val)
									.val('.col-xs-' + val);
						}
					});

			//"jQuery UI Slider"
			//range slider tooltip example
			$("#slider-range")
					.css('height', '200px')
					.slider(
							{
								orientation : "vertical",
								range : true,
								min : 0,
								max : 100,
								values : [ 17, 67 ],
								slide : function(event, ui) {
									var val = ui.values[$(ui.handle).index() - 1]
											+ "";

									if (!ui.handle.firstChild) {
										$(
												"<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
												.prependTo(ui.handle);
									}
									$(ui.handle.firstChild).show().children()
											.eq(1).text(val);
								}
							}).find('span.ui-slider-handle').on('blur',
							function() {
								$(this.firstChild).hide();
							});

			$("#slider-range-max").slider({
				range : "max",
				min : 1,
				max : 10,
				value : 2
			});

			$("#slider-eq > span").css({
				width : '90%',
				'float' : 'left',
				margin : '15px'
			}).each(function() {
				// read initial values from markup and remove that
				var value = parseInt($(this).text(), 10);
				$(this).empty().slider({
					value : value,
					range : "min",
					animate : true

				});
			});

			$("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item

			$('#id-input-file-1 , #id-input-file-2').ace_file_input({
				no_file : 'No File ...',
				btn_choose : 'Choose',
				btn_change : 'Change',
				droppable : false,
				onchange : null,
				thumbnail : false
			//| true | large
			//whitelist:'gif|png|jpg|jpeg'
			//blacklist:'exe|php'
			//onchange:''
			//
			});
			//pre-show a file name, for example a previously selected file
			//$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])

			$('#id-input-file-3').ace_file_input({
				style : 'well',
				btn_choose : 'Drop files here or click to choose',
				btn_change : null,
				no_icon : 'ace-icon fa fa-cloud-upload',
				droppable : true,
				thumbnail : 'small'//large | fit
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

			}).on('change', function() {
				//console.log($(this).data('ace_input_files'));
				//console.log($(this).data('ace_input_method'));
			});

			//$('#id-input-file-3')
			//.ace_file_input('show_file_list', [
			//{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
			//{type: 'file', name: 'hello.txt'}
			//]);

			//dynamically change allowed formats by changing allowExt && allowMime function
			$('#id-file-format').removeAttr('checked').on(
					'change',
					function() {
						var whitelist_ext, whitelist_mime;
						var btn_choose
						var no_icon
						if (this.checked) {
							btn_choose = "Drop images here or click to choose";
							no_icon = "ace-icon fa fa-picture-o";

							whitelist_ext = [ "jpeg", "jpg", "png", "gif",
									"bmp" ];
							whitelist_mime = [ "image/jpg", "image/jpeg",
									"image/png", "image/gif", "image/bmp" ];
						} else {
							btn_choose = "Drop files here or click to choose";
							no_icon = "ace-icon fa fa-cloud-upload";

							whitelist_ext = null;//all extensions are acceptable
							whitelist_mime = null;//all mimes are acceptable
						}
						var file_input = $('#id-input-file-3');
						file_input.ace_file_input('update_settings', {
							'btn_choose' : btn_choose,
							'no_icon' : no_icon,
							'allowExt' : whitelist_ext,
							'allowMime' : whitelist_mime
						})
						file_input.ace_file_input('reset_input');

						file_input.off('file.error.ace').on('file.error.ace',
								function(e, info) {
									//console.log(info.file_count);//number of selected files
									//console.log(info.invalid_count);//number of invalid files
									//console.log(info.error_list);//a list of errors in the following format

									//info.error_count['ext']
									//info.error_count['mime']
									//info.error_count['size']

									//info.error_list['ext']  = [list of file names with invalid extension]
									//info.error_list['mime'] = [list of file names with invalid mimetype]
									//info.error_list['size'] = [list of file names with invalid size]

									/**
									if( !info.dropped ) {
										//perhapse reset file field if files have been selected, and there are invalid files among them
										//when files are dropped, only valid files will be added to our file array
										e.preventDefault();//it will rest input
									}
									 */

									//if files have been selected (not dropped), you can choose to reset input
									//because browser keeps all selected files anyway and this cannot be changed
									//we can only reset file field to become empty again
									//on any case you still should check files with your server side script
									//because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
								});

					});

			$('#spinner1').ace_spinner({
				value : 3,
				min : 0,
				max : 25,
				step : 0.1,
				btn_up_class : 'btn-info',
				btn_down_class : 'btn-info'
			}).closest('.ace-spinner').on('changed.fu.spinbox', function() {
				//alert($('#spinner1').val())

			});

			$('#spinner11').ace_spinner({
				value : 0,
				min : 0,
				max : 5,
				step : 1,
				btn_up_class : 'btn-info',
				btn_down_class : 'btn-info'
			}).closest('.ace-spinner').on('changed.fu.spinbox', function() {
				//alert($('#spinner1').val())

			});
			$('#spinner22').ace_spinner({
				value : 1,
				min : 0,
				max : 5,
				step : 1,
				btn_up_class : 'btn-info',
				btn_down_class : 'btn-info'
			}).closest('.ace-spinner').on('changed.fu.spinbox', function() {
				//alert($('#spinner1').val())

			});

			$('#spinner2').ace_spinner({
				value : 1,
				min : 0,
				max : 10000,
				step : 100,
				touch_spinner : true,
				icon_up : 'ace-icon fa fa-caret-up bigger-110',
				icon_down : 'ace-icon fa fa-caret-down bigger-110'
			});
			$('#spinner3').ace_spinner({
				value : 0,
				min : -100,
				max : 100,
				step : 10,
				on_sides : true,
				icon_up : 'ace-icon fa fa-plus bigger-110',
				icon_down : 'ace-icon fa fa-minus bigger-110',
				btn_up_class : 'btn-success',
				btn_down_class : 'btn-danger'
			});
			$('#spinner4').ace_spinner({
				value : 0,
				min : -100,
				max : 100,
				step : 10,
				on_sides : true,
				icon_up : 'ace-icon fa fa-plus',
				icon_down : 'ace-icon fa fa-minus',
				btn_up_class : 'btn-purple',
				btn_down_class : 'btn-purple'
			});

			//$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
			//or
			//$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
			//$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0

			//datepicker plugin
			//link
			$('.date-picker').datepicker({
				autoclose : true,
				todayHighlight : true
			})
			//show datepicker when clicking on the icon
			.next().on(ace.click_event, function() {
				$(this).prev().focus();
			});

			//or change it into a date range picker
			$('.input-daterange').datepicker({
				autoclose : true
			});

			//datepicker1
			$('.date-picker1').datepicker({
				autoclose : true,
				todayHighlight : true
			})
			//show datepicker when clicking on the icon
			.next().on(ace.click_event, function() {
				$(this).prev().focus();
			});

			//or change it into a date range picker
			$('.input-daterange').datepicker({
				autoclose : true
			});

			//datepicker2
			$('.date-picker2').datepicker({
				autoclose : true,
				todayHighlight : true
			})
			//show datepicker when clicking on the icon
			.next().on(ace.click_event, function() {
				$(this).prev().focus();
			});

			//or change it into a date range picker
			$('.input-daterange').datepicker({
				autoclose : true
			});
			//datepicker3
			$('.date-picker3').datepicker({
				autoclose : true,
				todayHighlight : true
			})
			//show datepicker when clicking on the icon
			.next().on(ace.click_event, function() {
				$(this).prev().focus();
			});

			//or change it into a date range picker
			$('.input-daterange').datepicker({
				autoclose : true
			});
			//to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
			$('input[name=date-range-picker]').daterangepicker({
				'applyClass' : 'btn-sm btn-success',
				'cancelClass' : 'btn-sm btn-default',
				locale : {
					applyLabel : 'Apply',
					cancelLabel : 'Cancel',
				}
			}).prev().on(ace.click_event, function() {
				$(this).next().focus();
			});

			$('#timepicker1').timepicker({
				minuteStep : 1,
				showSeconds : true,
				showMeridian : false
			}).next().on(ace.click_event, function() {
				$(this).prev().focus();
			});

			$('#date-timepicker1').datetimepicker().next().on(ace.click_event,
					function() {
						$(this).prev().focus();
					});

			$('#colorpicker1').colorpicker();

			$('#simple-colorpicker-1').ace_colorpicker();
			//$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
			//$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
			//var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
			//picker.pick('red', true);//insert the color if it doesn't exist

			$(".knob").knob();

			var tag_input = $('#form-field-tags');
			try {
				tag_input.tag({
					placeholder : tag_input.attr('placeholder'),
					//enable typeahead by specifying the source array
					source : ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
				/**
				//or fetch data from database, fetch those that match "query"
				source: function(query, process) {
				  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
				  .done(function(result_items){
					process(result_items);
				  });
				}
				 */
				})

				//programmatically add a new
				var $tag_obj = $('#form-field-tags').data('tag');

			} catch (e) {
				//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
				tag_input.after(
						'<textarea id="' + tag_input.attr('id') + '" name="'
								+ tag_input.attr('name') + '" rows="3">'
								+ tag_input.val() + '</textarea>').remove();
				//$('#form-field-tags').autosize({append: "\n"});
			}

			var tag_input = $('#form-field-tags2');
			try {
				tag_input.tag({
					placeholder : tag_input.attr('placeholder'),
					//enable typeahead by specifying the source array
					source : ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
				/**
				//or fetch data from database, fetch those that match "query"
				source: function(query, process) {
				  $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
				  .done(function(result_items){
					process(result_items);
				  });
				}
				 */
				})

				//programmatically add a new
				var $tag_obj = $('#form-field-tags').data('tag');

			} catch (e) {
				//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
				tag_input.after(
						'<textarea id="' + tag_input.attr('id') + '" name="'
								+ tag_input.attr('name') + '" rows="3">'
								+ tag_input.val() + '</textarea>').remove();
				//$('#form-field-tags').autosize({append: "\n"});
			}

			/////////
			$('#modal-form input[type=file]').ace_file_input({
				style : 'well',
				btn_choose : 'Drop files here or click to choose',
				btn_change : null,
				no_icon : 'ace-icon fa fa-cloud-upload',
				droppable : true,
				thumbnail : 'large'
			})

			//chosen plugin inside a modal will have a zero width because the select element is originally hidden
			//and its width cannot be determined.
			//so we set the width after modal is show
			$('#modal-form').on(
					'shown.bs.modal',
					function() {
						if (!ace.vars['touch']) {
							$(this).find('.chosen-container').each(
									function() {
										$(this).find('a:first-child').css(
												'width', '210px');
										$(this).find('.chosen-drop').css(
												'width', '210px');
										$(this).find('.chosen-search input')
												.css('width', '200px');
									});
						}
					})
			/**
			//or you can activate the chosen plugin after modal is shown
			//this way select element becomes visible with dimensions and chosen works as expected
			$('#modal-form').on('shown', function () {
				$(this).find('.modal-chosen').chosen();
			})
			 */

			$(document)
					.one(
							'ajaxloadstart.page',
							function(e) {
								$('textarea[class*=autosize]').trigger(
										'autosize.destroy');
								$('.limiterBox,.autosizejs').remove();
								$(
										'.daterangepicker.dropdown-menu,.colorpicker.dropdown-menu,.bootstrap-datetimepicker-widget.dropdown-menu')
										.remove();
							});

		});

		$("#datepicker").datepicker({
			showOtherMonths : true,
			selectOtherMonths : false,
		//isRTL:true,

		/*
		changeMonth: true,
		changeYear: true,
		
		showButtonPanel: true,
		beforeShow: function() {
			//change button colors
			var datepicker = $(this).datepicker( "widget" );
			setTimeout(function(){
				var buttons = datepicker.find('.ui-datepicker-buttonpane')
				.find('button');
				buttons.eq(0).addClass('btn btn-xs');
				buttons.eq(1).addClass('btn btn-xs btn-success');
				buttons.wrapInner('<span class="bigger-110" />');
			}, 0);
		}
		 */
		});
		$("#datepicker1").datepicker({
			showOtherMonths : true,
			selectOtherMonths : false,
		//isRTL:true,

		/*
		changeMonth: true,
		changeYear: true,
		
		showButtonPanel: true,
		beforeShow: function() {
			//change button colors
			var datepicker = $(this).datepicker( "widget" );
			setTimeout(function(){
				var buttons = datepicker.find('.ui-datepicker-buttonpane')
				.find('button');
				buttons.eq(0).addClass('btn btn-xs');
				buttons.eq(1).addClass('btn btn-xs btn-success');
				buttons.wrapInner('<span class="bigger-110" />');
			}, 0);
		}
		 */
		});
		$("#datepicker2").datepicker({
			showOtherMonths : true,
			selectOtherMonths : false,
		//isRTL:true,

		/*
		changeMonth: true,
		changeYear: true,
		
		showButtonPanel: true,
		beforeShow: function() {
			//change button colors
			var datepicker = $(this).datepicker( "widget" );
			setTimeout(function(){
				var buttons = datepicker.find('.ui-datepicker-buttonpane')
				.find('button');
				buttons.eq(0).addClass('btn btn-xs');
				buttons.eq(1).addClass('btn btn-xs btn-success');
				buttons.wrapInner('<span class="bigger-110" />');
			}, 0);
		}
		 */
		});
		$("#datepicker3").datepicker({
			showOtherMonths : true,
			selectOtherMonths : false,
		//isRTL:true,

		/*
		changeMonth: true,
		changeYear: true,
		
		showButtonPanel: true,
		beforeShow: function() {
			//change button colors
			var datepicker = $(this).datepicker( "widget" );
			setTimeout(function(){
				var buttons = datepicker.find('.ui-datepicker-buttonpane')
				.find('button');
				buttons.eq(0).addClass('btn btn-xs');
				buttons.eq(1).addClass('btn btn-xs btn-success');
				buttons.wrapInner('<span class="bigger-110" />');
			}, 0);
		}
		 */
		});
	</script>
	<script type="text/javascript">
		jQuery(function($) {

			var $validation = false;
			$('#fuelux-wizard-container')
					.ace_wizard({
					//step: 2 //optional argument. wizard will jump to step "2" at first
					//buttons: '.wizard-actions:eq(0)'
					})
					.on('actionclicked.fu.wizard', function(e, info) {
						if (info.step == 1 && $validation) {
							if (!$('#validation-form').valid())
								e.preventDefault();
						}
					})
					.on(
							'finished.fu.wizard',
							function(e) {
								bootbox
										.dialog({
											message : "Thank you! Your information was successfully saved!",
											buttons : {
												"success" : {
													"label" : "OK",
													"className" : "btn-sm btn-primary"
												}
											}
										});
							}).on('stepclick.fu.wizard', function(e) {
						//e.preventDefault();//this will prevent clicking and selecting steps
					});

			//hide or show the other form which requires validation
			//this is for demo only, you usullay want just one form in your application
			$('#skip-validation').removeAttr('checked').on('click', function() {
				$validation = this.checked;
				if (this.checked) {
					$('#sample-form').hide();
					$('#validation-form').removeClass('hide');
				} else {
					$('#validation-form').addClass('hide');
					$('#sample-form').show();
				}
			})

			//documentation : http://docs.jquery.com/Plugins/Validation/validate

			$.mask.definitions['~'] = '[+-]';
			$('#phone').mask('(999) 999-9999');

			jQuery.validator.addMethod("phone", function(value, element) {
				return this.optional(element)
						|| /^\(\d{3}\) \d{3}\-\d{4}( x\d{1,6})?$/.test(value);
			}, "Enter a valid phone number.");

			$('#validation-form')
					.validate(
							{
								errorElement : 'div',
								errorClass : 'help-block',
								focusInvalid : false,
								ignore : "",
								rules : {
									email : {
										required : true,
										email : true
									},
									password : {
										required : true,
										minlength : 5
									},
									password2 : {
										required : true,
										minlength : 5,
										equalTo : "#password"
									},
									name : {
										required : true
									},
									phone : {
										required : true,
										phone : 'required'
									},
									url : {
										required : true,
										url : true
									},
									comment : {
										required : true
									},
									comment1 : {
										required : true
									},
									year_of_passing : {
										required : true
									},
									platform : {
										required : true
									},
									subscription : {
										required : true
									},
									gender : {
										required : true,
									},
									agree : {
										required : true,
									},
									job_category : {
										required : true,
									},
									companyid : {
										required : true,
										isnumeric : true
									},
									eventid : {
										required : true,
									},
									createdby : {
										required : true,
									},
									modifiedby : {
										required : true,
									},
									criteriaid : {
										required : true,
									},
									skills_required : {
										required : true,
									},
									docs_required : {
										required : true,
									},
									ctc : {
										required : true,
									},
									createddate : {
										required : true,
									},
									drive_date : {
										required : true,
									},
									year_gap_allowed : {
										required : true,
									},
									jobcategory : {
										required : true,
									},
									eligible_branches : {
										required : true,
									},
									last_date_to_apply : {
										required : true,
									},
									no_of_live_kts_allowed : {
										required : true,
									},
									no_of_dead_kts_allowed : {
										required : true,
									},
									job_description : {
										required : true,
									},
									company_id: {
										required : true,
									}
								},

								messages : {
									email : {
										required : "Please provide a valid email.",
										email : "Please provide a valid email."
									},
									password : {
										required : "Please specify a password.",
										minlength : "Please specify a secure password."
									},
									year_of_passing : "Please choose an year of passing",
									subscription : "Please choose at least one option",
									gender : "Please choose gender",
									agree : "Please accept our policy",
									skills_required : "Please enter atleast one skill",
									company_id : "Please Enter the Company name",
									docs_required : "Please Enter the Document to be carried",
									job_description:"Please Enter the Job Description",
									ctc : "Please Enter a C.T.C",
									createddate : "Please Enter a Valid Date",
									modifieddate : "Please Enter a Valid Date",
									drive_date : "Please Enter a Valid Date",
									job_category : "Please select a Job Category",
									eligible_branches : "Select atleast one eligible branch",
									last_date_to_apply : "Please Enter a Valid Date",
									no_of_live_kts_allowed : "Please specify a number",
									no_of_dead_kts_allowed : "Please specify a number",
									year_gap_allowed : "Please specify a number"
								},

								highlight : function(e) {
									$(e).closest('.form-group').removeClass(
											'has-info').addClass('has-error');
								},

								success : function(e) {
									$(e).closest('.form-group').removeClass(
											'has-error');//.addClass('has-info');
									$(e).remove();
								},

								errorPlacement : function(error, element) {
									if (element.is('input[type=checkbox]')
											|| element.is('input[type=radio]')) {
										var controls = element
												.closest('div[class*="col-"]');
										if (controls.find(':checkbox,:radio').length > 1)
											controls.append(error);
										else
											error.insertAfter(element.nextAll(
													'.lbl:eq(0)').eq(0));
									} else if (element.is('.select2')) {
										error
												.insertAfter(element
														.siblings('[class*="select2-container"]:eq(0)'));
									} else if (element.is('.chosen-select')) {
										error
												.insertAfter(element
														.siblings('[class*="chosen-container"]:eq(0)'));
									} else
										error.insertAfter(element.parent());
								},

								submitHandler : function(form) {
								},
								invalidHandler : function(form) {
								}
							});

			$('#modal-wizard-container').ace_wizard();
			$('#modal-wizard .wizard-actions .btn[data-dismiss=modal]')
					.removeAttr('disabled');

			/**
			$('#date').datepicker({autoclose:true}).on('changeDate', function(ev) {
				$(this).closest('form').validate().element($(this));
			});
			
			$('#mychosen').chosen().on('change', function(ev) {
				$(this).closest('form').validate().element($(this));
			});
			 */

		})
	</script>

</body>
</html>
