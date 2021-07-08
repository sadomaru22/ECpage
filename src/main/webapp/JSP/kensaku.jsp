<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品検索ページ</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/userStyle.css">
</head>
<body class="center">
	<p>検索キーワードを入力してください</p>
	<form action="/ECpage/Kensaku" method="post">
		<input type="text" name="keyword">
		<input type="submit" value="検索">
	</form>
</body>
</html>