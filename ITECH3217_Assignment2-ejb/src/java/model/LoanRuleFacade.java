package model;

import entities.Item;
import entities.LoanRule;
import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class LoanRuleFacade extends AbstractFacade<LoanRule> implements LoanRuleFacadeLocal {

    @PersistenceContext(unitName = "ITECH3217_Assignment2-ejbPU")
    private EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    public LoanRuleFacade() {
        super(LoanRule.class);
    }
    
    @Override
    public LoanRule findByRule(User _user, Item _item) {
        // Get query parameters
        String userType = _user.getUserType().getUserTypeString();
        String itemType = _item.getItemType().getItemTypeString();
        Query query = this.entityManager.createNamedQuery("LoanRule.findByRule");
        query.setParameter("itemtype", itemType);
        query.setParameter("usertype", userType);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return(LoanRule) results.get(0);
    }
    
}
