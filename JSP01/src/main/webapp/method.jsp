<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메소드 정의</title>
		</head>
	<body>
		<h2>선언문-메소드</h2>
		
		<%!
			String id = "abcd";
			
			// 선언부에서만 선언할 수 있음
			public String getId() {
				return id;
			}
		%>
		
		id 변수 : <%= id %><br>
		getId() 메소드 호출 결과 : <%= getId() %>
	</body>
</html>