<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/meta.jsp" %>
<meta charset="UTF-8">
<title>Reset Your Password</title>
</head>
<body class="reset-password-page">
<div>
    <h2>Forgot Password</h2>
</div>
<div class="border border-secondary rounded p-3">
    <div>
        <p>
         Your password have to be between 5 and 20 characters with at least one special character and number digit.
         </p>
    </div>
         
	<form th:action="${Path}/userInfo/reset_password" method="post" style="max-width: 350px; margin: 0 auto;">
	    <input type="hidden" name="token" th:value="${token}" />

	    <div>
	        <p>
	            <input type="password" name="password" id="password" class="form-control"
	                placeholder="Enter your new password" required autofocus onchange="checkPasswordValid(this)" />
	        </p>         
	        <p>
	            <input type="password" class="form-control" placeholder="Confirm your new password"
	                required oninput="checkPasswordMatch(this);" />
	        </p>
	        <div class="message"></div>
	        <p class="text-center">
	            <input type="submit" value="Change Password" class="btn btn-primary btn-reset-send" />
	        </p>
	    </div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	
	<%@ include file="../include/script.jsp" %>
	
	<script type="text/javascript">
		function checkPasswordMatch(fieldConfirmPassword) {
		    if (fieldConfirmPassword.value != $("#password").val()) {
		        fieldConfirmPassword.setCustomValidity("Passwords do not match!");
		    } else {
		        fieldConfirmPassword.setCustomValidity("");		        
		    }
		}
		function checkPasswordValid(validConfirmPassword) {
			var pwRegex =  /^.*(?=^.{5,20}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
			
			if(pwRegex.test(validConfirmPassword.value)){
				$(".message").text("");
				$(".btn.btn-primary").attr('disabled', false);
			}else{
				$(".message").text("Your password must be between 5 and 20 characters with at least one special character and number digit.");
				$(".btn.btn-primary").attr('disabled', true);
			}
		}
	</script>
	</form>
	</div>
</body>
</html>