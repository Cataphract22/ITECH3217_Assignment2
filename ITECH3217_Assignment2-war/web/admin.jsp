<!-- ADD: ability to Create, Edit and Delete ITEM records
ASSIGNMENT READS: "which can manage all data contained within the application"
NOTE: if changes made will need to iterate through database updating all tables affected -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
if(request.getSession().getAttribute("admin").equals("false")) {
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
    </head>
<body>
    <div class="verticalContain">
        <div class="content-block">
            <h1></h1>
            
            <div id="divAdministrateUsers" name="divAdministrateUsers" style="border:2px solid black;">
                <div id="divAdministrateUsers_Controls" name="divAdministrateUsers_Controls" style="border:1px solid black;">
                    Data Controls: 
                    <button id="addNewUser">Add New User</button>
                    <button id="updateUser">Update User</button>
                    <button id="deleteUser">Delete User</button>
                </div>
                <div id="divAdministrateUsers_Content" name="divAdministrateUsers_Content" style="border:1px solid black;">
                    administrate (USERS: add, update, delete) (Tables: USER) in this cell
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