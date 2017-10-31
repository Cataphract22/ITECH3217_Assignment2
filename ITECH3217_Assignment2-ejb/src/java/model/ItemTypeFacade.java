package model;

import entities.ItemType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ItemTypeFacade extends AbstractFacade<ItemType> implements ItemTypeFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public ItemTypeFacade() {
        super(ItemType.class);
    }
    
}
