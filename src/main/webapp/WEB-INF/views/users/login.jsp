<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<%@ include file="../include/meta.jsp" %>
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <a href="${path}/">
            <b>ShipApp</b>
        </a>
    </div>
    <!-- /.login-logo -->
    <c:if test="${not empty message}">
        <font color="blue">
            <p class="confirm-message">${message}</p>
        </font>
    </c:if>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">Log in to Admin Page</p>

        <form action="${pageContext.request.contextPath}/users/login-processing" method="post"> 
            <div class="form-group has-feedback">
            	<span class="id">ID: </span>
                <input type="text" name="username" placeholder="ID" /> 
                <span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
            	<span class="password">PW:</span>
                <input type="password" name="password" placeholder="PASSWORD" />
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat btn-login">
                        <i class="fa fa-sign-in"></i> login
                    </button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
                </div>
                <!-- /.col -->
            </div>
        </form>
	<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
	    <font color="red">
	        <p>Your login attempt was not successful due to <br/>
	            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
	        <c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
	    </font>
	</c:if>


        <!-- /.social-auth-links -->

        <a href="${path}/userInfo/forgotPassword" class="account-forgot-password">forgot your password?</a>
        <a href="${path}/users/register" class="account-register">registration</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<%@ include file="../include/script.jsp" %>
<script>

</script>
</body>
</html>