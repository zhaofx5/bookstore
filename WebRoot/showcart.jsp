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
   <div id="content">
    <h1 class="txt2">购物车：</h1>
     <c:choose>
    <c:when test="${empty cart}">
      <h1>购物车为空</h1>
    </c:when>
    <c:otherwise>
       <c:set var="sum" value="0" scope="page"></c:set>
	    <table>
	      <tr><td>书籍名称</td><td>数量</td><td>价格</td><td>总价</td></tr>
			<c:forEach items="${cart}" var="item">
			 <tr>
			  <td>${item.book.title }</td>
			  <td>${item.count }</td>
			  <td>${item.book.price }</td>
			  <td>${item.count * item.book.price }</td>
			  <c:set var="sum" value="${sum + item.count * item.book.price}"></c:set>
			 </tr>
			</c:forEach>
			
	    </table>	    
	    <p>总价:${sum }</p>
    </c:otherwise>
   </c:choose>
   <span><a href="query.action">继续选择书籍</a></span>
   <span>结账</span>
    
    </div>
   </div>
  </body>
</html>
