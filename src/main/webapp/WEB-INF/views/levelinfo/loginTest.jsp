<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<title>카카오톡 로그인</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	</head>
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script>
	var statusObj = 
		$(document).ready(function(){
			Kakao.init("16c37d12fd059134b18fd3eb88b533dc");
		/* 	function checkLoginStatus(){
				Kakao.API.request({
					url: '/v1/user/me',
					success: function(res) {
						
						$("#kakao-profile").append(res.properties.nickname);
						$("#kakao-profile").append($("<img/>",{"src":res.properties.profile_image,"alt":res.properties.nickname+"님의 프로필 사진"}));
					},
					fail: function(error) {
						console.log(error);
					}
				});
			} */
			function loginWithKakao(callbackFunc){
		 		Kakao.Auth.getStatus(function(statusObj){
		 	         if(statusObj.status == "not_connected"){
		     		 Kakao.Auth.login({
		     		   success: function(authObj){
		     		      if(callbackFunc && typeof(callbackFunc) == "function"){
		     				callbackFunc();
		     				alert(statusObj.status);
		     			}
		     		   },
		     		   fail: function(err){
		     		     if(err.error == "window_closed" || err.error == "access_denied"){
		     					alert("허가를 해야해 !!");
		     			}
		     	 	}
		     	 });
		     	}else{
		     	     if(callbackFunc && typeof(callbackFunc) == "function"){
		     				callbackFunc();
		     		}
		     	    }
		     	 });
		     	}
		
			function getKakaotalkUserProfile(){
				Kakao.API.request({
					url: '/v1/user/me',
					success: function(res) {
						
						$("#kakao-profile").append(res.properties.nickname);
						$("#kakao-profile").append($("<img/>",{"src":res.properties.profile_image,"alt":res.properties.nickname+"님의 프로필 사진"}));
					},
					fail: function(error) {
						console.log(error);
					}
				});
			}
			function createKakaotalkLogin(){
				$("#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn").remove();
				Kakao.Auth.getStatus(function(statusObj) {
					  alert(statusObj);
					});
				var loginBtn = $("<a/>",{"class":"kakao-login-btn","text":"로그인"});
				loginBtn.click(function(){
					Kakao.Auth.login({
						kakao.Auth.setAccessToken(authObj.access_token);
						persistAccessToken: true,
						persistRefreshToken: true,
						success: function(authObj) {
							getKakaotalkUserProfile();
							createKakaotalkLogout();
							loginWithKakao(callbackFunc);
						},
						fail: function(err) {
							console.log(err);
						}
					});
				});
				$("#kakao-logged-group").prepend(loginBtn)
			}

			function createKakaotalkLogout(){
				$("#kakao-logged-group .kakao-logout-btn,#kakao-logged-group .kakao-login-btn").remove();
				Kakao.Auth.getStatus(function(statusObj) {
					  alert(statusObj);
					});
				alert(Kakao.Auth.getAccessToken());
				var logoutBtn = $("<a/>",{"class":"kakao-logout-btn","text":"로그아웃"});
				logoutBtn.click(function(){
			
					Kakao.Auth.logout();
					createKakaotalkLogin();
					$("#kakao-profile").text("");
				});
				$("#kakao-logged-group").prepend(logoutBtn);
			}
			if(Kakao.Auth.getRefreshToken()!=undefined&&Kakao.Auth.getRefreshToken().replace(/ /gi,"")!=""){
				createKakaotalkLogout();
				getKakaotalkUserProfile();
			}else{
				createKakaotalkLogin();
			}
		});
	</script>

<body>
	<div id="kakao-logged-group"></div>
	<div id="kakao-profile"></div>
</body>
</html>