<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<body>
<a id="kakao-login-btn"></a>

<a href="http://developers.kakao.com/logout"></a>
 
 <script type="text/javascript">
      // 사용할 앱의 JavaScript 키를 설정해 주세요.
      Kakao.init('16c37d12fd059134b18fd3eb88b533dc');
      // 카카오 로그인 버튼을 생성합니다.
      Kakao.Auth.createLoginButton({
        container: '#kakao-login-btn',
        success: function(authObj) {
           alert('로그인에 성공하였습니다.');
           console.log(JSON.stringify(authObj.access_token));
           console.log(JSON.stringify(authObj.refresh_token));
          // 로그인 성공시, API를 호출합니다.
          Kakao.API.request({
            url: '/v1/user/me',
            success: function(res) {            
              console.log(JSON.stringify(res));
              console.log(JSON.stringify(res.kaccount_email));
              console.log(JSON.stringify(res.id));
              console.log(JSON.stringify(res.properties.profile_image));
              console.log(JSON.stringify(res.properties.nickname));
            },
            fail: function(error) {
              alert(JSON.stringify(error));
            }
          });
          
        },
        fail: function(err) {
          alert(JSON.stringify(err));
        }
      });

</script>
</body>
</html>