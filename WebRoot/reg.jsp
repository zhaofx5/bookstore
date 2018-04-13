<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
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
  <h1 class="txt2">注册界面</h1>
   <form action="reg.action" method="post" enctype="multipart/form-data">
       用户名:<input type="text" name="user"/><br/>
       密码：&nbsp<input type="password" name="pass"/><br/>
      上传头像：<input type="file" name="upLoad"><br/>
     <input type="submit" value="点击 注册"/>
   </form>
   </div>
   </div>
  </body>
</html>
