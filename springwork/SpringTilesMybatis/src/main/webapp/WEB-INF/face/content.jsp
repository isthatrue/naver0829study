<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
</head>
<body>
	<h5 class="alert alert-success">사진에서 얼굴 인식하기</h5>
	<h6>얼굴이 많이 포함된 사진으로 업로드 해주세요.</h6>
	<input type="file" id="upload">
	<br>
	<div class="jdata" style="width: 400px;">Json 결과 출력</div>
	<h6>원본 이미지</h6>
	<img src="" id="facephoto" style="max-width: 400px;">
	<div id="photoinfo" style="margin-left: 5px; width: 300px;">결과 출력</div>
</body>
</html>