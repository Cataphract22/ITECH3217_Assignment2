<%-- 
    Document   : loanHistory
    Created on : 26/10/2017, 10:43:09 PM
    Author     : CMD
--%>

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
        <title>User Loan History</title>
    </head>
    <body>
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
                            int loanId = loan.getLoanid();
                            item =loan.getItemid();

                    %>
                    <tr>
                        <td>
                            
                            <% out.println(item.getTitle()); %>
                        </td>
                        <td>
                        <% out.println(formatter.format(loan.getLoandate())); %>
                        </td>
                        <td>
                            <% out.println(formatter.format(loan.getDuedate())); %>
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