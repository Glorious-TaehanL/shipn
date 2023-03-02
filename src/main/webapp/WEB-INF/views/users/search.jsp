<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and pr./ovides the needed markup only.
-->
<html lang="en">
<%@include file="../include/meta.jsp"%>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<!-- Navbar -->
		<%@include file="../include/navbar.jsp"%>
		<!-- /.navbar -->

		<!-- Main Sidebar Container -->
		<%@include file="../include/sidebar.jsp"%>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper pick" style="display:flow-root;">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">MAIN Page</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Main Page</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			<div class="content">
				<div class="container-fluid">
					<div class="so-section">
						<div class="title-section">
							<h4>Sales order Information</h4>
						</div>
						<div class="content-section">
							<div class="pickticket-search-form">
								<p class="content-title">PICK TICKET NO#</p>
								
								<form class="searchSection">
									<input type="text" class="form-control ptSearch" id="articleNo"
										placeholder="Search number#">
									<button type="button" class="btn btn-primary searchbtn"
										id="btn-pickticket-info-find">
										<i class="fas fa-search"></i>
									</button>
									<button type="button" class="btn btn-primary validbtn"
										id="btn-pickticket-info-validation-check">
										<i class="fas fa-check"></i>
									</button>
									<button type="button" class="btn btn-primary searchbtn savebtn"
										id="btn-pickticket-info-find">
										<i class="fas fa-save"></i>
									</button>
									<button type="button" class="btn btn-primary searchbtn"
										id="btn-pickticket-info-find">
										<i class="fas fa-sync-alt"></i>
									</button>
								</form>
								<div class="col-md-12">
									<div class="col-md-4">
										<form>
										<p style="float:left; margin-right:5px;">Using Open Api :</p> 
											<div class="form-group" style="min-width: 400px;">
												<input type="text" class="form-control" id="keyword"
													placeholder="inseart search name" style="width:50%; float:left;">
												<button type="button" class="btn btn-primary"
													id="btn-movies-find" style="width:18%;">search</button>
											</div>
										</form>
									</div>
								</div>


							</div>
							<div class="information-table">
								<div class="pick-left">
									<div class="ship-container">
										<div class="ship-tab">
											<div class="shipto active">
												<div class="shipto-tab">SHIP TO</div>
											</div>
											<div class="shipfrom">
												<div class="shipfrom-tab">SHIP FROM</div>
											</div>
										</div>
										
										<!-- SHIP TO INFORMATION BUMDLE -->
										<form class="shipToSection" action="testApi.do" method="post">
											<div class="ship-section shipTo active">
												<div class="row">
													<div class="ship-section-left">
														<div class="col-address col-6">
															<p class="content-title">PICKTICKET NO#</p>
															<input type="text" class="form-control" id="to-picticket" name="to-picticket"
																placeholder="Picket NO#">
														</div>
														<div class="col-address col-6">
															<p class="content-title">SO NO#</p>
															<input type="text" class="form-control" id="to-sono" name="to-sono"
																placeholder="SO NO#">
														</div>
													</div>
													<div class="ship-section-right">
														<div class="col-address col-6">
															<p class="content-title">DIVISION</p>
															<input type="text" class="form-control" id="to-division" name="to-division"
																placeholder="Division">
														</div>
														<div class="col-address col-6">
															<p class="content-title">CUSTOMER</p>
															<input type="text" class="form-control" id="to-customer" name="to-customer"
																placeholder="Customer">
														</div>
													</div>
												</div>
												<div class="row validCheckSection">
													<div class="ship-section-left">
														<div class="col-address col-6">
															<p class="content-title">STORE</p>
															<input type="text" class="form-control" id="to-store" name="to-store"
																placeholder="Store">
														</div>
														<div class="col-address col-6">
															<p class="content-title">NAME</p>
															<input type="text" class="form-control" id="to-name" name="to-name"
																placeholder="Name">
														</div>
													</div>
													<div class="ship-section-right">
														<div class="col-address col-6">
															<p class="content-title">EMAIL</p>
															<input type="text" class="form-control" id="to-email" name="to-email"
																placeholder="Email">
														</div>
														<div class="col-address col-6">
															<p class="content-title">PHONE</p>
															<input type="text" class="form-control" id="to-phone" name="to-phone"
																placeholder="Phone">
														</div>
													</div>
												</div>
												<div class="row validCheckSection">
													<div class="ship-section-left">
														<div class="col-address col-6">
															<p class="content-title">CITY</p>
															<input type="text" class="form-control" id="to-city" name="to-city"
																placeholder="City">
														</div>
														<div class="col-address col-6">
															<p class="content-title">STATE</p>
															<input type="text" class="form-control" id="to-state" name="to-state"
																placeholder="State">
														</div>
													</div>
													<div class="ship-section-right">
														<div class="col-address col-6">
															<p class="content-title">COUNTRY</p>
															<input type="text" class="form-control" id="to-country" name="to-country"
																placeholder="Country">
														</div>
														<div class="col-address col-6">
															<p class="content-title">ZIP</p>
															<input type="text" class="form-control" id="to-zip" name="to-zip"
																placeholder="Zip-code">
														</div>
													</div>
												</div>
												<div class="row validCheckSection">
													<div class="ship-section-left">
														<div class="col-address street col-12">
															<p class="content-title">ADDRESS#1</p>
															<input type="text" class="form-control" id="to-street" name="to-street"
																placeholder="street">
														</div>
													</div>
													<div class="ship-section-right">
														<div class="col-address street col-12">
															<p class="content-title">ADDRESS#2</p>
															<input type="text" class="form-control" id="to-street2" name="to-street2"
																placeholder="Street #2">
														</div>
													</div>
												</div>
											</div>
										</form>
										
										<!-- SHIP TO INFORMATION BUMDLE -->
										<form class="shipFromSection">
											<div class="ship-section shipFrom">
												<div class="row">
													<div class="ship-section-left">
														<div class="col-address col-6">
															<p class="content-title">STORE</p>
															<input type="text" class="form-control" id="from-store"
																placeholder="Store">
														</div>
														<div class="col-address col-6">
															<p class="content-title">NAME</p>
															<input type="text" class="form-control" id="from-name"
																placeholder="Name">
														</div>
													</div>
													<div class="ship-section-right">
														<div class="col-address col-6">
															<p class="content-title">EMAIL</p>
															<input type="text" class="form-control" id="from-email"
																placeholder="Email">
														</div>
														<div class="col-address col-6">
															<p class="content-title">PHONE</p>
															<input type="text" class="form-control" id="from-phone"
																placeholder="Phone">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="ship-section-left">
														<div class="col-address col-6">
															<p class="content-title">CITY</p>
															<input type="text" class="form-control" id="from-city"
																placeholder="City">
														</div>
														<div class="col-address col-6">
															<p class="content-title">STATE</p>
															<input type="text" class="form-control" id="from-state"
																placeholder="State">
														</div>
													</div>
													<div class="ship-section-right">
														<div class="col-address col-6">
															<p class="content-title">COUNTRY</p>
															<input type="text" class="form-control" id="from-country"
																placeholder="Country">
														</div>
														<div class="col-address col-6">
															<p class="content-title">ZIP</p>
															<input type="text" class="form-control" id="from-zip"
																placeholder="Zip-code">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="ship-section-left">
														<div class="col-address street col-12">
															<p class="content-title">ADDRESS#1</p>
															<input type="text" class="form-control" id="from-street"
																placeholder="Street">
														</div>
													</div>
													<div class="ship-section-right">
														<div class="col-address street col-12">
															<p class="content-title">ADDRESS#2</p>
															<input type="text" class="form-control" id="from-street2"
																placeholder="Street #2">
														</div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="pick-right">
									<div class="info-tab">
										<div class="shipinfo">
											<div class="shipinfo-title">SHIP INFO</div>
										</div>
									</div>
									<div class="info-container">
										<div class="row">
											<div class="col-address col-12">
												<p class="content-title">PRODUCT INFO</p>
												<input type="text" class="form-control" id="title"
													placeholder="Title">
											</div>
										</div>
										<div class="row">
											<div class="col-address col-12">
												<p class="content-title">CARTON TYPE</p>
												<input type="text" class="form-control" id="carton"
													placeholder="Carton">
											</div>
										</div>
										<div class="row">
											<div class="col-address col-12">
												<p class="content-title">WEIGHT</p>
												<input type="text" class="form-control" id="weight"
													placeholder="Weight (lb)">
											</div>
										</div>
										<div class="row">
											<div class="col-address col-4">
												<p class="content-title">LENGTH</p>
												<input type="text" class="form-control" id="length"
													placeholder="Length (in)">
											</div>
											<div class="col-address col-4">
												<p class="content-title">WIDTH</p>
												<input type="text" class="form-control" id="width"
													placeholder="Width (in)">
											</div>
											<div class="col-address col-4">
												<p class="content-title">HEIGHT</p>
												<input type="text" class="form-control" id="height"
													placeholder="Height (in)">
											</div>
										</div>
									</div>
								</div>
								<div class="ship-jqgrid-container">
									<!-- <div class="jqgrid-tab">
										<div class="jqgrid-title">Table</div>
									</div> -->
									<div class="row">
										<div class="col-address col-12">
											<p class="content-title">jqgrid</p>
											<%@include file="../shipment/rateTable.jsp"%>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="pick-Information"></div>

			</div>

		</div>
		<!-- /.content-wrapper -->

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
			<div class="p-3">
				<h5>Title</h5>
				<p>Sidebar content</p>
			</div>
		</aside>
		<!-- /.control-sidebar -->

		<!-- Main Footer -->
		<%@include file="../include/footer.jsp"%>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS LOAD FILE -->
	<%@include file="../include/script.jsp"%>
	<!-- ADD PICKTICKET LOGIC SCRIPTS -->
	<%@include file="../scriptLogic/pickticket.jsp"%>

</body>
</html>
