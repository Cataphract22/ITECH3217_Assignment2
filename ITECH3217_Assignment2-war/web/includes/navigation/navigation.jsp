<ul class="nav_ul">
    
    <!-- Nav code created by following guide: https://www.w3schools.com/css/css_navbar.asp -->

    <% pageContext.setAttribute("callingFilename", this.getClass().getSimpleName().replaceAll("_jsp", ".jsp")); %>

    <% if (pageContext.getAttribute("callingFilename").equals("index.jsp")) { %>
    <li class="nav_li"><a class="nav_active">Home</a></li>
        <% } else { %>
    <li class="nav_li"><a class="nav_inactive" href="./index.jsp">Home</a></li>
        <% } %>

    <% if (request.getSession().getAttribute("loggedIn").equals("true")) { %>
        
        <% if(pageContext.getAttribute("callingFilename").equals("profile.jsp")) { %>
            <li class="nav_li"><a class="nav_active">Profile</a></li>
        <% } else { %>
            <li class="nav_li"><a class="nav_inactive" href="./profile.jsp">Profile</a></li>
        <% } %>
        
        <% if(pageContext.getAttribute("callingFilename").equals("browse.jsp")) { %>
            <li class="nav_li"><a class="nav_active">Search</a></li>
        <% } else { %>
            <li class="nav_li"><a class="nav_inactive" href="./ListItemsServlet?type=BOOK&type=EBOOK&type=EQUIPMENT">Search</a></li>
        <% } %>
        
        <% if(request.getSession().getAttribute("admin").equals("true")) { // user is admin%>
            <% if(pageContext.getAttribute("callingFilename").equals("admin.jsp")) { %>    
                <li class="nav_li" style="float:right"><a class="nav_active">Administrate Library Data</a></li>
            <% } else { %>
                <!--<li class="nav_li" style="float:right"><a class="nav_inactive" href="/AdministrateLibraryDataServlet">Administrate Library Data</a></li>-->
                <li class="nav_li" style="float:right"><a class="nav_inactive" href="./admin.jsp">Administrate Library Data</a></li>
            <% } %>
        <% } %>    

        <li class="nav_li" style="float:right"><a class="nav_inactive" href="./includes/scripts/logoutUser.jsp">Log Out (<%=request.getSession().getAttribute("email")%>)</a></li>
        
    <% } else { %>
        <li class="nav_li"><a class="nav_inactive" href="./login/login.jsp">Log In / Register</a></li>
    <% } %>
</ul>