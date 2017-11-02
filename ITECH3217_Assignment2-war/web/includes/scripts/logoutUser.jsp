<%
session.invalidate();
request.getSession().setAttribute("loggedIn", "false");
response.sendRedirect("../../login/login.jsp");
%>