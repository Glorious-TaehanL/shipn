<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="../include/meta.jsp" %>
<title>Common Error theme</title>
</head>
<body>

	<div id="notfound">
		<div class="notfound">
			<div class="notfound-404">
				<h1><c:out value="${errorCode}"></c:out></h1>
			</div>
			<h2>Oops!</h2>
			<p>Sorry, <c:out value="${errorMsg}"/></p>
			<a href="../">Go To Homepage</a>
		</div>
	</div>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
