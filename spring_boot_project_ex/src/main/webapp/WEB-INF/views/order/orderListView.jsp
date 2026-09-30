<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>나의 주문 내역</title>
    <c:import url="/WEB-INF/views/layout/head.jsp" />       
</head>
<body>
    <div id="wrap">
        <!-- top -->         
        <c:import url="/WEB-INF/views/layout/top.jsp" />
        
        <section>       
            <h3>나의 주문 내역</h3>
            <table border="1" style="width: 80%; margin: 0 auto; text-align: center;">
                <thead>
                    <tr>
                        <th>주문번호</th>
                        <th>수령인</th>
                        <th>결제금액</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- 주문 내역이 없을 때 -->
                    <c:if test="${empty orderList}">
                        <tr>
                            <td colspan="3">주문 내역이 없습니다.</td>
                        </tr>
                    </c:if>
                    
                    <!-- 주문 내역이 있을 때 -->
                    <c:if test="${not empty orderList}">
                        <c:forEach var="order" items="${orderList}">
                            <tr>
                                <td>${order.ordNo}</td>
                                <td>${order.ordRcvReceiver}</td>
                                <td><fmt:formatNumber value="${order.ordPay}" pattern="#,###" />원</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </section> 
    
        <!-- bottom -->         
        <c:import url="/WEB-INF/views/layout/bottom.jsp" />
    </div>
</body>
</html>