<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<ProductBeans> key = (ArrayList)request.getAttribute("keyword");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<%for (ProductBeans p : key) {
	String url = "/ECpage/DetailServlet";
	url = url + "?id=" + p.getId();	
%>
<table border="1">
<tr>
	<td><a href="<%= url%>"><img src="/ECpage/JSP/img/<%= p.getFileName() %>" height="64px"></a></td>
	<td>商品ID：<%= p.getId() %></td>
	<td>商品名：<%= p.getName() %></td>
	<td>価格：<%= p.getPrice() %></td>
</tr>
<tr>
	<td><a href="/ECpage/DetailServlet?id=<%= p.getId() %>"><button>詳細ページへ</button></a></td>
</tr>
<%-- 
<td><a href="/ECpage/CartAddAction?id=<%= p.getId() %>"><button style="margin-left:15px;">カートに追加</button></a></td>
--%>
</table>
<br>
<% 	}
%>
<a href="/ECpage/JSP/Toppage.jsp"><button>トップページへ戻る</button></a>
</body>
<jsp:include page="footer.jsp" />
</html>