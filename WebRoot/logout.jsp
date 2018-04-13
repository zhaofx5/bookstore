<%
 session.invalidate();
 request.getRequestDispatcher("/logoutPage.jsp").forward(request,response);
%>