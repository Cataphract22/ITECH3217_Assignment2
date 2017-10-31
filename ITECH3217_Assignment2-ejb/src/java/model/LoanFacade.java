package model;

import entities.Item;
import entities.Loan;
import entities.User;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoanFacade extends AbstractFacade<Loan> implements LoanFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public LoanFacade() {
        super(Loan.class);
    }
    
    @Override
    public void create(Loan loan) {
        loan.setHistory(false);
        this.em.persist(loan);
    }
    
    @Override
    public void delete(Loan loan) {
        this.em.remove(this.em.merge(loan));
    }
    
    @Override
    public boolean update(Loan loan) {
        try {
            this.em.merge(loan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List findAllByUser(User userid, boolean history) {
        Query query = this.em.createNamedQuery("Loan.findAll");
        List results = query.getResultList();
        Loan loan;
        if (results.isEmpty()) {
            return null;
        }
        // Toggle historical results
        if (history == false) {
            for (int i = results.size()-1; i >= 0; i--) {
                loan = (Loan) results.get(i);
                if (loan.getHistory() == true) {
                    results.remove(i);
                }
            }
        }
        // Remove non-matching loans
        for (int i = results.size()-1; i >= 0; i--) {
            loan = (Loan) results.get(i);
            if (!Objects.equals(loan.getUser().getUserID(), userid.getUserID())) {
                results.remove(i);
            }
        }
        // Return result list
        return results;
    }
    
    @Override
    public Loan findByUser(User user, Item item) {
        Query query = this.em.createNamedQuery("Loan.findAll");
        List results = query.getResultList();
        Loan loan;
        if (results.isEmpty()) {
            return null;
        }
        // Get only current loans
        for (int i = results.size()-1; i >= 0; i--) {
            loan = (Loan) results.get(i);
            if (loan.getHistory() == true) {
                results.remove(i);
            }
        }
        // Return matching loan
        for (Object result : results) {
            loan = (Loan) result;
            if (Objects.equals(loan.getUser().getUserID(), user.getUserID())) {
                if (Objects.equals(loan.getItem().getItemID(), item.getItemID())) {
                    return loan;
                }
            }
        }
        // Otherwise return null
        return null;
    }
    
}
