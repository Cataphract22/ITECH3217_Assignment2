package model;

import entities.Book;
import entities.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public BookFacade() {
        super(Book.class);
    }
    
    @Override
    public Book findByItem(Item item) {
        Query query = this.em.createNamedQuery("Book.findByItemid").setParameter("itemid", item.getItemID());
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return(Book) results.get(0);
    }
    
}
