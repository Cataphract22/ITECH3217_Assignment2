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
        em.persist(loan);
    }
    
    @Override
    public void delete(Loan loan) {
        em.remove(em.merge(loan));
    }

    @Override
    public List findAllByUserid(User userid) {
        Query query = em.createNamedQuery("Loan.findAll");
        List results = query.getResultList();
        
        if (results.isEmpty()) {
            return null;
        }
        
        for (int i = 0; i < results.size(); i++) {
            Loan loan = (Loan) results.get(i);
            if (!Objects.equals(loan.getUserid().getUserid(), userid.getUserid())) {
                results.remove(i);
            }
        }
        return results;
    }
    
    @Override
    public Loan findById(User user, Item item) {
        Query query = em.createNamedQuery("Loan.findAll");
        List results = query.getResultList();
        
        if (results.isEmpty()) {
            return null;
        }
        
        for (int i = 0; i < results.size(); i++) {
            Loan loan = (Loan) results.get(i);
            if (Objects.equals(loan.getUserid().getUserid(), user.getUserid())) {
                if (Objects.equals(loan.getItemid().getItemid(), item.getItemid())) {
                    return (Loan) results.get(i);
                }
            }
        }
        return null;
    }
    
}
