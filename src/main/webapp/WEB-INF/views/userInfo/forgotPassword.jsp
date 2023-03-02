<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
</head>
<%@ include file="../include/meta.jsp" %>
<body class=forgot-password-page>
<div>
    <h2>Forgot Password</h2>
</div>
     
<form action="${path}/userInfo/forgotPassword" method="post" style="max-width: 420px; margin: 0 auto;">
<div class="border border-secondary rounded p-3">
    <div>
        <p>We will be sending a reset password link to your email.</p>
    </div>
    <div>
        <p>
            <input type="email" name="userEmail" class="form-control" placeholder="Enter your e-mail" required autofocus/>
        </p>         
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
        <p class="text-center">
            <input type="submit" value="Send" class="btn btn-primary btn-forgot" />
        </p>
    </div>
    <a href="${path}/users/login" class="go-previous-page">Go to login page</a>
    <c:if test="${not empty error}">
	    <font color="red">
	        <p>${error}</p>
	    </font>
	</c:if>
</div>
</form>
</body>
</html>