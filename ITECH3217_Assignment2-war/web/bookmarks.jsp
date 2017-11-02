<%@page import="entities.Bookmark"%>
<%@page import="entities.Equipment"%>
<%@page import="entities.Ebook"%>
<%@page import="entities.Book"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entities.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Federation University Library - Bookmarks</title>
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/bookmarks.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/navigation.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <navigation>
            <%@include file="./includes/navigation/navigation.jsp" %>
        </navigation>
    
        <h1>Bookmarks</h1>
        <div class="verticalContain">
            <div class="content-block">           
                <!-- Iterate through item list, build HTML for each item -->

                <% Iterator itr; %>
                <% List list = (List) request.getAttribute("list"); %>
                <% if (list.size() > 0) { %>
                <ul>
                    <%  for (itr = list.iterator(); itr.hasNext();) {
                            Bookmark bookmark = (Bookmark) itr.next();
                            Item item =  bookmark.getItem(); //getItemId actually returns the item?
                            int itemId = item.getItemID(); 
                    %>
                    
                    
                    <jsp:include page="./GetItemTypeServlet">
                        <jsp:param name="item" value="<%=itemId%>"/>
                    </jsp:include>
                    <li class='item-container'>
                        <form action="ItemDetailsServlet?id=<%out.println(item.getItemID());%>" method="POST">
                            <img class='coverImage' src='<%out.println(item.getImage());%>' width="120"</img>
                            <table>
                                <tr><td><h3 class='title'><%out.println(item.getTitle());%></h3></td></tr>

                                <!-- BOOK -->
                                <% if (request.getAttribute("book") != null) { %>
                                <% Book book = (Book) request.getAttribute("book"); %>
                                <tr><td class="author"><%out.println(book.getAuthor());%></td></tr>
                                <tr><td class="publisher">Published by: <%out.println(book.getPublisher());%>, <%out.println(book.getPublishYear());%></td></tr>
                                <tr><td class='isbn'>ISBN-13: <%out.println(book.getISBN());%></td></tr>
                                <% } %><!--EndIf-->

                                <!-- EBOOK -->
                                <% if (request.getAttribute("ebook") != null) { %>
                                <% Ebook ebook = (Ebook) request.getAttribute("ebook"); %>
                                <tr><td class='author'><%out.println(ebook.getAuthor());%></td></tr>
                                <tr><td class="publisher">Published by: <%out.println(ebook.getPublisher());%>, <%out.println(ebook.getPublishYear());%></td></tr>
                                <tr><td class='isbn'>ISBN-13: <%out.println(ebook.getISBN());%></td></tr>
                                <% } %><!--EndIf-->

                                <!-- EQUIPMENT -->
                                <% if (request.getAttribute("equipment") != null) { %>
                                <% Equipment equipment = (Equipment) request.getAttribute("equipment"); %>
                                <tr><td class='model'>Model: <%out.println(equipment.getModel());%></td></tr>
                                <tr><td class='serialno'>Serial#: <%out.println(equipment.getSerialNo());%></td></tr>
                                <% } %><!--EndIf-->

                                <tr><td><p> </p></td></tr>
                                <tr><TD class='description'><%out.println(item.getDescription());%></TD></tr>

                                <!-- Buttons -->
                                <tr><td><p> </p></td></tr>
                                <tr><td><input class="itemButton" type="submit" value="Details"></input></td></tr>
                            </table>              
                        </form>  
                    </li> 
                    <% } %> <!--EndFor-->
                </ul>
                <% } %> <!--EndIf-->
            </div>
        </div>
        
    </body>
</html>
