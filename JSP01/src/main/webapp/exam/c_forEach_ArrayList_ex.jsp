<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.exam.ProductVO" %>
<%
    ArrayList<ProductVO> productList = new ArrayList<>();
    productList.add(new ProductVO("P001", "무선 마우스", 25000, "로지텍"));
    productList.add(new ProductVO("P002", "기계식 키보드", 120000, "커세어"));
    productList.add(new ProductVO("P003", "27인치 모니터", 350000, "LG전자"));
    productList.add(new ProductVO("P004", "블루투스 이어폰", 150000, "삼성전자"));

    request.setAttribute("productList", productList);
%>

<jsp:forward page="c_forEach_ArrayList_result_ex.jsp" />