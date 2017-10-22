/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Ebook;
import entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author drewm
 */
@Stateless
public class EbookFacade extends AbstractFacade<Ebook> implements EbookFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EbookFacade() {
        super(Ebook.class);
    }
    
    @Override
    public Ebook findByItemid(Item item) {
        Query query = em.createNamedQuery("Ebook.findByItemid").setParameter("itemid", item.getItemid());
        List results = query.getResultList();
        
        if (results.isEmpty()) {
            return null;
        }
        return(Ebook) results.get(0);
    }
    
}
