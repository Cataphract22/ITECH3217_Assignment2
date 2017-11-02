<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="../includes/styles/login.css" rel="stylesheet" type="text/css">
        <title>Federation University Library - Login</title>
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
                        out.write("<div class=\"message\">You must login to use feature</div>");
                    }
                %>
                <div class="login-block">
                    <h1> Federation University Library </h1>
                    <form action="../ProcessLoginServlet" method="post">
                        <input type="email" name="email" value="" placeholder="Email Address" required/>
                        <input type="password" name="password" value="" placeholder="Password" required/>
                        <input class="submit" type="submit" value="Login">
                    </form>
                    <button class="reg" onclick="location.href = '../login/register/register.jsp'">Registration</button>
                    <button class="guest" onclick="location.href = '../index.jsp'">Access as a Guest</button>
                </div>
            </div>
        </div>
    </body>
</html>
