<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- <head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<script type="text/javascript">
  var naver_id_login = new naver_id_login("MQeAhKF9EeXd_4hUZPlU", "http://localhost/url/levelinfo:callback");
  // 접근 토큰 값 출력
  alert(naver_id_login.oauthParams.access_token);
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age'));
    alert(naver_id_login.getProfileData('name'));
    alert(naver_id_login.getProfileData('profile_image'));
    alert(naver_id_login.getProfileData('id'));
    console.log(naver_id_login);
  }
</script>
</body>
</html>
					 -->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NaverLoginSDK</title>
</head>

<body>

	callback 처리중입니다. 이 페이지에서는 callback을 처리하고 바로 main으로 redirect하기때문에 이 메시지가
	보이면 안됩니다.

	<!-- (1) LoginWithNaverId Javscript SDK -->
	<script type="text/javascript"
		src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js"
		charset="utf-8"></script>


	<!-- (2) LoginWithNaverId Javscript 설정 정보 및 초기화 -->
	<script>
		var naverLogin = new naver.LoginWithNaverId({
			clientId : "MQeAhKF9EeXd_4hUZPlU",
			callbackUrl : "http://localhost/url/levelinfo:callback",
			isPopup : false,
			callbackHandle : true
		/* callback 페이지가 분리되었을 경우에 callback 페이지에서는 callback처리를 해줄수 있도록 설정합니다. */
		});

		/* (3) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		/* (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup close) */
		window.addEventListener('load',function() {
							naverLogin.getLoginStatus(function(status) {
										if (status) {
											/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
											
											var email = naverLogin.user.getEmail();
											var profileImage = naverLogin.user.getProfileImage();
											var id = naverLogin.user.getId();
											var birthday = naverLogin.user.getBirthday();
											var nickname = naverLogin.user.getNickName();
											var name = naverLogin.user.getName();
											var age = naverLogin.user.getAge();

											if (email == undefined
													|| email == null) {
												alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
												naverLogin.reprompt();
												return;
											}
											if (profileImage == undefined
													|| profileImage == null) {
												alert("프로필 사진은 필수정보입니다. 정보제공을 동의해주세요.");
												naverLogin.reprompt();
												return;
											}
											if (age == undefined || age == null) {
												alert("나이는 필수정보입니다. 정보제공을 동의해주세요.");
												/* (5-1) 사용자 정보 재동의를 위하여 다시 네아로 동의페이지로 이동함 */
												naverLogin.reprompt();
												return;
											}
											alert(id);
											alert(email);
											alert(profileImage);
											alert(birthday);
											alert(nickname);
											alert(name);
											alert(age);

											alert("회원가입이 완료되었습니다.");
											window.location.replace("http://localhost/url/levelinfo:naverLogin");
											/*window.location.replace("http://" + window.location.hostname + ( (location.port==""||location.port==undefined)?"":":" + location.port) + "/sample/main.html"); */
										} else {
											console.log("callback 처리에 실패하였습니다.");
										}
									});
						});
	</script>
</body>

</html>