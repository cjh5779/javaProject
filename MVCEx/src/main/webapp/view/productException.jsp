<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	isErrorPage="true"    
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>예외발생</title>
	</head>
	<body>
		==========================================<br>
		<h3><%=exception.toString() %></h3>
		==========================================<br>
		<h3><%=exception.getMessage() %></h3>
		==========================================<br>
		<h3>다시 시도하세요.</h3>
		<a href='main.jsp'>메인으로 돌아가기</a>
	</body>
</html>