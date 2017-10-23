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
        
        <div class="header">
            <h1>Welcome to Federation University Library</h2>
            <h1>Browse Books</h1>
            <div class="search-container">
                <h2>Search</h2>
                <form action="ListItemsServlet" method="Post">
                    <table>
                        <tr><td><h3>Search Parameters</h3></td></tr>
                        <tr>
                            <td>
                                <label for="searchTitle">Title</label>
                            </td>
                            <td>
                                <label for="searchAuthor">Author</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" name="searchTitle" value=""/>
                            </td>
                            <td>
                                <input type="text" name="searchAuthor" value=""/>
                            </td>
                        </tr>
                        <tr><td><br></td></tr>
                        
                        <!-- Filter checkboxes -->
                        <tr><td><h3>Filters</h3></td></tr>
                        
                        <tr>
                            <td>
                                <label class="ck">
                                    <input type="checkbox" name="type" value="BOOK" <%= request.getAttribute("BOOK") %> /><span>Show Books</span>
                                </label>
                            </td>
                            <td>
                                <label class="ck">
                                    <input type="checkbox" name="type" value="EBOOK" <%= request.getAttribute("EBOOK") %> /><span>Show eBooks</span>
                                </label>
                            </td>
                            <td>
                                <label class="ck">
                                    <input type="checkbox" name="type" value="EQUIPMENT" <%= request.getAttribute("EQUIPMENT") %> /><span>Show Equipment</span>
                                </label>
                            </td>
                        </tr>
                        
                        <!-- Submit button -->
                        <tr><td><h3> <br></h3></td></tr>
                        <tr>
                            <td>
                                <input class="searchButton" type="submit" value="Apply Search"></input> 
                            </td>
                        </tr>
                    </table>
                </form>
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
                        <jsp:include page="/CheckBookmarkServlet">
                            <jsp:param name="item" value="<%=itemId%>"/>
                        </jsp:include>
                        <jsp:include page="./GetItemTypeServlet">
                            <jsp:param name="item" value="<%=itemId%>"/>
                        </jsp:include>
                        <li class='item-container'>
                            <form action="/ITECH3217_Assignment2-war/BookmarkServlet?id=<%out.println(item.getItemid());%>" method="POST">
                                <img class='coverImage' src='<%out.println(item.getImage());%>' width="120"</img>
                                <table>
                                    <tr>
                                        <td>
                                            <h3 class='title'><%out.println(item.getTitle());%></h3>
                                        </td>
                                    </tr>
                                    
                                    <!-- BOOK -->
                                    <% if (request.getAttribute("book") != null) { %>
                                    <% Book book = (Book) request.getAttribute("book"); %>
                                        <tr>
                                            <td class="author"><%out.println(book.getAuthor());%></td>
                                        </tr>
                                        <tr>
                                            <td class="publisher">Published by: <%out.println(book.getPublisher());%>, <%out.println(book.getPublishYear());%></td>
                                        </tr>
                                        <tr>
                                            <td class='isbn'>ISBN-13: <%out.println(book.getIsbn());%></td>
                                        </tr>
                                    <% } %><!--EndIf-->
                                    
                                    <!-- EBOOK -->
                                    <% if (request.getAttribute("ebook") != null) { %>
                                    <% Ebook ebook = (Ebook) request.getAttribute("ebook"); %>
                                        <tr>
                                            <td class='author'><%out.println(ebook.getAuthor());%></td>
                                        </tr>
                                        <tr>
                                            <td class="publisher">Published by: <%out.println(ebook.getPublisher());%>, <%out.println(ebook.getPublishYear());%></td>
                                        </tr>
                                        <tr>
                                            <td class='isbn'>ISBN-13: <%out.println(ebook.getIsbn());%></td>
                                        </tr>
                                    <% } %><!--EndIf-->
                                    
                                    <!-- EQUIPMENT -->
                                    <% if (request.getAttribute("equipment") != null) { %>
                                    <% Equipment equipment = (Equipment) request.getAttribute("equipment"); %>
                                        <tr>
                                            <td class='model'>Model: <%out.println(equipment.getModel());%></td>
                                        </tr>
                                        <tr>
                                            <td class='serialno'>Serial#: <%out.println(equipment.getSerialno());%></td>
                                        </tr>
                                    <% } %><!--EndIf-->
                                    <tr>
                                        <td>
                                            <p> </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <TD class='description'><%out.println(item.getDescription());%></TD>
                                    </tr>
                                    <tr>
                                        <td>
                                            <p> </p>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input class="itemButton" type="submit" value="<%out.println(request.getAttribute("bookmark"));%>"></input>
                                        </td>
                                    </tr>
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