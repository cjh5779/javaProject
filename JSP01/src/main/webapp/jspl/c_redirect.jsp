<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:redirect 태그 사용</title>
	</head>
	<body>
		<c:redirect url="/jstl/urlTestRes.jsp">
			<c:param name="id" value="hong"/> <%-- ?id=hong --%>
			<c:param name="pwd" value="1234"/><%-- ?id=hong&pwd=1234 --%>
			<c:param name="name" value="홍길동"/>
			<c:param name="email" value="client 재요청"/><%-- /JSP01/jstl/urlTestRes.jsp?id=hong&pwd=1234&name=홍길동&email=hong@test.com --%>
		</c:url>
	</body>
</html>