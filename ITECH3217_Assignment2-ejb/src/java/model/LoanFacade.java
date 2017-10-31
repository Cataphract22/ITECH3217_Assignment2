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
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public LoanFacade() {
        super(Loan.class);
    }
    
    @Override
    public void create(Loan _loan) {
        _loan.setHistory(false);
        this.entityManager.persist(_loan);
    }
    
    @Override
    public void delete(Loan _loan) {
        this.entityManager.remove(this.entityManager.merge(_loan));
    }
    
    @Override
    public boolean update(Loan _loan) {
        try {
            this.entityManager.merge(_loan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List findAllByUserID(User _user, boolean _history) {
        Query query = this.entityManager.createNamedQuery("Loan.findAll");
        List results = query.getResultList();
        Loan loan;
        if (results.isEmpty()) {
            return null;
        }
        // Toggle historical results
        if (_history == false) {
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
            if (!Objects.equals(loan.getUser().getUserID(), _user.getUserID())) {
                results.remove(i);
            }
        }
        // Return result list
        return results;
    }
    
    @Override
    public Loan findByID(User _user, Item _item) {
        Query query = this.entityManager.createNamedQuery("Loan.findAll");
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
            if (Objects.equals(loan.getUser().getUserID(), _user.getUserID())) {
                if (Objects.equals(loan.getItem().getItemID(), _item.getItemID())) {
                    return loan;
                }
            }
        }
        // Otherwise return null
        return null;
    }
    
}
