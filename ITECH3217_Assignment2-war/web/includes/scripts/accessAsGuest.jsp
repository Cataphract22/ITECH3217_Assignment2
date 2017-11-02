<%
request.getSession().setAttribute("loggedIn", "false");
response.sendRedirect("../../index.jsp");
%>