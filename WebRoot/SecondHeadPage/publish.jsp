<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1 class="txt2">二手物品发布界面</h1>
   <form action="saveGoods.action" method="post" enctype="multipart/form-data">
       物品名称:<input type="text" name="GOODSNAME"/><br/>
        物品详细信息:<input type="textarea" name="DETAIL"/><br/>
        物品价位:<input type="text" name="PRICE"/><br/>
        卖家姓名:<input type="text" name="SELLERNAME"/><br/>
        卖家手机号码:<input type="text" name="TEL"/><br/>
      上传实物图：<input type="file" name="upLoad"><br/>
     <input type="submit" value="点击 发布"/>
   </form>
  </body>
</html>
