package model;

import entities.Comment;
import entities.Item;
import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CommentFacade extends AbstractFacade<Comment> implements CommentFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public CommentFacade() {
        super(Comment.class);
    }
    
    @Override
    public void create(Comment _comment) {
        this.entityManager.persist(_comment);
    }
    
    @Override
    public List findAllByItemID(Item _item) {
        Query query = this.entityManager.createNamedQuery("Comment.findByItemid").setParameter("itemid", _item);
        List results = query.getResultList();
        
        // Return null if there are no comments
        if (results.isEmpty()) {
            return null;
        }

        // Return result list
        return results;
    }
    
    @Override
    public List findAllByUserID(User _user) {
        Query query = this.entityManager.createNamedQuery("Comment.findByUserid").setParameter("userid", _user);
        List results = query.getResultList();
        
        // Return null if there are no comments
        if (results.isEmpty()) {
            return null;
        }

        // Return result list
        return results;
    }
    
}
