<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName = (String)session.getAttribute("name");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/userStyle.css">
</head>
<% if (userName != null){ %>
 <p>ようこそ<%= userName %>さん！</p>
<jsp:include page="header.jsp" />
<% } %>
<body class="center">
<p>ご注文ありがとうございました。</p>
<a href="/ECpage/JSP/Toppage.jsp"><button>トップページへ戻る</button></a>
</body>
</html>