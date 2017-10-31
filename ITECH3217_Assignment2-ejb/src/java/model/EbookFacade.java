package model;

import entities.Ebook;
import entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class EbookFacade extends AbstractFacade<Ebook> implements EbookFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public EbookFacade() {
        super(Ebook.class);
    }
    
    @Override
    public Ebook findByItemID(Item _item) {
        Query query = this.entityManager.createNamedQuery("Ebook.findByItemid").setParameter("itemid", _item.getItemID());
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return (Ebook) results.get(0);
    }
    
}
