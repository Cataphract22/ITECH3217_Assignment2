package servlets;

import entities.Loan;
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
import model.ItemFacadeLocal;
import model.LoanFacadeLocal;
import model.UserFacadeLocal;

public class CheckLoanServlet extends HttpServlet {

    @EJB
    private LoanFacadeLocal loanFacade;

    @EJB
    private ItemFacadeLocal itemFacade;

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
        try {
            User user = (User) this.userFacade.findByEmail((String)_request.getSession().getAttribute("email"));
            Item item = this.itemFacade.findByItemID(Integer.parseInt(_request.getParameter("item")));
            List list = this.loanFacade.findAllByUserID(user, false);
            _request.setAttribute("loan", "Request Loan");
            // If user has already made a loan request                                            
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext();) {
                Loan loan = (Loan) itr.next();
                // If already loaned
                if (Objects.equals(loan.getItem().getItemID(), item.getItemID())) {
                    _request.setAttribute("loan", "Return Item");
                    break;
                }
            }
            if (_request.getAttribute("loan") != "Return Item" && item.Available() == false) { // If item unavailable
                _request.setAttribute("loan", "Unavailable");
                
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
