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
    public List findAllByItemid(Item itemId) {
        Query query = this.em.createNamedQuery("Comment.findByItemid").setParameter("itemid", itemId);
        List results = query.getResultList();
        
        // Return null if there are no comments
        if (results.isEmpty()) {
            return null;
        }

        // Return result list
        return results;
    }
    
    @Override
    public List findAllByUserid(User userId) {
        Query query = this.em.createNamedQuery("Comment.findByUserid").setParameter("userid", userId);
        List results = query.getResultList();
        
        // Return null if there are no comments
        if (results.isEmpty()) {
            return null;
        }

        // Return result list
        return results;
    }
    
}
