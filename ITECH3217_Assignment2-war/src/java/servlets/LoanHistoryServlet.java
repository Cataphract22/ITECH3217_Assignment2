/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoanFacadeLocal;
import model.UserFacadeLocal;

/**
 *
 * @author CMD
 */
@WebServlet(name = "LoanHistoryServlet", urlPatterns = {"/LoanHistoryServlet"})
public class LoanHistoryServlet extends HttpServlet {

    @EJB
    private LoanFacadeLocal loanFacade;
    
    @EJB
    private UserFacadeLocal userFacade;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    List results;
    String userEmail;
    User user;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try {
                //get userEmail for current session
                userEmail = request.getSession().getAttribute("email").toString();
                
                //get user from userEmail
                user = userFacade.findByEmail(userEmail);
                
                // Get loan list
                results = loanFacade.findAllByUserid(user, true);

         
                //Get Item details for description?
                
                
            
          

            
            
            //Attach the result list to return message
            request.setAttribute("list", results);

        } catch (Exception e) {
            out.println(e);
        }

        // Dispatch return message
        RequestDispatcher dispatcher = request.getRequestDispatcher("./loanHistory.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
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