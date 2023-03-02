<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
		$(function() {
			var ajaxUrl = "/users/register/";
			var filter = "find";

			$('#userId, #userName, #userEmail').on("change", function() {
				var value = $(this).val();
				var ajaxFinalUrl = ajaxUrl + filter + this.name + "?" + this.name + "=" + value;
				ajaxCall(ajaxFinalUrl, $(this));
				});
		});

		function ajaxCall(parm, oBject) {
			var type = oBject.attr("placeholder");
			$.ajax({
				url : '${path}' + parm,
				type : 'get',
				success : function(data) {
					if (data) {
						oBject.next().text( type + " is duplicated. Please use different "+ type);
						return false;
					} else {
						oBject.next().text("");
						return true;
					}
				},
				error : function(event) {
					console.error(type + " CHECK ERROR :: " + event + " --");
				}

			});
		}
</script>