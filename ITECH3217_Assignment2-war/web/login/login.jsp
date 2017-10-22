<%-- 
    Document   : login
    Author     : hoangnguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/ITECH3217_Assignment2-war/includes/styles/login.css" rel="stylesheet" type="text/css">
        <title>FedUni Registration</title>
    </head>
    <body>
        <div class="verticalContain">
            <div class="verticalContainMiddle">
                <%
                    if (request.getParameter("failed") != null) {
                        out.write("<div class=\"message\">Incorrect email or password</div>");
                    }
                    if (request.getParameter("logout") != null) {
                        session.setAttribute("user", null);
                        out.write("<div class=\"message\">Sucessfully Logged out</div>");
                    }
                    if (request.getParameter("newuser") != null) {
                        out.write("<div class=\"message\">Successfully Registered</div>");
                    }
                    if (request.getParameter("needlogin") != null) {
                        out.write("<div class=\"message\">You must login to access that feature</div>");
                    }
                %>
                <div class="login-block">
                    <h1> Federation University Library </h1>
                    <form action="/ITECH3217_Assignment2-war/ProcessLoginServlet" method="post">
                        <input type="email" name="email" value="" placeholder="Email Address" required/>
                        <input type="password" name="password" value="" placeholder="Password" required/>
                        <input class="submit" type="submit" value="Login">
                    </form>
                    <button class="reg" onclick="location.href = '/ITECH3217_Assignment2/login/register/register.jsp'">Registration</button>
                    <button class="guest" onclick="location.href = '/ITECH3217_Assignment2/'">Access as a Guest</button>
                </div>
            </div>
        </div>
    </body>
</html>
