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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
  </head>
  
  <body >
  <div id="main">
   <div id="content">
    <h1 class="txt2">图书管理列表：  
    </h1>
    
    <c:forEach items="${requestScope.books}" var="book">
     <a href="querySingleBook.action?bookid=${book.bookid }">
     <div class="lstBook">
     <!-- 这个是图书的文字标题
      <span class="txt1">☆${book.title }</span><hr/>
       -->
      <img class="lstpic" src="upLoad/${book.pic}" height="200" width="200"/>
     </div></a>
    </c:forEach>
    </div>
   </div>
  </body>
</html>
