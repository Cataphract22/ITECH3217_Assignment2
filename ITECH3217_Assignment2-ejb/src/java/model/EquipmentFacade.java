/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Equipment;
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
public class EquipmentFacade extends AbstractFacade<Equipment> implements EquipmentFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipmentFacade() {
        super(Equipment.class);
    }
    
    @Override
    public Equipment findByItemid(Item item) {
        Query query = em.createNamedQuery("Equipment.findByItemid").setParameter("itemid", item.getItemid());
        List results = query.getResultList();
        
        if (results.isEmpty()) {
            return null;
        }
        return(Equipment) results.get(0);
    }
}
