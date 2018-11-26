<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/login/loginPost" method="post" id="loginForm">
	<div class="form-group label-floating">
		<label class="control-label">이메일 주소</label> <input name="userEmail" type="text" id="exampleInputEmail1" class="form-control" value="${cookie.rememberID.value}">
	</div>    
	<div class="form-group label-floating">
		<label class="control-label">비밀번dddd호dddd</label> <input name="userPwd" type="password" id="exampleInputPassword1" class="form-control">
	</div>
	<div class="checkbox">
		<label> <input type="checkbox" name="rememberEmail"> 아이디저장 </label>
		<label> <input type="checkbox" name="useCookie"> 자동로그인 </label>
	</div>
	<button type="submit" class="btn btn-default">로그인</button>
</form>
</body>
</html>