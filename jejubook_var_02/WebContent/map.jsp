<%@page import="java.util.ArrayList"%>
<%@page import="com.map.dto.mapDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MyPosition</title>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<style>
/* Always set the map height explicitly to define the size of the div element that contains the map. */
#map {
	height: 100%;
}
/* Optional: Makes the sample page fill the window. */
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
<script defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDtrVIsB2_LjXiFUjZ7lIm-fYUHW3qJ9R4&callback=initMap"></script>
</head>
<script type="text/javascript">
	
	function goHomepage(url){
		open(url);
	}
	
	$(function() {
		
		$("select").change(function() {
			$("#tema").val($("select").val());
		});

		$("#search").click(function() {
			var command = $("#command").val();
			var tema = $("#tema").val();
			var title = $("#title").val();

			$.ajax({
				url : "controller.do?command=" + command + "&tema=" + tema + "&title=" + title,
				dataType : "json",
				success : function(data) {
					$.each(data, function(key, val) {
						var list = val;
						var count = 1;
						function initMap() {
							var map = new google.maps.Map(document.getElementById('map'), {
								center : {
									lat : 33.374073,
									lng : 126.538540
								},
								zoom : 10
							});
							var markers = new Array();
							if (list != null) {
								for (var i = 0; i < list.length; i++) {
									
									var icon=null;
									if(list[i].temaNo==1){
										icon = 'img/��Ŀ1.png';
									}else if(list[i].temaNo==2){
										icon = 'img/��Ŀ2.png';
									}else if(list[i].temaNo==3){
										icon = 'img/��Ŀ3.png';
									}else if(list[i].temaNo==4){
										icon = 'img/��Ŀ4.png';
									}
									
									var marker = new google.maps.Marker({
										position : {
											lat : list[i].xMap,
											lng : list[i].yMap
										},
										map : map,
										icon : icon
									});
									markers.push(marker);
									
									var phone = '';
									var home = '';
									
									if(list[i].phone!=null){
										phone = list[i].phone
									}else{
										phone = '�������';
									}
									if(list[i].homePage!=null){
										home = '<a style="color: blue;" onclick="goHomepage(\''+list[i].homePage+'\');">'+list[i].homePage+'</a>';
									}else{
										home = '�������';
									}
									
									var contentString = '<div><p><b>�з�</b> : '+list[i].sortName+'<br/>'+
														'<b>�̸�</b> : '+list[i].title+'<br/>'+
														'<b>�ּ�</b> : '+list[i].addr+'<br/>'+
														'<b>��ȭ��ȣ</b> : '+phone+'<br/>'+
														'<b>Ȩ������</b> :'+home+'<br/>'+
														'<b>����</b> : '+list[i].description+'<p><br/>'+
														'<span style="font: blue"><b><a href="controller.do?command=asTema">���ñ� ����</a></b></span></div>';
									attechContentString(marker, contentString);
									function attechContentString(marker, contentSting) {
										var infowindow = new google.maps.InfoWindow({
											content : contentSting
										});
										marker.addListener('click', function() {
											if (count % 2 != 0) {
												infowindow.open(marker.get('map'), marker);
												count++;
											} else {
												infowindow.close(marker.get('map'), marker);
												count++;
											}
										});
									}
								}
								var markerCluster = new MarkerClusterer(map, markers, {
									imagePath : 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'
								});
							}
						}
						initMap();
					});
				},
				error : function() {
					alert("�˻� ����� �����ϴ�.");
				}
			});
		});
	});
</script>
<body>
	<div>
		<input type="hidden" name="command" id="command" value="search">
		<input type="hidden" name="tema" id="tema" value="5">
		<table>
			<tr>
				<td><select>
						<option value="5">--��ü--</option>
						<option value="1">�ؼ���/�ؾ��å��</option>
						<option value="2">���ð�/��ȭ�Կ���</option>
						<option value="3">����</option>
						<option value="4">����</option>
				</select></td>
				<td><input type="text" id="title" name="title"></td>
				<td><input type="button" id="search" value="�˻�"></td>
			</tr>
		</table>

		<div id="map" style="width: 500px; height: 500px;"></div>
	</div>
	<script type="text/javascript">
	
		function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 33.374073,
					lng : 126.538540
				},
				zoom : 10
			});
		}
	</script>

</body>
</html>