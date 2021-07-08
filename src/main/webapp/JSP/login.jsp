<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/userStyle.css">
</head>
<body class="center">
	<form action="/ECpage/AccountSearch" method="post">
		ユーザーID：<input type="text" name="loginId" required><br>
		<p></p>
		パスワード：<input type="password" name="password" required><br>
		<p></p>
		<input type="submit" value="ログイン"><br>		
	</form>
	
	<p>
	アカウント登録がお済みでない方はこちらへ↓<br>
	<a href="register.jsp"><button>新規登録</button></a>
	</p>	
</body>
</html>