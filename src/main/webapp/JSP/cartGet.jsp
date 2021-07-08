<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%@ page import="java.util.ArrayList" %>  
<%
	ArrayList<ProductBeans> cart = (ArrayList)session.getAttribute("cart");
	int count= 0;
	int total = 0;
%>
<style>
	.total {
		display: block;
		margin: 0 0 0 auto;
	}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートの中身確認ページ</title>
</head>
<body style="height: 350px">
<p><%= cart.size() %>個の商品をカートに入れています。</p>
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
		<td><a href="/ECpage/CartDelete?delete=<%=count - 1 %>"><button style="margin-left:15px;">カートから削除</button></a></td>
		
<% 
total = total + p.getPrice(); }
%>
</tr>
	</table>
	<hr>
<p class="total">合計金額：<%=total %>円</p>
<br>
<% if (cart.size() != 0) { %>
<a href="/ECpage/JSP/oderConfirm.jsp"><button>レジへ進む</button></a>
<% } %>	
<a href="/ECpage/SeafoodServlet"><button>商品一覧へ戻る</button></a>
<a href="/ECpage/JSP/Toppage.jsp"><button>トップページへ戻る</button></a>
</body>
</html>

