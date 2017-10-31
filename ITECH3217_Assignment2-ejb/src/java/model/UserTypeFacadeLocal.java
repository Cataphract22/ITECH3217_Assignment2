package model;

import entities.UserType;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserTypeFacadeLocal {

    void create(UserType _userType);

    void edit(UserType _userType);

    void remove(UserType _userType);

    UserType find(Object _object);

    List<UserType> findAll();

    List<UserType> findRange(int[] _range);

    int count();
}
