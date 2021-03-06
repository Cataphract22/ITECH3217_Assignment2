package model;

import entities.Item;
import entities.LoanRule;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LoanRuleFacadeLocal {

    void create(LoanRule loanRule);

    void edit(LoanRule loanRule);

    void remove(LoanRule loanRule);

    LoanRule find(Object id);

    List<LoanRule> findAll();

    List<LoanRule> findInRange(int[] range);

    int count();

    public LoanRule findByUser(User user, Item item);
    
}
