<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%
	ProductBeans p = (ProductBeans)request.getAttribute("p");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細ページ</title>
</head>
<body>
<table border="1">
<tr>
<td rowspan="3"><img src="/ECpage/JSP/img/<%= p.getFileName() %>" height="250px" width="150px"></td>
<td><p>商品ID：<%= p.getId() %></p></td>
</tr>
<tr>
<td><p>商品名：<%= p.getName() %></p></td>
</tr>
<tr>
<td><p>価格：<%= p.getPrice() %></p></td>
</table>
<p>商品説明：<%= p.getExp() %></p>
<br>
<hr>
<a href="/ECpage/CartAddAction?id=<%=p.getId() %>"><button>カートに追加</button></a>
<a href="/ECpage/SeafoodServlet">商品一覧へ戻る</a>
</body>
<jsp:include page="footer.jsp" />
</html>