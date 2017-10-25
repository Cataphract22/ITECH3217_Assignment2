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
        <title>Federation University Library</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/browse.css" rel="stylesheet" type="text/css">

    <div class="header">
        <h1>Welcome to Federation University Library</h2>
            <h1>Browse Items</h1>
            <div class="search-container">
                <table>    
                    <form action="ListItemsServlet" method="Post">

                        <tr><td><h3>Search Parameters</h3></td></tr>
                        <!-- Generic params -->
                        <tr>
                            <td><label for="searchTitle">Title</label></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="searchTitle" value=""/></td>
                        </tr>
                        <!-- Books/eBooks params -->
                        <tr>
                            <td><label for="searchAuthor">Author</label></td>
                            <td><label for="searchPublisher">Publisher</label></td>
                            <td><label for="searchPublishYear">Year</label></td>
                            <td><label for="searchIsbn">ISBN</label></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="searchAuthor" value=""/></td>
                            <td><input type="text" name="searchPublisher" value=""/></td>
                            <td><input type="text" name="searchPublishYear" value=""/></td>
                            <td><input type="text" name="searchIsbn" value=""/></td>
                        </tr>
                        <!-- Equipment params -->
                        <tr>
                            <td><label for="searchModel">Model</label></td>
                            <td><label for="searchSerialno">Serial#</label></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="searchModel" value=""/></td>
                            <td><input type="text" name="searchSerialno" value=""/></td>
                        </tr>
                        <tr><td><br></td></tr>

                        <!-- Filter checkboxes -->
                        <tr><td><h3>Filters</h3></td></tr>

                        <tr>
                            <td>
                                <label class="ck">
                                    <input type="checkbox" name="type" value="BOOK" <%= request.getAttribute("BOOK")%> /><span>Show Books</span>
                                </label>
                            </td>
                            <td>
                                <label class="ck">
                                    <input type="checkbox" name="type" value="EBOOK" <%= request.getAttribute("EBOOK")%> /><span>Show eBooks</span>
                                </label>
                            </td>
                            <td>
                                <label class="ck">
                                    <input type="checkbox" name="type" value="EQUIPMENT" <%= request.getAttribute("EQUIPMENT")%> /><span>Show Equipment</span>
                                </label>
                            </td>
                        </tr>

                        <!-- Submit button -->
                        <tr><td><h3> <br></h3></td></tr>
                        <tr><td><input class="searchButton" type="submit" value="Apply Search"></input> </td></tr>
                    </form>
                </table>


            </div>
    </div>

    <body>
        <div class="verticalContain">
            <div class="content-block">           
                <!-- Iterate through item list, build HTML for each item -->

                <% Iterator itr; %>
                <% List list = (List) request.getAttribute("list"); %>
                <% if (list.size() > 0) { %>
                <ul>
                    <%  for (itr = list.iterator(); itr.hasNext();) {
                            Item item = (Item) itr.next();
                            int itemId = item.getItemid();
                    %>
                    
                    
                    <jsp:include page="./GetItemTypeServlet">
                        <jsp:param name="item" value="<%=itemId%>"/>
                    </jsp:include>
                    <li class='item-container'>
                        <form action="ItemDetailsServlet?id=<%out.println(item.getItemid());%>" method="POST">
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