package servlets;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserFacadeLocal;

public class ProcessLoginServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal userFacade;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param _request servlet request
     * @param _response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        _response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = _response.getWriter();
        // Set default redirect
        String address = "login.jsp";
        String params = "";
        User user;
        try {
            _response.setContentType("text/html;charset=UTF-8");
            // Get user
            user = this.userFacade.findByEmail(_request.getParameter("email"));
            if (user == null) {
                address = "/login/login.jsp";
                params = "?failed=true";
                //request.setAttribute("failed", true);
            } else if (user.getPassword().equals(_request.getParameter("password"))) {
                // Set address and params
                address = "/ListItemsServlet";
                params = "?type=BOOK&type=EBOOK&type=EQUIPMENT";
                // Session values
                _request.getSession().setAttribute("email", user.getEmail());
                _request.getSession().setAttribute("password", user.getPassword());
                _request.getSession().setAttribute("type", user.getUserType().getUserTypeString());
                _request.getSession().setAttribute("admin", user.isAdmin());
            } else {
                address = "/login/login.jsp";
                params = "?failed=true";
            }
            _response.sendRedirect(_request.getContextPath() + address + params);
        } catch (IOException e) {
            out.println(e);
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
        processRequest(request, response);
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
