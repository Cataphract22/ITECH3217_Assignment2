package servlets;

import entities.Book;
import entities.Ebook;
import entities.Equipment;
import entities.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookFacadeLocal;
import model.EbookFacadeLocal;
import model.EquipmentFacadeLocal;
import model.ItemFacadeLocal;

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
    
    protected void processRequest(HttpServletRequest _request, HttpServletResponse _response)
            throws ServletException, IOException {
        _response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = _response.getWriter();
        try {
            // Get types
            String[] types = _request.getParameterValues("type");
            // Get item list
            this.results = this.itemFacade.findAll();
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
                    _request.setAttribute(types[t], "checked='checked'");
                    // Filter list
                    for (int i = 0; i < this.results.size(); i++) {
                        Item result = (Item) this.results.get(i);
                        if (result.getItemType().getItemTypeString().equals(types[t])) {
                            filteredResults.add(result);
                        }
                    }
                }
                this.results = filteredResults;
            } else {
                // Clear results if no type is selected
                this.results.clear();
            }

            /***********************
            /** SEARCH QUERIES
            /************************
            /* Search strings from search parameters
            /* Remove items if they don't match
             */
            for (int i = this.results.size() - 1; i >= 0; i--) {
                Item result = (Item) this.results.get(i);
                registerSearch(result, result.getTitle(), _request.getParameter("searchTitle"));
                switch (result.getItemType().getItemTypeString()) {
                    case "BOOK":
                        Book book = this.bookFacade.findByItemID(result);
                        registerSearch(result, book.getAuthor(), _request.getParameter("searchAuthor"));
                        registerSearch(result, book.getPublisher(), _request.getParameter("searchPublisher"));
                        registerSearch(result, Integer.toString(book.getPublishYear()), _request.getParameter("searchPublishYear"));
                        registerSearch(result, book.getISBN(), _request.getParameter("searchIsbn"));
                        registerSearch(result, null, _request.getParameter("searchModel"));
                        registerSearch(result, null, _request.getParameter("searchSerialno"));
                        break;
                    case "EBOOK":
                        Ebook ebook = this.ebookFacade.findByItemID(result);
                        registerSearch(result, ebook.getAuthor(), _request.getParameter("searchAuthor"));
                        registerSearch(result, ebook.getPublisher(), _request.getParameter("searchPublisher"));
                        registerSearch(result, Integer.toString(ebook.getPublishYear()), _request.getParameter("searchPublishYear"));
                        registerSearch(result, ebook.getISBN(), _request.getParameter("searchIsbn"));
                        registerSearch(result, null, _request.getParameter("searchModel"));
                        registerSearch(result, null, _request.getParameter("searchSerialno"));
                        break;
                    case "EQUIPMENT":
                        Equipment equipment = this.equipmentFacade.findByItemID(result);
                        registerSearch(result, equipment.getModel(), _request.getParameter("searchModel"));
                        registerSearch(result, equipment.getSerialNo(), _request.getParameter("searchSerialno"));
                        registerSearch(result, null, _request.getParameter("searchAuthor"));
                        registerSearch(result, null, _request.getParameter("searchPublisher"));
                        registerSearch(result, null, _request.getParameter("searchPublishYear"));
                        registerSearch(result, null, _request.getParameter("searchIsbn"));
                        break;
                }
            }
            //Attach the result list to return message
            _request.setAttribute("list", this.results);
        } catch (Exception e) {
            out.println(e);
        }
        // Dispatch return message
        RequestDispatcher dispatcher = _request.getRequestDispatcher("/browse.jsp");
        if (dispatcher != null) {
            dispatcher.forward(_request, _response);
        }
    }

    private void registerSearch(Item _item, String _string1, String _string2) {
        // Calls searchString, and processes the resultSet
        if (_string2 != null && !_string2.equals("")) {
            if (_string1 == null || !searchString(_string1, _string2)) {
                this.results.remove(_item);
            }
        }
    }
    
    private boolean searchString(String _string1, String _string2) {
        if(_string1.toLowerCase().contains(_string2.toLowerCase())) {
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
