<ul>
    
    <% pageContext.setAttribute("thisFile", this.getClass().getSimpleName().replaceAll("_jsp", ".jsp")); %>
    
    <% if(pageContext.getAttribute("thisFile").equals("index.jsp")) { %>
        <li><a class="active">Home</a></li>
    <% } else { %>
        <li><a href="./index.jsp">Home</a></li>
    <% } %>
    
    <!-- // to add: check if user logged in:
        display Log In / Register if not logged in
    ELSE
        display Profile if logged in
    -->
  
    <% if(request.getSession(false) != null) { // get session if exists, do not create new session %>
        <% if(pageContext.getAttribute("thisFile").equals("login.jsp") || pageContext.getAttribute("thisFile").equals("register.jsp")) { %>    
            <li><a class="active">Log In / Register</a></li>
        <% } else { %>
            <li><a href="./login/login.jsp">Log In / Register</a></li>
        <% } %>
    <% } else { // session exists = logged in%>
        <% if(pageContext.getAttribute("thisFile").equals("profile.jsp")) { %>    
            <li><a class="active">Profile</a></li>
        <% } else { %>
            <li><a href="./profile.jsp">Profile</a></li>
        <% } %>
    <% } %>
            
    <% if(pageContext.getAttribute("thisFile").equals("browse.jsp")) { %>    
        <li><a class="active">Search</a></li>
    <% } else { %>
        <li><a href="./browse.jsp">Search</a></li>
    <% } %>
    
    <% // if(!request.getSession().getAttribute("admin").equals(1)) { %>
        <% if(pageContext.getAttribute("thisFile").equals("admin.jsp")) { %>    
            <li style="float:right"><a class="active">Administrate Library Data</a></li>
        <% } else { %>
            <li style="float:right"><a href="./admin.jsp">Administrate Library Data</a></li>
        <% } %>
    <% // } %>    
    
</ul>