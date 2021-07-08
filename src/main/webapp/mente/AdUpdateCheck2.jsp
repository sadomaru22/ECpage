<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%> 
<% 	
	ProductBeans pb = (ProductBeans)session.getAttribute("pb");
%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力内容確認</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/adminStyle.css">
</head>
<body class="center">
	<p>入力内容は以下で間違いありませんか？</p>
	<p>↓</p>

	<p>商品名：<%= pb.getName() %></p>
	<p>価格：<%= pb.getPrice() %></p>
	<p>説明：<%= pb.getExp() %></p>
	<p style="margin-bottom:15px;">画像名：<%= pb.getFileName() %></p>
	
	<% System.out.println(pb.getId()); %>
	
	<a href="/ECpage/AdUpdateComp"><button>確定</button></a>
	<a href="/ECpage/mente/AdUpdateCheck.jsp"><button>戻る</button></a>
</body>
</html>