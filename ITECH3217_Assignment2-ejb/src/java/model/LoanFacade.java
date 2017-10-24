/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author drewm
 */
@Stateless
public class LoanFacade extends AbstractFacade<Loan> implements LoanFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoanFacade() {
        super(Loan.class);
    }
    
    @Override
    public void create(Loan loan) {
        loan.setHistory(false);
        em.persist(loan);
    }
    
    @Override
    public void delete(Loan loan) {
        em.remove(em.merge(loan));
    }
    
    @Override
    public boolean update(Loan loan) {
        try {
            em.merge(loan);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List findAllByUserid(User userid, boolean history) {
        Query query = em.createNamedQuery("Loan.findAll");
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
            if (!Objects.equals(loan.getUserid().getUserid(), userid.getUserid())) {
                results.remove(i);
            }
        }
        
        // Return result list
        return results;
    }
    
    @Override
    public Loan findById(User user, Item item) {
        Query query = em.createNamedQuery("Loan.findAll");
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
            if (Objects.equals(loan.getUserid().getUserid(), user.getUserid())) {
                if (Objects.equals(loan.getItemid().getItemid(), item.getItemid())) {
                    return loan;
                }
            }
        }
        
        // Otherwise return null
        return null;
    }
    
}
