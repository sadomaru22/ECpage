<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%@ page import="java.util.ArrayList" %>    
<% 
	int id = Integer.parseInt(request.getParameter("id"));
	//id = id - 1;
	
	ArrayList<ProductBeans> list = (ArrayList)session.getAttribute("list");
	//ProductBeans li = (ProductBeans)list.get(id);  
	//運用すればするほど、列番号(id)とindexにずれが生じるからこれではだめ。%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除項目の確認</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/adminStyle.css">
</head>
<body class="center">
<% 	for (ProductBeans li : list) {
		if (id == li.getId()) {
			System.out.println("一致"); %>
			<p>商品名:<%= li.getName() %></p>
			<p>本当に削除しますか？</p>
			<a href="/ECpage/AdDelete?id=<%=id %>"><button>はい</button></a>
			<a href="/ECpage/mente/AdloginOk.jsp"><button>いいえ</button></a>
<% 		}
	}
%>
</body>
</html>