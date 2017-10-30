<%@page import="entities.User"%>
<%@page import="entities.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="entities.Ebook"%>
<%@page import="entities.Equipment"%>
<%@page import="entities.Book"%>
<%@page import="entities.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // check if admin user - if not: redirect to login.jsp
    if(!request.getSession().getAttribute("admin").equals(1)) {
        %>
        <meta http-equiv="refresh" content="0;URL='/login/login.jsp'" />
        <%
    }
%>

<!-- Get Item and subtype -->
<%
    Item item = (Item) request.getAttribute("item");
    List comments = (List) request.getAttribute("comments");
    int itemId = item.getItemid();
%>
<jsp:include page="./GetItemTypeServlet">
    <jsp:param name="item" value="<%=itemId%>"/>
</jsp:include>

<!DOCTYPE html>
<html>
    <head>
        <title>Federation University Library - Administrator</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/details.css" rel="stylesheet" type="text/css">
    </head>
<body>    
    <div class="header">
        <h1>ADMINISTRATOR PAGE - TO BE COMPLETED</h2>
            <h1>Details</h1>
            <div class="search-container">
                
                    <img class='coverImage' src='<%out.println(item.getImage());%>' width="120"</img>
                    <table>
                        <tr><td><h3 class='title'><%out.println(item.getTitle());%></h3></td></tr>

                        <!-- BOOK -->
                        <% if (request.getAttribute("book") != null) { %>
                        <% Book book = (Book) request.getAttribute("book"); %>
                        <tr><td class="author"><%out.println(book.getAuthor());%></td></tr>
                        <tr><td class="publisher">Published by: <%out.println(book.getPublisher());%>, <%out.println(book.getPublishYear());%></td></tr>
                        <tr><td class='isbn'>ISBN-13: <%out.println(book.getIsbn());%></td></tr>
                        <% } %><!--EndIf-->

                        <!-- EBOOK -->
                        <% if (request.getAttribute("ebook") != null) { %>
                        <% Ebook ebook = (Ebook) request.getAttribute("ebook"); %>
                        <tr><td class='author'><%out.println(ebook.getAuthor());%></td></tr>
                        <tr><td class="publisher">Published by: <%out.println(ebook.getPublisher());%>, <%out.println(ebook.getPublishYear());%></td></tr>
                        <tr><td class='isbn'>ISBN-13: <%out.println(ebook.getIsbn());%></td></tr>
                        <% } %><!--EndIf-->

                        <!-- EQUIPMENT -->
                        <% if (request.getAttribute("equipment") != null) { %>
                        <% Equipment equipment = (Equipment) request.getAttribute("equipment"); %>
                        <tr><td class='model'>Model: <%out.println(equipment.getModel());%></td></tr>
                        <tr><td class='serialno'>Serial#: <%out.println(equipment.getSerialno());%></td></tr>
                        <% } %><!--EndIf-->

                        <tr><td><p> </p></td></tr>
                        <tr><td class='description'><%out.println(item.getDescription());%></td></tr>

                        <!-- Loan -->
                        <jsp:include page="/CheckLoanServlet">
                            <jsp:param name="item" value="<%=itemId%>"/>
                        </jsp:include>
                        <tr><td><p> </p></td></tr>
                        <form action="./LoanServlet?id=<%out.println(item.getItemid());%>" method="POST">
                            <tr><td><input class="searchButton" type="submit" value="<%out.println(request.getAttribute("loan"));%>"></input></td></tr>
                        </form> 
                        
                        <!-- Bookmark -->
                        <jsp:include page="/CheckBookmarkServlet">
                            <jsp:param name="item" value="<%=itemId%>"/>
                        </jsp:include>
                        <form action="./BookmarkServlet?id=<%out.println(item.getItemid());%>" method="POST">
                            <tr><td><input class="searchButton" type="submit" value="<%out.println(request.getAttribute("bookmark"));%>"></input></td></tr>
                        </form> 
                    </table>              
                 
            </div>
    </div>

<!--    <body>-->
        <div class="verticalContain">
            <div class="content-block">
                
                <!-- New comment form -->
                
                <div class="new-comment-container"><h2>Comments</h2></div>              
                <!-- Get comment list, build HTML for each item -->
                <% Iterator itr; %>
                <% if (comments != null && comments.size() > 0) { %>
                <ul>
                    <!-- Build comment form -->
                    <form action="./CommentServlet?id=<%out.println(item.getItemid());%>" method="POST" style="width: 450px; margin-left: 20px;">
                        <li class='form-comment-container' style="margin-bottom: 0px;">
                            <table class='form-comment-table'>
                                <tr><td style="padding: 0px;"><h4 class='form-comment-head'>New Comment: ( Posting as <%out.println(session.getAttribute("email"));%>)</h4></td></tr>
                                <tr><td><textarea rows="2" class="form-comment-text" name="commentText" value=""></textarea></td></tr>
                            </table>
                        </li>
                        <input class="comment-button" type="submit" value="Post Comment"></input>
                    </form> 

                    <!-- Build comments -->
                    <%  for (itr = comments.iterator(); itr.hasNext();) {
                            Comment comment = (Comment) itr.next();
                    %>
                    
                    <li class='comment-container'>
                        <h3 class='comment-head'><%out.println(comment.getUserid().getGivenname() + " " + comment.getUserid().getFamilyname());%></h3>
                        <p class="comment-text"><%out.println(comment.getCommenttext());%></p>           
                    </li> 
                    <% } %> <!--EndFor-->
                </ul>
                <% } %> <!--EndIf-->
            </div>
        </div>
    </body>
</html>