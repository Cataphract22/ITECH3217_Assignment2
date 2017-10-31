package model;

import entities.Equipment;
import entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EquipmentFacade extends AbstractFacade<Equipment> implements EquipmentFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public EquipmentFacade() {
        super(Equipment.class);
    }
    
    @Override
    public Equipment findByItem(Item item) {
        Query query = this.em.createNamedQuery("Equipment.findByItemid").setParameter("itemid", item.getItemID());
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return (Equipment) results.get(0);
    }
}
