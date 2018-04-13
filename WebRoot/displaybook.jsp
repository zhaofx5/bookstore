<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'displaybook.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/main.css">

  </head>
  
  <body>
    <div id="main">
    
    <%@include file="head.jsp" %>
   <div id="content" >
    <h1 class="txt2">书籍详情：</h1>
    
   <c:choose>
    <c:when test="${empty book}">
      <h1>书籍未找到</h1>
    </c:when>
    <c:otherwise>
       <h1>${book.title }</h1>
	    <img src="img/${book.pic }"/>
	    书籍ID：${book.bookid }<br/>
	    作者：${book.author }<br/>
	    价格： ${book.price }<br/>
	    <a href="cart.action?bookid=${book.bookid }"><span>加入购物车</span></a>
	    
    </c:otherwise>
   </c:choose>
    
    </div>
   </div>
  
  
  
  </body>
</html>
