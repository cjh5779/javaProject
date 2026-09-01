<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
    <table>
        <thead>
            <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>가격</th>
                <th>제조사</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.prdNo}</td>
                    <td>${product.prdName}</td>
                    <td>${product.prdPrice}원</td>
                    <td>${product.prdCompany}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
	</body>
</html>