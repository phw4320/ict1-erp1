<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
		레벨번호 : <input type="text" name="lilevel"><br>
		레벨이름 : <input type="text" name="liname"><br>
		레벨설명 : <input type="text" name="lidesc"><br>
		<button onclick="insertLevelInfo()">등록</button>
	<script>
	function insertLevelInfo(){
		
		var lilevel = document.querySelector("input[name=lilevel]").value;
	 	var liname = document.querySelector("input[name=liname]").value;
	 	var lidesc = document.querySelector("input[name=lidesc]").value;
		alert(lilevel + "," + liname + "," +lidesc);

		var xhr = new XMLHttpRequest();
		var data = {
				liname:liname,
				lilevel:lilevel,
				lidesc:lidesc
				};
		data = JSON.stringify(data)
		alert(data);
		var url = "/levelinfo";
		var method = "POST";
		
		xhr.open(method,url);
		xhr.setRequestHeader("Content-type","application/json");
		
		xhr.onreadystatechange = function(){
			
			if(xhr.readyState==4){
				alert(xhr.responseText);
				if(xhr.status=="200"){
					
					if(xhr.responseText=='1'){
						alert("추가 성공!");
						location.href='/levelinfo/list';
					}
				}else if(xhr.status=="500"){
					alert("중복된 레벨이름이 있습니다. 다시 입력해주세요.");
					location.href='/url/levelinfo:insert';
				}else{
					alert(xhr.status);
					alert("추가 실패");
				}
			}
		}
		xhr.send(data); 
	}
	
	</script>
</body>
</html>