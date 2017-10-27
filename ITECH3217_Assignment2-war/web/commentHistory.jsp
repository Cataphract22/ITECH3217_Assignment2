<%-- 
    Document   : commentHistory
    Created on : 27/10/2017, 11:41:31 AM
    Author     : CMD
--%>

<%@page import="entities.Comment"%>
<%@page import="java.util.List"%>
<%@page import="entities.Item"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comment Overview</title>
    </head>
    <body>
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
                            item = comment.getItemid();
                            

                    %>
                    <tr>
                        <td>
                            
                            <% out.println(item.getTitle()); %>
                        </td>
                        <td>
                            <% out.println(comment.getCommenttext()); %>
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
