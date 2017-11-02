<%@page import="entities.Item"%>
<%@page import="entities.Loan"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Federation University Library - User Profile</title>
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/profile.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/navigation.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <navigation>
            <%@include file="./includes/navigation/navigation.jsp" %>
        </navigation>
        
    <div class="header">
        <h1>User Profile</h1>
        <div class="user-options">
            <table>
                <tr><td>
                <a href="./LoanHistoryServlet">Current Loans</a>
                    </td>
                    <td>
                        <a href="./UserBookmarkServlet" >Bookmarks</a>
                    </td>
                    <td>
                        <a href="./CommentHistoryServlet" >Comments</a>
                    </td>
                </tr>
            </table>
            
        </div>
    </div>
        
        
    </head>
    <body>
        
    </body>
</html>
