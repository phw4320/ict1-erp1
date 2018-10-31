<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(document).ready(function() {
	$("#login").click(function() {
		var action = $("#form1").attr('action');
		var form_data = {
			id: $("#id").val(),
			pwd: $("pwd").val(),
		};
		$.ajax({
			type: 'POST',
			url: '/user/login',
			data : form_data,
			dataType:'json',
			success: function(response) {
				if(response == 'ok') {
					alert("로그인 성공");
				}
				else {
					alert("로그인 실패");
				}
			},
			error : function(){
            	console.log("에러");
       		}
		});
		return false;
	});
});
</script>
<body>
id : <input type="text" id="id">
pwd : <input type="password" id="pwd">
<button type="button" id="login"></button>
</body>
</html>