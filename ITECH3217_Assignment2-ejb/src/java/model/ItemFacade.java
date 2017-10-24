/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Item;
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
public class ItemFacade extends AbstractFacade<Item> implements ItemFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemFacade() {
        super(Item.class);
    }
    
        
    @Override
    public boolean update(Item item) {
        try {
            em.merge(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Item findByItemid(Integer id) {
        Query query = em.createNamedQuery("Item.findByItemid").setParameter("itemid", id);
        List results = query.getResultList();
        
        if (results.isEmpty()) {
            return null;
        }
        return(Item) results.get(0); 
    }

}
