<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ProductBeans"%>
<%@ page import="java.util.ArrayList" %>      
<%  //JSPではsession自動に作られてて、いきなり使える

	ArrayList<ProductBeans> cart = (ArrayList)session.getAttribute("cart");
	if (cart == null) {  //初回
		cart = new ArrayList<ProductBeans>(); 
	}

	//session.setAttribute("cart", cart);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/CSS/userStyle.css">
</head>
<body>
<div id="test">
	<a href="/ECpage/SeafoodServlet"><button>📖商品一覧</button></a>
	<% if (cart.size() != 0) { %>
	<a href="/ECpage/CartView"><button>🛒カートの確認</button></a>
	<% } %>
	<a href="/ECpage/JSP/kensaku.jsp"><button>🔎商品検索</button></a>
	
	<a href="/ECpage/JSP/login.jsp"><button>ログイン</button></a>
	<hr>
	<h2>寿司オンラインショッピングへようこそ！</h2>
</div>
</body>
<jsp:include page="footer.jsp" />
</html>