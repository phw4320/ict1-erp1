<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="${skyPath}/dhtmlx.css" />
</head>
<script>
	var mData = [{id:'delete',text:'delete'}];
	var dxGrid, dxMenu;
	function doInit() {
		
		dxMenu = new dhtmlXMenuObject();
		dxMenu.setIconsPath("../common/images/");
		dxMenu.renderAsContextMenu();
		dxMenu.attachEvent("onClick", function(mId, type){
			console.log(mId);
			console.log(type);
			if(mId == 'delete') {
				var rId = dxGrid.getSelectedRowId();
				if(!rId) {
					alert('삭제할 로우를 선택해주세요.');
					return;
				}
				var cIdx = dxGrid.getColIndexById('linum');
				var linum = dxGrid.cells(rId,cIdx).getValue();
				var xhr = new XMLHttpRequest();
				var url = "/levelinfos/" + linum;
				var method = "delete";
				xhr.open(method,url);
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
						if(xhr.status=="200"){
							if(xhr.responseText=='1'){
								alert("삭제 성공!");
							}
						}else{
							alert("실패");
						}
					}
				}
				xhr.send(); 
				alert(linum);
			}			
		})
		
		
		dxMenu.loadStruct(mData);
		dxGrid = new dhtmlXGridObject('dxGrid');
		dxGrid.setImagePath('${skyPath}/imgs/');
		dxGrid.setHeader('번호,레벨,이름,설명');
		dxGrid.setColumnIds('linum,lilevel,liname,lidesc');
		dxGrid.setColTypes('ro,ed,ed,ed');
		dxGrid.enableContextMenu(dxMenu);
		dxGrid.init();
		/* var xhr = new XMLHttpRequest();
		var url = "/levelinfos";
		var method = "GET";
		xhr.open(method,url);
		xhr.setRequestHeader("Content-type","application/json");
		xhr.onreadystatechange = function(){
			if(xhr.readyState==4){
				if(xhr.status=="200"){
					alert("로드 성공!");
					dxGrid.parse(xhr.responseText,'js');
					}
				}else{
					alert(xhr.status);
					alert("로드 실패");
				}
			}
		
		xhr.send(data);  */

		//dxGrid.parse(data,'js');
		dhx.ajax.get('/levelinfos', function(res) {
			var data = JSON.parse(res.xmlDoc.responseText);
			dxGrid.parse(data, 'js');
		})
		dxGrid.attachEvent('onEditCell', function(stage, rId, cInd, nValue, oValue) {
			if (stage == 2) {
				if(nValue!=oValue) {
					var rData = dxGrid.getRowData(rId);
					var data = JSON.stringify(rData);
					/* dhx.ajax.put('/levelinfos', function(res) {
						var data = JSON.parse(res.xmlDoc.responseText);
						dxGrid.parse(data, 'js');
					}) */
					var xhr = new XMLHttpRequest();
					alert(data);
					var url = "/levelinfos1";
					var method = "put";
					
					xhr.open(method,url);
					
						xhr.setRequestHeader("Content-type","application/json;charset=utf-8");
					
						xhr.onreadystatechange = function(){
						if(xhr.readyState==4){
							if(xhr.status=="200"){
								if(xhr.responseText=='1'){
									alert("수정 성공!");
								}
							}		
							else{
								alert(xhr.status);
								alert("실패");
							}
						}
					}
					xhr.send(data); 
					alert(data);
					console.log(rData);
				return true;
				}
			}
		})
	}
	window.addEventListener('load', doInit);
</script>
<body>
	<div id="dxGrid" style="width: 400px; height: 300px;"></div>
</body>
</html>