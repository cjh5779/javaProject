<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>파일 업로드 폼</title>
	</head>
	<body>
		<h3>이미지 파일 업로드</h3>
		<form id="fileUploadFrm">
			파일 : <input type="file" id="uploadFile" name="uploadFile"><br><br>
			<input type="submit" value="업로드">
		</form>
		
		<hr>
		
		<h3>업로드한 이미지</h3>
		<div id="imageBox"></div>
		
		<br>
		<a href="<c:url value='/'/>">메인으로 이동</a>
	</body>
</html>