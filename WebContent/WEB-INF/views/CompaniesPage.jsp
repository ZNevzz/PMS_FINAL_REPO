<!-- author: Lenherd Olivera
description: contains the list of all the companies -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Companies Page</title>

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<style>
#img {
position:absolute;
display: none;
}
</style>	
	
<script src="http://code.jquery.com/jquery-1.4.4.min.js" type="text/javascript"></script>

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
					<h1>Companies</h1>
				</div>

				<div class="row">
					<div class="col-xs-12">
						<!-- PAGE CONTENT BEGINS -->
						<div>
							<ul class="ace-thumbnails ">


								<li><a href="Company?companyname=JP Morgan" > <img  id="JPMorgan"
										width="200" height="150" alt="JP Morgan"

										src="assets/images/companies/JP Morgan.jpg" />

								</a></li>
								<li><a href="Company?companyname=Direct i"> <img id="Directi"
										width="200" height="150" alt="Direct i"
										src="assets/images/companies/Direct i.jpg" />
								</a></li>
								<li><a href="Company?companyname=Morgan Stanley"> <img id="MorganStanley"
										width="200" height="150" alt="Morgan Stanley"
										src="assets/images/companies/Morgan Stanley.jpg" />
								</a></li>

								
								<!-- <li><a href="Company?companyname=Godrej"> <img
										width="200" height="150" alt="Godrej"
										src="assets/images/companies/Godrej.jpg" />
								</a></li> -->
								
								<li><a href="Company?companyname=Laursen %26 Tubro"> <img id="Laursen-Tubro"

										width="200" height="150" alt="Laursen & Tubro"
										src="assets/images/companies/Laursen & Tubro.jpg" />

										<li><a href="Company?companyname=Wipro"> <img id="Wipro"
												width="200" height="150" alt="Wipro"
												src="assets/images/companies/Wipro.jpg" />
										</a></li>
								</a></li>


								<li><a href="Company?companyname=Tata Consultancy Services">
										<img  id="TataConsultancyServices"
										width="200" height="150" alt="Tata Consultancy Services"
										src="assets/images/companies/Tata Consultancy Services.jpg" />
								</a></li>

								

								<li><a href="Company?companyname=ZS Associates"> <img id="ZSAssociates"
										width="200" height="150" alt="ZS Associates"
										src="assets/images/companies/ZS Associates.jpg" />
								</a></li>

								<li><a href="Company?companyname=Mahindra"> <img id="Mahindra"
										width="200" height="150" alt="Mahindra"
										src="assets/images/companies/Mahindra.jpg" />
								</a></li>

								
								
								<li><a href="Company?companyname=Accenture"> <img id="Accenture"
										width="200" height="150" alt="Accenture"
										src="assets/images/companies/Accenture.jpg" />
								</a></li>


								<li><a href="Company?companyname=Infosys"> <img id="Infosys"
										width="200" height="150" alt="Infosys"
										src="assets/images/companies/Infosys.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=Patni"> <img id="Patni"
										width="200" height="150" alt="Patni"
										src="assets/images/companies/Patni.jpg" />
								</a></li>
								
								
								<li><a href="Company?companyname=Google">
										<img id="Google"
										width="200" height="150" alt="Google"
										src="assets/images/companies/Google.jpg" />
								</a></li>
								
								

								<li><a
									href="Company?companyname=National Stock Exchange of India">
										<img id="NationalStockExchangeofIndia" 
										width="200" height="150"
										alt="National Stock Exchange of India"
										src="assets/images/companies/National Stock Exchange of India.jpg" />
								</a></li>

								<li><a href="Company?companyname=Hewlett-Packard"> <img id="Hewlett-Packard"
										width="200" height="150" alt="Hewlett-Packard"
										src="assets/images/companies/Hewlett-Packard.jpg" />
								</a></li>

								<li><a href="Company?companyname=Federal Bank"> <img id="FederalBank"
										width="200" height="150" alt="Federal Bank"
										src="assets/images/companies/Federal Bank.jpg" />
								</a></li>
								

								<li><a href="Company?companyname=Amdocs"> <img id="Amdocs"
										width="200" height="150" alt="Amdocs"
										src="assets/images/companies/Amdocs.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=Capgemini"> <img id="Capgemini"
										width="200" height="150" alt="Capgemini"
										src="assets/images/companies/Capgemini.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=Kansai Nerolac Paints">
										<img id="KansaiNerolacPaints" 
										width="200" height="150" alt="Kansai Nerolac Paints"
										src="assets/images/companies/Kansai Nerolac Paints.jpg" />
								</a></li>
								

								<li><a href="Company?companyname=HSBC"> <img id="HSBC"
										width="200" height="150" alt="HSBC"
										src="assets/images/companies/HSBC.jpg" />
								</a></li>

								<li><a href="Company?companyname=Tech Mahindra"> <img id="TechMahindra"
										width="200" height="150" alt="Tech Mahindra"
										src="assets/images/companies/Tech Mahindra.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=MAQ Software">
										<img id="MAQSoftware" 
										width="200" height="150" alt="MAQ Software"
										src="assets/images/companies/MAQ Software.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=Genesys">
										<img id="Genesys" 
										width="200" height="150" alt="Genesys"
										src="assets/images/companies/Genesys.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=Quinnox">
										<img id="Quinnox" 
										width="200" height="150" alt="Quinnox"
										src="assets/images/companies/Quinnox.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=Godrej Infotech"> <img id="GodrejInfotech"
										width="200" height="150" alt="Godrej Infotech"
										src="assets/images/companies/Godrej Infotech.jpg" />
								</a></li>
								
								
								<li><a href="Company?companyname=Weatherford">
										<img id="Weatherford" 
										width="200" height="150" alt="Weatherford"
										src="assets/images/companies/Weatherford.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=CSI Technologies">
										<img id="CSITechnologies"
										 width="200" height="150" alt="CSI Technologies"
										src="assets/images/companies/CSI Technologies.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=IBM">
										<img id="IBM" 
										width="200" height="150" alt="IBM"
										src="assets/images/companies/IBM.jpg" />
								</a></li>
								
								<li><a href="Company?companyname=Syntel"> <img id="Syntel"
										width="200" height="150" alt="Syntel"
										src="assets/images/companies/Syntel.jpg" />
								</a></li>
								

							</ul>
						</div>
						<!-- PAGE CONTENT ENDS -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->

				<jsp:directive.include file="scripts.jsp" />
				<jsp:directive.include file="Footer.jsp" />




			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->

	<!-- /.page-header -->



	<!-- inline scripts related to this page -->

	<!-- ace scripts -->
	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>



