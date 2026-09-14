<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 목록</title>
</head>
<body>
    <h2 style="text-align:center;">상품 목록</h2>
    <table align="center" border="1" width="80%">
        <tr align="center" bgcolor="lightblue">
            <th>상품 아이디</th>
            <th>상품명</th>
            <th>가격</th>
            <th>제조사</th>
        </tr>
        <c:choose>
            <c:when test="${empty prdList}">
                <tr>
                    <td colspan="4" align="center">등록된 상품이 없습니다.</td>
                </tr>
            </c:when>
            <c:otherwise>
                <c:forEach var="prd" items="${prdList}">
                    <tr align="center">
                        <td>${prd.prdId}</td>
                        <td>${prd.prdName}</td>
                        <td>${prd.prdPrice}</td>
                        <td>${prd.prdMaker}</td>
                    </tr>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </table>
</body>
</html>