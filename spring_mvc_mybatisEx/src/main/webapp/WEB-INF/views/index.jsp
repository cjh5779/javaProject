<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
</head>
<body>
	<h3>MyBatis 사용 DB 연동</h3>
	<h4>도서 관리 시스템</h4>
	<br>
	<a href="<c:url value='/book/listAllBook'/>">전체도서조회</a><br>
	<a href="<c:url value='/book/newBookForm'/>">도서등록</a><br>
	<a href="<c:url value='/book/bookSearchForm'/>">도서검색</a>
</body>
</html>