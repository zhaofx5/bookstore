<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="head">
      <div class="loginstatus">
        <c:choose>
          <c:when test="${empty esessionScope.user}">
            <span><a href="login.jsp">登录</a></span> <span><a href="reg.jsp">注册</a></span>
          </c:when>
          <c:otherwise>
          <img  src="upLoad/${user.filename}" height="60px"/>
           <span>${user.username } 你好！</span> 
           <a href="logout.jsp"><span>注销用户</span></a>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
