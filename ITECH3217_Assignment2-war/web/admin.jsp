<%@page import="entities.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<!-- ADD: ability to Create, Edit and Delete ITEM records
ASSIGNMENT READS: "which can manage all data contained within the application"
NOTE: if changes made will need to iterate through database updating all tables affected -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (request.getSession().getAttribute("admin").equals("false")) {
        // not admin - redirect
        response.sendRedirect(request.getContextPath() + "/login/login.jsp");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Federation University Library - Administrate Library Data</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/admin.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/navigation.css" rel="stylesheet" type="text/css">
    </head>
    <body>

    <navigation>
        <%@include file="./includes/navigation/navigation.jsp" %>
    </navigation>

    <div class="verticalContain">
        <div class="content-block">
            <h1></h1>

            <div id="divAdministrateUsers" name="divAdministrateUsers" style="border:2px solid black;">
                <div id="divAdministrateUsers_Controls" name="divAdministrateUsers_Controls" style="border:1px solid black;">
                    <h1>Users</h1>
                </div>
                <div id="divAdministrateUsers_Controls" name="divAdministrateUsers_Controls" style="border:1px solid black;">
                    Data Controls: 
                    <button id="addNewUser">Add New User</button>
                    <button id="updateUser">Update User</button>
                    <button id="deleteUser">Delete User</button>
                </div>
                <div id="divAdministrateUsers_Content" name="divAdministrateUsers_Content" style="border:1px solid black;">


                    <div class="verticalContainer">
                        <div class="content-block">           

                            <% Iterator itr; %>
                            <% List userList = (List) request.getAttribute("userList"); %>
                            <% if (userList != null && userList.size() > 0) { %>

                            <table>
                                <tr>
                                    <th>User ID:</th>
                                    <th>First:</th>
                                    <th>Last:</th>
                                    <th>Phone</th>
                                    <th>Email:</th>
                                    <th>Admin:</th>
                                </tr>

                                <%  for (itr = userList.iterator(); itr.hasNext();) {
                                        User user = (User) itr.next();
                                %>
                                <form>
                                    <tr>
                                        <td><input type="text" id="userID" disabled><% out.println(user.getUserID()); %></input></td>
                                        <td><input type="text" id="userFirstName" disabled><% out.println(user.getGivenName()); %></input></td>
                                        <td><input type="text" id="userLastName" disabled><% out.println(user.getFamilyName()); %></input></td>
                                        <td><input type="text" id="userPhone" disabled><% out.println(user.getPhone()); %></input></td>
                                        <td><input type="text" id="userEmail" disabled><% out.println(user.getEmail()); %></input></td>
                                        <td><input type="text" id="userAdmin" disabled><% out.println(user.getAdmin()); %></input></td>
                                    </tr>
                                </form>
                                <% } %> <!--EndIf-->
                            </table>
                            <% } else { %> <!--EndIf-->
<!--                                No users found!--> <!-- getting error here, should be a list of Users to be displayed for Administrating -->
                            <% }%> <!--EndFor--> 
                        </div>
                    </div>




                </div>
            </div>
            <br>
            <div id="divAdministrateItems" name="divAdministrateItems" style="border:2px solid black;">
                <div id="divAdministrateUsers_Controls" name="divAdministrateUsers_Controls" style="border:1px solid black;">
                    Data Controls: 
                    <button id="addNewItem">Add New Item</button>
                    <button id="updateItem">Update Item</button>
                    <button id="deleteItem">Delete Item</button>
                </div>
                <div id="divAdministrateUsers_Content" name="divAdministrateUsers_Content" style="border:1px solid black;">
                    administrate (ITEMS: add, update, delete) (Tables: ITEM, BOOK, EQUIPMENT, EBOOK, BOOKMARK, COMMENT, LOAN) in this cell
                </div>
            </div>
            <br>
            <div id="divAdministrateTypes" name="divAdministrateTypes" style="border:2px solid black;">
                <div id="divAdministrateUsers_Controls" name="divAdministrateUsers_Controls" style="border:1px solid black;">
                    Data Controls: 
                    <button id="addNewType">Add New Type</button>
                    <button id="updateType">Update Type</button>
                    <button id="deleteType">Delete Type</button>
                </div>
                <div id="divAdministrateUsers_Content" name="divAdministrateUsers_Content" style="border:1px solid black;">
                    administrate (TYPES: add, update, delete) (Tables: USER_TYPE, ITEM_TYPE, LOAN_TYPE) in this cell
                </div>
            </div>

        </div>
    </body>
</html>