package model;

import entities.Item;
import entities.Loan;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LoanFacadeLocal {

    void create(Loan _loan);

    void edit(Loan _loan);

    void remove(Loan _loan);

    Loan find(Object _object);

    List<Loan> findAll();

    List<Loan> findRange(int[] _range);

    int count();

    public Loan findByID(User _user, Item _item);

    public void delete(Loan _loan);


    public List findAllByUserID(User _user, boolean _history);

    public boolean update(Loan _loan);
    
}
