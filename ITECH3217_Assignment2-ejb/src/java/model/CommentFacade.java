package model;

import entities.Comment;
import entities.Item;
import entities.User;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CommentFacade extends AbstractFacade<Comment> implements CommentFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public CommentFacade() {
        super(Comment.class);
    }
    
    @Override
    public void create(Comment comment) {
        this.em.persist(comment);
    }
    
    @Override
    public List findAllByItem(Item item) {
        Query query = this.em.createNamedQuery("Comment.findByItemid").setParameter("itemid", item);
        List results = query.getResultList();
        
        // Return null if there are no comments
        if (results.isEmpty()) {
            return null;
        }

        // Return result list
        return results;
    }
    
    @Override
    public List findAllByUser(User user) {
        Query query = this.em.createNamedQuery("Comment.findByUserid").setParameter("userid", user);
        List results = query.getResultList();
        
        // Return null if there are no comments
        if (results.isEmpty()) {
            return null;
        }

        // Return result list
        return results;
    }
    
}
