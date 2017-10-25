<%-- 
    Document   : index
    Author     : hoangnguyen
--%>

<%@page import="entities.Ebook"%>
<%@page import="entities.Equipment"%>
<%@page import="entities.Book"%>
<%@page import="entities.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Get Item and subtype -->
<%
    Item item = (Item) request.getAttribute("item");
    int itemId = item.getItemid();
%>
<jsp:include page="./GetItemTypeServlet">
    <jsp:param name="item" value="<%=itemId%>"/>
</jsp:include>

<!DOCTYPE html>
<html>
    <head>
        <title>FedUniLibrary</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/details.css" rel="stylesheet" type="text/css">
        
    <div class="header">
        <h1>Welcome to Federation University Library</h2>
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
                        <tr><TD class='description'><%out.println(item.getDescription());%></TD></tr>

                        <!-- Loan -->
                        <jsp:include page="/CheckLoanServlet">
                            <jsp:param name="item" value="<%=itemId%>"/>
                        </jsp:include>
                        <tr><td><p> </p></td></tr>
                        <form action="./LoanServlet?id=<%out.println(item.getItemid());%>" method="POST">
                            <tr><td><input class="itemButton" type="submit" value="<%out.println(request.getAttribute("loan"));%>"></input></td></tr>
                        </form> 
                        
                        <!-- Bookmark -->
                        <jsp:include page="/CheckBookmarkServlet">
                            <jsp:param name="item" value="<%=itemId%>"/>
                        </jsp:include>
                        <form action="./BookmarkServlet?id=<%out.println(item.getItemid());%>" method="POST">
                            <tr><td><input class="itemButton" type="submit" value="<%out.println(request.getAttribute("bookmark"));%>"></input></td></tr>
                        </form> 
                    </table>              
                 
            </div>
    </div>

    <body>
        <div class="verticalContain">
            <div class="content-block">           
                <!-- Build HTML for each comment -->
                <ul>
                    <li class='comment-container'>
                    </li> 
                </ul>

            </div>
        </div>
    </body>
</html>