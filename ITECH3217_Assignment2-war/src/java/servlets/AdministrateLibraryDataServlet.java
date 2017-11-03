package servlets;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ItemFacadeLocal;
import model.ItemTypeFacadeLocal;
import model.UserFacadeLocal;
import model.UserTypeFacadeLocal;

//@WebServlet(name = "AdministrateLibraryDataervlet", urlPatterns = {"/AdministrateLibraryDataServlet"})
public class AdministrateLibraryDataServlet extends HttpServlet {
    
    @EJB
    private UserFacadeLocal userFacade;
    
    @EJB
    private ItemFacadeLocal itemFacade;
    
    @EJB
    private UserTypeFacadeLocal userTypeFacade;
    
    @EJB
    private ItemTypeFacadeLocal itemTypeFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    List userList;
    List itemList;
    
    List userTypeList;
    List itemTypeList;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            userList = userFacade.findAll();
            request.setAttribute("userList", userList);
            
            itemList = itemFacade.findAll();
            request.setAttribute("itemList", itemList);
            
            userTypeList = userTypeFacade.findAll();
            request.setAttribute("userTypeList", userTypeList);
            
            itemTypeList = itemTypeFacade.findAll();
            request.setAttribute("itemTypeList", itemTypeList);
            
        } catch (Exception exception) {
            out.println(exception.getMessage());
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
