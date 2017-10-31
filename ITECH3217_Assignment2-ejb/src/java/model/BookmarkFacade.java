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
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public BookmarkFacade() {
        super(Bookmark.class);
    }
    
    @Override
    public void create(Bookmark _bookmark) {
        this.entityManager.persist(_bookmark);
    }
    
    @Override
    public void delete(Bookmark _bookmark) {
        this.entityManager.remove(this.entityManager.merge(_bookmark));
    }
    
    @Override
    public List findAllByUserID(User _user) {
        Query query = this.entityManager.createNamedQuery("Bookmark.findAll");
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        for (int i = 0; i < results.size(); i++) {
            Bookmark bm = (Bookmark) results.get(i);
            if (!Objects.equals(bm.getUser().getUserID(), _user.getUserID())) {
                results.remove(i);
            }
        }
        return results;
    }
    
    @Override
    public Bookmark findByID(User _user, Item _item) {
        Query query = this.entityManager.createNamedQuery("Bookmark.findAll");
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        for (int i = 0; i < results.size(); i++) {
            Bookmark bm = (Bookmark) results.get(i);
            if (Objects.equals(bm.getUser().getUserID(), _user.getUserID())) {
                if (Objects.equals(bm.getItem().getItemID(), _item.getItemID())) {
                    return (Bookmark) results.get(i);
                }
            }
        }
        return null;
    }
    
}
