package model;

import entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ItemFacade extends AbstractFacade<Item> implements ItemFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public ItemFacade() {
        super(Item.class);
    }
    
    @Override
    public boolean update(Item item) {
        try {
            this.em.merge(item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public Item findByItemID(Integer id) {
        Query query = this.em.createNamedQuery("Item.findByItemid").setParameter("itemid", id);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return (Item) results.get(0); 
    }

}
