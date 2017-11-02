package model;

import entities.UserType;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserTypeFacadeLocal {

    void create(UserType userType);

    void edit(UserType userType);

    void remove(UserType userType);

    UserType find(Object id);

    List<UserType> findAllUsers();

    List<UserType> findUsersInRange(int[] range);

    int count();
    
}
