package model;

import entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserFacadeLocal {

    void create(User _user);

    void edit(User _user);

    void remove(User _user);

    User find(Object _object);
    
    User findByEmail(String _email);

    List<User> findAll();

    List<User> findRange(int[] _range);

    int count();
    
}
