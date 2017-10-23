/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Bookmark;
import entities.Item;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookmarkFacadeLocal;
import model.ItemFacadeLocal;
import model.UserFacadeLocal;

/**
 *
 * @author drewm
 */
public class BookmarkServlet extends HttpServlet {

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private BookmarkFacadeLocal bookmarkFacade;

    @EJB
    private ItemFacadeLocal itemFacade;

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
        PrintWriter out = response.getWriter();
        
        try {
           
            User user = (User) userFacade.findByEmail((String)request.getSession().getAttribute("email"));
            Item item = (Item) itemFacade.findByItemid(Integer.parseInt(request.getParameter("id")));
            Date bookmarkDate = new Date();
           
            Bookmark bookmark = bookmarkFacade.findById(user, item);
            if ( bookmark == null) {
                bookmark = new Bookmark();
                bookmark.setItemid(item);
                bookmark.setUserid(user);
                bookmark.setBookmarkdate(bookmarkDate);

                bookmarkFacade.create(bookmark);
            } else {
                bookmarkFacade.delete(bookmark);
            }
           
            
        } catch (Exception e) {
            out.println(e);
        }
        
        response.sendRedirect("/ITECH3217_Assignment2-war/ListItemsServlet?type=BOOK&type=EBOOK&type=EQUIPMENT");
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
