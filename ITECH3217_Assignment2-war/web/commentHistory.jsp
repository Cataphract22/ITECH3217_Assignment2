<%@page import="entities.Comment"%>
<%@page import="java.util.List"%>
<%@page import="entities.Item"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Federation University Library - Comment Overview</title>
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/commentHistory.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/navigation.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <navigation>
            <%@include file="./includes/navigation/navigation.jsp" %>
        </navigation>
    
        <h1>My Comments</h1>
        <div class="verticalContainer">
            <div class="content-block">           
                <!-- Iterate through item list, build HTML for each item -->

                <% Iterator itr; %>
                <% List list = (List) request.getAttribute("list"); %>
                <% Item item = new Item(); %>
                
                
                
                <% if (list != null && list.size() > 0) { %>
                <table
                   <li class='loan-container'> 
                    <tr>
                        <td>Item</td>
                        <td>Comment</td>
                        
                    </tr>
                <ul>
                    <%  for (itr = list.iterator(); itr.hasNext();) {
                            Comment comment = (Comment) itr.next();
                            item = comment.getItem();
                            

                    %>
                    <tr>
                        <td>
                            
                            <% out.println(item.getTitle()); %>
                        </td>
                        <td>
                            <% out.println(comment.getCommentText()); %>
                        </td>
                        
                    </tr>
                    <% } %> <!--EndFor-->
                    </li> 
                </table>
                </ul>
                <% } %> <!--EndIf-->
            </div>
        </div>
        
    </body>
</html>
