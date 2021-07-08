<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%@ page import="java.util.ArrayList" %>    
<%
	ArrayList<ProductBeans> list = (ArrayList)session.getAttribute("list");
	String userName = (String)session.getAttribute("name");
	//System.out.println(list);
%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>商品一覧ページ</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/userStyle.css">
<body>
<% if (userName != null){ %>
 <p>ようこそ<%= userName %>さん！</p>
<jsp:include page="header.jsp" />
<% } %>
	<table border="1" style="border-collapse:separate; border-spacing:10px;">
<%
	for (ProductBeans p : list) { 
		String url = "/ECpage/DetailServlet";
		url = url + "?id=" + p.getId();
	%>
<tr>	<td>商品No.<% out.println(String.format("%02d", p.getId()));%></td>
		<td><img src="/ECpage/JSP/img/<%= p.getFileName() %>" height="64"></td>
		<td><a href="<%= url %>"><%= p.getName()%></a></td>	
		<td><%= p.getPrice() %>円</td>
		<td><a href="/ECpage/CartAddAction?id=<%=p.getId() %>"><button style="margin-left:15px;">カートに追加</button></a></td>

<% 	}
%>
</tr>
	</table>
	<hr>
<a href="/ECpage/JSP/Toppage.jsp"><button>トップページへ戻る</button></a>
</body>
<jsp:include page="footer.jsp" />	
</html>