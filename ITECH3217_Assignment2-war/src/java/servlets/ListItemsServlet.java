/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookmarkFacadeLocal;
import model.ItemFacadeLocal;

/**
 *
 * @author drewm
 */
public class ListItemsServlet extends HttpServlet {

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

            // Get types
            String[] types = request.getParameterValues("type");
            
            // Get item list
            List results = itemFacade.findAll();
            
            // Filter list by item type (display only one type of item)
            
            if (types != null) {
                List filteredResults = new ArrayList();
                for(int t = 0; t < types.length; t++) {
                    // Set attribute of checkbox to checked
                    request.setAttribute(types[t], "checked='checked'");
                    
                    // Filter list
                    for(int i = 0; i < results.size(); i++) {
                        Item result = (Item) results.get(i);
                        if (result.getItemtype().getItemtype().equals(types[t])) {
                            filteredResults.add(result);
                        }
                    }
                }
                results = filteredResults;
            } else {
                // Clear results if no type is selected
                results.clear();
            }
            
            request.setAttribute("list", results);
            


        } catch (Exception e) {
            out.println(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/browse.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
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
