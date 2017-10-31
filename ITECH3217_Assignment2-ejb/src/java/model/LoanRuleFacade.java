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
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    public LoanRuleFacade() {
        super(LoanRule.class);
    }
    
    @Override
    public LoanRule findByUser(User user, Item item) {
        // Get query parameters
        String userType = user.getUserType().getUserTypeString();
        String itemType = item.getItemType().getItemtypeString();
        Query query = this.em.createNamedQuery("LoanRule.findByRule");
        query.setParameter("itemtype", itemType);
        query.setParameter("usertype", userType);
        List results = query.getResultList();
        if (results.isEmpty()) {
            return null;
        }
        return(LoanRule) results.get(0);
    }
    
}
