/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entities.Book;
import entities.Ebook;
import entities.Equipment;
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
import model.BookFacadeLocal;
import model.BookmarkFacadeLocal;
import model.EbookFacadeLocal;
import model.EquipmentFacadeLocal;
import model.ItemFacadeLocal;

/**
 *
 * @author drewm
 */
public class ListItemsServlet extends HttpServlet {

    @EJB
    private EquipmentFacadeLocal equipmentFacade;

    @EJB
    private EbookFacadeLocal ebookFacade;

    @EJB
    private BookFacadeLocal bookFacade;

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
    
    List results;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            // Get types
            String[] types = request.getParameterValues("type");

            // Get item list
            results = itemFacade.findAll();

            /***********************
            /** FILTER
            /************************
            /* Filter list by item type (display only one type of item)
            /* Add found items to temp list, then merge with results
             */
            
            if (types != null) {
                List filteredResults = new ArrayList();
                for (int t = 0; t < types.length; t++) {
                    // Set attribute of checkbox to checked
                    request.setAttribute(types[t], "checked='checked'");

                    // Filter list
                    for (int i = 0; i < results.size(); i++) {
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

            
            /***********************
            /** SEARCH QUERIES
            /************************
            /* Search strings from search parameters
            /* Remove items if they don't match
             */
            
            for (int i = results.size() - 1; i >= 0; i--) {
                Item result = (Item) results.get(i);
                processSearch(result, result.getTitle(), request.getParameter("searchTitle"));

                switch (result.getItemtype().getItemtype()) {
                    case "BOOK":
                        Book book = bookFacade.findByItemid(result);
                        processSearch(result, book.getAuthor(), request.getParameter("searchAuthor"));
                        processSearch(result, book.getPublisher(), request.getParameter("searchPublisher"));
                        processSearch(result, Integer.toString(book.getPublishYear()), request.getParameter("searchPublishYear"));
                        processSearch(result, book.getIsbn(), request.getParameter("searchIsbn"));
                        processSearch(result, null, request.getParameter("searchModel"));
                        processSearch(result, null, request.getParameter("searchSerialno"));
                        break;
                    case "EBOOK":
                        Ebook ebook = ebookFacade.findByItemid(result);
                        processSearch(result, ebook.getAuthor(), request.getParameter("searchAuthor"));
                        processSearch(result, ebook.getPublisher(), request.getParameter("searchPublisher"));
                        processSearch(result, Integer.toString(ebook.getPublishYear()), request.getParameter("searchPublishYear"));
                        processSearch(result, ebook.getIsbn(), request.getParameter("searchIsbn"));
                        processSearch(result, null, request.getParameter("searchModel"));
                        processSearch(result, null, request.getParameter("searchSerialno"));
                        break;
                    case "EQUIPMENT":
                        Equipment equipment = equipmentFacade.findByItemid(result);
                        processSearch(result, equipment.getModel(), request.getParameter("searchModel"));
                        processSearch(result, equipment.getSerialno(), request.getParameter("searchSerialno"));
                        processSearch(result, null, request.getParameter("searchAuthor"));
                        processSearch(result, null, request.getParameter("searchPublisher"));
                        processSearch(result, null, request.getParameter("searchPublishYear"));
                        processSearch(result, null, request.getParameter("searchIsbn"));
                        break;
                }
            }

            
            
            //Attach the result list to return message
            request.setAttribute("list", results);

        } catch (Exception e) {
            out.println(e);
        }

        // Dispatch return message
        RequestDispatcher dispatcher = request.getRequestDispatcher("/browse.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
  
        
    }

    private void processSearch(Item result, String s1, String s2) {
        // Calls searchString, and processes the resultSet
        if (s2 != null && !s2.equals("")) {
            if (s1 == null || !searchString(s1, s2)) {
                results.remove(result);
            }
        }
    }
    
    private boolean searchString(String s1, String s2) {
        if (s1.toLowerCase().contains(s2.toLowerCase())) {
            return true;
        }
        return false;
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
