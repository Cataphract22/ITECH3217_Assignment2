package model;

import entities.Item;
import entities.LoanRule;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LoanRuleFacadeLocal {

    void create(LoanRule _loanRule);

    void edit(LoanRule _loanRule);

    void remove(LoanRule _loanRule);

    LoanRule find(Object _object);

    List<LoanRule> findAll();

    List<LoanRule> findRange(int[] _range);

    int count();

    public LoanRule findByRule(User _user, Item _item);
    
}
