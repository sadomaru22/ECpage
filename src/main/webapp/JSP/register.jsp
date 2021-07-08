<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/userStyle.css">
</head>
<body class="center">
	<form action="/ECpage/AccountRegister" method="post">
	<p>すべて入力してください↓</p>

	<p>名前：      <input type="text" name="name" required></p>
	<p>ユーザーID：<input type="text" name="loginId" required></p>
	<p>パスワード：<input type="password" name="pass" required></p>
	<p></p>
	<input type="submit" value="登録"><br>
		</form>
</body>
</html>