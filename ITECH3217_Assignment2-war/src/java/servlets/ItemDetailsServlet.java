package servlets;

import entities.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CommentFacadeLocal;
import model.ItemFacadeLocal;

/**
 *
 * @author drewm
 */
public class ItemDetailsServlet extends HttpServlet {

    @EJB
    private CommentFacadeLocal commentFacade;

    @EJB
    private ItemFacadeLocal itemFacade;

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
        try {
            // Get item
            Item item = (Item) this.itemFacade.findByItemID(Integer.parseInt(_request.getParameter("id")));
            
            //Attach the result list to return message
  
            // Get comment list
            List comments = this.commentFacade.findAllByItemID(item);
    
            //Attach the item and comments to return message
            _request.setAttribute("item", item);
            _request.setAttribute("comments", comments);
            
        } catch (NumberFormatException e) {
            out.println(e);
        }
        // Dispatch return message
        RequestDispatcher dispatcher = _request.getRequestDispatcher("details.jsp");
        if (dispatcher != null) {
            dispatcher.forward(_request, _response);
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
