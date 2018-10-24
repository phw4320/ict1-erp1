<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <%
  String openYn = request.getParameter("openYn"); // 최초팝업오픈여부
 %>
 <head>
  <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.1.min.js"></script>
 </head>
 <body>
  <form method="post">
   <input type="hidden" id="openYn" value="<%=openYn%>"/>
  </form>
  <div id="naver_id_login"></div>
  <script type="text/javascript">
   // 네이버아이디로그인 시작
   var naver_id_login = new naver_id_login("네이버에서 부여한 고객ID", "네이버아이디로그인 성공 후 호출할 화면URL");
   function naverIdLogin(){
    var state = naver_id_login.getUniqState();
    naver_id_login.setButton("white", 2, 40); // 네이버로그인 버튼 생성
    naver_id_login.setDomain("");  // 상태토큰 비교를 위한 domain 설정
    naver_id_login.setState(state);
    naver_id_login.init_naver_id_login();  // 로그인 시작
    naver_id_login.get_naver_userprofile("callback()");
    location.replace(naver_id_login_url);
   }	
   // 네이버 사용자정보 가져오기
   function callback(){
    var paramBody = {id : naver_id_login.getProfileData('id') // 네이버ID
                    ,nickname : naver_id_login.getProfileData('nickname') // 네이버에서 설정한 별명
                    ,email : naver_id_login.getProfileData('email') // 이메일주소(xxxx@naver.com)
                    ,gender : naver_id_login.getProfileData('gender') // 성별(남자 : M, 여자 : F)
                    ,age : naver_id_login.getProfileData('age') // 나이(20-29 같이 연령대로 전달받음)
                    ,birthday : naver_id_login.getProfileData('birthday') // 생일(0815 출생년도 없이 월일만 전달받음)
                    ,profileImage : naver_id_login.getProfileData('profileImage') // 프로필이미지 경로
                    };
    opener.naverIdLoginCallback(paramBody); // 팝업을 호출한 모창에 있는 naverIdLoginCallback function에 사용자 프로필 전달
    var win = window.open("", "_self");
    win.close();
   }
  </script>
  <script>
   $(document).ready(function(){
    if($('#openYn').val() != "" && $('#openYn').val() != "null"){ // 팝업이 최초 호출된 경우에는 로그인
     naverIdLogin();
    } else {
     naver_id_login.get_naver_userprofile("callback()"); // 네이버아이디로그인 결과를 네이버에서 전달받은 경우
    }
   });
  </script>
 </body>
</html>