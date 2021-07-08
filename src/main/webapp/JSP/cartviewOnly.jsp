<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%@ page import="java.util.ArrayList" %>      
<% 
	ArrayList<ProductBeans> cart = (ArrayList)session.getAttribute("cart");
	if (cart == null) {  //初回
		cart = new ArrayList<ProductBeans>();  
	}
	int count = 0;
	int total = 0;
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カートの中身</title>
</head>
<body>
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
<a href="/ECpage/JSP/Toppage.jsp"><button>トップページへ戻る</button></a>
</body>
<jsp:include page="footer.jsp" />
</html>