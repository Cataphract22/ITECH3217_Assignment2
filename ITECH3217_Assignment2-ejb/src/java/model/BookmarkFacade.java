package model;

import entities.Bookmark;
import entities.Item;
import entities.User;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BookmarkFacade extends AbstractFacade<Bookmark> implements BookmarkFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public BookmarkFacade() {
        super(Bookmark.class);
    }
    
    @Override
    public void create(Bookmark bookmark) {
        this.em.persist(bookmark);
    }
    
    @Override
    public void delete(Bookmark bookmark) {
        this.em.remove(this.em.merge(bookmark));
    }
    
    @Override
    public List findAllByUserid(User userid) {
        Query query = this.em.createNamedQuery("Bookmark.findAll");
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        for (int i = 0; i < results.size(); i++) {
            Bookmark bm = (Bookmark) results.get(i);
            if (!Objects.equals(bm.getUserid().getUserid(), userid.getUserid())) {
                results.remove(i);
            }
        }
        return results;
    }
    
    @Override
    public Bookmark findById(User user, Item item) {
        Query query = this.em.createNamedQuery("Bookmark.findAll");
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        for (int i = 0; i < results.size(); i++) {
            Bookmark bm = (Bookmark) results.get(i);
            if (Objects.equals(bm.getUserid().getUserid(), user.getUserid())) {
                if (Objects.equals(bm.getItemid().getItemid(), item.getItemid())) {
                    return (Bookmark) results.get(i);
                }
            }
        }
        return null;
    }
    
}
