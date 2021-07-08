<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.AdminBeans" import="model.ProductBeans" %>
<%@ page import="java.util.ArrayList" %>        
<%	
	ArrayList<ProductBeans> list = (ArrayList)session.getAttribute("list");

	AdminBeans amb = (AdminBeans)session.getAttribute("amb");
	if (amb == null) {	//情報セキュリティ() %> 
		<jsp:forward page="login.jsp" /> 		
<% } %>
<%	String message = (String)session.getAttribute("message");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン成功‼</title>
</head>
<body>
<p><%= message %></p>
<a href="/ECpage/mente/AdRegister.jsp"><button>商品の新規登録</button></a>
<br>
<table border="1" style="border-collapse:separate; border-spacing:10px;">


<% for (ProductBeans p : list) { %>
<tr>

	<td>商品No.<% out.println(String.format("%02d", p.getId())); %></td>
	<td><img src="/ECpage/JSP/img/<%= p.getFileName() %>" height="64"></td>
	<td><%= p.getName() %></td>	
	<td><%= p.getPrice() %>円</td>
	<td><a href="/ECpage/AdUpdateCheck?id=<%= p.getId() %>"><button style="margin-left:15px;">商品の更新</button></a></td>
	<td><a href="/ECpage/mente/AdDeleteCheck.jsp?id=<%= p.getId() %>"><button style="margin-left:15px;">商品の削除</button></a></td>

</tr>
<% 	} %>
	</table>
	<hr>
</body>
</html>