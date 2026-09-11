<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	index 페이지 입니다. <br>
	
	<a href="/projectData/showInfo">showInfo</a> <br>
	<a href="/projectData/showInfoMV">showInfoMV</a> <br>
	<a href="/projectData/book/bookInfoView">bookInfoView</a> <br>
	<a href="/projectData/book/bookInfoView2">bookInfoView2</a> <br>
	<a href="/projectData/book/bookInfoView3">bookInfoView3</a> <br>
	<a href="/projectData/book/bookInfoView4">bookInfoView4</a> <br>
	<a href="/projectData/book/bookInfoView5">bookInfoView5</a> <br>
	<a href="<c:url value='/student/studentForm' /> ">studentForm</a> <br>
	<a href="/projectData/product/productForm">상품 등록1</a> <br>
	<a href="<c:url value='/product/productForm2' />">상품 등록 2</a> <br>
	<a href="<c:url value='/product/productForm3' />">상품 등록 3 (또는 4)</a>
</body>
</html>