<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="../include/meta.jsp"%>
<body class="hold-transition contact">
	<!-- Navbar -->
	<%@include file="../include/navbar.jsp"%>
	<!-- /.navbar -->
	<!-- Main Sidebar Container -->
	<%@include file="../include/sidebar.jsp"%>
	<div class="wrapper">
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">Contact</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Contact</li>
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
			<div class="intro-section" style="height:300px;">
			This is our intro section
			</div>
			<div class="support-shiplist-section">
				<h4>Support Ship Company List</h4>
<!-- 				<p><img alt="ups" src="/resources/img/ups.png" style=" width: 85px; height:85px;"></p> -->
<!-- 				<p><img alt="ups" src="/resources/img/usps.png" ></p> -->
<!-- 				<p><img alt="ups" src="/resources/img/fedex.png" style=" width: 85px; height:85px;"></p> -->
<!-- 				<p><img alt="ups" src="/resources/img/dhl.png" style=" width: 85px; height:85px;"></p> -->
			</div>
			</div>

		</div>
	</div>


	<!-- Main Footer -->
	<%@include file="../include/footer.jsp"%>

	<!-- REQUIRED SCRIPTS LOAD FILE -->
	<%@include file="../include/script.jsp"%>
</body>
</html>