package servlets;

import entities.Bookmark;
import entities.Item;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookmarkFacadeLocal;
import model.ItemFacadeLocal;
import model.UserFacadeLocal;

public class CheckBookmarkServlet extends HttpServlet {

    @EJB
    private ItemFacadeLocal itemFacade;

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private BookmarkFacadeLocal bookmarkFacade;

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
            Item item = itemFacade.findByItemid(Integer.parseInt(request.getParameter("item")));
            List list = bookmarkFacade.findAllByUserid(user);
            request.setAttribute("bookmark", "Bookmark");
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext();) {
                Bookmark bookmark = (Bookmark) itr.next();
                if (Objects.equals(bookmark.getItemid().getItemid(), item.getItemid())) {
                    request.setAttribute("bookmark", "Remove Bookmark");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            //out.println(e);
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
