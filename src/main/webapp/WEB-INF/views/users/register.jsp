<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="../include/meta.jsp"%>
<body class="hold-transition register-page">
	<div class="register-box">
		<div class="register-logo">
			<a href="${path}/"> <b>Ship App</b>
			</a>
		</div>

		<div class="register-box-body">
			<p class="login-box-msg">Register</p>

			<form action="${path}/users/register" method="post">
				<div class="form-group has-feedback">
					<span class="id">ID: </span> 
					<input type="text" name="userId" id="userId" class="form-control" placeholder="ID" required autofocus>
					<span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<span class="email">EMAIL:</span> 
					<input type="email" name="userEmail" id="userEmail" class="form-control" placeholder="EMAIL" required autofocus>
					<span class="glyphicon glyphicon-exclamation-sign form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<span class="name">NAME:</span> 
					<input type="text" name="userName" id="userName" class="form-control" placeholder="Name" required autofocus> 
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<span class="password">PASSWORD:</span> 
					<input type="password" name="userPw" class="form-control" placeholder="Password" required autofocus>
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<span class="confirm-password">CONFIRM PASSWORD:</span> 
					<input type="password" class="form-control" placeholder="confirm Password" required autofocus> 
					<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-4">
						<button type="submit"
							class="btn btn-primary btn-block btn-flat btn-register">register</button>
					</div>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>


			<a href="${path}/users/login" class="go-previous-page">Go to login page</a>
		</div>
		<!-- /.form-box -->
	</div>
	<!-- /.register-box -->

	<%@ include file="../include/script.jsp"%>
	<%@ include file="../scriptLogic/registration.jsp"%>
</body>
</html>