package servlets;

import entities.LoanRule;
import entities.Loan;
import entities.Item;
import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoanFacadeLocal;
import model.ItemFacadeLocal;
import model.LoanRuleFacadeLocal;
import model.UserFacadeLocal;

public class LoanServlet extends HttpServlet {

    @EJB
    private LoanRuleFacadeLocal loanRuleFacade;

    @EJB
    private UserFacadeLocal userFacade;

    @EJB
    private LoanFacadeLocal loanFacade;

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
            User user = (User) this.userFacade.findByEmail((String)request.getSession().getAttribute("email"));
            Item item = (Item) this.itemFacade.findByItemid(Integer.parseInt(request.getParameter("id")));
            Loan loan;
            if (item.getIsavailable() == true) {
            // If item is available for loan
                // Set due date
                LoanRule rule = (LoanRule) this.loanRuleFacade.findByRule(user, item);
                int loanDays = rule.getLoantime();
                Date loanDate = new Date();
                Date dueDate = new Date(loanDate.getTime() + TimeUnit.DAYS.toMillis(loanDays));
                // Create loan
                loan = new Loan();
                loan.setItemid(item);
                loan.setUserid(user);
                loan.setLoandate(loanDate);
                loan.setDuedate(dueDate);
                this.loanFacade.create(loan);
                // Update item availability
                item.setIsavailable(false);
                this.itemFacade.update(item); 
            } else {
                loan = this.loanFacade.findById(user, item);
                if ( loan != null) {
                    // Update loan history
                    loan.setHistory(true);
                    this.loanFacade.update(loan);
                    // Update item availability
                    item.setIsavailable(true);
                    this.itemFacade.update(item);
                }
            }
            response.sendRedirect("ItemDetailsServlet?id=" + item.getItemid());
        } catch (IOException | NumberFormatException e) {
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
