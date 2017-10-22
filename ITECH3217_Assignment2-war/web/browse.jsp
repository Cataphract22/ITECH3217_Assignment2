<%-- 
    Document   : index
    Author     : hoangnguyen
--%>

<%@page import="entities.Ebook"%>
<%@page import="entities.Equipment"%>
<%@page import="entities.Book"%>
<%@page import="entities.Item"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FedUniLibrary</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="/ITECH3217_Assignment2-war/includes/styles/browse.css" rel="stylesheet" type="text/css">
    <body>
        <div class="verticalContain">
            <div class="verticalContainMiddle">
                <div class="header">
                    <h1>Welcome to Federation University Library</h2>
                </div>
                <div class="content-block">
                    <div class="content">
                        <div class="subcontent">
                            <h1>Browse Books</h1>
                            <input type="checkbox" name="showBooks" checked="checked" />
                            <label for='showBooks'>Show Books</label>
                            <input type="checkbox" name="showEbooks" checked="checked" />
                            <label for='showEbooks'>Show eBooks</label>
                            <input type="checkbox" name="showEquipment" checked="checked" />
                            <label for='showEquipment'>Show Equipment</label>
                            <p></p>
                            <% Iterator itr; %>
                            <% List list = (List) request.getAttribute("list");
                            for (itr = list.iterator(); itr.hasNext();) {
                                Item item = (Item) itr.next();
                                int itemId = item.getItemid();
                                %>
                                <jsp:include page="/CheckBookmarkServlet">
                                    <jsp:param name="item" value="<%=itemId%>"/>
                                </jsp:include>
                                <jsp:include page="./GetItemTypeServlet">
                                    <jsp:param name="item" value="<%=itemId%>"/>
                                </jsp:include>

                                <form action="/ITECH3217_Assignment2-war/BookmarkServlet?id=<%out.println(item.getItemid());%>" method="POST">
                                    <div class='item-container'>
                                        <h2 class='title'><%out.println(item.getTitle());%></h2>
                                        <img class='coverImage' src='<%out.println(item.getImage());%>' width="120"</img>
                                        
                                        <!-- BOOK -->
                                        <% if (request.getAttribute("book") != null) { 
                                            Book book = (Book) request.getAttribute("book");
                                        %>
                                            <p class='author'><%out.println(book.getAuthor());%></p>
                                            <p class='publisher'>Published by: <%out.println(book.getPublisher());%>, <%out.println(book.getPublishYear());%></p>
                                            <p class='isbn'>ISBN-13: <%out.println(book.getIsbn());%></p>
                                    
                                        <%}%>
                                        
                                        <!-- EBOOK -->
                                        <% if (request.getAttribute("ebook") != null) { 
                                            Ebook ebook = (Ebook) request.getAttribute("ebook");
                                        %>
                                            <p class='author'><%out.println(ebook.getAuthor());%></p>
                                            <p class='publisher'>Published by: <%out.println(ebook.getPublisher());%>, <%out.println(ebook.getPublishYear());%></p>
                                            <p class='isbn'>ISBN-13: <%out.println(ebook.getIsbn());%></p>
                                    
                                        <%}%>
                                        
                                        <!-- EQUIPMENT -->
                                        <% if (request.getAttribute("equipment") != null) { 
                                            Equipment equipment = (Equipment) request.getAttribute("equipment");
                                        %>
                                            <p class='model'>Model: <%out.println(equipment.getModel());%></p>    
                                            <p class='serialno'>Serial#: <%out.println(equipment.getSerialno());%></p>
                                    
                                        <%}%>
                                      
                                        <p class='description'><%out.println(item.getDescription());%></p>
                                        <input type="submit" value="<%out.println(request.getAttribute("bookmark"));%>"></input>
                                    </div>
                                </form>
                                    
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<%
/*
            for (int i = 0; i < results.size(); i++) {
                ItemBook item = (ItemBook) results.get(i);
                out.println(""
                    + "<div class='bookItem'>"
                    + "<h2 class='title'>" + item.getTitle() + "</h2>"
                    + "<img class='coverImage' src='" + item.getImage() + "' </img>"
                    + "<p class='author'>" + item.getAuthor() + "</p>"
                    + "<p class='publisher'>" + item.getPublisher() + "</p>"
                    + "<p class='isbn'>" + item.getIsbn() + "</p>"
                    + "<p class='description'>" + item.getDescription() + "</p>"
                    + "</div>" 
                );
            }
            */
%>