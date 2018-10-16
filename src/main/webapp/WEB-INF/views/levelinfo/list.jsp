<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<script>

var AjaxUtil = function(conf){
	var xhr = new XMLHttpRequest();
	var url = conf.url;
	var method = conf.method?conf.method:'GET';
	var param = conf.param;
	
	var success = conf.success?conf.success:function(res){
		alert(res);
	}
	var error = conf.error?conf.error:function(res){
		alert(res);
	}
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status=="200"){
				success(xhr.responseText);
			}else{
				error(xhr.responseText);
			}
		}
	}
	xhr.open(method,url);
	this.send = function(){
		xhr.send();
	}
}
 window.addEventListener('load',function(){

	var conf = {
			url : '/levelinfo',
			success : function(res){
				contentType: "application/json; charset=UTF-8";
				res = JSON.parse(res);
				var html = '';
				
			    for(var li of res){
					html += '<tr>';
					html += '<td> <input type="text" name="linum" value='+li.linum+'></td>';
					html += '<td> <input type="text" name="lilevel'+li.linum+'" value='+li.lilevel+'></td>';
					html += '<td> <input type="text" name="liname'+li.linum+'"  value='+li.liname+'></td>';
					html += '<td> <input type="text" name="lidesc'+li.linum+'"  value='+li.lidesc+'></td>';
					
					html += '<td><button onclick=updateLevelInfo('+li.linum+')>수정</button><button onclick="deleteLevelInfo('+li.linum+')">삭제</button></td>';
					html += '</tr>';
				}  
				
				document.querySelector('#liBody').insertAdjacentHTML('beforeend',html);
			}
	}
	var au = new AjaxUtil(conf);
	au.send();
});
</script>
<body>



	<table>
		<tr>
			<td>
				<form action="" method="get">
					레벨 이름 : <input type="text" name="liname">
					<button>검색</button>
				</form>
			</td>
			<td>
				<form action="/url/levelinfo:insert" method="get">
					<button>추가 페이지</button>
				</form>
			</td>

			<td>
				<form action="" method="get">
					<button>로그인</button>
				</form>
			</td>
		</tr>
	</table>
	
	<button onclick="addLevelInfo()">추가</button>
	<table border="1">
		<thead>
			<tr>
				<th>linum</th>
				<th>lilevel</th>
				<th>liname</th>
				<th>lidesc</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<tbody id="liBody">
		</tbody>
	</table>


	<script>
	

function addLevelInfo() {
	var html = '<tr>';
	html += '<td>&nbsp</td>';
	html += '<td> <input type="text" id="lilevel" value=""></td>';
	html += '<td> <input type="text" id="liname"  value=""></td>';
	html += '<td> <input type="text" id="lidesc"  value=""></td>';
	html += '<td><button onclick=saveLevelInfo()>저장</td>';
	html += '</tr>';
	document.querySelector('#liBody').insertAdjacentHTML('beforeend',html);
}
	
function saveLevelInfo() {
	var lilevel = document.querySelector("#lilevel").value;
	var liname = document.querySelector("#liname").value;
	var lidesc = document.querySelector("#lidesc").value;
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
	
function deleteLevelInfo(linum){
	alert(linum);
	var xhr = new XMLHttpRequest();
	var url = "/levelinfo/" + linum;
	var method = "delete";
	xhr.open(method,url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status=="200"){
				if(xhr.responseText=='1'){
					alert("삭제 성공!");
					location.href='/levelinfo/list';
				}
			}else{
				alert("실패");
			}
		}
	}
	xhr.send(); 
}

function updateLevelInfo(linum){
	alert(linum);
	var lilevel = document.querySelector("input[name=lilevel" + linum + "]").value;
 	var liname = document.querySelector("input[name=liname" + linum + "]").value;
 	var lidesc = document.querySelector("input[name=lidesc" + linum + "]").value;
	alert(lilevel + "," + liname + "," +lidesc);

	var xhr = new XMLHttpRequest();
	var data = {
			liname:liname,
			lilevel:lilevel,
			lidesc:lidesc
			};
	data = JSON.stringify(data)
	/* var conf = {
		url : '/levelInfo/' + linum,
		methid : 'PUT',
		data : data,
		success : function(res){ 
			alert(res);
		}
	} */
	alert(data);
	var url = "/levelinfo/"+linum;
	var method = "put";
	
	xhr.open(method,url);
	if (method != 'GET') {
		xhr.setRequestHeader("Content-type","application/json;charset=utf-8");
	}
		xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status=="200"){
				if(xhr.responseText=='1'){
					alert("수정 성공!");
					location.href='/levelinfo/list';
				}
			}		
			else{
				alert(xhr.status);
				alert("실패");
			}
		}
	}
	xhr.send(data); 
}



</script>
</body>
</html>