<!-- script to fade the images onload -->
<script type="text/javascript">
$(document).ready(function() { 
	
	// $('#img'+2).fadeTo(1000, 0.2);
	 
		$.ajax({
			url: 'getValuesToFed' ,
			
			dataType : 'json',
			success : function(data){
				
				console.log(data.length);
				for (i = 0; i < data.length; i++)
					console.log(data[i]);
				
				/*
				$.each(data , function(key,value){
					
					 console.log("key:"+key);
					    $.each(value, function (index, data) {
					        console.log(index, data)
					       // console.log("data: "+ data)
					     
					         if(data == 0){
					        	console.log();
					        	
					        	$('#'+(key)).fadeTo(1000, 0.2);

					        } 
					    })
					
				});
				*/
				
				for(var index in data){
					//console.log(data[index]);
					
					if(data[index] == 0){
			        	
			        	var ind = index.toString();
			        	//console.log("ind="+ind);
			        	
			        	var arr = ind.split(" ");
			        	//console.log("arr="+arr);
			        	
			        	
			        	
			        	var id="";
			        	for(var i in arr){
			        		if(arr[i]== '&'){
			        			arr[i] = '-';
			        		}
			        			
			        		id = id+arr[i];
			        		
			        	}
			        				        	
			        	console.log("id="+id);
			        	
			        	$('#'+(id)).fadeTo(1000, 0.2);

			        }
					
				}
			} 
		});
});
</script>

	<script type="text/javascript">
	 
	
		jQuery(function($) {
			var $overflow = '';
			
			
			var colorbox_params = {
				rel : 'colorbox',
				reposition : true,
				scalePhotos : true,
				scrolling : false,
				previous : '<i class="ace-icon fa fa-arrow-left"></i>',
				next : '<i class="ace-icon fa fa-arrow-right"></i>',
				close : '&times;',
				current : '{current} of {total}',
				maxWidth : '100%',
				maxHeight : '100%',
				onOpen : function() {
					$overflow = document.body.style.overflow;
					document.body.style.overflow = 'hidden';
				},
				onClosed : function() {
					document.body.style.overflow = $overflow;
				},
				onComplete : function() {
					$.colorbox.resize();
				}
			};

			$('.ace-thumbnails [data-rel="colorbox"]')
					.colorbox(colorbox_params);
			$("#cboxLoadingGraphic").html(
					"<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon

			$(document).one('ajaxloadstart.page', function(e) {
				$('#colorbox, #cboxOverlay').remove();
			});
		});
	</script>

</body>
</html>