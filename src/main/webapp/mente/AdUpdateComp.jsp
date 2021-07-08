<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("pb");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新完了</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/adminStyle.css">
</head>
<body class="center">
<p>データを更新しました。</p>
<a href="/ECpage/GoBack">操作ページへ戻る</a>
</body>
</html>