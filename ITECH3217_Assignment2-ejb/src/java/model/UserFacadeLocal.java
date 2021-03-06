package model;

import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);
    
    User findByEmail(String email);

    List<User> findAll();

    List<User> findInRange(int[] range);

    int count();
    
}
