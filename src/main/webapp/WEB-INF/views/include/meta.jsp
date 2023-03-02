<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <meta id="_csrf" name="_csrf" content="${_csrf.token}" />
  <meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}" />

<title>SHIPAPP | test ver </title>
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="${path}/resources/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${path}/resources/dist/css/adminlte.min.css">
  
<!--   <!-- For using ax5grid --> 
<!--   <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/ax5ui/ax5ui-kernel/master/dist/ax5ui.all.css"> -->
  
  <%@ include file="../include/main.jsp" %>  
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

<%-- 	<link href="<c:url value="/resources/jquery-ui/jquery-ui.css"/>" --%>
<!-- 		rel="stylesheet" type="text/css" /> -->
<%-- 	<link href="<c:url value="/resources/jqGrid/css/ui.jqgrid.css"/>" --%>
<!-- 		rel="stylesheet" type="text/css" /> -->
	
<%-- 	<script src="<c:url value="/resources/jqGrid/js/jquery-1.11.0.min.js"/>"></script> --%>
<%-- 	<script src="<c:url value="/resources/jquery-ui/jquery-ui.js"/>"></script> --%>
<!-- 	<script -->
<%-- 		src="<c:url value="/resources/jqGrid/js/i18n/grid.locale-en.js"/>"></script> --%>
<%-- 	<script src="<c:url value="/resources/jqGrid/js/jquery.jqGrid.min.js"/>"></script> --%>

<link href="<c:url value="/resources/jquery-ui/jquery-ui.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/jqGrid/css/ui.jqgrid.css"/>" rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/jqGrid/js/jquery-1.11.0.min.js"/>"></script>
<script src="<c:url value="/resources/jquery-ui/jquery-ui.js"/>"></script>
<script	src="<c:url value="/resources/jqGrid/js/i18n/grid.locale-en.js"/>"></script>
<script src="<c:url value="/resources/jqGrid/js/jquery.jqGrid.min.js"/>"></script>

<!-- 	<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/ax5ui/ax5ui-kernel/master/dist/ax5ui.all.css"> -->
<!-- 	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->
<!-- 	<script type="text/javascript" src="https://cdn.rawgit.com/ax5ui/ax5ui-kernel/master/dist/ax5ui.all.min.js"></script> -->


	
</head>
</html>