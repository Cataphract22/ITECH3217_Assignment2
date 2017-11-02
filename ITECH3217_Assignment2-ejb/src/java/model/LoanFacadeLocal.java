package model;

import entities.Item;
import entities.Loan;
import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LoanFacadeLocal {

    void create(Loan loan);

    void edit(Loan loan);

    void remove(Loan loan);

    Loan find(Object id);

    List<Loan> findAllUsers();

    List<Loan> findUsersInRange(int[] range);

    int count();

    public Loan findByUser(User user, Item item);

    public void delete(Loan loan);

    public List findAllByUser(User userid, boolean history);

    public boolean update(Loan loan);
    
}
