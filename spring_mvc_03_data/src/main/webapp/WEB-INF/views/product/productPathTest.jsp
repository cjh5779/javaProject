<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Path 테스트</title>
</head>
<body>
    상품번호: ${prdNo} <br>
    상품명: ${prdName} <br>
    재고: ${prdStock} <br>
    가격: ${prdPrice} <br>
    제조사: ${prdCompany} <br>

    <p>url을 통한 데이터 전달<br>
       상품정보상세보기의 링크 예시
    </p>

    URL 방식 : 단일 값 전달 (PathVariable 방식)<br>
    상품명 : <a href="<c:url value='/product/productDetailView/${prdName}' />">${prdName}</a>
    <br><br>

    URL 방식 : 여러 값을 전달<br>
    상세정보 : <a href="<c:url value='/product/productDetailView/${prdName}/${prdStock}/${prdNo}' />">${prdName}, ${prdStock}, ${prdNo}</a>
    <br>
</body>
</html>