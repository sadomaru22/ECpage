<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String message = (String)session.getAttribute("message");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/adminStyle.css">
</head>
<body class="center">
<% if (message != null) { %>
<p><%= message %></p>
<% } %>
	<form action="/ECpage/watanabe" method="post">
		ユーザーID：<input type="text" name="loginId" required><br>
		<br>
		パスワード：<input type="password" name="password" required><br>
		<br>
		<input type="submit" value="ログイン"><br>		
	</form>

</body>
</html>