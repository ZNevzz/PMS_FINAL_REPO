<!-- @author Leon 
    for Group Email -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Email-Sending</title>

<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />



<!-- page specific plugin styles -->
<link rel="stylesheet" href="assets/css/select2.min.css" />
<script src="http://code.jquery.com/jquery-1.4.4.min.js"
	type="text/javascript"></script>

</head>
<body class="no-skin">
	<%@include file="Header.jsp"%>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">

				<jsp:directive.include file="searchheader.jsp" />


			</div>

			<div class="page-content">




				<div class="row">
					<div class="col-xs-12">
						<form class="form-horizontal" role="form"
							action="GroupSubmitEmail" enctype="multipart/form-data"
							method="post">






							<div class="form-group">
								<label class="control-label col-xs-12 col-sm-3 no-padding-right">
									To </label>

								<div class="col-xs-12 col-sm-9">
									<select multiple="" id="state" name="receiver" class="select2"
										data-placeholder="Click to Choose Recipients" required>
										<option value="">&nbsp;</option>
										<option value="CompsSTPC">CompsSTPC</option>
										<option value="ITSTPC">ITSTPC</option>
										<option value="ElexSTPC">ElexSTPC</option>
										<option value="ProdSTPC">ProdSTPC</option>
										<option value="CompsFTPC">CompsFTPC</option>
										<option value="ITFTPC">ITFTPC</option>
										<option value="ProdFTPC">ProdFTPC</option>
										<option value="ElexFTPC">ElexFTPC</option>
										<option value="STPC">STPC</option>
										<option value="FTPC">FTPC</option>
										<option value="TPC">TPC</option>
										<option value="compsClass">CompsClass</option>
										<option value="prodClass">ProdClass</option>
										<option value="itClass">ITClass</option>
										<option value="elexClass">ElexClass</option>
										<!--<option value="JP Morgan">JP Morgan</option>
                        <option value="Morgan Stanley"> Morgan Stanley </option>
                        <option value="Direct i">Directi </option>
                        <option value ="Tata Consultancy Services">TCS</option>
                        <option value="Accenture">Accenture</option>
                        <option value="SAP">SAP</option>
                        <option value="Godrej">Godrej</option>
                        <option value="Laursen & Tubro">L&T</option>  -->
										<c:forEach items="${companies}" var="companies">
											<option value="${companies.key}">${companies.value}</option>
										</c:forEach>
										<!--<option value="Neebal">Neebal</option>
                        <option value="Seclore">Seclore</option>
                        <option value="LnTInfoTech"> L&T Infotech</option>
                        <option value="LntEngineering"> L&T Engineering</option>
                        <option value="Nerolac"> Nerolac </option>
                        <option value="Amdocs"> Amdocs</option>
                        <option value="Patni"> Patni </option>
                        <option value="Oracle"> Oracle </option>
                        <option value="TCSDigital"> TCS Digital</option>
                        <option value="NSE"> NSE </option>
                        <option value="Siemens">Siemens</option>
                        <option value="BNP"> BNP Paribas </option>   -->
										<!--<option value ="ZS Associates"> ZS </option>    -->

									</select>
								</div>
								<br /> <br /> <br>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> Subject </label>

									<div class="col-sm-5">
										<input type="text" id="form-field-1" placeholder="Subject"
											class="col-xs-10 col-sm-12" name="subject" />
									</div>
								</div>
								<center>
									<div class="form-group">

										<label class="col-sm-3 control-label no-padding-right"
											for="form-field">Message</label>
										<div class="col-sm-5">
											<textarea id="form-field"
												class="autosize-transition form-control"
												placeholder="Message" name="message" cols="20" rows="10"></textarea>
										</div>
									</div>
								</center>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-2"> Attachments </label>
									<div class="col-sm-9">
										<input type="file" multiple name="fileUpload" />
									</div>
								</div>

								<div class="col-md-offset-3 col-md-9">
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-info" type="submit" id="submit">
										<i
					class="menu-icon fa fa-send"></i> Send
									</button>

								</div>
								<font color="green"> ${success} </font>

							</div>

						</form>
					</div>
				</div>
				
				<jsp:directive.include file="scripts.jsp" />
				<jsp:directive.include file="Footer.jsp" />
			</div>
			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->

	

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>


	
	

	<!-- page specific plugin scripts -->
	<script src="assets/js/jquery.bootstrap-duallistbox.min.js"></script>
	<script src="assets/js/jquery.raty.min.js"></script>
	<script src="assets/js/bootstrap-multiselect.min.js"></script>
	<script src="assets/js/select2.min.js"></script>
	<script src="assets/js/typeahead.jquery.min.js"></script>


	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			var demo1 = $('select[name="duallistbox_demo1[]"]')
					.bootstrapDualListbox(
							{
								infoTextFiltered : '<span class="label label-purple label-lg">Filtered</span>'
							});
			var container1 = demo1.bootstrapDualListbox('getContainer');
			container1.find('.btn').addClass('btn-white btn-info btn-bold');

			/**var setRatingColors = function() {
			 $(this).find('.star-on-png,.star-half-png').addClass('orange2').removeClass('grey');
			 $(this).find('.star-off-png').removeClass('orange2').addClass('grey');
			 }*/
			$('.rating').raty({
				'cancel' : true,
				'half' : true,
				'starType' : 'i'
			/**,
			 
			 'click': function() {
			 setRatingColors.call(this);
			 },
			 'mouseover': function() {
			 setRatingColors.call(this);
			 },
			 'mouseout': function() {
			 setRatingColors.call(this);
			 }*/
			})//.find('i:not(.star-raty)').addClass('grey');

			//////////////////
			//select2
			$('.select2').css('width', '200px').select2({
				allowClear : true
			})
			$('#select2-multiple-style .btn').on('click', function(e) {
				var target = $(this).find('input[type=radio]');
				var which = parseInt(target.val());
				if (which == 2)
					$('.select2').addClass('tag-input-style');
				else
					$('.select2').removeClass('tag-input-style');
			});

			//////////////////
			$('.multiselect')
					.multiselect(
							{
								enableFiltering : true,
								buttonClass : 'btn btn-white btn-primary',
								templates : {
									button : '<button type="button" class="multiselect dropdown-toggle" data-toggle="dropdown"></button>',
									ul : '<ul class="multiselect-container dropdown-menu"></ul>',
									filter : '<li class="multiselect-item filter"><div class="input-group"><span class="input-group-addon"><i class="fa fa-search"></i></span><input class="form-control multiselect-search" type="text"></div></li>',
									filterClearBtn : '<span class="input-group-btn"><button class="btn btn-default btn-white btn-grey multiselect-clear-filter" type="button"><i class="fa fa-times-circle red2"></i></button></span>',
									li : '<li><a href="javascript:void(0);"><label></label></a></li>',
									divider : '<li class="multiselect-item divider"></li>',
									liGroup : '<li class="multiselect-item group"><label class="multiselect-group"></label></li>'
								}
							});

			///////////////////

			//typeahead.js
			//example taken from plugin's page at: https://twitter.github.io/typeahead.js/examples/
			var substringMatcher = function(strs) {
				return function findMatches(q, cb) {
					var matches, substringRegex;

					// an array that will be populated with substring matches
					matches = [];

					// regex used to determine if a string contains the substring `q`
					substrRegex = new RegExp(q, 'i');

					// iterate through the pool of strings and for any string that
					// contains the substring `q`, add it to the `matches` array
					$.each(strs, function(i, str) {
						if (substrRegex.test(str)) {
							// the typeahead jQuery plugin expects suggestions to a
							// JavaScript object, refer to typeahead docs for more info
							matches.push({
								value : str
							});
						}
					});

					cb(matches);
				}
			}

			$('input.typeahead').typeahead({
				hint : true,
				highlight : true,
				minLength : 1
			}, {
				name : 'states',
				displayKey : 'value',
				source : substringMatcher(ace.vars['US_STATES'])
			});

			///////////////

			//in ajax mode, remove remaining elements before leaving page
			$(document).one(
					'ajaxloadstart.page',
					function(e) {
						$('[class*=select2]').remove();
						$('select[name="duallistbox_demo1[]"]')
								.bootstrapDualListbox('destroy');
						$('.rating').raty('destroy');
						$('.multiselect').multiselect('destroy');
					});

		});
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
				value : 0,
				min : 0,
				max : 200,
				step : 10,
				btn_up_class : 'btn-info',
				btn_down_class : 'btn-info'
			}).closest('.ace-spinner').on('changed.fu.spinbox', function() {
				//alert($('#spinner1').val())
			});
			$('#spinner2').ace_spinner({
				value : 0,
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
			$("#form-field-tag").blur(function() {
				if (tag_input == '') {
					alert("Enter a email id");
					return false;
				}
			});

			try {
				tag_input.tag({
					placeholder : tag_input.attr('placeholder'),
				//enable typeahead by specifying the source array
				//source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
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
				//$tag_obj.add('');
				$('#form-field-tags').autosize({
					append : ""
				});

			} catch (e) {
				//display a textarea for old IE, because it doesn't support this plugin or another one I tried!
				tag_input.after(
						'<textarea id="' + tag_input.attr('id') + '" name="'
								+ tag_input.attr('name') + '" rows="3">'
								+ tag_input.val() + '</textarea>').remove();
				$('#form-field-tags').autosize({
					append : ""
				});
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

		function check() {
			var value = document.getElementById("form-field");
			if (value == "") {
				alert("Specify a recipient");
			}
		}
	</script>
</body>
</html>
