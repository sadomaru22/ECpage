<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%> 
<% 	
	ProductBeans pb = (ProductBeans)session.getAttribute("pb");
%>        
<!DOCTYPE html>
<html>
<style>
input, textarea {
	margin-bottom: 25px;
}
</style>
<head>
<meta charset="UTF-8">
<title>商品の新規登録</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/adminStyle.css">
</head>
<body class="center">
<%
	if (pb == null) {
%>
<form action="/ECpage/AdRegister" method="post">
<p>すべて入力してください。↓</p>

	名前：<input type="text" name="name" required><br>
	価格：<input type="text" name="price" required><br>
	<p>説明：</p><textarea name="exp" cols="35" rows="10" required></textarea><br>	
	画像名：<input type="text" name="fileName" required><br>
	<input type="submit" value="登録する">	
</form>
<% } else { %>
<form action="/ECpage/AdRegister" method="post">
<p>すべて入力してください。↓</p>

	名前：<input type="text" name="name" value="<%= pb.getName() %>" required><br>
	価格：<input type="text" name="price" value="<%= pb.getPrice() %>" required><br>
	<p>説明：</p><textarea name="exp" cols="35" rows="10" required><%= pb.getExp() %></textarea><br>	
	画像名：<input type="text" name="fileName" value="<%= pb.getFileName() %>" required><br>
	<input type="submit" value="登録する">	
</form>
<% } %>
</body>
</html>