<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%> 
<% 	
	ProductBeans pb = (ProductBeans)session.getAttribute("pb");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新ページ</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/adminStyle.css">
</head>
<body class="center">
<form action="/ECpage/AdUpdateCheck2" method="post">
<p>変更箇所に入力してください。↓</p>
		<input type="hidden" name="id" value="<%= pb.getId() %>">
		名前：<input type="text" name="name" value="<%= pb.getName() %>"><br>
		価格：<input type="text" name="price" value="<%= pb.getPrice() %>"><br>
		<p>説明：</p><textarea name="exp" cols="35" rows="10"><%= pb.getExp() %></textarea><br>	
		画像名：<input type="text" name="fileName" value="<%= pb.getFileName() %>"><br>
		<input type="submit" value="更新する">	
</form>

</body>
</html>