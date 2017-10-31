package model;

import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public UserFacade() {
        super(User.class);
    }
    
    @Override
    public User findByEmail(String _email) {
        Query query = this.entityManager.createNamedQuery("User.findByEmail").setParameter("email", _email);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return(User) results.get(0);
    }
    
}
