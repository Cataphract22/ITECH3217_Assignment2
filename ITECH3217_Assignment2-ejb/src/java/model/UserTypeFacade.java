package model;

import entities.UserType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserTypeFacade extends AbstractFacade<UserType> implements UserTypeFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public UserTypeFacade() {
        super(UserType.class);
    }
    
}
