<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    session.removeAttribute("email");
%>
<html>
    <head>
        <title>Federation University Libraty Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../../includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="../../includes/styles/login.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="../../includes/scripts/functions.js"></script>
    </head>
    <body>
        <div class="verticalContain">
            <div class="verticalContainMiddle">
                <%
                    if (request.getParameter("failed") != null) {
                %>
                <div class="message">Registration Failed</div>
                <%
                    }
                %>
                <div class="login-block">
                    <h1>Federation University Library Registration</h1>
                    <form action="registration/" method="post">
                        <input type="text" name="firstName" value="" placeholder="First Name" required/>
                        <input type="text" name="lastName" value="" placeholder="Last Name" required/>
                        <input type="email" name="email" value="" placeholder="Email Address" required/>
                        <input type="tel" name="phone" value="" placeholder="Phone Number" required/>
                        <input type="password" name="password" value="" placeholder="Password" required/>
                        <input class="submit" type="submit" value="Register">
                    </form>
                    <button class="reg" onclick="goBackAPage()">Cancel</button>
                </div>
            </div>
        </div>
    </body>
</html>
