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
<body class="hold-transition setting">
	<!-- Navbar -->
	<%@include file="../include/navbar.jsp"%>
	<!-- /.navbar -->
	<!-- Main Sidebar Container -->
	<%@include file="../include/sidebar.jsp"%>
	<div class="wrapper">
			<div class="content-wrapper">
				test
			</div> 
	</div>


	<!-- Main Footer -->
	<%@include file="../include/footer.jsp"%>

	<!-- REQUIRED SCRIPTS LOAD FILE -->
	<%@include file="../include/script.jsp"%>
</body>
</html>