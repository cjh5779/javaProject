<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>메인 페이지</title>
</head>
<body>
    <div style="text-align:center">
        <h3>Spring JDBC 상품 조회 예제</h3>
        
        <a href="<c:url value='/product/productList'/>">상품 목록 조회</a>
    </div>
</body>
</html>