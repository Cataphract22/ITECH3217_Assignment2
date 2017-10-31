package servlets;

import entities.Book;
import entities.Ebook;
import entities.Equipment;
import entities.Item;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookFacadeLocal;
import model.EbookFacadeLocal;
import model.EquipmentFacadeLocal;
import model.ItemFacadeLocal;

public class GetItemTypeServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Item item = this.itemFacade.findByItemID(Integer.parseInt(request.getParameter("item")));
            request.setAttribute("book", null);
            request.setAttribute("ebook", null);
            request.setAttribute("equipment", null); 
            request.setAttribute("type", item.getItemType().getItemtypeString());
            switch(item.getItemType().getItemtypeString()) {
                case "BOOK":        Book book = this.bookFacade.findByItem(item);
                                    request.setAttribute("book", book);
                                    break;
                case "EBOOK":       Ebook ebook = this.ebookFacade.findByItem(item);
                                    request.setAttribute("ebook", ebook);
                                    request.setAttribute("test", "yay");
                                    break;
                case "EQUIPMENT":   Equipment equipment = this.equipmentFacade.findByItem(item);
                                    request.setAttribute("equipment", equipment);
                                    break;
            }
        } catch (NumberFormatException e) {
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
