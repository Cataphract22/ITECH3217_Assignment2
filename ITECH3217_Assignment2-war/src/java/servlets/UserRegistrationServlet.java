package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserRegistrationServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserRegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con = null;
        
        String address = "login.jsp";
        String params = "";
        
        String url="jdbc:mysql://localhost/";
        String databaseName = "ITECH3217_LMS";
        String driver = "com.mysql.jdbc.Driver";
        String query="";
        
        try {
          String email = request.getParameter("email");
          String firstName = request.getParameter("firstName");
          String lastName = request.getParameter("lastName");
          String phone = request.getParameter("phone");
          String password = request.getParameter("password"); 
          
          Class.forName(driver);
          con = DriverManager.getConnection(url + databaseName, "root", "kronos1995");                  
          query = ("INSERT INTO User (Password, GivenName, FamilyName, Phone, Email, Type, IsAdmin)" +
" VALUES ('" + password + "','" + firstName + "','" + lastName + "','" + phone + "','" + email + "','UNDERGRAD' ,0)");

          Statement st = con.createStatement();
          
          st.executeUpdate(query);

          int i = st.executeUpdate(query);
          if (i!=0) {
              address = "/login/login.jsp";
              params = "?newuser=true";
          }
          else {
              address = "/login/login.jsp";
              params = "?failed";
          }
        response.sendRedirect(request.getContextPath() + address + params);
        st.close();
        } catch(Exception ex) {
            out.println(ex);
        } 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
