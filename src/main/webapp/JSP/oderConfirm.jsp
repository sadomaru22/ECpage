<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%@ page import="java.util.ArrayList" %>  
<%
	ArrayList<ProductBeans> cart = (ArrayList)session.getAttribute("cart");
	String userName = (String)session.getAttribute("name");	
	int count= 0;
	int total = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注文の確認</title>
<style type="text/css">
body {
	background-color: #cae4ff;
	color: #000000;
}
</style>
</head>
<body>
<% if (userName != null) { %>
<p><%= userName %>さんは現在、</p>
<% } %>
<p><%= cart.size() %>個の商品をカートに入れています。</p>
<p>よろしければ「注文の確定」ボタンを押して、次にお進みください。</p>
	<table style="border-collapse:separate; border-spacing:10px;">
<%
	for (ProductBeans p : cart) { 
	count++;
	%>
<tr>	
		<td>商品<%= count %></td>
		<td><img src="/ECpage/JSP/img/<%= p.getFileName() %>" height="64"></td>
		<td><%= p.getName()%></td>	
		<td><%= p.getPrice() %>円</td>
		
<% 
total = total + p.getPrice(); }
%>
</tr>
	</table>
	<hr>
<p class="total">合計金額：<%=total %>円</p>
<a href="/ECpage/Finish"><button>注文の確定</button></a>	
</body>
</html>
