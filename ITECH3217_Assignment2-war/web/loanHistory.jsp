<%@page import="entities.Item"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entities.Loan"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Federation University Library - User Loan History</title>
        <link href="./includes/styles/_main.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/loanHistory.css" rel="stylesheet" type="text/css">
        <link href="./includes/styles/navigation.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        
        <navigation>
            <%@include file="./includes/navigation/navigation.jsp" %>
        </navigation>
    
        <h1>Loan History</h1>
        <div class="verticalContainer">
            <div class="content-block">           
                <!-- Iterate through item list, build HTML for each item -->

                <% Iterator itr; %>
                <% List list = (List) request.getAttribute("list"); %>
                <% Item item = new Item(); %>
                
                <% DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); %>
                
                <% if (list != null && list.size() > 0) { %>
                <table
                   <li class='loan-container'> 
                    <tr>
                        <td>Item</td>
                        <td>Loan Start Date</td>
                        <td>Loan End Date</td>
                        
                    </tr>
                <ul>
                    <%  for (itr = list.iterator(); itr.hasNext();) {
                            Loan loan = (Loan) itr.next();
                            int loanId = loan.getLoanID();
                            item = loan.getItem();

                    %>
                    <tr>
                        <td>
                            
                            <% out.println(item.getTitle()); %>
                        </td>
                        <td>
                        <% out.println(formatter.format(loan.getLoanDate())); %>
                        </td>
                        <td>
                            <% out.println(formatter.format(loan.getDueDate())); %>
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
