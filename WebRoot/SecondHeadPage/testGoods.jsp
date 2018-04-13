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
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">

  </head>
  
  <body>
  <span><a href="SecondHeadPage/publish.jsp">点击发布二手物品交易信息</a></span>
  <span><a href="SecondHeadPage/managerlogin.jsp">管理人员登陆入口</a></span>
    <div>
    您发布的二手物品在网站管理员审核之后会展示在出来，一般会在三个工作日内通过审核，请耐心等待。<br/>
    下方是二手物品交易列表<br/><br/><br/> 
    <div >
    <!-- 通过循环展示所有待交易的物品 -->
    <c:forEach items="${requestScope.goods}" var="good">
      <div class="lstGood">
      <span class="txt1">物品名称☆${good.GOODSNAME}</span><hr/>
      <span class="txt1">详细描述☆${good.DETAIL}</span><hr/>
      <span class="txt1">价位☆${good.PRICE}</span><hr/>
      <span class="txt1">卖家☆${good.SELLERNAME}</span><hr/>
      <span class="txt1">卖家电话☆${good.TEL}</span><hr/>
      <img class="lstpic" src="upLoad/${good.PIC}" height="200" width="200"/><br/>
      <a href="changeState.action?SELLERNAME=${good.SELLERNAME}">审核通过</a><br/>
      <a href="">审核不通过</a><br/>
      </div>
    </c:forEach>
    </div>
    </div>
  </body>
</html>
