<ul>

    <% pageContext.setAttribute("callingFilename", this.getClass().getSimpleName().replaceAll("_jsp", ".jsp")); %>


    <% if (pageContext.getAttribute("callingFilename").equals("index.jsp")) { %>
    <li><a class="active">Home</a></li>
        <% } else { %>
    <li><a href="./index.jsp">Home</a></li>
        <% } %>

    <% if (request.getSession().getAttribute("loggedIn").equals("true")) { %>
        
        <% if(pageContext.getAttribute("callingFilename").equals("profile.jsp")) { %>
            <li><a class="active">Profile</a></li>
        <% } else { %>
            <li><a href="./profile.jsp">Profile</a></li>
        <% } %>
        
        <% if(pageContext.getAttribute("callingFilename").equals("browse.jsp")) { %>
            <li><a class="active">Search</a></li>
        <% } else { %>
            <li><a href="./ListItemsServlet?type=BOOK&type=EBOOK&type=EQUIPMENT">Search</a></li>
        <% } %>
        
        <% if(request.getSession().getAttribute("admin").equals("true")) { // user is admin%>
            <% if(pageContext.getAttribute("callingFilename").equals("admin.jsp")) { %>    
                <li style="float:right"><a class="active">Administrate Library Data</a></li>
            <% } else { %>
                <li style="float:right"><a href="./admin.jsp">Administrate Library Data</a></li>
            <% } %>
        <% } %>    

        <li style="float:right"><a href="./includes/scripts/logoutUser.jsp">Log Out (<%=request.getSession().getAttribute("email")%>)</a></li>
        
    <% } else { %>
        <li><a href="./login/login.jsp">Log In / Register</a></li>
    <% } %>
</ul>