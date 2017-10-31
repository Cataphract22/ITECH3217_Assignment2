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
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public EquipmentFacade() {
        super(Equipment.class);
    }
    
    @Override
    public Equipment findByItemID(Item _item) {
        Query query = this.entityManager.createNamedQuery("Equipment.findByItemid").setParameter("itemid", _item.getItemID());
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return (Equipment) results.get(0);
    }
}
